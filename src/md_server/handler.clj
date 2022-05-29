(ns md-server.handler
  (:require [md-server.utils.file :as file]
            [md-server.utils.markdown :as markdown]))

(defn get-body
  "Returns the body of a page based on the uri and server name of the request."
  [server-name uri]
  (let [url (str server-name uri)]
    (if (and (= uri "/") (file/file-exists? (str server-name "/index.md")))
      (markdown/load-markdown (str url "/index.md"))
      (cond
        (file/file-exists? (str url ".md")) (markdown/load-markdown (str url ".md"))
        :else :404))))

(defn handler
  "Handler for WebServer"
  [request]
  (let [body (get-body (get request :server-name) (get request :uri))]
    {:headers {"Content-Type" "text/html"},
     :body (if (= body :404)
             (let [notfound-file (str (get request :server-name) "/404.md")]
                (if (file/file-exists? notfound-file)
                  (markdown/load-markdown notfound-file)
                  "404 - Not found"))
             body),
     :status (if (= body :404)
               404
               200)}))
