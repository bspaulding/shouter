(ns shouter.json)

(defn value-reader [key value]
  (if (= key :created_at)
    (.getTime value)
    value))

