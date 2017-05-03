(ns shouter.client
  (:require [rum.core :as rum]
            [shouter.views.components :refer [app]]))

(def state (atom {}))

(def initialState (aget js/window "__INITIAL_STATE__"))
(reset! state (js->clj initialState :keywordize-keys true))

(rum/mount (app @state) (.getElementById js/document "app"))
