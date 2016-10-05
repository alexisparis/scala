package org.siberia.guest_table

import com.sun.org.apache.xpath.internal.operations.Variable
import collection.script.Index

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 27/09/11
 * Time: 10:42
 * To change this template use File | Settings | File Templates.
 */

class PlanTable(items : Array[Guest])
{

  def getNeighboors(g : Guest) : List[Guest] =
  {
    var result = List[Guest]();

    var index = this.items.indexOf(g);

    if ( index >= 0 && index <= 15 )
    {
      if ( index == 0 )
      {
        result = result.+:(this.items(1))
        result = result.+:(this.items(16))
        result = result.+:(this.items(17))
      }
      else if ( index == 15 )
      {
        result = result.+:(this.items(14))
        result = result.+:(this.items(30))
      }
      else
      {
        result = result.+:(this.items(index - 1))
        result = result.+:(this.items(index + 1))

        result = result.+:(this.items(index + 16 - 1))
        result = result.+:(this.items(index + 16 + 0))
        result = result.+:(this.items(index + 16 + 1))
      }
    }
    else
    {
      if ( index == 16 )
      {
        result = result.+:(this.items(0))
        result = result.+:(this.items(1))
        result = result.+:(this.items(17))
      }
      else if ( index == 30 )
      {
        result = result.+:(this.items(29))
        result = result.+:(this.items(13))
        result = result.+:(this.items(14))
        result = result.+:(this.items(15))
      }
      else
      {
        result = result.+:(this.items(index - 1))
        result = result.+:(this.items(index + 1))

        result = result.+:(this.items(index - 16 - 1))
        result = result.+:(this.items(index - 16 + 0))
        result = result.+:(this.items(index - 16 + 1))
      }
    }


    null;
  }

  def print() : Unit =
  {
    println("------------------------------------")
    var i = 0;

    while( i < 15)
    {
      println( this.items(16 + i).prenom + " / " + this.items(i).prenom )
      i = i + 1
    }
    println(this.items(15).prenom)
    println("------------------------------------")

  }
}