package org.siberia.objects

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 13/09/11
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */

object AccountTest extends App
{
  val a = Account(400, "PARIS", "Alexis")
  println("a is good ? " + a.isGood())
  val b = Account(-400, "PARIS", "Tino")
  println("b is good ? " + b.isGood())
}