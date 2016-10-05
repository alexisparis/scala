package org.siberia.generalities

/**
 * Created by IntelliJ IDEA.
 * User: alexis
 * Date: 27/08/11
 * Time: 09:32
 * To change this template use File | Settings | File Templates.
 */
class Rational(n: Int, d: Int)
{
  private def gcd(x: Int, y: Int): Int =
  {
    if (x == 0)
    {
      y
    }
    else if (x < 0)
    {
      gcd(x, y)
    }
    else if (y < 0)
    {
      gcd(x, y)
    }
    else
    {
      gcd(y % x, x)
    }
  }

  private val g = gcd(n, d)
  val numer: Int = n / g
  val denom: Int = d / g

  def +(that: Rational) : Rational =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def -(that: Rational) : Rational =
  {
    println("before")
    def rat = new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
    println("after")
    rat
  }

  def *(that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def /(that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  override def toString =
  {
    super.toString + ":: numerateur=" + n + "; denominateur=" + d
  }

}