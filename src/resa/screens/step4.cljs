(ns resa.screens.step4
  (:require [rum.core :refer-macros [defc]]
            [reaction.core :refer-macros [dispatch!]]
            [antizer.rum :as ant]
            [rum.core :as rum]
            [resa.components.hi-lib :refer [small-header navigation]]))

(defc screen4
  [store]
  (let [{:keys [pax time name phone email]} (:data @store)]
    [:div {:style {:flex 1
                   :display "flex"
                   :flex-direction "column"}}
     (small-header store)
     [:br]
     [:div {:style {:background-color "rgba(0, 0, 0, 0.8)"
                    :padding 20
                    :color "white"
                    :flex 1}}
      [:p "Dear MM. " (or name "")]
      [:p "Thank you for your reservation!"]
      [:p "A confirmation e-mail has been sent to: " (or email "")]]]))

(defc nav
  [state]
  (navigation state))

(defc next-button
  [state])
