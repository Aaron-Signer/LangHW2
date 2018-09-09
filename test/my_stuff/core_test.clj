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
        (is (= (duple 1 'HA!)) '(HA!))))
