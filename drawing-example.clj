(load-file "drawing-lib.clj")
(load-file "p-adic.clj")

(def frame (make-frame))

; very simple
;(defn fun [x y] (- x 400))
;(def drawing-fun (partial draw-function-color-circle-black-when-overflow fun 1))
;(draw-on-frame frame drawing-fun)
;(defn fun [x y] (bit-and x 0xff))
;(def drawing-fun (partial draw-function-color-circle-black-when-overflow fun 256))
;(draw-on-frame frame drawing-fun)
;(defn fun [x y] (* 80 (+ (/ Math/PI 2) (atan (/ (- x 500) 100)))))
;(def drawing-fun (partial draw-function-color-circle-black-when-overflow fun 1))
;(draw-on-frame frame drawing-fun)

; high frequency
; (defn fun [x y] (* (sin x) (cos y) (tan (* x y))))
;(def drawing-fun (partial draw-function-color-circle fun 100))
;(draw-on-frame frame drawing-fun)
; (def drawing-fun (partial draw-function-color-circle fun 10))
; (draw-on-frame frame drawing-fun)
; (def drawing-fun (partial draw-function-color-circle fun 0.01))
; (draw-on-frame frame drawing-fun)
;(def drawing-fun (partial draw-function-color-circle fun 0.1))
;(draw-on-frame frame drawing-fun)

; high frequency with interesting macro structure
; (defn fun [x y] (* (sin (/ x 100.0)) (cos (/ y 100.0)) (tan (/ (* x y) 300.0))))
; (def drawing-fun (partial draw-function-color-circle fun 0.1))
; (draw-on-frame frame drawing-fun)

; p-adic function: high frequency
; (defn fun [x y] (+ (* 1000 (exp-p x 17 10)) (* 500 (exp-p  y 19 10))))
; (def drawing-fun (partial draw-function-color-circle fun 0.1))
; (draw-on-frame frame drawing-fun)
; (defn fun [x y] (+ (* 1000 (exp-p x 17 10)) (* 500 (sin (/ y 100)))))
; (def drawing-fun (partial draw-function-color-circle fun 0.1))
; (draw-on-frame frame drawing-fun)

; rgb totally separate
; (draw-on-frame frame (partial draw-rgb-functions (fn [x y] (* 100 (atan2 (- x 500) (-  y 500)))) (fn [x y] (bit-and 0xff x y)) (fn [x y] (* 500 (sin (* x y))))))

; rgb sin of totally separate
;(draw-on-frame frame (partial draw-rgb-functions (fn [x y] (+ 150 (* 150 (sin (/ (* x y) 50)))))  (fn [x y] (+ 150 (* 150 (sin (/ (+ x y) 50)))))  (fn [x y] (+ 150 (* 150 (sin (/ (- (* 3 x) y) 50)))))))

; rgb sin of same function with different frequencies
;(draw-on-frame frame (partial draw-rgb-functions (fn [x y] (+ 150 (* 150 (sin (/ (bit-and 0xff x y) 50)))))  (fn [x y] (+ 150 (* 150 (sin (/ (bit-and 0xff x y) 60)))))  (fn [x y] (+ 150 (* 150 (sin (/ (bit-and 0xff x y) 70)))))))
;(draw-on-frame frame (partial draw-rgb-functions (fn [x y] (+ 150 (* 150 (sin (/ (* x y) 150)))))  (fn [x y] (+ 150 (* 150 (sin (/ (* x y) 160)))))  (fn [x y] (+ 150 (* 150 (sin (/ (* x y) 170)))))))
;(draw-on-frame frame (partial draw-rgb-functions (fn [x y] (+ 150 (* 150 (sin (/ (+ x y) 1.50)))))  (fn [x y] (+ 150 (* 150 (sin (/ (+ x y) 1.60)))))  (fn [x y] (+ 150 (* 150 (sin (/ (+ x y) 1.70)))))))

; show under-overflow
;(draw-on-frame frame (partial draw-function-color-circle-black-when-overflow (fn [x y] (* 100 (atan2 (- x 500) (-  y 500)))) 100))

