def replicate[A](el: A, i: Int): List[A] = {
    if(i <= 0) List()
    else el::replicate (el, i-1)
}
