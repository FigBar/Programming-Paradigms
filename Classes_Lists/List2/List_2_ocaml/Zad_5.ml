let rec initSegment (segment, list) = match (segment, list) with
| ([], _) -> true
| (_, []) -> false
| (h1::t1, h2::t2) -> if (h1 = h2) then initSegment(t1, t2) else false;;

print_string(string_of_bool(initSegment([],[])));;
print_string "\n";;
print_string(string_of_bool(initSegment([],["ala";"ma";"kota"])));;
print_string "\n";;
print_string(string_of_bool(initSegment(["ala"],[])));;
print_string "\n";;
print_string(string_of_bool(initSegment(["ala"],["ala"])));;
print_string "\n";;
print_string(string_of_bool(initSegment(["ala";"ma"],["ala"])));;
print_string "\n";;
print_string(string_of_bool(initSegment(["ala"],["ala";"ma"])));;
print_string "\n";;