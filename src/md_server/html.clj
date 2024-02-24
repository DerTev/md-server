(ns md-server.html
  (:require [hiccup2.core :as hiccup]
            [dotenv :as env]))

(defn render [body]
  (str (hiccup/html [:html [:head [:title "md-server"]      ; TODO change title
                            [:link {:rel "stylesheet" :href "/style.css"}]
                            (when (not= (env/env "ROBOTS_INDEX") "TRUE")
                              [:meta {:name "robots" :content "noindex, nofollow"}])]
                     [:body body]])))
