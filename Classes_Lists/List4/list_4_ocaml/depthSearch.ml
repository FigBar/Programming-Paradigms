type 'a graph = Graph of ('a-> 'a list)

let depthSearch(Graph succ) startNode =
  let rec innerSearch visited toVisit =
    match toVisit with
    []->[]
    |h::t -> if List.mem h visited then innerSearch visited t
    else h::innerSearch(h::visited)(succ h @ t)
  in
  innerSearch[][startNode];;

let g = Graph
(function
    0 -> [3]
   |1 -> [0;2;4]
   |2 -> [1]
   |3 -> []
   |4 -> [0;2]
   |n -> failwith ("Graph g: node "^string_of_int n^" doesn't exist")
);;

depthSearch g 0;;
depthSearch g 1;;
depthSearch g 2;;
depthSearch g 3;;
depthSearch g 4;;
depthSearch g 10;;
