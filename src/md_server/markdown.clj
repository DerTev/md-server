(ns md-server.markdown
  (:require [clojure.java.io :as jio]
            [cybermonday.core :as md]
            [md-server.html :as html]
            [clojure.string :as cstr]))

(defn- file-name [path]
  (-> path
      (cstr/split #"\\|/")
      last))

(defn- read-file [path]
  (let [file (jio/file path)]
    (when (and (.exists file)
               (.isFile file))
      (slurp file))))

(defn- md->html [markdown title]
  (when (some? markdown)
    (-> markdown
        md/parse-md
        :body
        (html/render title))))

(defn- path->html [path]
  (-> path
      read-file
      (md->html (file-name path))))

(defn render-content
  ([path] (render-content path "content/"))
  ([path root] (let [md (path->html (str root path))]
                 (when (some? md)
                   {:body    md
                    :headers {"Content-Type" "text/html"}
                    :status  200}))))
