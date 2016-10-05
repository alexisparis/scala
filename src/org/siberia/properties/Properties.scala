package org.siberia.properties

import reflect.BeanProperty

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 13/09/11
 * Time: 12:57
 * To change this template use File | Settings | File Templates.
 */

object Properties
{
  def main(args : Array[String])
  {
    var counter = new Counter()
    counter.increment()
    counter.increment()
    println("counter with current     : " + counter.current)
    println("counter with current()   : " + counter.current()) // prefer counter.current ==> no () for accessor method but () for mutator methods like increment
    println("counter with currentAlso : " + counter.currentAlso) // no () allowed

    var fred = new Person;
    println("fred age : " + fred.age) // calls fred.age()
    fred.age = 47                     // calls fred.age_=(47)
    fred.age =(50)                    // calls fred.age_=(50)
    println("new fred age : " + fred.age)

    var sophie = new PrivatePerson;
    println("sophie age : " + sophie.age)
    sophie.age = 23
    println("new sophie age : " + sophie.age)

    println("Properties va modifier et lire la valeur varAccessibleByPerson de sophie : ")
    println("sophie varAccessibleByProperties before modification : " + sophie.varAccessibleByProperties)
    sophie.varAccessibleByProperties = "modified"
    println("sophie varAccessibleByProperties after modification : " + sophie.varAccessibleByProperties)
    //fred modifyVarAccessibleByPersonAndPrint sophie

    var javaPerson = new JavaLikePerson
    javaPerson.setName("Tim")
    println("display nom java person : " + javaPerson.getName())
  }

  class Counter
  {
    private var value: Int = _;  // must be initialized
    def increment() = { value += 1} // methods are public by default
    def current() = {value}
    def currentAlso = value // method like current() but we cannot use ()
  }

  class Person
  {
    var age: Int = 0
    // scala generate a private field with public getter and setter
    //   getter age
    //   setter age_=
    //      for a private var, getter and setter would have been private

    val toto: Int = 0;
    // scala generate a public getter
  }

  class PrivatePerson
  {
    private var privateAge: Int = 0
    // scala generate private getter and setter but we can create our own getter and setter

    private var forename : String = _

    private[this] var surname  : String = _  // objects private access ==> no getter, no setter generated

    private[Properties] var varAccessibleByProperties : String = _  // seul Properties peut accéder à cette propriété et la modifier

    def age = privateAge

    def age_=(newValue : Int)
    {
      privateAge = 2 * newValue
    }

    def op(otherPerson : PrivatePerson) =
    {
      this.forename < otherPerson.forename

      //this.surname < otherPerson.surname
      // surname not accessible for otherPerson
    }
  }

  class JavaLikePerson
  {
    @BeanProperty
    var name : String = _
    // this generate 4 methods :
    //   name : String
    //   name_=(newValue : String) : Unit
    //   getName() : String
    //   setName(newValue : String) : Unit
  }
}