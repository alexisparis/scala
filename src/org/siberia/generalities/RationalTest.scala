package org.siberia.generalities

/**
 * Created by IntelliJ IDEA.
 * User: alexis
 * Date: 27/08/11
 * Time: 09:35
 * To change this template use File | Settings | File Templates.
 */

object RationalTest {

  def main(args : Array[String])
  {
    val rat1 = new Rational(2, 3)
    val rat2 = new Rational(5, 1)

    println("rat1 : " + rat1)
    println("rat2 : " + rat2)
    println("rat1 + rat2 = " + (rat1+rat2))
    //println("rat1 - rat2 = " + (rat1-rat2))
    println("rat1 * rat2 = " + (rat1*rat2))
    println("toto")
  }

}