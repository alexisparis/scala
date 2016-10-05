package org.siberia.inheritance

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 14/09/11
 * Time: 12:25
 * To change this template use File | Settings | File Templates.
 */

class Person(name : String, age : Int)
{

}

class Employee(name : String, age : Int, salary : Int) extends Person(name, age)
{

}
