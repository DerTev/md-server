(ns md-server.core
  (:require [org.httpkit.server :as http-server]
            [dotenv :as env]
            [md-server.handler :as handler]
            [clojure.java.io :as jio])
  (:gen-class))

(defn -main [& args]
  (let [file (jio/file "content/")]
    (when-not (.exists file)
      (.mkdir file)))

  (let [port (try
               (Integer/parseInt (env/env "PORT"))
               (catch Exception _exception
                 8080))]
    (println (str "Starting webserver on port " port "..."))
    (http-server/run-server handler/handle {:port port})))