; angle-based one center singulariy (wrong factor)
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (atan2 (- x 500) (-  y 500))) 0.25))

; angle-based one center (good)
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (atan2 (- x 500) (-  y 500))) (/ Math/PI 12)))

; angle-based two centers (good)
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (+ (atan2 (- x 300) (- y 500)) (atan2 (- x 700) (-  y 500)))) (/ Math/PI 12)))
; angle-based three centers (good)
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (+ (atan2 (- x 500) (- y 800)) (atan2 (- x 760) (-  y 350)) (atan2 (- x 240) (- y 350)))) (/ Math/PI 12)))
; multiply instead of add -> singularity
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (/ (* (+ Math/PI (atan2 (- x 500) (- y 800))) (+ Math/PI (atan2 (- x 760) (-  y 350))) (+ Math/PI (atan2 (- x 240) (- y 350)))) (* Math/PI Math/PI 4))) (/ Math/PI 12)))
; pythagoras instead of add -> singularity
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (sqrt (+ (** (atan2 (- x 500) (- y 800)) 2) (** (atan2 (- x 760) (-  y 350)) 2) (** (atan2 (- x 240) (- y 350)) 2)))) (/ Math/PI 12)))

; distance based one center
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (hyp (- x 500) (-  y 500))) 100))
; distance based two centers (+)
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (+ (hyp (- x 200) (-  y 500)) (hyp (- x 800) (- y 500)))) 170))
; distance based three centers (+)
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (+ (hyp (- x 500) (-  y 800)) (hyp (- x 760) (- y 350)) (hyp (- x 240) (- y 350)) )) 240))
; distance based two centers (+)
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (* (hyp (- x 200) (-  y 500)) (hyp (- x 800) (- y 500)))) 50000))
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (bit-xor (int (hyp (- x 200) (-  y 500))) (int (hyp (- x 800) (- y 500))))) 200))

; spirals
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500)] (+ (hyp xx yy) (* 200 (/ (atan2 xx yy) Math/PI))))) 200))
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500)] (+ (hyp xx yy) (* 200 (/ (atan2 xx yy) Math/PI))))) 50))
; (Thread/sleep 10)

; oscillate based on the radius
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy)] (+ r (* 10 (sin r)) (* 100 (/ (atan2 xx yy) Math/PI))))) 100))
; add some roughness from p-adic exp
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) rough (+ (* 100 (exp-p x 17 10)) (* 90 (exp-p  y 19 10)))] (+ r (* 10 (sin rough)) (* 100 (/ (atan2 xx yy) Math/PI))))) 100))
; (Thread/sleep 10)
; add roughness from bit-xor
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy)] (+ r (* 10 (sin (bit-xor x y))) (* 100 (/ (atan2 xx yy) Math/PI))))) 100))
; (Thread/sleep 10)

; morph the shape of the spiral: sin instead of linear angle
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 10 (sin (* 12 p))) (* 20 (/ p Math/PI))))) 20))
;(Thread/sleep 1000)
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 10 (sin (* 12 p))) (* 50 (/ p Math/PI))))) 50))
;(Thread/sleep 1000)
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 10 (sin (* 12 p))) (* 150 (/ p Math/PI))))) 150))
;(Thread/sleep 1000)
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 10 (sin (* 12 p))) (* 450 (/ p Math/PI))))) 450))
;(Thread/sleep 1000)
; morph the shape of the spiral: sin instead of linear radius
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ (* 50 (sin (/  r 100))) (* 120 (/ p Math/PI))))) 10))
;(Thread/sleep 10)
; morph angle and radisu
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ (* 50 (sin (/  r 100))) (* 40 (sin (* p 8)))))) 10))
;(Thread/sleep 10)

; morph with sec
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 10 (sec (* 12 p))) (* 50 (/ p Math/PI))))) 50))
;(Thread/sleep 10)
; morph with tan
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 10 (tan (* 12 p))) (* 50 (/ p Math/PI))))) 50))
; (Thread/sleep 10)

