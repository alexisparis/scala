package org.siberia.guest_table

import com.sun.org.apache.xpath.internal.operations.Variable

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 27/09/11
 * Time: 07:36
 * To change this template use File | Settings | File Templates.
 */

class Guest(val prenom : String, val sexe : String)
{
  var inCoupleWith : Guest = null

  var incompatibleGuest = List[Guest]()

  var affinities = List[GuestAffinity]();

  def setInCoupleWith(g : Guest) : Unit =
  {
    if ( g != null )
    {
      if ( g == this )
      {
        throw new RuntimeException("I cannot couple with me!!")
      }

      this.inCoupleWith = g;
      g.inCoupleWith = this;
    }
  }

  def addIncompatibleGuest(g : Guest) : Unit =
  {
    if ( g == this )
    {
      throw new RuntimeException("I cannot be incompatible with me!!")
    }

    this.incompatibleGuest = this.incompatibleGuest.::(g);

    g.incompatibleGuest = g.incompatibleGuest.::(this);
  }

  def isIncompatibleWith(g : Guest) : Boolean =
  {
    this.incompatibleGuest.contains(g)
  }

  def addAffinity(g : Guest, affinity : Int) : Guest =
  {
    return this.addAffinity(new GuestAffinity(g, affinity));
  }

  def addAffinity(g : GuestAffinity) : Guest =
  {
    if ( g != this )
    {
      this.affinities = this.affinities.::(g);

      val newAffinity = new GuestAffinity(this, g.affinity)
      g.guest.affinities = g.guest.affinities.::(newAffinity)
    }

    this
  }

  def isAffinityDefinedWith(g : Guest) : Boolean =
  {
		val result = this.affinities.filter( (_guest : GuestAffinity) => _guest.guest.equals(g) )

    ! result.isEmpty
  }

  def getAffinityWith(g : Guest) : Int =
  {
		val result = this.affinities.filter( (_guest : GuestAffinity) => _guest.guest.equals(g) )

    if ( ! result.isEmpty )
    {
      val aff = result(0)

      if ( aff == null )
      {
        return 2
      }
      else
      {
        return aff.affinity
      }
    }
    0
  }

  override def hashCode() : Int =
  {
    this.prenom.hashCode()
  }

  override def equals(arg : Any) : Boolean =
  {
    if ( arg.isInstanceOf[Guest] )
    {
      if ( this.prenom.equals((arg.asInstanceOf[Guest]).prenom) )
      {
        return true
      }
    }

    false
  }


  override def toString() =
  {
    var v : String = "";

    if ( this.inCoupleWith != null )
    {
      v = " in couple with " + this.inCoupleWith.prenom;
    }

    "Guest : " + this.prenom + v;
  }
}