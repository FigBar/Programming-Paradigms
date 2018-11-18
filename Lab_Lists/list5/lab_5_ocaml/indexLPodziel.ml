type 'a llist = LKoniec | LElement of 'a * (unit -> 'a llist)

let rec lfrom k = LElement (k, function() -> lfrom(k+1));;


let rec ltake = function
(0, _) -> []
|(_, LKoniec) -> []
|(n, LElement(x, xf)) -> x::ltake(n-1, xf());;

let lpodziel xs = 
  let rec innerLPodziel = function
    (LKoniec, _) -> LKoniec
    |(LElement(h, f), true) -> LElement(h, function() -> innerLPodziel(f(), false))
    |(LElement(h, f), false) -> innerLPodziel(f(), true)
  in
  (innerLPodziel(xs, true), innerLPodziel(xs, false));;

  ltake(5, fst (lpodziel(lfrom 20)));;
  ltake(5, snd (lpodziel(lfrom 20)));;
