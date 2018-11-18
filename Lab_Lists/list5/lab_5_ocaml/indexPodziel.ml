type 'a nlist = Koniec | Element of 'a * ('a nlist);;

let podziel xs = 
  let rec innerPodziel = function
    (Koniec, _) -> (Koniec, Koniec)
    |(Element(h, tl), true) -> let step = innerPodziel(tl, false) in (fst step, Element(h, snd step))
    |(Element(h, tl), false) -> let step = innerPodziel(tl, true) in (Element(h, fst step), snd step)
  in
  innerPodziel(xs, false);;

  let l1 = Element(1, Element(4, Element(6, Element(7,Element(3,Koniec)))));;

  podziel l1;;