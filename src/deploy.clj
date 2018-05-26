(ns deploy
  (:require [deploy :refer :all]))

(def *config* (read-string (slurp "deploy.secret.edn")))

(defn configure-deploy
  [target-key config]
  (let [target (get-in config [:targets (keyword target-key)])]
    {:repo (:repo config)
     :branch (:branch target)
     :src-dir (:src-dir config)
     :dest-dir (:dest-dir target)}))


(defn -main
  [target]
  (let [deploy-spec (configure-deploy target *config*)
        server-url (:server-url config)
                   (:private-key config)]
    (deploy server-url private-key deploy-spec)))
