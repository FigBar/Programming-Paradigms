type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let fibonacci = 
  let rec inFibonacci a b =
    LCons(a, fun() -> inFibonacci b (a+b))
  in
  inFibonacci 1 1;;

  let rec ltake = function
  (0, _) -> []
  |(_, LNil) -> []
  |(n, LCons(x, xf)) -> x::ltake(n-1, xf());;

  ltake (20, fibonacci);;
  