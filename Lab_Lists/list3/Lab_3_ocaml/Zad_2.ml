let convertFromBinary list =
  let rec innerConverter(accu, list, base) = match list with
    |[] -> accu
    |0::tl -> innerConverter(accu, tl, 2*base)
    |1::tl -> innerConverter(accu+base, tl, 2*base)
    |_::tl -> failwith "The number is not in binary notation"
  in
  innerConverter(0, List.rev list, 1);;

convertFromBinary([1;0;1]);;
convertFromBinary([]);;
convertFromBinary([1;2;3]);;