; rings combined with oscillation on product of angle and radius
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 10 (sin (*  p r))) (* 50 (/ p Math/PI))))) 50))
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 100 (sin (*  p r))) (* 50 (/ p Math/PI))))) 50))
; creates singularity
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (sin (* 0.001 p r)))) 0.25))
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (+ y 10) r (hyp xx yy) p (atan2 xx yy)] (sin (* 0.001 p r)))) 0.1))
;(Thread/sleep 10)

; morph with log
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 10 (Math/log (* 100 r))) (* 50 (/ p Math/PI))))) 50))
;(Thread/sleep 10)
; morph with exp
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 0.1 (min (Math/exp (/ (+ r p) 1000000)) 1000)) (* 50 (/ p Math/PI))))) 50))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* r (sin p)) (* 50 (/ p Math/PI))))) 50))
;(Thread/sleep 10)

; two points sum of distance
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ r1 r2))) 10))
;(Thread/sleep 10)

; two points bit-xor of distance
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (bit-xor (int r1) (int r2)))) 100))
; (Thread/sleep 10)
; two points product of distance
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (* r1 r2))) 10))
; (Thread/sleep 10)
; two points difference of distance
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (- r1 r2))) 50))
; (Thread/sleep 10)

; two points function on both angles and difference of distances
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* 100 (sin p1)) (* 100 (cos p2)) (- r1 r2)))) 50))
;(Thread/sleep 10)
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* 50 (atan (* (+ p1 (* 0.75 )) (- p2 (* 075 Math/PI))))) (- r1 r2)))) 50))
;(Thread/sleep 10)

; two points: sin of sum of distances
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (sin (/ (+ r1 r2) 50)))) (/ Math/PI)))
; (Thread/sleep 10)
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ p1 p2 (sin (/ (+ r1 r2) 50))))) Math/PI))
; (Thread/sleep 10)
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* 12 p1) p2 (sin (/ (+ r1 r2) 50))))) Math/PI))
; (Thread/sleep 10)

; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* 12 p1) (* 12 p2) (sin (/ (+ r1 r2) 50))))) Math/PI))
;(Thread/sleep 10)

