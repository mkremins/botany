(ns botany.util
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [twitter.oauth :as oauth]))

(defn download-file [url localpath]
  (with-open [in (io/input-stream url)
              out (io/output-stream localpath)]
    (io/copy in out)))

(defn load-oauth-creds [bot-name]
  (->> ["CONSUMER_KEY"
        "CONSUMER_SECRET"
        "OAUTH_TOKEN"
        "OAUTH_TOKEN_SECRET"]
       (map #(System/getenv (str bot-name "_" %)))
       (apply oauth/make-oauth-creds)))

(defn load-vocab-file [name]
  (-> (io/resource (str "vocabulary/" name ".txt"))
      slurp
      str/split-lines))
