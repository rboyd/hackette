(ns hackette.core)

(.addListener chrome.runtime.onMessage
              (fn [request sender sendResponse]
                (if (= "hello" (.-greeting request))
                  (sendResponse (js-obj "farewell" (-> sender .-tab .-url))))))
