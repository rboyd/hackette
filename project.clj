(defproject hackette "0.1.0"
  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-ring "0.8.13"]]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2411"]
                 [liberator "0.12.2"]
                 [compojure "1.3.1"]
                 [ring "1.3.2"]]
  :ring {:handler hackette.serv/handler}
  :cljsbuild {:builds [{:source-paths ["src-cljs/hackette"]
                        :compiler {:output-to "build/javascripts/hackette.js"
                                   :optimizations :simple
                                   :pretty-print true}}
                       {:source-paths ["src-cljs/content-script"]
                        :compiler {:output-to "build/javascripts/content-script.js"
                                   :optimizations :simple
                                   :pretty-print true}}]})
