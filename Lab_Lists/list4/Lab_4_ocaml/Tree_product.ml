type 'a bst = Empty | Node of 'a * 'a bst * 'a bst;;


let rec productTree = function
   Empty -> 1
 | Node(v, leftTree, rightTree) -> v * productTree leftTree * productTree rightTree;;

let tree1 = Node(1, 
                 Node(2,
                      Empty,
                      Node(3,
                           Empty,
                           Empty)), 
                 Node(4,
                      Empty,
                      Empty));;

productTree tree1;;