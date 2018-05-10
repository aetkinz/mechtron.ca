(ns mechtron.core
  (:require [clj-template.html5 :as h]
            [clojure.string :as str]))

(def navbar {"company" "Company"
             "products" "Products"
             "capabilities" "Capabilities"
             "contact" "Contact"})

(defn navigation-item
  [selected [href title]]
  (h/li {:class (str "navbar__item" (when (= selected href) " navbar__selected"))}
    (h/a {:class "navbar__link" :href href} title)))

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
        (h/a {:class "logo__link" :href "/"}
          (h/span {:class "logo__text"} "Mechtron Industries")
          (h/img- {:class "header__logo"
                   :src "static/images/mechtron_logo.jpg"
                   :alt "Mechtron Industries"}))))
    (h/section {:class "header__blurb blurb"}
      (h/p {:class "blurb__text"} "Mechtron Innovations is Your Supplier of Tubular Value Add Components, Sub Assemblies and Custom Tooling to the Automative and Related Industries"))
    (h/section {:class "header__info"}
      (h/p {:class "header__contact"} "TS16949 / ISO 9001:2015")
      (h/p {:class "header__contact"} "519-624-9780")
      (h/a {:href "mailto:info@mechtron.ca"}
        (h/img- {:alt "Email Mechtron Industries" :src "static/images/emailicon.jpg"})
        "Email Us"))))

(defn layout
  [page title content]
  (h/html
    (h/head
      (h/meta- {:charset "utf-8"})
      (h/title (str "Mechtron Innovations Inc.: " title))
      (h/link- {:href "static/css/style.css" :rel "stylesheet"}))
    (h/body
      (h/div {:class "layout"}
        (header)
        (navigation page)
        (h/div {:class "layout__main"}
          content)))))
