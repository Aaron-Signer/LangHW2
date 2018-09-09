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

(defn duple
	[n x]
	(if (<= n 1)
		(cons x nil)
		(cons x (duple (dec n) x))))

(defn invert
  	[lst]
    (if (empty? lst)
        lst
        (cons (list (first (rest (first lst))) (first (first lst)))
		(invert (rest lst)))))

(defn down
	[lst]
	(if (empty? lst)
		lst
		(cons (list (first lst)) (down (rest lst)))))