(ns deploy
  (:require [clj-http.client :as client]))

(defn create-post-body
  [dest-dir branch]
  {:dest_dir dest_dir
   :src_dir "dist"
   :branch branch
   :repo "aetkinz/mechtron.ca"})

(defn deploy
  [body]
  (client/post "http://dev.aetkinz.com/mechtron" {:form-params body
                                                  :content-type :json}))

(defn -main
  [& {:keys dest-dir branch}]
  (->> (create-post-body dest-dir branch)
       (deploy)))
