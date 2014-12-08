(ns hackette.serv
  (:require [liberator.core :refer [resource defresource]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.core :refer [defroutes ANY]]))

(def pageviews (ref []))

(defresource pageview
  :allowed-methods [:post :get]
  :post! (fn [ctx]
           (dosync
            (let [body (slurp (get-in ctx [:request :body]))
                  id (count (alter pageviews conj body))]
              (println body)
              {::id id})))
  :available-media-types ["text/html"]
  :handle-ok (fn [ctx]
               (format "<html>There have been %d pageviews logged with hackette. Last url: %s</html>"
                       (count @pageviews) (last @pageviews))))
(defroutes app
  (ANY "/pageviews" [] pageview))

(def handler
  (-> app
      wrap-params))
