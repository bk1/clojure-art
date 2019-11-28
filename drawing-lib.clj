(load-file "math-functions.clj")

(defn make-frame []
  (let [frame 
	    (doto (javax.swing.JFrame.)
            (.setSize (java.awt.Dimension. 1000 1000))
            (.setVisible true))]
   frame))

(defn draw-on-frame [frame & draw-functions]
    (let [gfx (.getGraphics frame)]
       (loop [remaining-draw-functions draw-functions]
           (when remaining-draw-functions
                ((first remaining-draw-functions) gfx)
                (recur 
                  (next remaining-draw-functions))))))

(defn draw-pixel [frame color x y]
    (let [gfx (.getGraphics frame)]
      (.setColor gfx color)
      (.fillRect gfx x y 1 1)))

(defn draw-rgb-functions [fun_r fun_g fun_b gfx]
      (let [safe-fun (fn [f x y] (try (f x y) (catch Exception e 0)))
            field-fun (fn [max-x mavalue-at-x-y] (for [x (range max-x) y (range mavalue-at-x-y)] [x y (safe-fun fun_r x y)  (safe-fun fun_g x y)  (safe-fun fun_b x y)]))
            normalize (fn [val]  (int (max 0 (if (> val 255) 0 val))))
      ]
            (doseq [[x y rr gg bb] (field-fun 1000 1000)]
                   (let [r (normalize rr)
                         g (normalize gg)
                         b (normalize bb)
                         color (java.awt.Color. r g b)]
                         (.setColor gfx color)
                         (.fillRect gfx x y 1 1)))))

(defn draw-function-color-circle-black-when-overflow [fun divisor gfx]
      (let [safe-fun (fn [x y] (try (fun x y) (catch Exception e 0)))
            offset-g (/ divisor 3)
            offset-b (* 2 offset-g)
            field-fun (fn [max-x mavalue-at-x-y] (for [x (range max-x) y (range mavalue-at-x-y)] [x y (safe-fun x y)]))
            normalize (fn [val]  (int (max 0 (if (> val 255) 0 val))))
      ]
            (doseq [[x y value-at-x-y] (field-fun 1000 1000)]
                   (let [r (normalize value-at-x-y)
                         g (normalize (+ value-at-x-y offset-g))
                         b (normalize (+ value-at-x-y offset-b))
                         color (java.awt.Color. r g b)]
                         (.setColor gfx color)
                         (.fillRect gfx x y 1 1)))))

(defn draw-function-color-circle [fun divisor gfx]
      (let [safe-fun (fn [x y] (try (fun x y) (catch Exception e 0)))
            offset-g (/ divisor 3)
            offset-b (* 2 offset-g)
            field-fun (fn [max-x mavalue-at-x-y] (for [x (range max-x) y (range mavalue-at-x-y)] [x y (safe-fun x y)]))
            normalize (fn [val] (bit-and 0xff (int (* 127.5 (+ 1 (Math/sin (/ (* Math/PI val) divisor)))))))
      ]
            (doseq [[x y value-at-x-y] (field-fun 1000 1000)]
                   (let [r (normalize value-at-x-y)
                         g (normalize (+ value-at-x-y offset-g))
                         b (normalize (+ value-at-x-y offset-b))
                         color (java.awt.Color. r g b)]
                         (.setColor gfx color)
                         (.fillRect gfx x y 1 1)))))

(defn draw-function-color-circle-darkened [fun darkener divisor gfx]
      (let [safe-fun (fn [x y] (try (fun x y) (catch Exception e 0)))
            safe-darkener (fn [x y] (max 0 (min 1 (try (darkener x y) (catch Exception e 0)))))
            offset-g (/ divisor 3)
            offset-b (* 2 offset-g)
            field-fun (fn [max-x mavalue-at-x-y] (for [x (range max-x) y (range mavalue-at-x-y)] [x y (safe-fun x y) (safe-darkener x y)]))
            normalize (fn [val d]  (bit-and 0xff (int (* d 127.5 (+ 1 (Math/sin (/ (* Math/PI val) divisor)))))))
      ]
            (doseq [[x y value-at-x-y d] (field-fun 1000 1000)]
                   (let [r (normalize value-at-x-y d)
                         g (normalize (+ value-at-x-y offset-g) d)
                         b (normalize (+ value-at-x-y offset-b) d)
                         color (java.awt.Color. r g b)]
                         (.setColor gfx color)
                         (.fillRect gfx x y 1 1)))))

