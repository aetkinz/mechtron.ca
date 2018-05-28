(ns mechtron.contact
  (:require [clj-template.html5 :as h]
            [mechtron.core :refer [layout line]]
            [clojure.string :as str]
            :reload-all))

(defn exhaust-products
  []
  (h/address {:class "contact"}
    (h/h3 {:class "contact__title"}
      "Exhaust Products")
    (line "Mary Ventimiglia")
    (h/span {:class "line contact__phone"} "586-709-7547")
    (h/a {:class "line contact__link"
          :href "mailto:mary.ventimiglia@mechtron.ca"}
      "mary.ventimiglia@mechtron.ca")))

(defn non-exhaust-products
  []
  (h/address {:class "contact"}
    (h/h3 {:class "contact__title"}
      "Non-Exhaust Products")
    (line "Mark Dremak")
    (h/span {:class "line contact__phone"} "226-820-5596")
    (h/a {:class "line contact__link"
          :href "mailto:mark.dremak@mechtron.ca"}
      "mark.dremak@mechtron.ca")))

(defn canada-location
  []
  (h/address {:class "contact contact__canada"}
    (h/span {:class "group"}
      (h/h3 {:class "contact__title"}
        "Mechtron Innovations Inc")
      (line "1250 Franklin Blvd")
      (line "Cambridge ON N1R 8B7")
      (line "CANADA"))
    (h/span {:class "group"}
      (h/span {:class "line contact__phone"} "519-624-9780")
      (h/a {:class "line contact__link"
            :href "mailto:info@mechtron.ca"}
        "info@mechtron.ca"))))

(defn mexico-location
  []
  (h/address {:class "contact contact__mexico"}
    (h/span {:class "group"}
      (h/h3 {:class "contact__title"}
        "Mechtron Innovations Inc")
      (line "Carretera Saltillo")
      (line "Coahuila 25315")
      (line "MEXICO"))
    (h/span {:class "group"}
      (h/span {:class "line contact__phone"} "519-624-9780")
      (h/a {:class "line contact__link"
            :href "mailto:info@mechtron.ca"}
        "info@mechtron.ca"))))

(defn contact
  []
  (layout
   "contact"
   "Contact"
   (h/section {:class "contacts"}
     (h/div {:class "contacts__header"}
       (h/h2 {:class "contacts__title"}
         "Sales Inquiries"))
     (h/div {:class "contacts__sections"}
       (h/div {:class "contacts__section contacts__sales"}
         (exhaust-products)
         (non-exhaust-products))
       (h/div {:class "contacts__section contacts__locations"}
         (canada-location)
         (mexico-location))))))
