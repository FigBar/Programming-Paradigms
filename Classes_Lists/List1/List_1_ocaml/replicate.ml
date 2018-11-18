let rec replicate(el, times) =
  if(times <= 0) then [] 
  else el::replicate(el, times-1);;

let rec print_list = function 
    [] -> ()
    | e::l -> print_int e ; print_string " " ; print_list l;;

print_list(replicate(3,3));;
