(defproject ex-parent "0.1.0-SNAPSHOT"

  :plugins [[lein-modules "0.3.11"]]

  :modules {:dirs ["modules/ex"
                   "modules/ex-manifold"
                   "modules/ex-auspex"]
            :inherited {:source-paths ["src/clj"]
                        :url "https://github.com/exoscale/ex"
                        :pedantic? :warn}
            :versions {org.clojure/clojure "1.10.1"}
            :monkeypatch-clojure-test false
            :subprocess nil}

  :release-tasks [["vcs" "assert-committed"]
                  ["modules" "change" "version" "leiningen.release/bump-version" "release"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["modules" "install"]
                  ["modules" "deploy" "clojars"]
                  ;; ["deploy" "clojars"]
                  ["modules" "change" "version" "leiningen.release/bump-version"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]])