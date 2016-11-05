(ns chatter.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "Good Day World")
  (route/not-found "Not Found"))

(comment
  
(def x 2)
(def y 3)
(* x y 4 5 6 7 ))

(def app
  (wrap-defaults app-routes site-defaults))
