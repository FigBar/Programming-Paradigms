def palindrome[A] (l1: List[A]): Boolean = {
    if (l1 == null) false
    else l1.length match{
        case 0 => true
        case 1 => true
        case _ => {
            if(l1.head == l1.last){
                palindrome(l1.slice(1, l1.length -1))
            } else false
        }
    }
}

def palindrome[A] (l1: List[A]): Boolean = { l1 == l1.reverse }
