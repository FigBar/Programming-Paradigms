type 'a bt = Empty | Node of 'a * 'a bt * 'a bt

let externalPathSum tt = 
  let rec sumHelper level subTree = match subTree with
  Empty -> level
  |Node(_, left, right) -> sumHelper(level + 1) left + sumHelper(level+1) right
in
sumHelper 0 tt;;

let tt = Node(1, Node(2, Node(4, Empty, Empty), Empty), Node(3, Node(5, Empty, Node(6, Empty, Empty)), Empty));;
let myTree = Node(7,Node(1,Node(5, Empty, Empty),Node(2, Empty, Empty)),Node(4, Node(9, Empty, Empty), Node(3, Empty, Empty)));;

externalPathSum tt;;
externalPathSum myTree;;