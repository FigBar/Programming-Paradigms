let root3 x =
  let rec insideRoot(x , xi, precision) =
    let finish = (abs_float(xi**3. -. x)) <= (precision *. abs_float(x))
    in
    if(finish) then xi
    else insideRoot(x, xi +. (x/.(xi**2.) -. xi)/. 3., precision)
  in
  let initial = if(x <= 1.) then x else x /. 3. in
  insideRoot(x, initial, 10.**(-15.));;

  print_float(root3(9.));;
