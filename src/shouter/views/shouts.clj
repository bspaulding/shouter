(ns shouter.views.shouts
  (:require [shouter.views.layout :as layout]
            [shouter.views.components :refer [app]]
            [rum.core :as rum]))

(defn index [shouts token]
  (let [state {:shouts shouts
               :token token}]
    (layout/common "SHOUTER"
                   state
                   (rum/render-static-markup (app state)))))
