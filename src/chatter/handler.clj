(ns chatter.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.params :refer [wrap-params]]
            [hiccup.page :as page]
            [hiccup.form :as form]))

(def chat-messages
    (atom '()))
;;{:name "Hi Tom" :message "Thanks for inviting me."}
;;{:name "Pizza" :message "Was Tasty."}
;;{:name "Beer" :message "More Please."}
;;)))

(defn title [n]
  (str "ClojureBridgeMN" n))

(defn generate-message-view
"This generates the HTML for displaying messages"
    [messages]
  (page/html5
    [:head
      [:title (title 2016)]]
    [:body
      [:h1 "Our Chat App"]
      [:p
       (form/form-to
        [:post "/"]
        "Name: " (form/text-field "name")
        "Message: " (form/text-field "msg")
        (form/submit-button "Submit"))]
      [:p
      [:table
        (map (fn [m]
               [:tr [:td (:name m)]
                 [:td (:message m)]])
             messages)]]]))

(defn update-messages!
"This will update a message list atom"
      [messages name new-message]
      (swap! messages conj {:name name :message new-message}))

(defroutes app-routes
    (GET "/" [] (generate-message-view @chat-messages))
    (POST "/" {params :params}
      (let [name-param (get params "name")
            msg-param (get params "msg")
            new-messages (update-messages! chat-messages name-param msg-param)]
        (generate-message-view new-messages)
        ))
    (route/not-found "Not Found"))

(comment
(generate-message-view)
(def x 2)
(def y 3)
(* x y 6 5 4 7 6 5 4 7 6 5 4 7)
)

(def app (wrap-params app-routes))
