type 'a nlist = Koniec | Element of 'a * ('a nlist);;


let rec lfilter pred = function
  Koniec -> Koniec
  |Element(x, xf) -> if pred x then Element(x, lfilter pred xf)
  else lfilter pred xf;;

 let rec reverseTuple (acc1, acc2) = function
 (Koniec, Koniec) -> (acc1, acc2)
 |(Koniec, Element(h2, t2)) -> reverseTuple((acc1, Element(h2, acc2))) (Koniec, t2)
 |(Element(h1,t1), Koniec) -> reverseTuple(Element(h1,acc1), acc2)(t1, Koniec)
 |(Element(h1,t1), Element(h2,t2)) -> reverseTuple(Element(h1, acc1), Element(h2, acc2))(t1, t2);;



let tailPodziel list =
  let rec inPodziel (p, np) = function
    Koniec -> reverseTuple(Koniec, Koniec)(p , np)
   |Element(h, tl) -> if h mod 2 = 0 then inPodziel(Element(h,p), np) tl
                      else inPodziel(p, Element(h, np)) tl
  in
  inPodziel(Koniec, Koniec) list;;

  let l1 = Element(1, Element(4, Element(6, Element(7,Element(3,Koniec)))));;

  tailPodziel l1;;

  let rec podziel = function
    Koniec -> (Koniec, Koniec)
    |Element(hd, tl) ->
    let lTuple = podziel tl 
    in if hd mod 2 = 0 then (Element(hd, fst lTuple), snd lTuple)
    else (fst lTuple, Element(hd, snd lTuple));;

podziel l1;;

let filterPodziel list =
  (lfilter (fun x -> x mod 2 = 0) list, lfilter(fun x -> x mod 2 <> 0) list);;

filterPodziel l1;;
