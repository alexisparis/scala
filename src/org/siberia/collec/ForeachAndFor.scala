package org.siberia.collec

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing.Validation
import java.util.Map
import collection.Map

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 26/07/11
 * Time: 13:46
 * To change this template use File | Settings | File Templates.
 */

object ForeachAndFor
{
  def main(args : Array[String])
  {
    val array = Array("toto", "tata", "titi", "tutu")
    array.foreach( (arg : String) => println(arg) )
    var result = array.forall( (arg : String) => if ( "toto".equals(arg) ) true else false )
    println("result : " + result)
    var count = array.count( (arg : String) => if ( "toto".equals(arg) ) true else false )
    println("count : " + count)

    for( arrayItem <- array )
    {
      println("\t" + arrayItem)
    }

    println("personnes : ")
    var persons  = List(new Person("PARIS", "Alexis", 30), new Person("GUERLAIN", "Sophie", 30), new Person("PARIS", "Timothé", 1))
    println("\tpersones : " + persons)
    val noms = for (p <- persons if p.age > 20) yield p.nom // 1
    println("\tnoms : " + noms)

    val map = persons filter (p => p.age > 20) map (p => p.nom) // equivalent to 1
    println("\tmap : " + map)

    val a = Array(2, 3, 5, 6, 9)

    val b = a.filter(_ % 2 == 0).map(2 * _)
    println("a filtered : ")
    for( arrayItem <- b )
    {
      println("\t" + arrayItem)
    }

    val c = a filter  { _ % 2 == 0} map { _ * 2 }
    println("a filtered 2 : ")
    for( arrayItem <- c )
    {
      println("\t" + arrayItem)
    }

    val map2 = scala.collection.mutable.Map("Alexis" -> 30, "Sophie" -> 30, "Timothé" -> 1)
    println("affichage map2 : ")
    for ( (k, v) <- map2 )
    {
      println("\t" + k + " ==> " + v)
    }

  }

  case class Person(nom : String, prenom : String, age : Int)
  {

  }
}