let rec fibonacci n = match n with 
| 0 -> 0
| 1 -> 1
| _ -> fibonacci(n-1) + fibonacci(n-2);;

print_int(fibonacci(0));;
print_string "\n";;
print_int(fibonacci(1));;
print_string "\n";;
print_int(fibonacci(2));;
print_string "\n";;
print_int(fibonacci(3));;
print_string "\n";;
print_int(fibonacci(4));;
print_string "\n";;
print_int(fibonacci(5));;
print_string "\n";;
print_int(fibonacci(6));;
print_string "\n";;