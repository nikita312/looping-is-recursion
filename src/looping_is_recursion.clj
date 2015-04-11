(ns looping-is-recursion)

(defn power [base exp]
  (let [helper (fn [acc n]

                 ;(let [ abc (- n 1)]
                 (if (= n 0)
                   1

                     (if (= n 1 )
                      acc


                     (recur (* acc base) (dec n) )
                     )

                  )
                )


        ]

    (helper base exp))


)




(defn last-element [a-seq]

   ( if (empty? a-seq)
   nil

    (if (= (count a-seq) 1 ) (first a-seq)  (recur(rest a-seq))   )
  )


)

(defn seq= [seq1 seq2]
 (cond

    (and (empty? seq1) (empty? seq2))  true
 (or  (empty? seq1) (empty? seq2))  false

  (not (= (first seq1) (first seq2))) false

   :else (recur (rest seq1) (rest seq2))
  )

)




(defn find-first-index [pred a-seq]
    (loop [acc 0
         b-seq a-seq
          ]
         ;n down-from]
      (if  (empty? b-seq) nil (if  (pred (first b-seq) ) acc (recur (inc acc) (rest b-seq)    ))


      )
    )
)


(find-first-index zero? [1 1 1 0 3 7 0 2])                    ;=> 3
(find-first-index zero? [1 1 3 7 2])                          ;=> nil
(find-first-index (fn [n] (= n 6)) [:cat :dog :six :blorg 6]) ;=> 4
(find-first-index nil? [])                                    ;=> nil

(defn avg [a-seq]
  (loop [sum 0
         b-seq a-seq
         cou (count a-seq)
          ]
 (if  (empty? b-seq) (if (integer? (/ sum cou) ) (/ sum cou)  (float (/ sum cou)) )  (recur (+ sum (first b-seq) ) (rest b-seq) cou ))


  )
)

(defn parity [a-seq]
 (loop [
   freq (frequencies a-seq)
    res ( set a-seq)
         ]
     ;(if  (empty? freq) res (second( first (frequencies a-seq))) )
    (if  (empty? freq) res
      ;we have element
      (if (= (mod  (second( first freq)) 2) 1 )
       (recur (rest freq) res     )     ; /odd 1
          (recur   (rest freq) (disj res  (first( first freq))  ) )                   ; odd
      )

    )
  )
)

(defn fast-fibo [n]
  (loop [
    step 2
    newN n
    ;res 0   ; store prev in this also
    prev1 0
    prev2 1
         ]

    (cond
    (<= newN 1 ) newN

    :else (if (= step newN) (+ prev1 prev2)
            (recur (inc step) newN prev2 (+ prev1 prev2) )


          )


    )
  )
)


(defn cut-at-repetition [a-seq]
 (loop [ abc (set a-seq )
          vect []
          b-seq a-seq
          ]

   (if  (empty? b-seq ) vect
     (if ( contains? abc (first b-seq) )

      (recur  (disj abc (first b-seq) ) (conj vect (first b-seq)) (rest b-seq  ) )

      (recur abc vect (rest b-seq  ))

     )


    )


  )




)



