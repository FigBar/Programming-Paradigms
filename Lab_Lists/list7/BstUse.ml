
let printList list =
  print_string "[";
    let rec inPrintList = function
      hd::tl ->
        print_int hd;
        if tl <> [] then print_string "; ";
        inPrintList tl
    |[] -> print_string "]";
    in
    inPrintList list;;



let tree = Bst.create();;
Bst.push(3, tree);;
Bst.push(3, tree);;
Bst.push(2, tree);;
Bst.push(5, tree);;
Bst.push(4, tree);;
print_string "Added 3, 2, 5, 4 to the tree\n";;

print_string "If contains 4: ";;
print_string(string_of_bool(Bst.find(4,tree)));;
print_string "\n";;

print_string "If contains 2: ";;
print_string(string_of_bool(Bst.find(2,tree)));;
print_string "\n";;

print_string "If contains 5: ";;
print_string(string_of_bool(Bst.find(5,tree)));;
print_string "\n";;

print_string "If contains 10: ";;
print_string(string_of_bool(Bst.find(10,tree)));;
print_string "\n";;

print_string "Inorder: ";;
printList(Bst.getInOrder tree);;
print_string "\n";;

print_string "Preorder: ";;
printList(Bst.getPreOrder tree);;
print_string "\n";;

print_string "Postorder: ";;
printList(Bst.getPostOrder tree);;
print_string "\n";;

print_string "If contains 3: ";;
print_string(string_of_bool(Bst.find(3,tree)));;
print_string "\n";;

print_string "Deleting 3.";;
print_string "\n";;
Bst.remove(3, tree);;

print_string "If contains 3: ";;
print_string(string_of_bool(Bst.find(3,tree)));;
print_string "\n";;


print_string "Inorder after deleting 3: ";;
printList(Bst.getInOrder tree);;
print_string "\n";;

Bst.push(10, tree);;
Bst.push(0, tree);;

print_string "Added 10, 0 to the tree\n";;

print_string "If contains 10: ";;
print_string(string_of_bool(Bst.find(10,tree)));;
print_string "\n";;

print_string "If contains 0: ";;
print_string(string_of_bool(Bst.find(0,tree)));;
print_string "\n";;


print_string "Inorder: ";;
printList(Bst.getInOrder tree);;
print_string "\n";;

print_string "Preorder: ";;
printList(Bst.getPreOrder tree);;
print_string "\n";;

print_string "Postorder: ";;
printList(Bst.getPostOrder tree);;
print_string "\n";;


print_string "Deleting all elements";;
print_string "\n";;
Bst.remove(0,tree);;
Bst.remove(4,tree);;
Bst.remove(5,tree);;
Bst.remove(2,tree);;
Bst.remove(10,tree);;

print_string "Inorder: ";;
printList(Bst.getInOrder tree);;
print_string "\n";;








