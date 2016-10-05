package org.siberia.generalities

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 26/07/11
 * Time: 15:16
 * To change this template use File | Settings | File Templates.
 */

object ForcingConstraints
{
  def main(args : Array[String])
  {
    funct(15)
    funct(-2)
  }

  def funct(arg2 : Int)
  {
    require(arg2 > 0)
    println("arg2 : " + arg2)
  }
}