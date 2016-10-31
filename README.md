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

## Data source

The data in `/resources/zip-city-state-timezone.edn` comes from the US Postal
Service. It can be downloaded in CSV format from 
http://www.usps.com/mailtracking/_csv/NonAutomated5Digit.csv.

We have modified the original file as follows:

- Convert integer ZIP codes to strings (sometimes they start with 0's).
- Convert to an EDN map (for easier ingestion in Clojure).
- Only keep the first instance of a given ZIP code.
    - The original file sometimes repeats ZIP codes, but since they become map
      keys they must be unique. So we just throw away all but the first.

## License

Copyright © 2016 Democracy Works, Inc.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
