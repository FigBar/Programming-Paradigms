type 'a bst = Empty | Node of 'a * 'a bst * 'a bst;;


let rec sumTree = function
   Empty -> 0
 | Node(v, leftTree, rightTree) -> v + sumTree leftTree + sumTree rightTree;;

let tree1 = Node(1, 
                 Node(2,
                      Empty,
                      Node(3,
                           Empty,
                           Empty)), 
                 Node(4,
                      Empty,
                      Empty));;

sumTree tree1;;