package org.siberia.importation

import java.text.DateFormat
import java.text.DateFormat._
import java.util.{Locale, Date}

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 26/07/11
 * Time: 10:49
 * To change this template use File | Settings | File Templates.
 */

object FrenchDate
{
  def main(args: Array[String])
  {
    val now = new Date;
    val df = getDateInstance(LONG, Locale.FRANCE)
    println(df format now)
  }
}