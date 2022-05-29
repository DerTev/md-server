(defproject md-server "0.1.0-SNAPSHOT"
  :description "Webserver with Markdown-Support"
  :url "https://github.com/dertev/md-server/"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [ring/ring-core "1.9.5"]
                 [ring/ring-jetty-adapter "1.9.5"]
                 [com.kiranshila/cybermonday "0.4.184"]
                 [hiccup "1.0.5"]]
  :main ^:skip-aot md-server.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
