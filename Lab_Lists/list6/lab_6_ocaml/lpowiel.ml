type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let lhd = function
   LNil -> failwith "lhd"
  |LCons(x, _) -> x


let lrepeat llist = 
  let rec innerRepeat n = function
    LNil -> LNil
   |LCons(x, tl) as list -> match tl() with
      LNil -> if n = 0 then innerRepeat(x)(LNil)
              else LCons(x, fun() -> innerRepeat(n - 1) list)
     |LCons(_, _) -> if n = 0 then innerRepeat(lhd(tl()))(tl())
                    else LCons(x, fun() -> innerRepeat(n - 1) list)
  in innerRepeat (lhd llist) llist;;
  
let rec take = function
(0, _) -> []
|(_, LNil) -> []
|(n, LCons(x, xf)) -> x::take(n-1, xf());;

let rec ltake = function
(0, _) -> LNil
|(_, LNil) -> LNil
|(n, LCons(x, xf)) -> LCons(x, fun() -> ltake(n-1, xf()));;

let rec lfrom k = LCons (k, function() -> lfrom(k+1));;


take(10, lrepeat (lfrom 2));;
take(20, lrepeat(ltake (3, lfrom 3)));;
