package org.siberia.tuple


/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 30/08/11
 * Time: 08:14
 * To change this template use File | Settings | File Templates.
 */

object TupleTest
{
  def main(args : Array[String])
  {
    println("tuple : " + getTuple())

  }

  def getTuple() : Tuple2[Int, Int] = {

    Tuple2[Int, Int](2, 3)
  }

}