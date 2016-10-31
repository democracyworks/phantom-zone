# phantom-zone

A Clojure library for translating US ZIP codes to city, state, and timezone

## Usage

Add this to your project dependencies:

![](https://clojars.org/democracyworks/phantom-zone/latest-version.svg)

```clojure
(ns my.proj
  (:require [phantom-zone.core :refer [zipcode->city-state-timezone]]))
  
(defn my-fn [zip]
  (println "The ZIP code" zip "is in"
           (zipcode->city-state-timezone zip)))
```


## License

Copyright © 2016 Democracy Works, Inc.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
