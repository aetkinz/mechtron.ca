(ns mechtron.company
  (:require [clj-template.html5 :as h]
            [mechtron.core :refer [layout]]
            [clojure.string :as str]
            :reload-all))

(defn text
  [& content]
  (h/p {:class "text text--margin_bottom"}
    (str/join "\n" content)))

(defn about
  []
  (h/section {:class "group"}
    (h/h2 {:class "group__title"}
      "About")
    (text "Mechtron Innovations celebrates our 20th anniversary as an innovative leader in the supply of Tubular Value Add Components
and Sub Assemblies to our Automotive tiered customer base. We offer customer design support, in house sample and prototype manufacturing and timely response to our customer
production APQP launch requirements. Mechtron designs our own processes and tooling with a focus on technology innovation, lean manufacturing and process
flexibility. Our core business includes tube perforation / louvering, CNC bending, end sizing / ram forming, robotic welding,
machining and final coating. Our experienced automotive management team, competitive cost structure and available capacity
are focused on our continued company growth.")
    (text "We are conveniently located in Cambridge, Ontario, (off highway 401) and Saltillo Coahuila, Mexico.")))

(defn quality
  []
  (h/section {:class "group"}
    (h/h2 {:class "group__title"}
      "Quality")
    (text
      "Our Quality Management Systems comply with the International Standard"
      (h/a {:href "static/pdfs/certificate_ts_646516_mechtron_mexico.pdf" :target "_pdf_ts"}
        "TS16949: 2009")
      " and "
      (str (h/a {:href "static/pdfs/fm_552295_new_2017.pdf" :target "_pdf_iso"}
             "ISO 9001: 2015")
           ".")
      "Our dedicated leadership and active participation of all employees insures our focus in achieving Total Customer Satisfaction.")))

(defn company-group
  [{:keys [name description location website url]}]
  (h/li {:class "company-group"}
    (h/address {:class "company-group__address"}
      (h/h3 {:class "line company-group__name"}
        name)
      (h/p {:class "line company-group__description"}
        description)
      (h/span {:class "line company-group__location"}
        location)
      (h/span {:class "line company-group__website"}
        (h/a {:class "company-group__link" :href url :target (str "_company_" website)}
          website)))))

(defn corporate
  []
  (h/section {:class "group"}
    (h/h2 {:class "group__title"}
      "Corporate Group")
    (text "Mechtron Innovations: Engineered Tubular Steel / Aluminum Components, Sub-Assemblies and Custom Tooling Cambridge, Ontario, Saltillo Coahuila, Mexico.")
    (h/ul {:class "companies"}
      (company-group
       {:name "Kromet International"
        :description "Aluminum Exrusions and Machining"
        :location "Cambridge / Hamilton, Ontario, Canada, China JV, Nanning Guangxi Province"
        :website "www.kromet.com"
        :url "http://www.kromet.com/"})
      (company-group
        {:name "Shur-way Group"
         :description "Wood Pallets and Packaging Products"
         :location "Cambridge, Ontario, Canada"
         :website "www.shur-way.com"
         :url "http://www.shur-way.com/"}))))


(defn company
  []
  (layout
   "company"
   "Company"
   (h/section {:class "company page"}
     (about)
     (quality)
     (corporate))))
