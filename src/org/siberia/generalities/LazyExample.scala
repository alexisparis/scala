package org.siberia.generalities

/**
 * Created by IntelliJ IDEA.
 * User: alexis
 * Date: 25/08/11
 * Time: 22:06
 * To change this template use File | Settings | File Templates.
 */

object LazyExample
{
  def main(args : Array[String])
  {
    val a1 = new Lazy
    val a2 = new Lazy

    println(a1)
  }

  class Lazy
  {
    lazy val note = computeNote();

    def computeNote() : Int =
    {
      println("computing value");
      25
    }

    override def toString() : String =
    {
      "Lazy with note=" + this.note
    }

  }
}