(ns watch
  (:require [hawk.core :as hawk]
            [build]
            :reload-all))


(defn -main
  []
  (hawk/watch! [{:paths ["src/mechtron"]
                 :filter hawk/file?
                 :handler (fn [ctx e]
                            ; (println "event: " e)
                            ; (println "context: " ctx)
                            (require 'build :reload-all)
                            (build/html)
                            ctx)}
                {:paths ["resources/scss"]
                 :filter hawk/file?
                 :handler (fn [ctx e]
                            (require 'build :reload-all)
                            (build/css)
                            ctx)}])
  (println "Watching source files..."))
