(ns shouter.views.layout
  (:require [hiccup.page :as h]
            [clojure.data.json :as json]
            [shouter.json :refer [value-reader]]))

(defn common [title state & body]
  (h/html5
    [:head
     [:meta {:charset "utf-8"}]
     [:meta {:http-equiv "X-UA-Compatible" :context "IE=edge,chrome=1"}]
     [:meta {:name "viewport"
             :content "width=device-width,initial-scale=1,maximum-scale=1"}]
     [:title title]]
    [:body
     [:div {:id "app"} body]
     [:script (str "window.__INITIAL_STATE__ = " (json/write-str state :value-fn value-reader))]
     [:script {:src "bundle.js"}]]))

(defn four-oh-four []
  (common "Page Not Found"
          [:div {:id "four-oh-four"}]
          "The page you requested could not be found"))
