package org.siberia.function

/**
 * Created by IntelliJ IDEA.
 * User: alexis
 * Date: 25/08/11
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */

object Currying
{
  def main(args : Array[String])
  {
    // currying : transforming a function that takes multiple arguments
    // in such a way that it can be called as a chain of functions each with a single argument

    // sum is a method that return another function
    def sum(f: Int => Int): (Int, Int) => Int =
    {
      def sumf(a : Int, b: Int) : Int =
      {
         if ( a > b ) 0 else f(a) + sumf(a+1, b)
      }
      sumf
    }

    println( sum( x => x )(2, 3) )
    println( sum( x => x )(2, 10) )
  }

}