; angles with different factors and oscillation on sum of distances
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* 13 p1) (* 11 p2) (sin (/ (+ r1 r2) 50))))) Math/PI))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ p1 p2 (* (tanh (* (Math/sqrt r1) 00.1)) (tanh (* (Math/sqrt r2) 0.01)) (sin (/ (+ r1 r2) 50)))))) Math/PI))
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ p1 p2 (* (tanh (* (Math/sqrt r1) 00.1)) (* 100 (tanh (* (Math/sqrt r2) 0.01))) (sin (/ (+ r1 r2) 50)))))) Math/PI))
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ p1 p2 (* (* (tanh (* (Math/sqrt r1) 00.1)) 100) (* 100 (tanh (* (Math/sqrt r2) 0.01))) (sin (/ (+ r1 r2) 50)))))) Math/PI))
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ p1 p2 (* (* 12 (tanh (* (Math/sqrt r1) 00.1))) (* 12 (tanh (* (Math/sqrt r2) 0.01))) (sin (/ (+ r1 r2) 50)))))) Math/PI))
;(Thread/sleep 10)
; weak influence of tanh
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* p1 25) (* p2 25) (* (tanh (* (Math/sqrt r1) 00.1)) (tanh (* (Math/sqrt r2) 0.01)) (sin (/ (+ r1 r2) 50)))))) Math/PI))
;(Thread/sleep 10)
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (tanh (/ r1 100)) (tanh (/ r2 100))))) 0.002))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (/ r1) (/ r2)))) 0.0001));
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (/ (Math/sqrt r1)) (/ (Math/sqrt r2))))) 0.01))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (/ (cos (/ r1 500))) (/ (sin (/ r2 500)))))) 0.01))
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (/ (cos (/ r1 500))) (/ (sin (/ r2 500)))))) 0.2))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (/ (sin (/ r1 500))) (/ (sin (/ r2 500)))))) 0.2))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (/ (sin (/ r1 500))) (/ (tan (/ r2 500)))))) 0.1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (sin (/ r1 200)) (sin (/ r2 200))))) 0.1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (sin (/ r1 200)) (sin (/ r2 200))))) 0.08))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (Math/tan (/ r1 200)) (Math/tan (/ r2 200))))) 0.08))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (bit-xor (* 11 (int (/ r1 6))) (* 13 (int (/ r2 6)))))) 0.7))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (bit-xor (* 11 (int (/ r1 12))) (* 13 (int (/ r2 12)))))) 3))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (bit-xor (* 13 (int (* p2 18))) (* 13 (int (* p1 18)))))) 3))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (bit-xor (* 13 (int (/ r2 18))) (* 13 (int (/ r1 18)))))) 3))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 r1 r2))) 1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 r1 r2))) 0.1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (sin (/ r1 100)) (sin (/ r2 100))))) 1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (cot (/ r1 750)) (cot (/ r2 750))))) 0.1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] 
;     (atan2 (cot (/ r1 750)) (cot (+ (/ r2 750) (sin (/ r1 20))))))) 0.1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (cot (/ r1 750)) (cot (+ (/ r2 750) (sin (/ r1 200))))))) 0.1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (cot (/ r1 750)) (cot (+ (/ r2 7500) (sin (/ r1 200))))))) 0.1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (cot (/ r1 1750)) (cot (+ (/ r2 2500) (sin (/ r1 100))))))) 0.1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (cot (+ (sin (* 10 p2)) (/ r1 2500))) (cot (+ (/ r2 2500) (sin (/ r1 100))))))) 0.1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (cot (+ (sin (* 10 p2)) (/ r1 2500))) (cot (+ (/ r2 2500) (sin (/ r1 100))))))) 0.2))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (cot (+ (sin (* 10 p2)) (/ (- r1 700) 2500))) (cot (+ (/ (- r2 700) 2500) (sin (/ r1 100))))))) 0.2))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (gauss (/ (- r1 500) 500) (/  (- r2 500) 500)))) 0.10))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (gauss (/ (- r1 500) 500) (+ (sin (* p1 2)) (/ (- r2 500) 500))))) 0.10))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (gauss (+ (sin (* p2 2)) (/ (- r1 500) 500)) (+ (sin (* p1 2)) (/ (- r2 500) 500))))) 0.10))
;(Thread/sleep 10)

; too high frequency
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (* r1 r2))) 100))
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (* r1 r2))) 5))
; (Thread/sleep 10)

; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (sin (* r1 r1 0.00001)) (sin (* r2 r2 0.00001))))) 1))
; (Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (tanh (* r1 r1 0.00001)) (tanh (* r2 r2 0.00001))))) 0.1))
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (tanh (* r1 r1 0.00001)) (tanh (* r2 r2 0.00001))))) 0.01))
;(Thread/sleep 10)

; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* 0.5 (sin (/ (+ x y) 10))) (ggt (int (/ r1 15)) (int (/ r2 15)))))) 1))
; (Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* 0.1 (sin (/ (+ x y) 10))) (ggt (int (/ r1 15)) (int (/ r2 15)))))) 1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ 1.2 (* 0.1 (sin (/ (- x y) 10))) (sin (* (/ Math/PI 12) (bit-xor (int (/ r1 15)) (int (/ r2 15)))))))) 0.1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ 1.2 (* 0.1 (sin (/ (- x y) 10))) (tan (* (/ Math/E 12) (bit-xor (int (/ r1 15)) (int (/ r2 15)))))))) 0.1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ r1 r2 (* r1 r2)))) 100))
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* 100 r1) (* 100 r2) (* r1 r2)))) 300))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ r1 r2 (* r1 r2)))) 250))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* r1 r1) (*  r2 r2) (* r1 r2)))) 250))
;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* r1 r1) (*  r2 r2) (* r1 r2)))) 2500))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* r1 r1 r1) (* 200  r2 r2) (* 300 r1 r2)))) 25000))
;(Thread/sleep 10)

