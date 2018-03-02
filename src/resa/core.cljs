(ns resa.core
  (:require
    cljsjs.react
    cljsjs.react.dom
    resa.actions.core
    [resa.store :refer [app-store]]
    [resa.utils :refer [wrap-en]]
    [antizer.rum :as ant]
    [resa.screens.core :refer [ui-screen]]
    [reaction.core :refer [bind-actions-list]])
  (:require-macros
    [devcards.core :as dc :refer [defcard deftest]]))

(enable-console-print!)

;;; cards
(defcard step1
  (fn [store _]
    (wrap-en (ui-screen store)))
  {:screen :step1}
  {:inspect-data true})
(defcard step2
  (fn [store _]
    (wrap-en (ui-screen store)))
  {:screen :step2}
  {:inspect-data true})
(defcard step3
  (fn [store _]
    (wrap-en (ui-screen store)))
  {:screen :step3}
  {:inspect-data true})
(defcard step4
  (fn [store _]
    (wrap-en (ui-screen store)))
  {:screen :step4}
  {:inspect-data true})

;;; app
(defn ui-app
  [store]
  (wrap-en (ui-screen store)))

(defn main []
  ;; conditionally start the app based on whether the #main-app-area
  ;; node is on the page
  (if-let [node (.getElementById js/document "main-app-area")]
    (do
      (add-watch app-store :render
                 (fn [k a o n] (.render js/ReactDOM (ui-app a) node)))
      (.render js/ReactDOM (ui-app app-store) node))))

(main)

(bind-actions-list)
