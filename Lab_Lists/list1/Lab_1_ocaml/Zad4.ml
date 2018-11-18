
let decreasing (fst, snd ,thd)= (thd < snd) && (snd < fst);;


let rec decreasingOrder list = 
  if(list == []) then true
  else 
  if(List.tl list == []) then true
  else if( List.hd list < (List.hd (List.tl list))) then false
  else decreasingOrder(List.tl list);;


print_string(string_of_bool(decreasingOrder([1;2;3;4])));;
print_string "\n";;
print_string(string_of_bool(decreasingOrder([3;2;1])));;
print_string "\n";;
print_string(string_of_bool(decreasingOrder([1;7;6])));;
print_string "\n";;
print_string(string_of_bool(decreasingOrder([])));;
print_string "\n";;
print_string(string_of_bool(decreasingOrder([-1])));;

print_string "\n";;
print_string "\n";;
print_string(string_of_bool(decreasing(3,2,1)));;
print_string "\n";;
print_string(string_of_bool(decreasing(0,0,0)));;
print_string "\n";;
print_string(string_of_bool(decreasing(1,0,-1)));;


