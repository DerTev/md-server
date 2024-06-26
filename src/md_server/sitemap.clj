(ns md-server.sitemap
  (:require [md-server.html :as html]
            [clojure.string :as cstr])
  (:import java.io.File))

(defn- adjust-file-path [^String path]
  (->> (cstr/split path #"\\|/")
       (drop 1)
       (cstr/join "/")))

(defn- render-linked-file [^File file]
  [:a {:href (->> file
                  .getPath
                  adjust-file-path
                  (str "/"))}
   (.getName file)])

(defn- index-file? [^File file]
  (= (.getName file) "index.md"))

(defn- hidden-file? [^File file]
  (.isHidden file))

(defn- render-file [^File file]
  (if (.isDirectory file)
    (list (if (some index-file? (.listFiles file))
            (render-linked-file file)
            (.getName file))
          [:ul (for [child-file (filter #(not (or (index-file? %)
                                                  (hidden-file? %)))
                                        (.listFiles file))]
                 [:li (render-file child-file)])])
    (render-linked-file file)))

(defn render [^File root]
  (html/render (when (.isDirectory root)
                 (-> root
                     render-file
                     second))
               "Sitemap"))
