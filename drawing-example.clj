(load-file "drawing-lib.clj")

; (def frame (make-frame))

;(defn fun [x y] (* (sin x) (cos y) (tan (* x y))))

;(def drawing-fun (partial draw-function-color-circle fun 100))

;(draw-on-frame frame drawing-fun)

;(def drawing-fun (partial draw-function-color-circle fun 0.01))

; (draw-on-frame frame drawing-fun)

;(def drawing-fun (partial draw-function-color-circle fun 0.1))

;(draw-on-frame frame drawing-fun)

; (defn fun [x y] (* (sin (/ x 100.0)) (cos (/ y 100.0)) (tan (/ (* x y) 300.0))))

; (def drawing-fun (partial draw-function-color-circle fun 0.1))

; (draw-on-frame frame drawing-fun)

(def frame (make-frame))

;(defn fun [x y] (* (sin x) (cos y) (tan (* x y))))

;(def drawing-fun (partial draw-function-color-circle fun 100))

;(draw-on-frame frame drawing-fun)

;(def drawing-fun (partial draw-function-color-circle fun 0.01))

; (draw-on-frame frame drawing-fun)

;(def drawing-fun (partial draw-function-color-circle fun 0.1))

;(draw-on-frame frame drawing-fun)

(defn fun [x y] (* (sin (/ x 100.0)) (cos (/ y 100.0)) (tan (/ (* x y) 300.0))))

(def drawing-fun (partial draw-function-color-circle fun 0.1))

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (atan2 (- x 500) (-  y 500))) (/ Math/PI 12)))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500)] (+ (hyp xx yy) (* 20 (/ (atan2 xx yy) Math/PI))))) 10))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy)] (+ r (* 10 (sin r)) (* 20 (/ (atan2 xx yy) Math/PI))))) 20))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy)] (+ r (* 0.5 (sin (bit-xor x y))) (* 50 (/ (atan2 xx yy) Math/PI))))) 50))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 10 (sin (* 12 p))) (* 50 (/ p Math/PI))))) 50))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 10 (sec (* 12 p))) (* 50 (/ p Math/PI))))) 50))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 10 (tan (* 12 p))) (* 50 (/ p Math/PI))))) 50))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 10 (sin (*  p r))) (* 50 (/ p Math/PI))))) 50))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 10 (Math/log (* 100 r))) (* 50 (/ p Math/PI))))) 50))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* 0.1 (min (Math/exp (/ (+ r p) 1000000)) 1000)) (* 50 (/ p Math/PI))))) 50))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [xx (- x 500) yy (- y 500) r (hyp xx yy) p (atan2 xx yy)] (+ r  (* r (sin p)) (* 50 (/ p Math/PI))))) 50))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ r1 r2))) 10))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (bit-xor (int r1) (int r2)))) 100))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (* r1 r2))) 10))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (- r1 r2))) 50))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* 100 (sin p1)) (* 100 (cos p2)) (- r1 r2)))) 50))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* 50 (atan (* (+ p1 (* 0.75 )) (- p2 (* 075 Math/PI))))) (- r1 r2)))) 50))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (sin (/ (+ r1 r2) 50)))) (/ Math/PI)))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ p1 p2 (sin (/ (+ r1 r2) 50))))) Math/PI))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* 12 p1) p2 (sin (/ (+ r1 r2) 50))))) Math/PI))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* 12 p1) (* 12 p2) (sin (/ (+ r1 r2) 50))))) Math/PI))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* 13 p1) (* 11 p2) (sin (/ (+ r1 r2) 50))))) Math/PI))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ p1 p2 (* (tanh (* (Math/sqrt r1) 00.1)) (tanh (* (Math/sqrt r2) 0.01)) (sin (/ (+ r1 r2) 50)))))) Math/PI))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* p1 25) (* p2 25) (* (tanh (* (Math/sqrt r1) 00.1)) (tanh (* (Math/sqrt r2) 0.01)) (sin (/ (+ r1 r2) 50)))))) Math/PI))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (tanh (/ r1 100)) (tanh (/ r2 100))))) 0.002))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (/ r1) (/ r2)))) 10))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (/ (Math/sqrt r1)) (/ (Math/sqrt r2))))) 0.01))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (/ (cos (/ r1 500))) (/ (sin (/ r2 500)))))) 0.01))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (/ (sin (/ r1 500))) (/ (sin (/ r2 500)))))) 0.01))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (/ (sin (/ r1 500))) (/ (tan (/ r2 500)))))) 0.1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (Math/sin (/ r1 200)) (Math/sin (/ r2 200))))) 0.1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (Math/sin (/ r1 200)) (Math/sin (/ r2 200))))) 0.08))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (Math/tan (/ r1 200)) (Math/tan (/ r2 200))))) 0.08))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (bit-xor (* 11 (int (/ r1 6))) (* 13 (int (/ r2 6)))))) 0.7))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (bit-xor (* 11 (int (/ r1 12))) (* 13 (int (/ r2 12)))))) 3))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (bit-xor (* 13 (int (* p2 18))) (* 13 (int (* p1 18)))))) 3))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (bit-xor (* 13 (int (/ r2 18))) (* 13 (int (/ r1 18)))))) 3))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 r1 r2))) 1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 r1 r2))) 0.1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (sin (/ r1 100)) (sin (/ r2 100))))) 1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (cot (/ r1 750)) (cot (/ r2 750))))) 0.1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (cot (/ r1 750)) (cot (+ (/ r2 750) (sin (/ r1 20))))))) 0.1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (cot (/ r1 750)) (cot (+ (/ r2 750) (sin (/ r1 200))))))) 0.1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (cot (/ r1 750)) (cot (+ (/ r2 7500) (sin (/ r1 200))))))) 0.1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (cot (/ r1 1750)) (cot (+ (/ r2 2500) (sin (/ r1 100))))))) 0.1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (cot (+ (sin (* 10 p2)) (/ r1 2500))) (cot (+ (/ r2 2500) (sin (/ r1 100))))))) 0.1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (cot (+ (sin (* 10 p2)) (/ r1 2500))) (cot (+ (/ r2 2500) (sin (/ r1 100))))))) 0.2))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (atan2 (cot (+ (sin (* 10 p2)) (/ (- r1 700) 2500))) (cot (+ (/ (- r2 700) 2500) (sin (/ r1 100))))))) 0.2))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (gauss (/ (- r1 500) 500) (/  (- r2 500) 500)))) 0.10))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (gauss (/ (- r1 500) 500) (+ (sin (* p1 2)) (/ (- r2 500) 500))))) 0.10))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (gauss (+ (sin (* p2 2)) (/ (- r1 500) 500)) (+ (sin (* p1 2)) (/ (- r2 500) 500))))) 0.10))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (* r1 r2))) 100))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (sin (* r1 r1 0.00001)) (sin (* r2 r2 0.00001))))) 1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (tanh (* r1 r1 0.00001)) (tanh (* r2 r2 0.00001))))) 0.1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* 0.5 (sin (/ (+ x y) 10))) (ggt (int (/ r1 15)) (int (/ r2 15)))))) 1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* 0.1 (sin (/ (+ x y) 10))) (ggt (int (/ r1 15)) (int (/ r2 15)))))) 1))

