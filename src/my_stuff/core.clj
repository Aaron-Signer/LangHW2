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

;; (== n 1) does not work, no idea why
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
		(cons
			((first (rest lst)) (cons (first (first lst))
			(invert (rest lst)))))))

			; ((rest lst) (first lst))
			; (invert (rest lst)))))

(defn square-list
	[lst]
	(if (empty? lst)
	lst
	(cons
		(* (first lst) (first lst))
		(square-list (rest lst)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
