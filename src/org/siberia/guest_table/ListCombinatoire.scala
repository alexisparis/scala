package org.siberia.guest_table

import scala.runtime.ScalaRunTime._

import scala.Array
import collection.mutable.ArrayBuffer

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 27/09/11
 * Time: 11:07
 * To change this template use File | Settings | File Templates.
 */

object ListCombinatoire
{
  def main(args : Array[String])
  {
    var time = System.currentTimeMillis()

    var tab = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
    //var tab = Array(1, 2, 3);

    traversePermutations(tab, 0, tab.length, null)//(arg : Array[Int]) => /*println(stringOf(arg)*/Unit)
    // getAllPermutations(tab)
    //println("fact => " + fact(tab.length))
    //getAllPermutations2(tab, new java.util.ArrayList[Int](fact(tab.length)))

    time = System.currentTimeMillis() - time

    println("temps d'execution : " + (time / 1000) + " secondes")
  }

  def fact(n : Int) : Int =
  {
    if ( n == 1 )
    {
      1
    }
    else
    {
      n * fact(n - 1)
    }
  }

  def getAllPermutations(tab : Array[Guest]) : ArrayBuffer[Array[Guest]] =
  {
    getAllPermutations(tab, 0, tab.length)
  }

  def getAllPermutations(tab : Array[Guest], start : Int, n : Int) : ArrayBuffer[Array[Guest]] =
  {
    var result = ArrayBuffer[Array[Guest]]();

    if ( start == n - 1 )
    {
      println("adding : " + stringOf(tab))
      result = result.+:(tab)
    }
    else
    {
      var i = start

      while( i < n )
      {
        var tmp = tab(i)

        tab(i) = tab(start)
        tab(start) = tmp

        var _subResult = getAllPermutations(tab, start + 1, n)

        if ( _subResult != null )
        {
          var j = 0;

          while(j < _subResult.length)
          {
            result = result.+:(_subResult(j));
            j = j + 1
          }
        }

        tab(start) = tab(i)
        tab(i) = tmp

        i = i + 1
      }
    }

    result
  }

  def traversePermutations(tab : Array[Guest], start : Int, n : Int, f : (Array[Guest]) => Unit) : ArrayBuffer[Array[Guest]] =
  {
    var result = ArrayBuffer[Array[Guest]]();

    if ( start == n - 1 )
    {
      println("adding : " + stringOf(tab))
      result = result.+:(tab)
    }
    else
    {
      var i = start

      while( i < n )
      {
        var tmp = tab(i)

        tab(i) = tab(start)
        tab(start) = tmp

        traversePermutations(tab, start + 1, n, f)

        tab(start) = tab(i)
        tab(i) = tmp

        i = i + 1
      }
    }

    result
  }

  def traversePermutations(tab : Array[Int], start : Int, n : Int, f : (Array[Int]) => Unit) : Unit =
  {
    if ( start == n - 1 )
    {
      if ( f != null )
      {
        f(tab)
      }
    }
    else
    {
      var i = start

      while( i < n )
      {
        var tmp = tab(i)

        tab(i) = tab(start)
        tab(start) = tmp

        traversePermutations(tab, start + 1, n, f)

        tab(start) = tab(i)
        tab(i) = tmp

        i = i + 1
      }
    }
  }

  def getAllPermutations(tab : Array[Int]) : ArrayBuffer[Array[Int]] =
  {
    getAllPermutations(tab, 0, tab.length)
  }

  def getAllPermutations(tab : Array[Int], start : Int, n : Int) : ArrayBuffer[Array[Int]] =
  {
    var result = ArrayBuffer[Array[Int]]();

    if ( start == n - 1 )
    {
      result = result.+:(tab)
      println("adding : " + stringOf(tab))
    }
    else
    {
      var i = start

      while( i < n )
      {
        var tmp = tab(i)

        tab(i) = tab(start)
        tab(start) = tmp

        var _subResult = getAllPermutations(tab, start + 1, n)

        if ( _subResult != null )
        {
          var j = 0;

          while(j < _subResult.length)
          {
            result = result.+:(_subResult(j));
            j = j + 1
          }
        }

        tab(start) = tab(i)
        tab(i) = tmp

        i = i + 1
      }
    }

    result
  }

  def getAllPermutations2(tab : Array[Int], resultList : java.util.List[Int]) : java.util.List[Int] =
  {
    getAllPermutations2(tab, 0, tab.length, resultList)
  }

  def getAllPermutations2(tab : Array[Int], start : Int, n : Int, resultList : java.util.List[Int]) : java.util.List[Int] =
  {
    var result = resultList;

    if ( start == n - 1 )
    {
      //result.add(new java.util.ArrayList[Int](tab))
      println("adding : " + stringOf(tab))
    }
    else
    {
      var i = start

      while( i < n )
      {
        var tmp = tab(i)

        tab(i) = tab(start)
        tab(start) = tmp

        var _subResult = getAllPermutations2(tab, start + 1, n, resultList)

        result.addAll(_subResult)

        tab(start) = tab(i)
        tab(i) = tmp

        i = i + 1
      }
    }

    result
  }

}