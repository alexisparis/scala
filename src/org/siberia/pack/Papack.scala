package org.siberia.pack

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 14/09/11
 * Time: 11:54
 * To change this template use File | Settings | File Templates.
 */

package com{
  class Papack
  {

  }
}

package a{
  class Papacka
  {

  }
}

package ch.d.e.f{
  class PapackWeird
  {

  }
}

package object people  // définit des éléments disponibles au niveau du package
{
  val defaultName = "John Doe"
}

package people
{
  class SomePeople
  {
    // utilisation de la valeur par défaut défini dans le package
    var name = org.siberia.pack.people.defaultName
    // or
    var name2 = defaultName

    // raise is accessible for all items in the people package
    private[people] def raise() =
    {

    }
  }
}