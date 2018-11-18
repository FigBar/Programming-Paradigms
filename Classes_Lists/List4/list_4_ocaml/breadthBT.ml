type 'a bt = Empty | Node of 'a * 'a bt * 'a bt

let breadthBT tt = 
  let rec innerBreadth ttQueue = match ttQueue with
  [] -> []
  |Empty :: tail -> innerBreadth tail
  |Node(elem, left, right) :: tail -> elem::innerBreadth(tail @ [left;right])
in
innerBreadth [tt];;

let tt = Node(1, Node(2, Node(4, Empty, Empty), Empty), Node(3, Node(5, Empty, Node(6, Empty, Empty)), Empty));;
let myTree = Node(7,Node(1,Node(5, Empty, Empty),Node(2, Empty, Empty)),Node(4, Node(9, Empty, Empty), Node(3, Empty, Empty)));;

breadthBT tt;;
breadthBT myTree;;

