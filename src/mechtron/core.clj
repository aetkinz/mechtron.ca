(ns mechtron.core
  (:require [clj-template.html5 :as h]
            [clojure.string :as str]))

(def navbar {"./" "Home"
             "company.htm" "Company"
             "products.htm" "Products"
             "capabilities.htm" "Capabilities"
             "contact.htm" "Contact"})

(defn navigation-item
  [selected [href title]]
  (when-not (and (= title "Home") (= selected "home"))
    (h/li {:class (str "navbar__item" (when (str/starts-with? href selected) " navbar__selected"))}
      (h/a {:class "navbar__link" :href href} title))))

(defn navigation
  [selected]
  (h/nav {:class "navbar"}
   (h/ul {:class "navbar__items"}
     (str/join "\n" (mapv #(navigation-item selected %) navbar)))))

(defn header
  []
  (h/header {:class "header"}
    (h/section {:class "header__logo logo"}
      (h/h1 {:class "logo__title"}
        (h/a {:class "logo__link" :href "./"}
          (h/span {:class "logo__text"} "Mechtron Industries")
          (h/img- {:class "logo__img"
                   :src "static/images/mechtron_logo.jpg"
                   :alt "Mechtron Industries"}))))
    (h/section {:class "header__blurb blurb"}
      (h/p {:class "blurb__text"}
        (h/span {:class "line"}
          "Mechtron Innovations is Your Supplier of Tubular")
        (h/span {:class "line"}
          "Value Add Components, Sub Assemblies and Custom")
        (h/span {:class "line"}
          "Tooling to the Automative and Related Industries")))
    (h/section {:class "header__info"}
      (h/p {:class "header__id"} "TS16949 / ISO 9001:2015")
      (h/p {:class "header__phone"} "519-624-9780")
      (h/a {:class "header__email" :href "mailto:info@mechtron.ca"}
        "Email Us"))))

(defn layout
  [current-page title content]
  (h/html
    (h/head
      (h/meta- {:charset "utf-8"})
      (h/title (str "Mechtron Innovations Inc.: " title))
      (h/link- {:href "static/css/style.css" :rel "stylesheet"})
      (h/meta- {:name "viewport" :content "width=device-width, initial-scale=1"})
      (h/link- {:href "static/images/favicon.png" :rel "icon" :type "image/png"}))
    (h/body
      (h/div {:class (str "layout layout--page_" current-page)}
        (header)
        (navigation current-page)
        (h/div {:class "layout__main"}
          content)))))

(defn line
  [text]
  (h/span {:class "line"} text))
