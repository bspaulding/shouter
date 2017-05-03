(ns shouter.views.components
  (:require [rum.core :as rum]))

(rum/defc shout-form [token]
  [:div {:id "shout-form"
         :class "sixteen columns alpha omega"}
   [:form {:method "POST"
           :action "/"}
    [:input {:type "hidden"
             :name "__anti-forgery-token"
             :value token}]
    [:label "What do you want to SHOUT?"]
    [:textarea {:name "shout"}]
    [:input {:type "submit"
             :value "SHOUT!"}]]])

(rum/defc shouts-list-item [shout]
  [:h2 {:class "shout"} (:body shout)])
(rum/defc shouts-list [shouts]
  [:div (map shouts-list-item shouts)])

(rum/defc header []
  [:h1 "SHOUTER"])

(rum/defc app [state]
  [:div
   (header)
   (shout-form (:token state))
   (shouts-list (:shouts state))])

