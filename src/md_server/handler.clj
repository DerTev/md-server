(ns md-server.handler
  (:require [md-server.markdown :as md]
            [clojure.string :as cstr]
            [md-server.sitemap :as sitemap])
  (:import java.io.File))

(defn handle [req]
  (let [uri (:uri req)]
    (condp contains? uri
      #{"/style.css"} {:body   (slurp "https://cdn.jsdelivr.net/npm/water.css@2/out/water.css")
                       :status 200}
      #{"/sitemap" "/sitemap/"} {:body   (sitemap/render (File. "content/"))
                                 :status 404}
      (or (md/render-content (str uri ".md"))
          (md/render-content (str uri "/index.md"))
          (when (cstr/ends-with? uri ".md")
            (md/render-content uri))
          {:body   "404 - Not found!"
           :status 404}))))
