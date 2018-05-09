(ns watch
  (:require [hawk.core :as hawk]
            [build]))


(defn -main
  []
  (hawk/watch! [{:paths ["src/mechtron"]
                 :filter hawk/file?
                 :handler (fn [ctx e]
                            ; (println "event: " e)
                            ; (println "context: " ctx)
                            (build/html)
                            ctx)}
                {:paths ["resources/scss"]
                 :filter hawk/file?
                 :handler (fn [ctx e]
                            (build/css)
                            ctx)}])
  (println "Watching source files..."))
