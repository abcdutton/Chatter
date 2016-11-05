(ns chatter.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.page :as page]))

(defn generate-message-view
"This generates the HTML for displaying messages"
[]
  (page/html5
    [:head
      [:title "chatter"]]
    [:body
      [:h1 "Our Chat App"]]))
(defroutes app-routes
    (GET "/" [] (generate-message-view))
    (route/not-found "Not Found"))
(comment

(def x 2)
(def y 3)
(* x y 6 5 4 7 6 5 4 7 6 5 4 7)
)

(def app
  (wrap-defaults app-routes site-defaults))
