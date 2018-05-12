(ns mechtron.home
  (:require [clj-template.html5 :as h]
            [mechtron.core :refer [layout]]
            [clojure.string :as str]
            :reload-all))

(defn column-item
  [item]
  (h/li {:class "column__item"}
    item))

(defn column
  [items content]
  (h/li {:class "column"}
    (str
      (h/ul {:class "column__list"}
        (str/join "\n"
                  (map column-item items)))
      "\n"
      content
      "\n")))

(defn -company
  []
  (column
   ["About" "Quality" "Corporate Group"]
   (h/img {:class "column__img column__img--pos_left"
           :alt "Manufactured parts on the left"
           :src "static/images/homepartleft.jpg"})))

(defn -products
  []
  (column
    ["Stainless Exhaust Components"
     "Welded Sub Assemblies"
     "Steering Column Tube Jackets"
     "Cross Car Beam PS/DS Tubes"
     "Under Hood Braces"
     "Frame Crossmembers"
     "Seating Components"
     "Energy Management Tubes"
     "Trailer Hitch / Spare Tire Carrier"
     "Water Well Filter Tubes"
     "Well Bore Slotted Liners"]
    nil))

(defn -capabilities
  []
  (column
    ["Value Chain"
     "Perforate / Louver"
     "Extrusions"
     "End Sizing / Ram Forming"
     "Tube Bending"
     "Welding"
     "Machining"
     "Assembly"
     "Tube Cutting"
     "Aluminum Tubing"
     "Powder Coating"]
    nil))

(defn -contact
  []
  (column
   ["Sales Inquiries" "Canada" "Mexico"]
   (h/img {:class "column__img column__img--pos_right"
           :alt "Manufactured parts on the right"
           :src "static/images/homepartright.jpg"})))

(defn home
  []
  (layout
    "home"
    "Home"
    (h/section {:class "home"}
      (h/ul {:class "columns"}
        (-company)
        (-products)
        (-capabilities)
        (-contact))
      (h/img {:class "columns__footer"
              :alt "Exhaust components on bottom of page"
              :src "static/images/homepartbottom.jpg"}))))
