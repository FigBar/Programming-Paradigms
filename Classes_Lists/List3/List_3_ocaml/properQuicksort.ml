let rec quicksort = function
    [] -> []
  | x::xs -> let small = List.filter (fun y -> y < x) xs 
      and        large = List.filter (fun y -> y >= x) xs 
      in quicksort small @ (x :: quicksort large);;

quicksort([5;5;7;1;1;2;9;21;13;21]);;
