
let repeat list = 
  let rec innerRepeat n = function
    []-> []
   |hd :: [] as list -> if n = 0 then innerRepeat(hd)([])
                        else hd :: innerRepeat(n-1) list
   |hd :: tl as list -> if n = 0 then innerRepeat(List.hd tl)(tl)
                    else hd :: innerRepeat(n - 1) list
  in innerRepeat (List.hd list) list;;


  repeat [1;2;3;4;5];;
  