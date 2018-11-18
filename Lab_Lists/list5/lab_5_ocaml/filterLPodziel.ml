type 'a llist = LKoniec | LElement of 'a * (unit -> 'a llist)

let rec lfrom k = LElement (k, function() -> lfrom(k+1));;


let rec ltake = function
(0, _) -> LKoniec
|(_, LKoniec) -> LKoniec
|(n, LElement(x, xf)) -> LElement(x, fun() -> ltake(n-1, xf()));;

let rec lfilter pred = function
  LKoniec -> LKoniec
  |LElement(x, xf) -> if pred x then LElement(x, fun()-> lfilter pred (xf()))
  else lfilter pred(xf());;

let lpodziel llist =
  (lfilter (fun x -> x mod 2 = 0) llist, lfilter(fun x -> x mod 2 <> 0) llist);;

  ltake(10, fst (lpodziel(lfrom 2)));;
  ltake(10, snd(lpodziel(lfrom 3)));;