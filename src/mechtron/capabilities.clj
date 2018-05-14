(ns mechtron.capabilities
  (:require [clj-template.html5 :as h]
            [mechtron.core :refer [layout line]]
            [clojure.string :as str]
            :reload-all))

(def capabilities-list
  [{:title ["Research" "And" "Development"]
    :slug "research-development"
    :features ["Engineering"
               "CAD Design"
               "Optimization"
               "3D Printing"
               "Prototyping"]}
   {:title ["Tooling" "And" "Equipment"]
    :slug "tooling"
    :features ["Design"
               "In House Build"
               "Tool Room"
               "Machine Build"
               "Integration"]}
   {:title ["Tube" "Value Add" "And Perforate"]
    :slug "tube"
    :features ["Perforate"
               "Bending"
               "Forming"
               "Size/Extrude"
               "Machining"]}
   {:title ["Sub-Assembly" "And" "Quality Check"]
    :slug "quality"
    :features ["Welding"
               "Coating"
               "Assembly"
               "Purchased"
               "Quality Control"]}])


(defn feature
  [name]
  (h/li {:class "capability__feature"}
    name))

(defn capability-img
  [title filename]
  (h/img- {:class "capability__img"
           :alt title
           :src (str "static/images/" filename)}))

(defn capability
  [{:keys [title slug features img]}]
  (h/li {:class (str "capability" " capability--slug_" slug)}
    (h/h2 {:class "capability__arrow"}
      (h/span {:class "capability__title"}
        (str/join "\n" (map line title))))
    (h/ul {:class "capability__features"}
      (str/join "\n" (map feature features)))))

(defn process
  []
  (h/ul {:class "capabilities__arrows"}
    (str/join "\n" (map capability capabilities-list))))

(defn photos
  []
  (h/ul {:class "capabilities__photos"}
    (h/li {:class "capabilities__photo"}
      (h/img- {:class "capabilities__img"
               :alt "Drawing in CAD"
               :src "static/images/research_development_cad.jpg"}))
    (h/li {:class "capabilities__photo"}
      (h/img- {:class "capabilities__img"
               :alt "Tooling with in-house equipment"
               :src "static/images/tooling.jpg"}))
    (h/li {:class "capabilities__photo"}
      (h/img- {:class "capabilities__img"
               :alt "3D Printer"
               :src "static/images/3d_printer.jpg"}))
    (h/li {:class "capabilities__photo"}
      (h/img- {:class "capabilities__img"
               :alt "3D Prints"
               :src "static/images/3d_prints.jpg"}))
    (h/li {:class "capabilities__photo"}
      (h/img- {:class "capabilities__img"
               :alt "Quality control with detailed assembly labeling"
               :src "static/images/quality_control.jpg"}))))

(defn capabilities
  []
  (layout
    "capabilities"
    "Capabilities"
    (h/section {:class "capabilities"}
      (process)
      (photos))))
