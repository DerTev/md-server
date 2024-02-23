(defproject md-server "2.0.0-SNAPSHOT"
  :description "Serve markdown files with ease."
  :url "https://dertev.de/md-server/"
  :license {:name "MIT License"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [http-kit "2.7.0"]
                 [lynxeyes/dotenv "1.1.0"]
                 [hiccup "2.0.0-RC3"]
                 [com.kiranshila/cybermonday "0.6.215"]]
  :main ^:skip-aot md-server.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
