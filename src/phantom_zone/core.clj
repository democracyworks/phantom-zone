(ns phantom-zone.core
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(defn city-state-tz-data []
  (-> "zip-city-state-timezone.edn"
      io/resource
      slurp
      edn/read-string))

(def city-state-tz-data-cached (memoize city-state-tz-data))

(defn single-proper-case [s]
  (if (#{"of" "in" "on"} (.toLowerCase s))
    (.toLowerCase s)
    (str (.toUpperCase (subs s 0 1))
         (.toLowerCase (subs s 1)))))

(defn proper-case [s]
  (apply str
         (map single-proper-case
              (map (partial apply str)
                   (partition-by #{\space \-} s)))))

(defn zipcode->city-state-timezone
  [zipcode]
  (let [m (city-state-tz-data-cached)]
    (-> m
        (get (str zipcode))
        (update :city proper-case))))
