let rec replaceNth(list, n, replace) = match (list, n) with
|([], _) -> []
|(hd::tl, 0) -> replace::tl
|(hd::tl, _)-> hd::replaceNth(tl, n-1, replace);;


let try1 = replaceNth(["just";"do";"it"], 1, "fuck");;
let try2 = replaceNth(["just";"do";"it"], 7, "fuck");;
let try3 = replaceNth([], 7, "fuck");;

let rec print_list list = match list with 
|[] -> ()
| hd::tl -> print_string hd; print_string " " ; print_list tl;;

print_list try1;;
print_string "\n";;
print_list try2;;
print_string "\n";;
print_list try3;;

