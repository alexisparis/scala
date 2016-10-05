package org.siberia.collec

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 22/08/11
 * Time: 15:29
 * To change this template use File | Settings | File Templates.
 */

object Lists
{
  def main(args : Array[String])
  {
    var list = List(1, 2, 3)
    require( list.addString(new StringBuilder()).toString().equals("123") )
    require( (list++List(5, 6)).equals(List(1, 2, 3, 5, 6)) )
    require( (list.++:(List(5, 6))).equals(List(5, 6, 1, 2, 3)) )
    require( (list.+:(6)).equals(List(6, 1, 2, 3)) )
    require( (list.:+(6)).equals(List(1, 2, 3, 6)) )
    require( (list.:+(40)).equals(List(1, 2, 3, 40)) )
    require( (list.::(40)).equals(List(40, 1, 2, 3)) )


    require( (list:::(List(40, 50))).equals(List(1, 2, 3, 40, 50)) )
    require( (list.:::(List(40, 50))).equals(List(40, 50, 1, 2, 3)) )
    //list./:(..) je sais pas à quoi ca sert
    //list./:\(..) je sais pas à quoi ca sert

    require( list.apply(2).equals(3) )
    require( list(2).equals(3) )

    list = List(1, 2, 3, 3, 3)
    require( list.groupBy( (arg:Int) => arg % 2 ).equals(Map(1 -> List(1, 3, 3, 3), 0 -> List(2))) )


    val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
    println("==> " + fruit)
    val fruit2 = "apples" :: "oranges" :: "pears" :: Nil
    println("==> " + fruit2)

    val a = 3  :: 4 :: 5 :: Nil
    val b = 6

    def sum(xs: List[Int]) = (xs foldLeft 0) {(x, y) => x + y}
    def product(xs: List[Int]) = (xs foldLeft 1) {(x, y) => x * y}
    def sum2(xs : List[Int]) = (0 :: xs) reduceLeft  {(x, y) => x + y}
    def sum3(xs : List[Int]) = xs reduceLeft  {(x, y) => x + y}
    def product2(xs : List[Int]) = (1 :: xs) reduceLeft  {(x, y) => {val v = println("x=" + x + ", y=" + y + " then "); x * y}}

    def diffLeft(xs: List[Int]) = xs reduceLeft {(x, y) => x - y}
    def diffRight(xs: List[Int]) = xs reduceRight {(x, y) => x - y}

    println("somme 1 de a => " + sum(a))
    println("produit 1 de a => " + product(a))
    println("somme 2 de a => " + sum2(a))
    println("produit 2 de a => " + product2(a))
    println("somme 3 de a => " + sum3(a))

    println("diffLeft : " + diffLeft(a))
    println("diffRight : " + diffRight(a))

  }
}