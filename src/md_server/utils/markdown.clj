(ns md-server.utils.markdown
  (:require [cybermonday.core :as md-parser]
            [md-server.utils.file :as file-utils]
            [hiccup.core :as html]))

(defn load-markdown
  "Load markdown from a file"
  [file]
  (html/html (get (md-parser/parse-md (file-utils/read-file file)) :body)))