(Thread/sleep 10)

)] (+ (* 0.1 (sin (/ (+ x y) 10))) (* 0.5 (bit-xor (int (/ r1 15)) (int (/ r2 15))))))) 1))

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ 1.2 (* 0.1 (sin (/ (- x y) 10))) (sin (* (/ Math/PI 12) (bit-xor (int (/ r1 15)) (int (/ r2 15)))))))) 0.1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ 1.2 (* 0.1 (sin (/ (- x y) 10))) (tan (* (/ Math/E 12) (bit-xor (int (/ r1 15)) (int (/ r2 15)))))))) 0.1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ r1 r2 (* r1 r2)))) 100))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ r1 r2 (* r1 r2)))) 250))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* r1 r1) (*  r2 r2) (* r1 r2)))) 250))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* r1 r1 r1) (* 200  r2 r2) (* 300 r1 r2)))) 25000))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ (* r1 r1 r1) (* 200  r2 r2) (* 300 r1 r2)))) 250000))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (let [u (sin (* 4 p1)) v (sin (* 4 p2))] (+ u v (* u v))))) 1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (let [u (sin (* 12 p1)) v (sin (* 12 p2))] (+ u v (* u v))))) 1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (let [u (sin (* 12 p1)) v (sin (* 12 p2))] (+ 1  (* u v))))) 0.2))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (let [u (sin (* 12 p1)) v (sin (* 12 p2))] (+ 1  (* u v))))) (/ Math/E)))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (let [u (sin (* 12 p1)) v (sin (* 12 p2))] (+ (tanh (/ (+ r1 r2) 200)) 1  (* u v))))) (/ Math/E)))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (let [u (sin (+ (* 12 p1) (/ r1 200))) v (sin (+ (* 12 p2) (/ r2 200)))] (+ (tanh (/ (+ r1 r2) 200)) 1  (* u v))))) (/ Math/E)))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (let [u (sin (+ (* 12 p1) (/ r1 200))) v (sin (+ (* 12 p2) (/ r2 200)))] (+ (tanh (/ (+ r1 r2) 200)) 1  (* 0.01 Math/E u v))))) (/ 0.1 Math/E)))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ 5/3 (Math/sin (* (/ x 100) (Math/sin (/ y 100))))))) 1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ 5/3 (Math/sin (* (/ x 100) (Math/sin (/ y 50))))))) 1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (+ 5/3 (Math/sin (* (/ r1 100) (Math/sin (/ r2 50))))))) 1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle-darkened (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (- (+ r1 r2) 1000))) (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (smooth-rise (* r1 r2 (/ 25000))))) 100))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle  (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (- (* (gauss  (/ (- x 500) 300) (/ (- y 500) 300)) 100) 50))) 8))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle  (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (- (* (gauss  (* (sin (* p1 12)) (/ (- x 500) 300)) (* (sin (* p2 12)) (/ (- y 500) 300))) 100) 50))) 8))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle  (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (- (* (gauss  (* (sin (* p1 12)) (/ (- x 500) 300)) (* (sin (* p2 12)) (/ (- y 500) 300))) 100) 50))) 8))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle  (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2)] (- (* (gauss  (* (sin (* p1 12)) (/ (- x 500) 300)) (* (tan (* p2 12)) (/ (- y 500) 300))) 100) 50))) 8))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle  (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2) pp1 (+ p1 (* 1/4 Math/PI)) pp2 (+ p2 (* 5/4 Math/PI))] (* (sin (* 12 pp1))  (sin (* 12 pp2))))) 1))

(Thread/sleep 10)

(draw-on-frame frame (partial draw-function-color-circle-hsv  (fn [x y] (let [x1 (- x 200) y1 (- y 200) x2 (- x 800) y2 (- y 800) r1 (hyp x1 y1) p1 (atan2 x1 y1) r2 (hyp x2 y2) p2 (atan2 x2 y2) pp1 (+ p1 (* 1/4 Math/PI)) pp2 (+ p2 (* 5/4 Math/PI))] (* (sin (* 12 pp1))  (sin (* 12 pp2))))) 1))
