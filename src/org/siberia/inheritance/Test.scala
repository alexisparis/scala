package org.siberia.inheritance

import org.siberia.inheritance.BetterRobot
import java.lang.reflect.Field

object Test extends Application
{	
	var robot = new RobotWithConstructor(true, "bronze")
	robot.printStatus

	//println(robot.material)
 
	robot = new RobotWithConstructor()
	robot.printStatus
 
	robot.material = "wood"
	robot.printStatus
 
  var bRobot = new BetterRobot("plastic")
  bRobot.printStatus

  println("is BetterRobot instanceof RobotWithConstructor ? " + bRobot.isInstanceOf[RobotWithConstructor])

  // cast de bRobot en RobotWithConstructor
  var x = bRobot.asInstanceOf[RobotWithConstructor]
  println("better robot casted to RobotWithConstructor : " + x)

  if ( bRobot.getClass == classOf[BetterRobot] )
    println("bRobot is a better robot")

  var y = bRobot.asInstanceOf[String] // throw exception
  println("better robot casted to String : " + y)
}
