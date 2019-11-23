(defn expt [x pow] (apply *' (repeat pow x)))

(defn numerator-x [r]
  (if (ratio? r)
      (numerator r)
    r))

(defn denominator-x [r]
  (if (ratio? r)
      (denominator r)
    r))

(defn mod-inverse [x m]
  (loop [t 0 r m new-t 1 new-r x]
       (if (zero? new-r)
           (do 
               (if (> r 1) 
                   (throw (Exception. (concat "x=" x " is not invertable mod m=" m))))
               (if (neg? t)
                   (+ t m)
                 t))
         (let [q (quot r new-r)]
              (recur new-t new-r (- t (* q new-t)) (- r (* q new-r)))))))

(defn exp-p [x p n]
       (let [xp (*' x p) pn (expt p n)]
        (loop [m 1N t 1N s 0N]
         (if (zero? t)
          (mod (* (numerator-x s) (mod-inverse (denominator-x s) pn)) pn)
          (let [rt (/ (*' t xp) m)
                rtn (mod (numerator-x rt) pn) 
                rtd (denominator-x rt) ]
                (recur (inc m) (/ rtn rtd) (+' s t)))))))
          
