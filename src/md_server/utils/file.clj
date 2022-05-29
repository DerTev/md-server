(ns md-server.utils.file
  (:import java.io.File))

(defn file-exists?
  "Check if a file exists"
  [name]
  (let [file (File. name)]
    (.exists file)))

(defn read-file
  "Read content froma a file"
  [name]
  (let [file (File. name)]
    (if (.isFile file)
      (slurp (.getPath file))
      "")))
