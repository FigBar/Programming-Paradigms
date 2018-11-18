def concat (sign: String, list: List[String]) : String = {
  if (list.isEmpty) ""
  else if(list.tail.isEmpty) list.head
  else
    list.head + sign + concat(sign, list.tail)
}

concat (", " , List("ala", "ma", "kota"))