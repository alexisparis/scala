package org.siberia.generalities

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 26/07/11
 * Time: 15:14
 * To change this template use File | Settings | File Templates.
 */

object DefaultValues
{
  def main(args : Array[String])
  {
    funct()
    funct("tata")
    funct("tata", 15)
  }

  def funct(arg1:String="toto", arg2 : Int=2)
  {
    println("arg1 : " + arg1 + "; arg2 : " + arg2)
  }
}