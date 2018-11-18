let rec flatten ls =
  if ls = [] then []
  else (List.hd ls)@flatten(List.tl ls);;


  let ll = [[1;4];[1;2;3]];;
  
  let output = flatten(ll);;




print_string (String.concat " " (List.map string_of_int output));;
print_string "\n";;

