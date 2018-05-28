(ns deploy
  (:require [deploy.client.core :as d]))

(def dev-config (read-string (slurp "deploy.secret.edn")))

(defn configure-deploy
  [target-key config]
  (let [target (get-in config [:targets (keyword target-key)])]
    {:repo (:repo config)
     :branch (:branch target)
     :src-dir (:src-dir config)
     :dest-dir (:dest-dir target)}))


(defn -main
  [target]
  (let [deploy-spec (configure-deploy target dev-config)
        server-url (:server-url dev-config)
        private-key (:private-key dev-config)]
    (d/deploy server-url private-key deploy-spec)))
