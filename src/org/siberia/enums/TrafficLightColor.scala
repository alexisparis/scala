package org.siberia.enums

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 13/09/11
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */

object TrafficLightColor extends Enumeration
{
  type TrafficLightColor = Value
  val Red, Yellow, Green = Value

  // shortcut for
  // val Red = Value
  // val Yellow = Value and so on

  val Blue = Value("bleu") // default value is val name
  val Orange = Value(45)
  val Cyan = Value // name is Cyan and id is Orange id + 1 => 46

  def main(args : Array[String])
  {
    print(TrafficLightColor.Cyan)

    print(TrafficLightColor.withName("Yellow"))
    print(TrafficLightColor(0))
  }

  def print(typ : TrafficLightColor)
  {
    println(typ + " id=" + typ.id)
  }
}