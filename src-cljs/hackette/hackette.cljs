(ns hackette.core
  (:require [clojure.browser.net :refer [xhr-connection]]
            [goog.structs :as structs]))

(def post-json-headers
  (structs/Map. (clj->js {:Content-Type "application/json"})))

(.addListener chrome.runtime.onMessage
              (fn [request sender sendResponse]
                (if (= "injected" (.-event request))
                    (.send (xhr-connection) "http://localhost:3000/pageviews" "POST" (JSON/stringify #js {:url (-> sender .-tab .-url)}) post-json-headers))))
