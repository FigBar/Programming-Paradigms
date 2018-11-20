type 'a bst = Leaf | Node of 'a * 'a bst * 'a bst

type 'a tr = {mutable root: int bst}

exception NotFound of string

let create = {root = Leaf}

let push(value, tree) =
  let rec innerPush = function
    Node(v, left, right) as tr -> if value < v then Node(v, innerPush left, right)
                                   else if value > v then Node(v, left, innerPush right)
                                   else tr
   |Leaf -> Node(value, Leaf, Leaf)
  in 
  tree.root <- innerPush tree.root

let find(value, tree) = 
  let rec inFind = function
    Node(v, left, right) -> if value < v then inFind left
                            else if value > v then inFind right
                            else true
   |Leaf -> false
  in 
  inFind tree.root


let getPreOrder tree =
  let rec preOrder = function
    Node(v, left, right) -> v :: preOrder left @ preOrder right
    |Leaf -> []
  in
  preOrder tree.root

  let getPostOrder tree =
    let rec postOrder = function
      Node(v, left, right) ->  postOrder left @ postOrder right @ [v]
      |Leaf -> []
    in
    postOrder tree.root

    let getInOrder tree =
      let rec inOrder = function
        Node(v, left, right) ->  inOrder left @ (v :: inOrder right) 
        |Leaf -> []
      in
      inOrder tree.root
  
  



