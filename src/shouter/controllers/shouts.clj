(ns shouter.controllers.shouts
  (:require [compojure.core :refer [defroutes GET POST]]
            [clojure.string :as str]
            [clojure.data.json :as json]
            [ring.util.response :as ring]
            [ring.middleware.anti-forgery :refer :all]
            [shouter.views.shouts :as view]
            [shouter.models.shout :as model]))

(defn index [token]
  (view/index (model/all) token))

(defn value-reader [key value]
  (if (= key :created_at)
    (.getTime value)
    value))
(defn index-json []
  (json/write-str (model/all)
                  :value-fn value-reader))

(defn create [shout]
  (when-not (str/blank? shout)
    (model/create shout))
  (ring/redirect "/"))

(defn create-json [shout]
  (when-not (str/blank? shout)
    (model/create shout))
  (index-json))

(defroutes routes
  (GET "/" [] (index *anti-forgery-token*))
  (GET "/shouts.json" [] (index-json))
  (POST "/" [shout] (create shout))
  (POST "/new" [shout] (create-json shout)))
