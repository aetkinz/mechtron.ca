(ns deploy
  (:require [clj-deploy.client :refer [deploy!]]))

(def dev-config (read-string (slurp "deploy.secret.edn")))

(defn configure-deploy
  "Takes a target-key and a config object.
  Returns a hash-map with repo, branch, src-dir, and dest-dir keys."
  [target-key config]
  (if-let [target (get-in config [:targets (keyword target-key)])]
    {:name "mechtron"
     :repo (:repo config)
     :branch (:branch target)
     :src_dir (:src-dir config)
     :dest_dir (:dest-dir target)}
    {:error (format "Could not find target \"%s\"." target-key)}))

(defn -main
  "Sends a deploy request to the given target server.
  Takes a target string which references a keyword key in deploy.secret.edn.
  Returns server response body."
  [target]
  (let [deploy-spec (configure-deploy target dev-config)
        server-url (:server-url dev-config)
        private-key (:private-key dev-config)]
    (if (contains? deploy-spec :error)
      (println deploy-spec)
      (do
        (println (format "Deploying to %s" target))
        (->> (deploy! server-url private-key [:repo :branch] deploy-spec)
             (clojure.pprint/pprint))))))
