(ns gh-runner-debug
  (:import (java.util.regex Matcher)
           (java.time LocalDateTime Clock Year Month LocalDate Instant Duration Period)
           (java.time.temporal ChronoUnit TemporalAmount)
           (java.time.format DateTimeFormatter)))

(defn- format-as
  [pattern dt]
  (.format (DateTimeFormatter/ofPattern pattern) dt))

; as seen in chime: https://github.com/jarohen/chime/blob/master/src/chime/core.clj#L134-L135
(defn periodic-seq [^Instant start ^TemporalAmount duration-or-period]
  (iterate #(.addTo duration-or-period ^Instant %) start))

(defn debug-year
  [year]
  (->> (periodic-seq (LocalDate/ofYearDay year 1) (Period/ofDays 1))
       (take 366)
       (map (fn [t] {:week-of-year (format-as "ww" t) :ts (str t)}))
       clojure.pprint/pprint))

(defn -main
  [& args]
  (debug-year 1985)
  (debug-year 1991)
  (debug-year 2006)
  (debug-year 2022)
  (debug-year 2168))
