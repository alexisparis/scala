package org.siberia.generalities

/**
 * Created by IntelliJ IDEA.
 * User: alexis
 * Date: 25/08/11
 * Time: 22:06
 * To change this template use File | Settings | File Templates.
 */

object QuantiteTest
{
  def main(args : Array[String])
  {
    var qt1 = new Quantite()
    // si on définit qt1 par ==> def qt1 = new Quantite(), on aura beau le modifier via qt1.qte = 5,
    // à chaque fois qu'on le réutilisera, il sera réévalué à new Quantite()
    qt1.qte = 5
    var qt2 = new Quantite()
    qt2.qte = 6

    var qt3 = qt1 + qt2

    println(qt1.qte)
    println(qt2.qte)

    qt3.qte = 9
    qt3 setNote 7
    println(qt3.qte)
    println("note : " + qt3.getNote())
  }

  class Quantite//(var qte : Int)
  {
    private var note = 0

    var qte : Int = 0

    def setNote(a : Int) =
    {
      this.note = a
    }

    def getNote() : Int =
    {
      this.note
    }

    def +(q : Quantite) : Quantite =
    {
      var qesult = new Quantite()
      qesult.qte = this.qte + q.qte;
      qesult
    }
  }
}