; 3rd degree polynomial -> bubbles
; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* r1 r1 r1) (* 200  r2 r2) (* 300 r1 r2)))) 250000))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (let [u (sin (* 4 p1)) v (sin (* 4 p2))] (+ u v (* u v))))) 1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (let [u (sin (* 12 p1)) v (sin (* 12 p2))] (+ u v (* u v))))) 1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (let [u (sin (* 12 p1)) v (sin (* 12 p2))] (+ 1  (* u v))))) 0.2))
;(Thread/sleep 10)

; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (let [u (sin (* 12 p1)) v (sin (* 12 p2))] (+ 1  (* u v))))) (/ Math/E)))
; (Thread/sleep 10)

; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (let [u (sin (* 12 p1)) v (sin (* 12 p2))] (+ (tanh (/ (+ r1 r2) 200)) 1  (* u v))))) (/ Math/E)))
; (Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (let [u (sin (+ (* 12 p1) (/ r1 200))) v (sin (+ (* 12 p2) (/ r2 200)))] (+ (tanh (/ (+ r1 r2) 200)) 1  (* u v))))) (/ Math/E)))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (let [u (sin (+ (* 12 p1) (/ r1 200))) v (sin (+ (* 12 p2) (/ r2 200)))] (+ (tanh (/ (+ r1 r2) 200)) 1  (* 0.01 Math/E u v))))) (/ 0.1 Math/E)))
;(Thread/sleep 10)

; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ 5/3 (sin (* (/ x 100) (sin (/ y 100))))))) 1))
; (Thread/sleep 10)

; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ 5/3 (sin (* (/ x 100) (sin (/ y 50))))))) 1))
; (Thread/sleep 10)

; (draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ 5/3 (sin (* (/ r1 100) (sin (/ r2 50))))))) 1))
; (Thread/sleep 10)

; (draw-on-frame frame (partial draw-function-color-circle-darkened (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (- (+ r1 r2) 1000))) (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (smooth-rise (* r1 r2 (/ 25000))))) 100))
;(Thread/sleep 10)

; (draw-on-frame frame (partial draw-function-color-circle  (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (- (* (gauss  (/ (- x 500) 300) (/ (- y 500) 300)) 100) 50))) 8))
; (Thread/sleep 10)

; (draw-on-frame frame (partial draw-function-color-circle  (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (- (* (gauss  (* (sin (* p1 12)) (/ (- x 500) 300)) (* (sin (* p2 12)) (/ (- y 500) 300))) 100) 50))) 8))
; (Thread/sleep 10)

; (draw-on-frame frame (partial draw-function-color-circle  (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (- (* (gauss  (* (sin (* p1 12)) (/ (- x 500) 300)) (* (sin (* p2 12)) (/ (- y 500) 300))) 100) 50))) 8))
; (Thread/sleep 10)

; (draw-on-frame frame (partial draw-function-color-circle  (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (- (* (gauss  (* (sin (* p1 12)) (/ (- x 500) 300)) (* (tan (* p2 12)) (/ (- y 500) 300))) 100) 50))) 8))
; (Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle  (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2) pp1 (+ p1 (* 1/4 Math/PI)) pp2 (+ p2 (* 5/4 Math/PI))] (* (sin (* 12 pp1))  (sin (* 12 pp2))))) 1))
;(Thread/sleep 10)

;(draw-on-frame frame (partial draw-function-color-circle-hsv  (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2) pp1 (+ p1 (* 1/4 Math/PI)) pp2 (+ p2 (* 5/4 Math/PI))] (* (sin (* 12 pp1))  (sin (* 12 pp2))))) 1))
;(Thread/sleep 10)

; (draw-on-frame frame (partial draw-function-color-circle  (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2) pp1 (+ p1 (* 1/4 Math/PI)) pp2 (+ p2 (* 5/4 Math/PI))] (+ (sin (/ x 50)) (sin (sin (/ y 50))) (sin (/ x 30))))) 0.02))

