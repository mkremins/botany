(ns mccloud.bot
  (:require [botany.util :as util]
            [twitter.api.restful :as twitter]
            [twitter.request :as req]))

(def ^:private creds
  (util/load-oauth-creds "MCCLOUD"))

(def ^:private panel-urls
  (util/load-vocab-file "panels"))

(def ^:private base-url
  "https://raw.githubusercontent.com/mkremins/bot_mccloud/master/panels/")

(defn- tweet [_ _]
  ;; download a random panel to the local filesystem as /tmp/panel.png
  ;; (we store the images elsewhere so we don't have to worry about repo size)
  (let [panel-url (str base-url (rand-nth panel-urls))]
    (util/download-file panel-url "/tmp/panel.png")
    (println (str "[mccloud/tweet] " panel-url)))
  ;; post the downloaded panel
  (twitter/statuses-update-with-media
    :oauth-creds creds
    :body [(req/file-body-part "/tmp/panel.png")
           (req/status-body-part "")]))

(def bot
  {:name "mccloud"
   :tweet tweet
   :schedule "0 0 /3 * * * *"})
