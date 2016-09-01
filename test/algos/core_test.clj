(ns algos.core-test
  (:require [clojure.test :refer :all]
            [algos.core :refer :all]))


(deftest sum-of-subset-test
  (testing "Sum of Subset"
    (is (= 6 (apply + (:res (sum-of-subset #{1 2 3 4 5} 6 #{})))))
    (is (= 17 (apply + (:res (sum-of-subset #{1 2 3 4 5 9 8 7} 17 #{})))))
    (is (= 27 (apply + (:res (sum-of-subset #{1 2 3 4 5 9 8 7} 27 #{})))))
    (is (= 37 (apply + (:res (sum-of-subset #{1 2 3 4 5 9 8 7} 37 #{})))))
    (is (= :fail (:status (sum-of-subset #{1 2 3 4 5 9 8 7} 47 #{}))))))
