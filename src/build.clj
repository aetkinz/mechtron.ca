(ns build
  (:require [mechtron.core :as m]
            [sass.core :refer :all]))

(defn -sass
  []
  (println "Compiling sass")
  (spit "dist/static/css/style.css"
    (render-file-path "resources/scss/style.scss"
                      :property-syntax :new :style :compressed)))

(defn -html
  []
  (println "Writing to dist/out.htm\n")
  (spit "dist/out.htm"
    (str
      "<!doctype html>\n"
      (m/layout "company" "Home" "Hello World"))))

(defn -main
  []
  (-html)
  (-sass))
