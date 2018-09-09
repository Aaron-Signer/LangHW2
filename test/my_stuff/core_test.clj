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
    	(is (= (duple 2 4)) '(4 4))
        (is (= (duple 3 '(Blah Blah))) '((Blah Blah) (Blah Blah) (Blah Blah)))
        (is (= (duple 1 'HA!)) '(HA!))
        (is (= (duple 0 'HA!)) '())))

(deftest invert-test
    (testing "invert returns a list where each element is a 2 element list witht he elements reversed"
        (is (= (invert '((1 2) (3 4)))) '((2 1)(4 3)))
        (is (= (invert '((3 4)))) '((4 3)))
        (is (= (invert '())) '())))

(deftest down-test
    (testing "down returns a list of elements where each element is wrapped in a layer of parenthesis"
        (is (= (down '())) '())
        (is (= (down '(1))) '((1)))
        (is (= (down '(1 2 3))) '((1) (2) (3)))
        (is (= (down '(1 2 (3))) '((1) (2) ((3)))))))
