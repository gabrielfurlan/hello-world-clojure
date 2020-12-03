(ns api.handler
  (:require [compojure.core :refer [defroutes GET]]
     [compojure.handler :as handler]
     [compojure.route :as route]
     [ring.middleware.json :as json]
     [ring.util.response :refer [response]]
     [api.services :refer [get-user]]))

(defroutes app-routes
  (GET "/api/user/:id" [id]
    (response (get-user id)))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (json/wrap-json-params)
      (json/wrap-json-response)))