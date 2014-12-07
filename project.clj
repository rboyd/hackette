(defproject hackette "0.1.0"
  :plugins [[lein-cljsbuild "1.0.3"]]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2411"]]
  :cljsbuild {:builds [{:source-paths ["src-cljs/hackette"]
                        :compiler {:output-to "build/javascripts/hackette.js"
                                   :optimizations :simple
                                   :pretty-print true}}
                       {:source-paths ["src-cljs/content-script"]
                        :compiler {:output-to "build/javascripts/content-script.js"
                                   :optimizations :simple
                                   :pretty-print true}}]})
