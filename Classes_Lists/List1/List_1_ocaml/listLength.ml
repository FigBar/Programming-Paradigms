let rec listLength list =
  if list = [] then 0 
  else 1 + listLength(List.tl list);;

  print_int(listLength([1;2;3]));;