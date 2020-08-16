(ns leiningen.new.quil-template
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "quil-template"))

(defn quil-template
  "A Quil template."
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' quil-template project.")
    (->files data
             ["src/clj/{{sanitized}}/core.clj" (render "core.clj" data)]
             [".gitignore" (render "gitignore" data)]
             [".java-version" (render "java-version" data)]
             ["project.clj" (render "project.clj" data)])))
