(ns build
  (:require [mechtron.core :as m]))

(defn -main
  []
  (println "Writing to dist/out.htm\n")
  (spit "dist/out.htm"
    (str
      "<!doctype html>\n"
      (m/layout "company" "Home" "Hello World")))
  (println (slurp "dist/out.htm")))
