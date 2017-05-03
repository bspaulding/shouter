(defproject shouter "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.521"]
                 [org.clojure/java.jdbc "0.6.1"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.2"]
                 [org.clojure/data.json "0.2.6"]
                 [rum "0.10.8"]
                 [hiccup "1.0.5"]]
  :main ^:skip-aot shouter.web
  :uberjar-name "shouter-standalone.jar"
  :hooks [leiningen.cljsbuild]
  :plugins [[lein-ring "0.8.13"]
            [lein-cljsbuild "1.1.6"]]
  :cljsbuild {:builds [{:source-paths ["src"]
                        :compiler {:main "shouter.client"
                                   :output-to "resources/public/bundle.js"
                                   :jar true
                                   :optimizations :advanced
                                   :pretty-print true}}]}
  :ring {:handler shouter.web/application
         :init shouter.models.migration/migrate}
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]}
             :uberjar {:aot :all}})
