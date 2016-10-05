package org.siberia.inheritance

class RobotWithConstructor (on : Boolean, var material:String)
{
	def printStatus() = 
    {
       println(on)
       println(material)
    }
  
	def this() = this(true, "Steel");
}
