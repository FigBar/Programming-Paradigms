type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let lrepeat k llist = 
  let rec innerRepeat n = function
    LNil -> LNil
   |LCons(x, fx) as list -> if n = 0 then innerRepeat(k)(fx())
                    else LCons(x, fun() -> innerRepeat(n - 1) list)
  in innerRepeat k llist;;
  
let rec ltake = function
(0, _) -> []
|(_, LNil) -> []
|(n, LCons(x, xf)) -> x::ltake(n-1, xf());;

let rec lfrom k = LCons (k, function() -> lfrom(k+1));;


ltake(10, lrepeat 3 (lfrom 2));;