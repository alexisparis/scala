package org.siberia.actors

import actors.{TIMEOUT, Actor}
import scala.actors

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 24/08/11
 * Time: 07:54
 * To change this template use File | Settings | File Templates.
 */

object ActorTest
{
  def main(args : Array[String])
  {
    var actor = new MyActor()
    var actor2 = new MyActor2()

    actor start;
    actor2 start;

    actor ! MyMessage1("toto") // envoi message à destination d'actor
    actor ! MyMessage2(43)
    actor ! MyMessage1("tata")
    Thread sleep 4000
    actor ! MyMessage1("message timed out")

    actor2 ! MyMessage1("a");
    actor2 ! MyMessage2(56);
    actor2 ! MyMessage1("b");
    actor2 ! MyMessage1("c");
    actor2 ! MyMessage2(3);
    actor2 ! MyMessage2(5);
    actor2 ! StopMessage
  }

  class MyActor extends Actor
  {
    var running = true;
    def act()
    {
      while(running)
      {
        receiveWithin(1000) // bloc jusqu'à la réception d'un message dans la seconde
        {
          case MyMessage1(nom: String) =>
            println("MyActor :: receive message 1 " + nom)
          case MyMessage2(_size: Int) =>
            println("MyActor :: receive message 2 " + _size)
          case TIMEOUT =>
            println("MyActor :: timeout")
            running = false
        }
      }
    }
  }

  class MyActor2 extends Actor
  {
    def act()
    {
      loop
      {
        react
        {
          case MyMessage1(arg: String) =>
            react
            {
              case MyMessage2(arg2 : Int) =>
                println("MyActor2 :: receive message 1 " + arg + " and then message 2 " + arg2)
            }
          case StopMessage => exit()
        }
      }
    }
  }

  abstract class MyMessage
  case class MyMessage1(name: String) extends MyMessage
  case class MyMessage2(size: Int) extends MyMessage
  case object StopMessage extends MyMessage
}