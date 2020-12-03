(defproject hello-world "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [
    [org.clojure/clojure "1.10.1"]
    [compojure "1.6.2"]
    [http-kit "2.3.0"]
    [ring/ring-core "1.8.2"]
    [ring/ring-json "0.5.0"]
    [ring/ring-defaults "0.3.2"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler api.handler/app}
  :main ^:skip-aot hello-world.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
