let tailFibonacci n = 
  let rec tailFibi (n, prevValue, prePrevValue) = match n with
  | 0 -> prevValue
  | _ -> tailFibi (n-1, prevValue + prePrevValue, prevValue)
  in tailFibi(n, 0, 1);;

  print_int(tailFibonacci(0));;
  print_string "\n";;
  print_int(tailFibonacci(1));;
  print_string "\n";;
  print_int(tailFibonacci(2));;
  print_string "\n";;
  print_int(tailFibonacci(3));;
  print_string "\n";;
  print_int(tailFibonacci(4));;
  print_string "\n";;
  print_int(tailFibonacci(5));;
  print_string "\n";;
  print_int(tailFibonacci(6));;
  print_string "\n";;