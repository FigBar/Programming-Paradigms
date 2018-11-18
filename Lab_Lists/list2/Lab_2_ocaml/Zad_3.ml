let evenAndOdd list =
  let rec innerEvenAndOdd (given, (list1, list2, list3)) = match given with
  |[] -> (List.rev list1, List.rev list2, List.rev list3)
  |hd::tl -> if (hd mod 2 = 0) 
    then innerEvenAndOdd(tl, (hd::list1, list2, list3))
      else if (hd > 0) then innerEvenAndOdd(tl, (list1, hd::list2, list3))
           else innerEvenAndOdd(tl, (list1, list2, hd::list3))
  in innerEvenAndOdd(list, ([],[],[]));;


evenAndOdd([-1;-2;3;4;8;0;-3;7;9]);;
evenAndOdd([]);;
evenAndOdd([0;-1;7]);;