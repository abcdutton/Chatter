(defproject chatter "0.1.0-SNAPSHOT"
  :description "Hi Tom. This is a web app that will display posted messages."
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [proto-repl "0.3.0"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler chatter.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
