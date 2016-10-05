package org.siberia.traits

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 26/07/11
 * Time: 14:16
 * To change this template use File | Settings | File Templates.
 */

class HybridCar extends OilCar with ElectricCar
{
  override def drive()
  {
    super.drive
    println("hybrid car")
  }

}