;(draw-on-frame frame (partial draw-function-color-circle  (fn [x y] (sin (* (/ x 100) (sin (/ y 100))))) 0.1))
;(draw-on-frame frame (partial draw-function-color-circle  (fn [x y] (sin (* (/ y 100) (sin (/ x 100))))) 0.1))
;(draw-on-frame frame (partial draw-function-color-circle  (fn [x y] (+ (sin (* (/ x 100) (sin (/ y 100)))) (sin (* (/ y 100) (sin (/ x 100)))))) 0.2))
;(draw-on-frame frame (partial draw-function-color-circle  (fn [x y] (* (+ 1 (sin (* (/ x 100) (sin (/ y 100))))) (+ 1 (sin (* (/ y 100) (sin (/ x 100))))))) 0.2))

; plot sin and atan
;(defn fun [x y] (- (* (sin (/ x 50)) 100) (- y 500)))
;(def drawing-fun (partial draw-function-color-circle fun 100))
;(draw-on-frame frame drawing-fun)
;(defn fun [x y] (- (* (atan (/ (- x 500) 50)) 100) (- y 500)))
;(def drawing-fun (partial draw-function-color-circle fun 100))
;(draw-on-frame frame drawing-fun)

; give it more dynamic
;(defn fun [x y] (sin (/ (- (* (sin (/ x 50)) 100) (- y 500)) 200)))
;(def drawing-fun (partial draw-function-color-circle fun 0.1))
;(draw-on-frame frame drawing-fun)
;(defn fun [x y] (sin (/ (- (* (atan (/ (- x 500) 50)) 100) (- y 500)) 200)))
;(def drawing-fun (partial draw-function-color-circle fun 0.2))
;(draw-on-frame frame drawing-fun)

; combine graphs of f(x)-y and f(x)-x
; with sum of both

;(defn fun [x y] (let [u (- (* (sin (/ x 50)) 100) (- y 500))
;                      v (- (* (sin (/ y 50)) 100) (- x 500))]
;                 (+ u v)))
;(def drawing-fun (partial draw-function-color-circle fun 100))
;(draw-on-frame frame drawing-fun)

;(defn fun [x y] (let [u (- (* (atan (/ (- x 500) 50)) 100) (- y 500))
;                      v (- (* (atan (/ (- y 500) 50)) 100) (- x 500))]
;                 (+ u v)))
;(def drawing-fun (partial draw-function-color-circle fun 100))
;(draw-on-frame frame drawing-fun)

; with pythagoras diagonal of both
;(defn fun [x y] (let [u (- (* (sin (/ x 50)) 100) (- y 500))
;                      v (- (* (sin (/ y 50)) 100) (- x 500))]
;                 (hyp u v)))
;(def drawing-fun (partial draw-function-color-circle fun 100))
;(draw-on-frame frame drawing-fun)
;(defn fun [x y] (let [u (- (* (atan (/ (- x 500) 50)) 100) (- y 500))
;                      v (- (* (atan (/ (- y 500) 50)) 100) (- x 500))]
;                 (hyp u v)))
;(def drawing-fun (partial draw-function-color-circle fun 100))
;(draw-on-frame frame drawing-fun)

; with product of both
;(defn fun [x y] (let [u (- (* (sin (/ x 50)) 100) (- y 500))
;                      v (- (* (sin (/ y 50)) 100) (- x 500))]
;                 (* u v)))
;(def drawing-fun (partial draw-function-color-circle fun 10000))
;(draw-on-frame frame drawing-fun)


;(defn fun [x y] (let [u (- (* (atan (/ (- x 500) 50)) 100) (- y 500))
;                      v (- (* (atan (/ (- y 500) 50)) 100) (- x 500))]
;                 (* u v)))
;(def drawing-fun (partial draw-function-color-circle fun 10000))
;(draw-on-frame frame drawing-fun)

;
(defn fun [x y] (let [u (sin (/ (- (* (sin (/ x 50)) 100) (- y 500)) 500))
                      v (sin (/ (- (* (sin (/ y 50)) 100) (- x 500)) 500))]
                 (* u v)))
(def drawing-fun (partial draw-function-color-circle fun 0.2))
(draw-on-frame frame drawing-fun)
