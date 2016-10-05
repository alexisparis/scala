package org.siberia.cases

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 26/07/11
 * Time: 09:21
 * To change this template use File | Settings | File Templates.
 */

object PersonTest {

  def main(args: Array[String])
  {
    val person = CasePerson("alexis", "PARIS")
    println("firstName : " + person.firstName)
    println("lastName : " + person.lastName)
    println("toString : " + person)
  }
}