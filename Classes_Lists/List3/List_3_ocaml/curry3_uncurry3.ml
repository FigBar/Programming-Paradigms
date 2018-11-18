let curry3 f x y z = f(x, y, z);;

let curry3_1 = function f -> function x -> function y -> function z -> f(x,y,z);;

let uncurry3 f (x, y, z) = f x y z;;

let uncurry3_1 = function f -> function(x, y, z) -> f x y z;;

let substract x y z = x - y - z;;

substract 1 2 3;;

let f1 = uncurry3 substract;;

f1(1, 2, 3);;

let f2 = curry3_1 f1;;

f2 1 2 3;;
