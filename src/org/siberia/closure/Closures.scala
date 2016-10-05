package org.siberia.closure

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 26/08/11
 * Time: 10:40
 * To change this template use File | Settings | File Templates.
 */

object Closures
{
  def main(args : Array[String])
  {
    def ajouteur(n: Int)(x: Int) = (x + n)

    //def ajoute10 = ajouteur(10);

    //println( ajoute10(5) )
  }
}