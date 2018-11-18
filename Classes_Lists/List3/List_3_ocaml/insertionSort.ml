let insertionSort order xs =
  let rec insert elem accXs = match accXs with
    | [] ->  elem :: []
    | h::t -> if(order elem  h) then elem :: accXs
        else h :: insert elem t
  in List.fold_left(fun accXs elem -> insert elem accXs) [] xs;;

  let increasingOrder a  b = 
    a < b;;

  let tupleOrder t1 t2 = fst t1 < fst t2;;
  insertionSort increasingOrder  [3;4;1;2;23;13;1;14;15;21];;

  insertionSort tupleOrder [(1,3); (1,1); (1,2); (1,4)];;
