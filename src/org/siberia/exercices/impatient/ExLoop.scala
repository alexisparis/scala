package org.siberia.exercices.impatient

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 05/09/11
 * Time: 13:59
 * To change this template use File | Settings | File Templates.
 */

object ExLoop
{
  def main(args : Array[String])
  {
    println("1 : " + unicodeSum("Hello"))
    println("2 : " + unicodeSum2("Hello"))
  }

  def unicodeSum(arg: String) : Int =
  {
    var result = 1;

    for (i <- arg)
    {
      result *= i.toInt
    }

    result
  }

  def unicodeSum2(arg: String) : Int =
  {
    def reduce(sum: Int, item : Char) : Int =
    {
      println("sum : " + sum + " ; item : " + item)
      1
    }

    1
    //var result = 1;
    //arg.reduceLeft[Int]( (x : Int, y : Char) => Math.max(1, x) * y.toInt )

    //[B >: Char] (op: (B, Char) ⇒ B): B

    //arg.map( (x: Char) => {x.toInt} )
    //arg.product( (x: Char) => {x.toInt} ).toInt
  }
}