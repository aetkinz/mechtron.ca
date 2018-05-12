(ns build
  (:require [mechtron.home :refer :all]
            [sass.core :refer :all]
            :reload-all))

(defn css
  []
  (println "Writing CSS to dist/static/css/style.css\n")
  (spit "dist/static/css/style.css"
    (render-file-path "resources/scss/style.scss"
                      :property-syntax :new :style :compressed)))

(defn html
  []
  (require 'mechtron.core
           '[mechtron.home :refer :all]
           :reload-all)

  (println "Writing HTML to dist/*.htm")
  (doseq [[filename render-page] {"index" home}]
    (println (str "  -> Wrote dist/" filename ".htm"))
    (spit (str "dist/" filename ".htm")
      (str
        "<!doctype html>\n"
        (render-page))))
  (println "\n"))

(defn -main
  []
  (html)
  (css))
