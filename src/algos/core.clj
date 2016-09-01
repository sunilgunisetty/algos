(ns algos.core)



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 1. Sum of subset problem
;; Given a set and a num, find a subset which sums to the number.
;; Example #{1 2 3 4 5} 6 =>> #{4 2}
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn sum-of-subset
  "set = set of numbers
   sum = total sum
   subset = subset which adds to sum"
  [set sum subset]
  (cond
    (= sum 0) {:status :success :res subset}
    (or (< sum 0) (empty? set)) {:status :fail :res #{}}
    :else
    (let [res1 (sum-of-subset (rest set) (- sum (first set)) (conj subset (first set)))
          res2 (sum-of-subset (rest set) sum subset)]
      (cond
        (and (= (:status res1) :fail)
             (= (:status res2) :fail)) {:status :fail :res #{}}
        (= (:status res2) :success) {:status :success :res (:res res2)}
        (= (:status res1) :success) {:status :success :res (:res res1)}
        :else {:status :success
               :res (if (> (count (:res res1)) (count (:res res2)))
                      (:res res2)
                      (:res res1))}))))
