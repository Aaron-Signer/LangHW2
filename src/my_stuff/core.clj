(ns my-stuff.core
	(:require [clojure.tools.namespace.repl :refer [refresh]]))

(defn times3
	[n]
	(* n 3))

(defn times3-or-4
	[n]
	(if (odd? n ) (* n 3) (* n 4)))

(defn xcubed-plus-one
	[n]
	(+ (* n n n) 1))

(defn sum-squares
	[n]
	(if (== n 1)
		1
		(+ (* n n) (sum-squares (dec n)))))

;1.15
(defn duple
	[n x]
	(if (<= n 1)
		(cons x nil)
		(cons x (duple (dec n) x))))

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
	(if (list? (first lst))
		(count-occurances a (first lst))
	(if (empty? lst)
	0
		(if (= a (first lst))
		(+ 1 (count-occurances a (rest lst)))
		(+ 0 (count-occurances a (rest lst)))))))

;1.21
(defn product
	[lst1 lst2]
	(if (empty? lst1)
		lst1))

; (defn create-pair
; 	[e1 e2]
; 	(list e1 e2))

;1.22
(defn filter-in
	[f lst]
	(if (empty? lst)
		lst
		(if (f (first lst))
			(cons (first lst) (filter-in f (rest lst)))
			(cons (filter-in f (rest lst)) nil))))

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
