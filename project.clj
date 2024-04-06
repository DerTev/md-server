(defproject md-server "2.0.0"
  :description "Serve markdown files with ease."
  :url "https://dertev.de/md-server/"
  :license {:name "MIT License"}
  :dependencies [[org.clojure/clojure "1.11.2"]
                 [http-kit "2.7.0"]
                 [lynxeyes/dotenv "1.1.0"]
                 [hiccup "2.0.0-RC3"]
                 [com.kiranshila/cybermonday "0.6.215"]
                 [ring/ring-core "1.12.1"]]
  :main ^:skip-aot md-server.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
