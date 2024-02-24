(ns md-server.markdown
  (:require [clojure.java.io :as jio]
            [cybermonday.core :as md]
            [md-server.html :as html]))

(defn- read-file [path]
  (let [file (jio/file path)]
    (when (and (.exists file)
               (.isFile file))
      (slurp file))))

(defn md->html [markdown]
  (when (some? markdown)
    (-> markdown
        md/parse-md
        :body
        html/render)))

(defn path->md [path]
  (-> path
      read-file
      md->html))

(defn render-content
  ([path] (render-content path "content/"))
  ([path root] (let [md (path->md (str root path))]
                 (when (some? md)
                   {:body    md
                    :headers {"Content-Type" "text/html"}
                    :status  200}))))
