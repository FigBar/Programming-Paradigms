let rec concat (sign , list) =
  if(list = []) then " "
  else if ((List.tl list)=[]) then (List.hd list)
  else (List.hd list) ^ sign ^ concat(sign, (List.tl list));;

  print_string(concat("," , ["coś"; "tam"]));;
  print_string "\n";;
  print_string(concat(":", ["ala"; "ma"; "kota"]));;