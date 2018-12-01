#use "QueueFun.ml";;

module ListQueue : QUEUE_FUN =
struct
  type 'a t = 'a list
  exception Empty of string

  let empty() = []

  let rec enqueue(elem, queue) =
    match queue with
    hd::tl -> hd::enqueue(elem, tl)
    |[] -> [elem]

  let dequeue = function
    _::tl -> tl
    |[] -> []

  let first = function
    hd::_ -> hd
    |[] -> raise(Empty "module ListQueue: first")
  
  let isEmpty queue = queue = []
end;;

  let queue1 = ListQueue.empty();;
  let q2 = ListQueue.enqueue(3, queue1);;
  let q3 = ListQueue.enqueue(5, q2);;

  ListQueue.first q3;;

  ListQueue.first(ListQueue.dequeue q3);;

  ListQueue.dequeue q3;;
  ListQueue.dequeue q3;;
  ListQueue.isEmpty q3;;

  ListQueue.isEmpty(ListQueue.dequeue(ListQueue.dequeue q3));;
  ListQueue.first(ListQueue.dequeue(ListQueue.dequeue q3));;
  