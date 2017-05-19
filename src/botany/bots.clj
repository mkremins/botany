(ns botany.bots
  (:require [cryptic.bot :as cryptic]
            [mccloud.bot :as mccloud]
            [cronj.core :as cronj :refer [cronj]])
  (:gen-class))

(def ^:private bots
  [cryptic/bot mccloud/bot])

(defn- bot->cronj-entry [bot]
  {:id (str (:name bot) "-tweet-task")
   :handler (:tweet bot)
   :schedule (:schedule bot)})

(def ^:private scheduler
  (cronj :entries (mapv bot->cronj-entry bots)))

(defn -main []
  (println "Starting up...")
  (cronj/start! scheduler)
  (println "Started!"))
