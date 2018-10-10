(ns carmine-issue.core
  (:require [taoensso.carmine :as car]))

(def conn {:pool {} :spec {:uri "redis://localhost:6379"}})    ; <- blocks on exit
; (def conn {:pool :none :spec {:uri "redis://localhost:6379"}}) <- works

(defmacro wcar*  [& body] `(car/wcar conn ~@body))

(defn -main
  [& args]
  (println "Hello, problem!")
  (wcar* (car/ping)))
