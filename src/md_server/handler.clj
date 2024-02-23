(ns md-server.handler
  (:require [md-server.markdown :as md]
            [clojure.java.io :as jio]
            [clojure.string :as cstr]))

(defn- read-file [path]
  (let [file (jio/file path)]
    (when (and (.exists file)
               (.isFile file))
      (slurp file))))

(defn- md-response [path]
  (->> path
       (str "./content")
       read-file
       md/md->response))

(defn handle [req]
  (let [uri (:uri req)]
    (or (md-response (str uri ".md"))
        (md-response (str uri "/index.md"))
        (when (cstr/ends-with? uri ".md")
          (md-response uri))
        {:body   "404 - Not found!"
         :status 404})))
