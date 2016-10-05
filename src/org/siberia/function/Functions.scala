package org.siberia.function

/**
 * Created by IntelliJ IDEA.
 * User: alexis
 * Date: 25/08/11
 * Time: 21:49
 * To change this template use File | Settings | File Templates.
 */

object Functions
{
  def main(args : Array[String])
  {
    def sum(f : (Int) => Int, a : Int, b : Int) : Int =
    {
      f(a) + f(b)
    }

    def carre = (x : Int) => x*x
    def triple = (x : Int) => 3*x
    println("1 : " + sum( carre, 2, 3 ))
    println("2 : " + sum( triple, 2, 3 ))
  }
}