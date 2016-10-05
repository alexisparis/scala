package org.siberia.constructor


/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 13/09/11
 * Time: 14:23
 * To change this template use File | Settings | File Templates.
 */

object Constructors
{
  def main(args : Array[String])
  {
    var p = new Person()
    var p1 = new Person("toto")
    var p2 = new Person("tata", 45)

    var q = new Person2("tutu", 2)

    // does not work, Person3 has private constructor
    //var r = new Person3("tutu", 2)

  }

  class Person
  {
    // part of the primary constructor
    println("Person created")
    println("Yipee!!")

    private var name : String = ""
    private var age : Int = 0

    def this(name : String) // auxiliary constructor
    {
      this() // call primary constructor
      this.name = name
    }

    def this(name: String, age : Int) // another auxiliary constructor
    {
      this(name)
      this.age = age
    }
  }

  class Person2(val name : String, val age : Int)
  {
    // part of the primary constructor
    println("Person2 created") // executed when an objects is created

  }

  class Person3 private(val name : String, val age : Int) // private constructor
  {
    // part of the primary constructor
    println("Person3 created") // executed when an objects is created

  }
}