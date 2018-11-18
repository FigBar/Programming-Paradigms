let rec listContains (list, filter) =
  if(list = []) then false
  else if (List.hd list = filter) then  true
  else listContains(List.tl list, filter);;


let rec deleteIfContains(xss, filter) =
  if(xss = []) then []
  else if (listContains(List.hd xss, filter)) then deleteIfContains(List.tl xss, filter)
  else List.hd xss :: deleteIfContains(List.tl xss, filter);;


  deleteIfContains([["ala";"ma"; "kota"] ; ["ala"]], "ala");;
  deleteIfContains([["ala";"ma"; "kota"] ; ["ala"]; ["ma"; "kota"]; ["kota"]], "ala");;
  deleteIfContains([], "coś");;