(ns cryptic.bot
  (:require [botany.util :as util]
            [cryptic.generate :as gen]
            [twitter.api.restful :as twitter]))

(def ^:private creds
  (util/load-oauth-creds "EBOOKS"))

(defn- tweet [_ _]
  (let [status (gen/error)]
    (println (str "[cryptic/tweet] " status))
    (twitter/statuses-update
      :oauth-creds creds
      :params {:status status})))

(def bot
  {:name "cryptic"
   :tweet tweet
   :schedule "0 0 /3 * * * *"})
