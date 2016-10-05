package org.siberia.genericity

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 26/07/11
 * Time: 11:05
 * To change this template use File | Settings | File Templates.
 */

class Reference[T]
{
  private var contents: T = _ // _ is the default value

  def set(value: T) { contents = value }

  def get: T = contents
}