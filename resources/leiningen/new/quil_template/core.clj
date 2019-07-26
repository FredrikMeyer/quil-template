(ns {{name}}.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(def w 600)
(def h 600)
 
(defn setup []
  (q/color-mode :hsb 100 100 100 100)
  {}) 

(defn update-state [state]
  state)

(defn draw-state [state]
  (q/background 0)
  (println "Done")
  (q/no-loop))

(defn save-on-click [state event]
  (println "Saved")
  (println state)
  (q/save-frame (str "{{name}}" (hash state) "_" (q/random 0 1) " .tif"))
  state)

(q/defsketch {{name}}
  :title "You spin my circle right round"
  :size [w h]
  :setup setup
  :update update-state
  :mouse-clicked save-on-click
  :draw draw-state
  :features [:keep-on-top :no-bind-output :pause-on-error]
  :middleware [m/fun-mode m/pause-on-error])
