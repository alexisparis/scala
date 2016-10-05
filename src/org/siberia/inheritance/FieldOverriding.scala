package org.siberia.inheritance

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 14/09/11
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */

object FieldOverriding extends App
{
  var a = new Person("alexis")
  println("a : " + a)

  var b = new SecretAgent("James Pond")
  println("b : " + b)

  val ant = new Ant()
  ant.printEnvSize()

  abstract class AbstractPerson
  {
    val name: String // no initializer ==> abstract field
  }

  class Person(val name : String) extends AbstractPerson
  {
    override def toString = getClass.getName + "[name=" + name + "]"
  }

  class SecretAgent(codename: String) extends Person(codename)
  {
    override val name = "secret"
    override val toString = "secret"
  }

  class Creature
  {
    val range : Int = 10
    val env: Array[Int] = new Array[Int](range)
  }

  class Ant extends Creature
  {
    override val range = 2

    def printEnvSize() = println("length = " + env.length)
  }
}