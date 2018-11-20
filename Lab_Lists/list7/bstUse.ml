#use "bst.ml";;
let rec printList list =
  print_string "[";
  match list with
      hd::tl ->
        print_int hd;
        print_string "; ";
        printList tl
    |[] -> print_string "]";
;;



let tree = bst.create();;
tree.push(3, tree);;
tree.push(3, tree);;
tree.push(2, tree);;
tree.push(5, tree);;
tree.push(4, tree);;
print_string "Added 3, 2, 5, 4 to the tree\n";;
print_string "Inorder: ";;
printList(bst.getInOrder tree);;
print_string "\n";;

print_string "Preorder: ";;
printList(bst.getPreOrder tree);;
print_string "\n";;

print_string "Postorder: ";;
printList(bst.getPostOrder tree);;
print_string "\n";;

print_string "If contains 3: ";;
print_string(string_of_bool bst.find(3,tree));;
print_string "\n";;

print_string "Deleting 3.";;
tree.remove(3, tree);;

print_string "If contains 3: ";;
print_string(string_of_bool bst.find(3,tree));;
print_string "\n";;






