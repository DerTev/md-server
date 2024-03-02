(ns md-server.html
  (:require [hiccup2.core :as hiccup]
            [dotenv :as env]))

(defn render [body title]
  (str (hiccup/html [:html [:head [:title title]
                            [:link {:rel "stylesheet" :href "/style.css"}]
                            [:meta {:charset "UTF-8"}]
                            [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
                            (when (not= (env/env "ROBOTS_INDEX") "TRUE")
                              [:meta {:name "robots" :content "noindex, nofollow"}])]
                     [:body body]])))
