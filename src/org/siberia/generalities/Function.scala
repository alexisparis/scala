package org.siberia.generalities

object Function {
  def main(args: Array[String])
  {
    val f = Function;
    println("toto")
    println("min 1 : " + f.min(4, 5))
    println("min 2 : " + f.min2(4, 5))

    f.sayHello
    f.sayHello("a")
    f sayHello "a"
  }

  def min(i: Int, j: Int): Int = {
    if (i > i)
      i
    else
      j
  }

  def min2(i: Int, j: Int) = {
    if (i > i)
      i
    else
      j
  }

  def sayHello = println("Hello")

  def sayHello(s: String) = println("Hello " + s)
}
