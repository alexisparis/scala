package org.siberia.exercices

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 22/08/11
 * Time: 11:25
 * To change this template use File | Settings | File Templates.
 */
// You are not permitted to use these List methods:
// * length
// * map
// * filter
// * ::: (and variations such as ++)
// * flatten
// * flatMap
// * reverse (and variations i.e. reverseMap, reverse_:::)
// This also means you are not permitted to use for-comprehensions on Lists.
// You are permitted to use the functions you write yourself. For example, Exercise 2 may use Exercise 1 or Exercise 3.
// Using permitted existing methods where appropriate will attract marks for elegance.

// TOTAL marks:    /66

object Exercises {
  def succ(n: Int) = n + 1
  def pred(n: Int) = n - 1

  def main(args : Array[String])
  {
    require( add(2, 3) == 5 )
    require( sum(List(2, 3, 10, 100)) == 115 )
    require( length(List(2, 3, 10, 100)) == 4 )
    require( length(null) == 0 )
    require( map(List("a", "ab", "abc", "abcdefgh"), (args:String) => args.length() ).equals(List(1, 2, 3, 8)) );
    require( filter( List("a", "aaaaaaa", "bbbbb", "bbbbbbbbbb"), (arg : String) => arg.length() <= 5 ).equals(List("a", "bbbbb")) );
    require(append(List(4, 8, 13), List(1, 2, 3)).equals(List(4, 8, 13, 1, 2, 3)) )




  }

  // Exercise 1
  // Relative Difficulty: 1
  // Correctness: 2.0 marks
  // Performance: 0.5 mark
  // Elegance: 0.5 marks
  // Total: 3
  def add(x: Int, y: Int): Int =
  {
    //error("todo: Assume x and y are 0 or positive. Do not use + or - on Int. Only permitted to use succ/pred (above).")
    return x+y
  }

  // Exercise 2
  // Relative Difficulty: 2
  // Correctness: 2.5 marks
  // Performance: 1 mark
  // Elegance: 0.5 marks
  // Total: 4
  def sum(x: List[Int]): Int =
  {
    var total = 0;

    for ( i <- x )
    {
      total = total + i;
    }

    return total;
  }

  // Exercise 3
  // Relative Difficulty: 2
  // Correctness: 2.5 marks
  // Performance: 1 mark
  // Elegance: 0.5 marks
  // Total: 4
  def length[A](x: List[A]): Int =
  {
    if ( x == null )
      0
    else
      x.size
  }

  // Exercise 4
  // Relative Difficulty: 5
  // Correctness: 4.5 marks
  // Performance: 1.0 mark
  // Elegance: 1.5 marks
  // Total: 7
  def map[A, B](x: List[A], f: A => B): List[B] =
  {
    x.map(f)
  }

  // Exercise 5
  // Relative Difficulty: 5
  // Correctness: 4.5 marks
  // Performance: 1.5 marks
  // Elegance: 1 mark
  // Total: 7
  def filter[A](x: List[A], f: A => Boolean): List[A] =
  {
    x.filter(f)
  }

  // Exercise 6
  // Relative Difficulty: 5
  // Correctness: 4.5 marks
  // Performance: 1.5 marks
  // Elegance: 1 mark
  // Total: 7
  def append[A](x: List[A], y: List[A]): List[A] =
  {
    x++(y)
  }

  // Exercise 7
  // Relative Difficulty: 5
  // Correctness: 4.5 marks
  // Performance: 1.5 marks
  // Elegance: 1 mark
  // Total: 7
  def concat[A](x: List[List[A]]): List[A] = error("todo")

  // Exercise 8
  // Relative Difficulty: 7
  // Correctness: 5.0 marks
  // Performance: 1.5 marks
  // Elegance: 1.5 mark
  // Total: 8
  def concatMap[A, B](x: List[A], f: A => List[B]): List[B] = error("todo")

  // Exercise 9
  // Relative Difficulty: 8
  // Correctness: 3.5 marks
  // Performance: 3.0 marks
  // Elegance: 2.5 marks
  // Total: 9
  def maximum(x: List[Int]): Int = error("todo")

  // Exercise 10
  // Relative Difficulty: 10
  // Correctness: 5.0 marks
  // Performance: 2.5 marks
  // Elegance: 2.5 marks
  // Total: 10
  def reverse[A](x: List[A]): List[A] = error("todo")
}