package org.siberia.generalities

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 05/09/11
 * Time: 13:32
 * To change this template use File | Settings | File Templates.
 */

object VariableArguments
{
  def main(args : Array[String])
  {
    println("a = " + sum(2, 3, 9))
    println("b = " + sum( 1 to 5 : _*  ) ) // ': _*' ==> to be considered as an argument sequence

  }

  def sum(arg : Int*) =   // argument of type sequence
  {
    var result = 0;
    for(i <- arg.elements)
      result += i
    result
  }
}