(defn hh-to-rgb [hh] (let [h6 (mod (* hh 6) 6)
                           section (mod (int h6) 6)
                           angle (mod h6 1)
                           value (int (* angle 256))]
                       (cond
                         (= section 0) [ 255 value 0 ]
                         (= section 1) [ (- 255 value) 255 0 ]
                         (= section 2) [ 0 255 value ]
                         (= section 3) [ 0 (- 255 value) 255 ]
                         (= section 4) [ value 0 255 ]
                         (= section 5) [ 255 0 (- 255 value) ]
                         :else (throw (Exception. (str "hh=" hh " h6=" h6 " section=" section " angle=" angle " value=" value))))))

(defn hs-to-rgb [hh] (let [h6 (mod (* hh 6) 6)
                           section (mod (int h6) 6)
                           angle (mod h6 1)
                           value (bit-and 0xff (int (* 127.5 (+ 1 (sin (* Math/PI (- angle 0.5))))))) ]
                       (cond
                         (= section 0) [ 255 value 0 ]
                         (= section 1) [ (- 255 value) 255 0 ]
                         (= section 2) [ 0 255 value ]
                         (= section 3) [ 0 (- 255 value) 255 ]
                         (= section 4) [ value 0 255 ]
                         (= section 5) [ 255 0 (- 255 value) ]
                         :else (throw (Exception. (str "hh=" hh " h6=" h6 " section=" section " angle=" angle " value=" value))))))

(defn draw-function-color-circle-hhsv [fun divisor gfx]
      (let [safe-fun (fn [x y] (try (fun x y) (catch Exception e 0)))
            offset-g (/ divisor 3)
            offset-b (* 2 offset-g)
            field-fun (fn [max-x mavalue-at-x-y] (for [x (range max-x) y (range mavalue-at-x-y)] [x y (safe-fun x y)]))
            normalize (fn [val] (bit-and 0xff (int (* 127.5 (+ 1 (Math/sin (/ (* Math/PI val) divisor)))))))
      ]
            (doseq [[x y value-at-x-y] (field-fun 1000 1000)]
                   (let [[r g b] (hh-to-rgb value-at-x-y)
                         color (java.awt.Color. r g b)]
                         (.setColor gfx color)
                         (.fillRect gfx x y 1 1)))))

(defn draw-function-color-circle-hsv [fun divisor gfx]
      (let [safe-fun (fn [x y] (try (fun x y) (catch Exception e 0)))
            offset-g (/ divisor 3)
            offset-b (* 2 offset-g)
            field-fun (fn [max-x mavalue-at-x-y] (for [x (range max-x) y (range mavalue-at-x-y)] [x y (safe-fun x y)]))
            normalize (fn [val] (bit-and 0xff (int (* 127.5 (+ 1 (Math/sin (/ (* Math/PI val) divisor)))))))
      ]
            (doseq [[x y value-at-x-y] (field-fun 1000 1000)]
                   (let [[r g b] (hs-to-rgb value-at-x-y)
                         color (java.awt.Color. r g b)]
                         (.setColor gfx color)
                         (.fillRect gfx x y 1 1)))))
                       

(defn draw-function-color-circle-tanh [fun divisor gfx]
      (let [safe-fun (fn [x y] (try (fun x y) (catch Exception e 0)))
            offset-g (/ (* 100 divisor) 3)
            offset-b (- offset-g)
            field-fun (fn [max-x mavalue-at-x-y] (for [x (range max-x) y (range mavalue-at-x-y)] [x y (safe-fun x y)]))
            normalize (fn [val] (bit-and 0xff (int (* 127.5 (+ 1 (tanh (/  val divisor)))))))
      ]
            (doseq [[x y value-at-x-y] (field-fun 1000 1000)]
                   (let [r (normalize value-at-x-y)
                         g (normalize (+ value-at-x-y offset-g))
                         b (normalize (+ value-at-x-y offset-b))
                         color (java.awt.Color. r g b)]
                         (.setColor gfx color)
                         (.fillRect gfx x y 1 1)))))



(defn rotate [[x y] angle]
  (let [c (cos angle) s (sin angle)]
    [ (- (* c x) (* s y)) (+ (* c y) (* s x))]))

(defn transform [[x y] shift scale]
  [ (/ (- x shift) scale) (/ (- y shift) scale)])

