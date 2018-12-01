#use "QueueFun.ml";;
module ListTupleQueue : QUEUE_FUN =
struct
  type 'a t = 'a list * 'a list
  exception Empty of string

  let empty() = ([], [])

  let enqueue (elem, queue) = 
    match queue with
    ([], _) -> ([elem], [])
    |(llist, rlist) -> (llist, elem::rlist)
    
  
  let dequeue = function
    ([elem], rlist) -> (List.rev rlist, [])
    |(lhd::ltl, rlist) -> (ltl, rlist)
    |([],[]) -> ([], [])
    |([], rlist) -> failwith "This case should never happen"
  
  let first = function
    (lhd::ltl, _) -> lhd
    |([], _) -> raise(Empty "module ListTupleQueue: first")

  let isEmpty queue = queue = ([], [])
  end;;

  let queue1 = ListTupleQueue.empty();;
  let q2 = ListTupleQueue.enqueue(3, queue1);;
  let q3 = ListTupleQueue.enqueue(5, q2);;

  ListTupleQueue.first q3;;

  ListTupleQueue.first(ListTupleQueue.dequeue q3);;

  ListTupleQueue.dequeue q3;;
  ListTupleQueue.dequeue q3;;
  ListTupleQueue.isEmpty q3;;

  ListTupleQueue.isEmpty(ListTupleQueue.dequeue(ListTupleQueue.dequeue q3));;
  ListTupleQueue.first(ListTupleQueue.dequeue(ListTupleQueue.dequeue q3));;
  