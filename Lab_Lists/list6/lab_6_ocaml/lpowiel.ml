type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let lhd = function
   LNil -> failwith "lhd"
  |LCons(x, _) -> x


let lrepeat llist = 
  let rec innerRepeat n = function
    LNil -> LNil
   |LCons(x, fx) as list -> if n = 0 then innerRepeat(lhd(fx()))(fx())
                    else LCons(x, fun() -> innerRepeat(n - 1) list)
  in innerRepeat (lhd llist) llist;;
  
let rec ltake = function
(0, _) -> []
|(_, LNil) -> []
|(n, LCons(x, xf)) -> x::ltake(n-1, xf());;

let rec lfrom k = LCons (k, function() -> lfrom(k+1));;


ltake(10, lrepeat (lfrom 2));;
