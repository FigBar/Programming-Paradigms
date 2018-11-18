type 'a llist = LKoniec | LElement of 'a * (unit -> 'a llist)

let rec lfrom k = LElement (k, function() -> lfrom(k+1));;

let rec ltake = function
(0, _) -> LKoniec
|(_, LKoniec) -> LKoniec
|(n, LElement(x, xf)) -> LElement(x, fun() -> ltake(n-1, xf()));;

let rec ltake1 = function
(0, _) -> []
|(_, LKoniec) -> []
|(n, LElement(x, xf)) -> x::ltake1(n-1, xf());;



let ltakeTuple (n, tuple) =
(ltake1(n, fst tuple), ltake1(n, snd tuple));;



let rec podziel = function
LKoniec -> (LKoniec, LKoniec)
|LElement(hd, tl) ->
let lTuple = podziel (tl()) 
in if hd mod 2 = 0 then (LElement(hd, fun() -> fst lTuple), snd lTuple)
else (fst lTuple, LElement(hd, fun() -> snd lTuple));;

ltakeTuple(20, podziel(ltake(10, lfrom 5)));;
