(ns md-server.core
  (:gen-class)
  (:require [ring.adapter.jetty :as jetty]
            [md-server.handler :as handler]))

(defn start-server
  "Start server"
  [port]
  (jetty/run-jetty handler/handler {:port port}))

(defn -main [& args]
  (println "Start server...")
  (start-server (if (nil? args)
                  80
                  (Long/parseLong (nth args 0)))))
