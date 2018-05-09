(ns build
  (:require [mechtron.core :as m]
            [sass.core :refer :all]))

(defn css
  []
  (println "Writing CSS to dist/static/css/style.css")
  (spit "dist/static/css/style.css"
    (render-file-path "resources/scss/style.scss"
                      :property-syntax :new :style :compressed)))

(defn html
  []
  (println "Writing HTML to dist/out.htm\n")
  (spit "dist/out.htm"
    (str
      "<!doctype html>\n"
      (m/layout "company" "Home" "Hello World"))))

(defn -main
  []
  (html)
  (css))
