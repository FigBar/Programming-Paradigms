let rec count (filter, list) = 
  if list = [] then 0
  else if (List.hd list = filter) then 1 + count(filter, List.tl list)
      else count(filter, List.tl list);;

print_int (count(2, [1;2;4;5;2;4]));;