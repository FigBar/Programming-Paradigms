let rec sqrList list =
  if(list = []) then []
  else ((List.hd list)*(List.hd list))::sqrList(List.tl list);;


    let rec print_list = function 
    [] -> ()
    | e::l -> print_int e ; print_string " " ; print_list l;;

    print_list(sqrList([1;2;3]));;
