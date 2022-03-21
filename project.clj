(defproject fi.polycode/gh-action-debug "_"
  :description "GitHub Actions debugging project"
  :url "https://github.com/esuomi/lein-git-revisions"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}

  :scm {:name "git" :url "https://github.com/esuomi/gh-actions-runner-debug"}

  :eval-in-leiningen true

  :dependencies []

  :global-vars {*warn-on-reflection* true}

  :source-paths   ["src/main/clj"]
  :test-paths     ["src/test/clj"]
  :resource-paths ["src/main/resources"]
  :target-path    "target/%s"
  :repl-options {:init-ns gh-runner-debug}

  :profiles {:dev {:dependencies [[lambdaisland/kaocha "1.64.1010"]
                                  [lambdaisland/kaocha-cloverage "1.0.75"]]}}

  :aliases {"kaocha" ["run" "-m" "kaocha.runner"]})
