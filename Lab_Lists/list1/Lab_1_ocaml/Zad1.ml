let rec sumList list = 
  if (list == []) then 0. 
  else
    List.hd list +. sumList(List.tl list);;

print_float(sumList([4.1; 6.3; 7.5; 2.1]));;
print_string "\n";;
print_float(sumList([]));;
print_string "\n";;
print_float(sumList([-1.2; 6.3; -2.0]));;



