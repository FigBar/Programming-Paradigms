let rec mergesort order xs =
  let partition = List.length xs / 2 in
  if (partition == 0) then xs
  else
    let rec merge = function
    |[], xs2 -> xs2
    |xs1, [] -> xs1
    |h1::t1 as xs1, (h2::t2 as xs2) -> 
        if (order h1 h2) then h1::merge(t1, xs2)
        else h2::merge(xs1, t2)

    and split leftPart rightPart size = 
      if(size = 0) then (List.rev leftPart,rightPart) 
      else split(List.hd rightPart::leftPart)(List.tl rightPart)(size-1)

    in let(left, right) = split [] xs partition

in merge(mergesort order left,  mergesort order right);;  

let increasingOrder x y = x <= y;;

mergesort increasingOrder [235;401;3;5;4;1;2;23567;2;5;8;8;7;6;7;6;356;101;4430;1003;];;

let tupleOrder t1 t2 = fst t1 <= fst t2;;

mergesort tupleOrder [(1,3); (1,1); (1,2)];;