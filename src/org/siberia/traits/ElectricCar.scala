package org.siberia.traits

import io.BytePickle.Def

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 26/07/11
 * Time: 10:20
 * To change this template use File | Settings | File Templates.
 */

trait ElectricCar extends Car
{
  override def drive =
  {
    super.drive()

    println(" electric car")
  }

  def reload() =
  {

  }
}
