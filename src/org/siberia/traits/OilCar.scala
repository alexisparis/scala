package org.siberia.traits

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 26/07/11
 * Time: 10:20
 * To change this template use File | Settings | File Templates.
 */

trait OilCar extends Car
{
  override def drive =
  {
    super.drive()

    println(" oil car")
  }

  def fill() =
  {

  }
}