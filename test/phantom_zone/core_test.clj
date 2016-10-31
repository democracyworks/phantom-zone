(ns phantom-zone.core-test
  (:require [clojure.test :refer :all]
            [phantom-zone.core :refer :all]))

(deftest proper-case-test
  (testing "properly cases a place name"
    (is (= "Brooklyn" (proper-case "BROOKLYN")))
    (is (= "New York" (proper-case "NEW YORK")))
    (is (= "Grand View-on-Hudson" (proper-case "GRAND VIEW-ON-HUDSON")))))

(deftest zipcode->city-state-timezone-test
  (testing "returns city, state, TZ for a ZIP"
    (is (= {:city "Denver", :state "CO", :timezone-id "America/Denver"}
           (zipcode->city-state-timezone "80218")))))