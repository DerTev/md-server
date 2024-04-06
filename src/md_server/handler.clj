(ns md-server.handler
  (:require [md-server.markdown :as md]
            [clojure.string :as cstr]
            [md-server.sitemap :as sitemap]
            [ring.util.response :as ruresp])
  (:import java.io.File))

(defn handle [req]
  (let [uri (if (cstr/ends-with? (:uri req) "/")
              (->> (:uri req)
                   (drop-last 1)
                   (apply str))
              (:uri req))]
    (condp contains? uri
      #{"/style.css"} (ruresp/response (slurp "https://cdn.jsdelivr.net/npm/water.css@2/out/water.css"))
      #{"/sitemap"} (->> "content/"
                         (new File)
                         sitemap/render
                         ruresp/response)
      (or (md/render-content (str uri ".md"))
          (md/render-content (str uri "/index.md"))
          (when (cstr/ends-with? uri ".md")
            (md/render-content uri))
          (ruresp/file-response uri {:root "content/"})
          (ruresp/not-found "404 - Not found!")))))
