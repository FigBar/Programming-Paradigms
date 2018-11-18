def countChars (char: Char, list: List[Char]):Int = {
  if (list == Nil) 0
  else if (list.head == char) 1 + countChars(char, list.tail)
  else countChars(char, list.tail)

}

countChars('a' , List('a', '1', '2','\n', 'a'))
countChars('1', List())
