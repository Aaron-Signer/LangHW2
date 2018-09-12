(ns my-stuff.core
	(:require [clojure.tools.namespace.repl :refer [refresh]]
						[clojure.tools.trace :as tr]))

;Q1
(defn times3
	[n]
	(* n 3))

;Q2
(defn times3-or-4
	[n]
	(if (odd? n ) (* n 3) (* n 4)))

;Q3
(defn xcubed-plus-one
	[n]
	(+ (* n n n) 1))

;Q4
(defn sum-squares
	[n]
	(if (== n 1)
		1
		(+ (* n n) (sum-squares (dec n)))))

;1.15
(defn duple
	[n x]
	(if (= n 0)
		'()
		(if (<= n 1)
			(cons x nil)
			(cons x (duple (dec n) x)))))

;1.16
(defn invert
  	[lst]
    (if (empty? lst)
        lst
        (cons (list (first (rest (first lst))) (first (first lst)))
		(invert (rest lst)))))

;1.17
(defn down
	[lst]
	(if (empty? lst)
		lst
		(cons (list (first lst)) (down (rest lst)))))

;1.18
(defn swapper
	[s1 s2 lst]
		(if (empty? lst)
			lst
			(if (= s1 (first lst))
			(cons s2 (swapper s1 s2 (rest lst)))
				(if (= s2 (first lst))
				(cons s1 (swapper s1 s2 (rest lst)))
					(if (list? (first lst))
					(cons (swapper s1 s2 (first lst)) (swapper s1 s2 (rest lst)))
					(cons (first lst) (swapper s1 s2 (rest lst))))))))

;1.20
(defn count-occurances
	[a lst]
	(if (empty? lst)
	0
		(if (= a (first lst))
			(+ 1 (count-occurances a (rest lst)))
			(if (list? (first lst))
				(+ (count-occurances a (first lst)) (count-occurances a (rest lst)))
				(count-occurances a (rest lst))))))

;1.21
(defn product
	[lst1 lst2]
	(if (empty? lst1)
		lst1))

(tr/deftrace create-pairs
	[e1 lst]
	(if (empty? lst)
		lst
		(cons (list e1 (first lst)) (rest lst))))

;1.22
(defn filter-in
	[f lst]
	(if (empty? lst)
		lst
		(if (f (first lst))
			(cons (first lst) (filter-in f (rest lst)))
			(filter-in f (rest lst)) )))

;1.23
(defn find-index
	[f lst index]
	(if (empty? lst)
		false
		(if (f (first lst))
			index
			(find-index f (rest lst) (inc index)))))

(defn list-index
	[f lst]
	(find-index f lst 0))

;1.24
(defn my-every?
	[f lst]
	(if (empty? lst)
		true
		(if (f (first lst))
			(every? f (rest lst))
			false)))

;1.26
(defn up
	[lst]
	(if (empty? lst)
	lst
	))

;1.28
(defn my-merge
	[lst1 lst2]
	(if (empty? lst1)
	 (if (empty? lst2)
	 	lst1
		(cons (first lst2) (my-merge lst1 (rest lst2))))
		(if (empty? lst2)
			(cons (first lst1) (my-merge (rest lst1) lst2))
			(if (< (first lst1) (first lst2))
				(cons (first lst1) (my-merge (rest lst1) lst2))
				(cons (first lst2) (my-merge lst1 (rest lst2)))))))

;1.29
(defn my-sort
	[lst]
	0)
