(defproject exoscale/ex-auspex "0.1.2"
  :dependencies [[cc.qbits/auspex "0.1.0-alpha2"]]
  :profiles {:dev {:dependencies [[exoscale/ex :version]]}}
  :plugins [[lein-modules "0.3.11"]]
  :modules {:parent "../../"})
