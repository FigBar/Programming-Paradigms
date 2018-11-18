type 'a lBT = LEmpty | LNode of 'a * (unit -> 'a lBT) * (unit -> 'a lBT);;
type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec ltree n = 
  LNode(n, (fun()-> ltree (2*n)), (fun() -> ltree (2*n+1)));;


let toLazyList tree = 
  let rec innerToLazy queue = match queue with
    [] -> LNil
   |LEmpty :: tail -> innerToLazy tail
   |LNode(elem, left, right) :: tail -> LCons(elem, fun()-> innerToLazy(tail @ [left(); right()]))
  in
  innerToLazy([tree]);;

  let rec ltake = function
(0, _) -> []
|(_, LNil) -> []
|(n, LCons(x, xf)) -> x::ltake(n-1, xf());;

ltake(10, toLazyList(ltree 10));;
    