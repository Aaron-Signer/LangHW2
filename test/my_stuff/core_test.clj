(ns my-stuff.core-test
  (:require [clojure.test :refer :all]
            [my-stuff.core :refer :all]))

(deftest times3-test
  (testing "times3 returns n*3."
    (is (= (times3 3) 9))
    (is (= (times3 24) 72))))

(deftest times3-or-4-test
	(testing "times3-or-4 returns n*3 if n is odd and n*4 if n is even"
		(is (= (times3-or-4 7) 21))
		(is (= (times3-or-4 8) 32))))

(deftest xcubed-plus-one-test
	(testing "xcubed-plus-one returns x cubed plus 1"
		(is (= (xcubed-plus-one 3)) 10)))

(deftest sum-squares-test
	(testing "sum-squares returns the sum of i squared from 1 to n"
		(is (= (sum-squares 1)) 1)
		(is (= (sum-squares 2)) 5)
		(is (= (sum-squares 3)) 11)))

(deftest duple-test
    (testing "duple returns a list of elements repeated n times"
    	  (is (= (duple 2 4) '(4 4)))
        (is (= (duple 3 '(Blah Blah)) '((Blah Blah) (Blah Blah) (Blah Blah))))
        (is (= (duple 1 'HA!) '(HA!)))
        (is (= (duple 0 'HA!) '()))))

(deftest invert-test
    (testing "invert returns a list where each element is a 2 element list witht he elements reversed"
        (is (= (invert '((1 2) (3 4))) '((2 1)(4 3))))
        (is (= (invert '((3 4))) '((4 3))))
        (is (= (invert '())) '())))

(deftest down-test
    (testing "down returns a list of elements where each element is wrapped in a layer of parenthesis"
        (is (= (down '()) '()))
        (is (= (down '(1)) '((1))))
        (is (= (down '(1 2 3)) '((1) (2) (3))))
        (is (= (down '(1 2 (3))) '((1) (2) ((3)))))))

(deftest swapper-test
  (testing "swapper swaps the first argurment with the second argument and vice versa for each element in the list"
    (is (= (swapper 'a 'b '( a a b b)) '(b b a a)))
    (is (= (swapper 'a 'b '((a) a b b)) '((b) b a a)))
    (is (= (swapper 'a 'b '((a) (a) b b)) '((b) (b) a a)))
    (is (= (swapper 'a 'b '(a (a) b (b))) '(b (b) a (a))))
    (is (= (swapper 'a 'd '(a d () c d)) '(d a () c a)))))

(deftest count-occurances-test
  (testing "count-occurances returns the number of times an element exists in a list and any possible nested list"
    (is (= (count-occurances 'a '(a b d a a a)) 4))
    (is (= (count-occurances 'a '((a b a) d a a a)) 5))
    (is (= (count-occurances 'a '(a b (a d) a a a)) 5))))

(deftest product-test
  (testing "product returns the cartesian product of two lists"
    (is (= (product '(a b) '(1 2)) '((a 1) (a 2) (b 1) (b 2))))))

(deftest create-pairs-test
  (testing "create-pairs takes to arugments and returns a list of the two arguments"
    (is (= (create-pairs 'a '(b)) '((a b))))))

(deftest filter-in-test
  (testing "filter-in takes a list and type f and returns a list where the elements are only of type f"
  (is (= (filter-in number? '(a 2 (1 3) b 7)) '(2 7)))
  (is (= (filter-in number? '(1 2 3 4)) '(1 2 3 4)))))

(deftest list-index-test
  (testing "returns the first index of the type passed in, or false if not found"
  (is (= (list-index number? '(a 2 (1 3) b 7)) 1))
  (is (= (list-index symbol? '(1 2 (a b) 3)) false))
  (is (= (list-index number? '(a d (1 3) b 7)) 4))))

(deftest my-every?-test
  (testing "for a given list and pred, return true if every element in the list is of type pred, otherwise return false"
    (is (= (my-every? number? '(a b c 3 e)) false))
    (is (= (every? number? '(1 2 3 5 4)) true))))

(deftest up-test
  (testing "for a given list and pred, return true if every element in the list is of type pred, otherwise return false"
    (is (= (up '((1 2) (3 4))) '(1 2 3 4)))
    (is (= (up '((x (y)) z)) '(x (y) z)))))

(deftest my-merge-test
  (testing "for a given list and pred, return true if every element in the list is of type pred, otherwise return false"
    (is (= (my-merge '(1 4) '(1 2 8)) '(1 1 2 4 8)))
    (is (= (my-merge '(35 62 81 90 91) '(3 83 85 90)) '(3 35 62 81 83 85 90 90 91)))))

(deftest my-sort-test
  (testing "for a given list and pred, return true if every element in the list is of type pred, otherwise return false"
    (is (= (my-sort '(8 2 5 2 3)) '(2 2 3 5 8)))))
