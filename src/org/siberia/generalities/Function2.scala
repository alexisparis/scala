package org.siberia.generalities

import scala.Int

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 26/07/11
 * Time: 10:53
 * To change this template use File | Settings | File Templates.
 */

object Function2
{

  /* with anonymous function */
  def funk (a:String, b:String):Int =
  {
    a.length() + b.length();
  }

  def main(args: Array[String])
  {
    //oncePerSecond(timeFlies)

    oncePerSecondWithParameter( (arg : String) => 6 )

    oncePerSecondWith2Parameters( funk );
  }

  def oncePerSecond(callback: ()=> Unit) // Unit means return nothing
  {
    var _count = 0;
    while(_count < 2)
    {
      callback(); Thread.sleep(1000);
      _count = _count + 1;
    }
  }

  def timeFlies()
  {
    println("time flies like an arrow...")
  }

  def oncePerSecondWithParameter(callback: (String)=> Int)
  {
    println( callback("toto") );
  }

  def oncePerSecondWith2Parameters(callback: (String, String)=> Int)
  {
    println( callback("toto", "titi") );
  }
}