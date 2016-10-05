package org.siberia.loop

object Loops
{
	def main(args : Array[String])
	{
		val list = List("Java", "Scala", "Groovy", ".net");
 
		list.foreach(n=>println(n))
  
		for (i<- 1.to(9))
		{
			print(i)
		}
		println()
		for (i<- 1 to 9)
		{
			print(i)
		}
	}
}
