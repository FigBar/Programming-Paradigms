let rec findUnmatchedNumber list = match list with
| [] -> 0
| hd::tl -> hd lxor (findUnmatchedNumber tl);;

findUnmatchedNumber([1;2;1;2;3;5;4;3;4;3;3])
