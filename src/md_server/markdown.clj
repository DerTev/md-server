(ns md-server.markdown
  (:require [cybermonday.core :as md]
            [hiccup2.core :as hiccup]))

(defn- apply-html-structure [body]
  (str (hiccup/html [:html [:head [:title "md-server"]]     ; TODO change title
                     [:body body]])))

(defn md->response [markdown]
  (when (some? markdown)
    {:body   (-> markdown
                 md/parse-md
                 :body
                 apply-html-structure)
     :status 200}))
