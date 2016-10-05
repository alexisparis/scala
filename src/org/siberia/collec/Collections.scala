package org.siberia.collec

object Collections
{
	def main(args : Array[String])
	{
		// #########################
		// LIST
		// #########################
		// Lists is immutable, if you add something to it, you create another instance
		val languages = List("Java", "C++")
  
		println("languages " + languages)
		println("languages(2) " + languages(1))
		println("contains groovy ? " + languages.contains("groovy"))

		val languages2 = languages+ "Groovy"

		println("languages(2) 0 " + languages2(0))
		println("languages(2) 1 " + languages2(1))
		println("languages(2) 2 " + languages2(2))
		println("languages(2) length " + languages2.size)

		println("languages2 " + languages2)
		println("languages " + languages)
  
		// #########################
		// ARRAY
		// #########################
		val array = Array("Java", "Scala")
		println("array : " + array)
  
		// #########################
		// MAP
		// #########################
		val map = Map("Scala"-> "JVM", "Java"-> "JVM", ".net"-> "CLR")
		println("map : " + map)
		println("map scala ? " + map("Scala"))
  
		// #########################
		// METHODS
		// #########################
		val list= List(1, 2, 3, 4)
		// Prints number of all elements
		println (list.size )
		// Count only the elements which can be divided by 2
		println (list.count(i=> i %2==0))
		// Check if a elements in included in list
		println(list.exists(i=> i == 4));
		println(list.exists(i=> i == 5));
		// Using filter to get elements
		val newList = list.filter(i=> i>=3)
		println (newList)
		// Map does allow to transform a list
		val newList2 = list.map(i=> i*3)
		println (newList2)

    val listString = List("a", "b", "c", "d", "avion", "alouette")
    println (listString.count(i => i.startsWith("a")))
	}
}
