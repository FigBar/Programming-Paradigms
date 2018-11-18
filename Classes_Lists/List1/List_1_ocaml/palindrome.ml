let palindrome list = list = List.rev list;;

print_string (string_of_bool(palindrome([])));;
print_string("\n");;
print_string (string_of_bool(palindrome([1;2;1])));;