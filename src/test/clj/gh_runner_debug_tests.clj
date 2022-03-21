(ns gh-runner-debug-tests
  (:require [clojure.test :refer :all]
            [gh-runner-debug :as debug]))

(deftest debug-gh-runner
  (testing "Debug 1985"
    (debug/debug-year 1985))
  (testing "Debug 1991"
    (debug/debug-year 1991))
  (testing "Debug 2006"
    (debug/debug-year 2006))
  (testing "Debug 2022"
    (debug/debug-year 2022))
  (testing "Debug 2168"
    (debug/debug-year 2168))
  (testing "simple out"
    (println (.get (java.time.LocalDate/of 2168 1 1) java.time.temporal.IsoFields/WEEK_OF_WEEK_BASED_YEAR))))
