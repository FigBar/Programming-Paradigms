let rec insert elem list = match list with
   [] -> elem :: []
  |hd :: tl -> if (elem <= hd) then elem :: list
               else hd :: insert elem tl;;

insert(4)[1;2;8;10;11];;
insert(-10)[1;2;8;10;11];;
insert(101)[1;2;8;10;11];;
insert(2)[1;2;8;10;11];;
