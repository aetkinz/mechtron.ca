(ns mechtron.capabilities
  (:require [clj-template.html5 :as h]
            [mechtron.core :refer [layout]]
            [clojure.string :as str]
            :reload-all))

(defn line
  [text]
  (h/span {:class "line"} text))

(def capabilities-list
  [{:title [(line "Research")
            (line "And")
            (line "Development")]
    :slug "research-development"
    :features ["Engineering"
               "CAD Design"
               "Optimization"
               "3D Printing"
               "Prototyping"]
    :img ["research_development_cad.jpg"]}
   {:title "Tooling And Equipment"
    :slug "tooling"
    :features ["Design"
               "In House Build"
               "Tool Room"
               "Machine Build"
               "Integration"]
    :img ["tooling.jpg"]}
   {:title "Tube Value Add And Perforate"
    :slug "tube"
    :features ["Perforate"
               "Bending"
               "Forming"
               "Size/Extrude"
               "Machining"]
    :img ["3d_printer.jpg"
          "3d_prints.jpg"]}
   {:title "Sub-Assembly And Quality Check"
    :slug "quality"
    :features ["Welding"
               "Coating"
               "Assembly"
               "Purchased"
               "Quality Control"]
    :img ["quality_control.jpg"]}])


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
      title)
    (h/ul {:class "capability__features"}
      (str/join "\n" (map feature features)))
    (h/div {:class "capability__photos"}
      (str/join "\n"
        (map #(capability-img title %) img)))))

(defn capabilities
  []
  (layout
    "capabilities"
    "Capabilities"
    (h/section {:class "capabilities"}
      (h/ul {:class "capabilities__list"}
        (str/join "\n" (map capability capabilities-list))))))
