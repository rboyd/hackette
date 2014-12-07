(ns hackette.content)

(.sendMessage chrome.runtime #js {:greeting "hello"}
              (fn [response]
                (.log js/console (.-farewell response))))
