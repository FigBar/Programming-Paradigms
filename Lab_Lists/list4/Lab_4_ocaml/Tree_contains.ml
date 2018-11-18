type 'a bst = Empty | Node of 'a * 'a bst * 'a bst;;


let rec contains value = function
   Empty -> false
 | Node(v, leftTree, rightTree) -> if (v = value) then true 
                                   else contains(value) leftTree || contains(value) rightTree;;


let tree1 = Node(1, 
                 Node(2,
                      Empty,
                      Node(3,
                           Empty,
                           Empty)), 
                 Node(4,
                      Empty,
                      Empty));;

contains(3) tree1;;
contains(7) tree1;;
contains(1) tree1;;
contains(4) tree1;;