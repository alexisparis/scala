package org.siberia.genericity

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 26/07/11
 * Time: 11:07
 * To change this template use File | Settings | File Templates.
 */

object IntegerReference
{
  def main(args : Array[String])
  {
    val cell = new Reference[Int]
    cell.set(13)
    println("ref : " + cell.get)
  }
}