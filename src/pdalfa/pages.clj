(ns pdalfa.pages
  (:require [hiccup.core :refer [html]]
            [hiccup.page :as hp]))

(defn base
  [nama content]
  (hp/html5
    [:head
     (hp/include-css "https://cdnjs.cloudflare.com/ajax/libs/foundation/5.5.2/css/foundation.min.css")]
    [:body.row
     [:center
      [:h1 (str "Hello " nama "!")]
      [:h5 "This greeting is powered by pedestal"]
      [:hr]
      [:br]
      [:p (map #(vector :li (str %)) content)]]]))

(defn home
  [request]
  (let [{:keys [path-params]} request]
    (if (> (count (:kalian path-params)) 0)
      (base (:kalian path-params) request)
      (base "Joni" request))))

