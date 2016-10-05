package org.siberia.genericity

import com.sun.org.apache.xpath.internal.operations.Variable

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 30/08/11
 * Time: 07:59
 * To change this template use File | Settings | File Templates.
 */

object StackTest {
  def main(args: Array[String])
  {
    var a = EmptyStack.push("toto")
    // a stack de String

    var b = a.push(new AnyRef)
    // b stack de AnyRef

    var c = b.push(EmptyStack)
    // c stack de AnyRef

    var d = new SimpleStack[String]
    d.push("toto")
    //d.push(new AnyRef)  not allowed, should be a string that why Stack declare genericity +A
  }

  class SimpleStack[A]
  {
    def push(x : A) {}
  }

  abstract class Stack[+A] {
    def push[B >: A](x: B): Stack[B] = new NonEmptyStack(x, this)

    def isEmpty: Boolean

    def top: A

    def pop: Stack[A]
  }

  object EmptyStack extends Stack[Nothing] {
    def isEmpty = true

    def top = error("EmptyStack.top")

    def pop = error("EmptyStack.pop")
  }

  class NonEmptyStack[+A](elem: A, rest: Stack[A]) extends Stack[A] {
    def isEmpty = false

    def top = elem

    def pop = rest
  }

}