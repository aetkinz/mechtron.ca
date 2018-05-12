(ns mechtron.products
  (:require [clj-template.html5 :as h]
            [mechtron.core :refer [layout]]
            [clojure.string :as str]
            :reload-all))

(def products-list [{:name "Stainless Steel Grades 304 - 441"
                     :slug "steel"
                     :description "Resistance Welding"
                     :img "stainless_steel_grads_304_441_resistance_welding.jpg"}
                    {:name "Perforate Bend Tangent and Bends"
                     :slug "bend"
                     :img "perforate_bend_tanget_bends.jpg"}
                    {:name "CNC Bending - Multi Stack 1D (1 X Diameter)"
                     :slug "cnc-bending"
                     :img "cnc_bending_multi_stack_1d.jpg"}
                    {:name "Severe Expansion and Reduction"
                     :slug "severe-expansion"
                     :description "Unique Hole and Slot Patterns"
                     :img "severe_expansion_reduction_unique_hole_slot_patterns.jpg"}
                    {:alt "Edge Rolling of Tube Ends (top), Ram Form Sizing (bottom left), Carbon Steel - Mechanical & DOM (bottom right)"
                     :slug "edge-rolling"
                     :top "Edge Rolling of Tube Ends"
                     :left "Ram Form Sizing"
                     :right "Carbon Steel - Mechanical & DOM"
                     :img "edge_tube_ends_ram_forming_mechanical_dom.jpg"}
                    {:name "CNC Machining"
                     :slug "cnc-machining"
                     :img "cnc_machining.jpg"}
                    {:name "Hole Piercing"
                     :slug "hole-piercing"
                     :img "hole_piercing.jpg"}
                    {:name "Powder Coating"
                     :slug "powder-coating"
                     :img "powder_coating.jpg"}
                    {:name "Robotic MIG Welding"
                     :slug "robotic-mig"
                     :alt "Robotic MIG Welding Assembly"
                     :description "Assembly"
                     :img "robotic_mig_welding_assembly.jpg"}
                    {:name "Perforation on Weld Seam"
                     :slug "weld-seam"
                     :img "perforation_weld_seam.jpg"}
                    {:name "Minimal Deformation"
                     :slug "minimal-deformation"
                     :img "minimal_deformation.jpg"}
                    {:name "Extrusions - Inward and Outward"
                     :description "DF/WF Style Louvers"
                     :slug "extrusions"
                     :alt "Extrusions - Inward and Outward DF/WF Style Louvers"
                     :img "extrusions_inward_outward_df_wf_louvers.jpg"}])

(defn product
  [{:keys [name slug img alt description top left right]}]
  (h/li {:class (str
                 "product group"
                 " product--slug_" slug
                 (when (or top left right)
                   " product--labels_absolute"))}
    (h/img- {:class "product__img"
             :alt (or alt name)
             :src (str "static/images/" img)})
    (when name
      (h/h2 {:class "product__title product__name"}
        name))
    (when description
      (h/h2 {:class "product__title product__description"}
        description))
    (when top
      (h/h2 {:class "product__title product__top"}
        top))
    (when left
      (h/h2 {:class "product__title product__left"}
        left))
    (when right
      (h/h2 {:class "product__title product__right"}
        right))))

(defn products
  []
  (layout
    "products"
    "Products"
    (h/section {:class "products page"}
      (h/ul {:class "products-list"}
        (str/join "\n" (map product products-list))))))
