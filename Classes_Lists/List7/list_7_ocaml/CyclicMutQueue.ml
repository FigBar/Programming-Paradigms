#use "QueueMut.ml";;

module CyclicMutQueue : QUEUE_MUT = 
struct
  type 'a t = {mutable f: int; mutable r: int; size: int; mutable a: 'a option array}
  exception Empty of string
  exception Full of string
  
  let empty n = {f = 0; r = 0; size = n + 1; a = Array.make(n+1) None }

  let enqueue (elem, queue) = 
    if(succ queue.r) mod queue.size = queue.f then raise (Full "module CyclicMutQueue: enqueue")
    else queue.a.(queue.r) <- Some elem; queue.r <- (succ queue.r) mod queue.size

  let dequeue queue =
    if queue.r != queue.f then queue.f <- (succ queue.f) mod queue.size

  let first queue = 
    if queue.r = queue.f then raise (Empty "module CyclicMutQueue: first")
    else match queue.a.(queue.f) with
        Some elem -> elem
        |None -> failwith "Should never happen"

  let isEmpty queue = queue.f = queue.r

  let isFull queue = (succ queue.r) mod queue.size = queue.f
end;;

let q1 = CyclicMutQueue.empty 4;;
CyclicMutQueue.enqueue(4, q1);;
CyclicMutQueue.enqueue(6, q1);;
CyclicMutQueue.enqueue(8, q1);;
CyclicMutQueue.enqueue(10, q1);;
CyclicMutQueue.isFull q1;;

CyclicMutQueue.first q1;;
CyclicMutQueue.dequeue q1;;

CyclicMutQueue.first q1;;
CyclicMutQueue.dequeue q1;;

CyclicMutQueue.first q1;;
CyclicMutQueue.dequeue q1;;

CyclicMutQueue.first q1;;
CyclicMutQueue.dequeue q1;;

CyclicMutQueue.isEmpty q1;;

