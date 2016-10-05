package org.siberia.guest_table

import com.sun.org.apache.xpath.internal.operations.Variable

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 27/09/11
 * Time: 07:38
 * To change this template use File | Settings | File Templates.
 */

object PlanTableOptimizer
{
  val alexis = new Guest("Alexis", "M")
  val sophie = new Guest("Sophie", "F")

  val hugo = new Guest("Hugo", "M")
  val quentin = new Guest("Quentin", "M")
  val virginie = new Guest("Virginie", "F")
  val gregory = new Guest("Gregory", "M")

  val julien = new Guest("Julien", "M")
  val amelie = new Guest("Amélie", "F")

  val claire = new Guest("Claire", "F")
  val jb = new Guest("jb", "M")

  val martine = new Guest("Martine", "F")
  val elisabeth = new Guest("Elisabeth", "F")

  val mado = new Guest("Mado", "F")
  val pierre = new Guest("Pierre", "M")

  val therese = new Guest("Therese", "F")

  val laurent = new Guest("Laurent", "M")
  val aurelie = new Guest("Aurélie", "F")

  val antoineR = new Guest("Antoine R", "M")
  val edouardR = new Guest("Edouard R", "M")
  val stephanie = new Guest("Stéphanie", "F")
  val stephane = new Guest("Stéphane", "M")

  val loic = new Guest("Loic", "M")
  val alexandra = new Guest("Alexandra", "F")

  val angelique = new Guest("Angélique", "F")

  val jeanine = new Guest("Jeanine", "F")

  val christine = new Guest("Christine", "F")
  val bernard = new Guest("Bernard", "M")

  val monique = new Guest("Monique", "F")
  val michel = new Guest("Michel", "M")

  val thomas = new Guest("Thomas", "M")

  val edouard = new Guest("Edouard", "M")

  var guestlist : List[Guest] = List[Guest]()

  def main(args : Array[String])
  {
    init()

    checkAffinityDefined()

    //var newPlan = new PlanTable(guestlist.toArray)

    //newPlan.print()

    println("guest list size : " + guestlist.length)

    var allPermutations = ListCombinatoire.getAllPermutations(guestlist.toArray)

    var i = 0;

    var allPermutationsSize = allPermutations.length;

    println("starting permutations process...")
    while(i < allPermutationsSize)
    {
      var continue = true;

      var newPlan = new PlanTable(allPermutations(i))

      // pour chaque invité, on va regarder si des choses ne sont pas valides vis-à-vis des personnes
      // placés de facon fixe ou vis-à-vis des incompatibilités
      var j = 0

      while(j < guestlist.length && continue)
      {
        var currentGuest = guestlist(j)
        var neighboors = newPlan.getNeighboors(currentGuest)

        var k = 0

        while(k < neighboors.length && continue)
        {
          var currentNeighboor = neighboors(k)

          if ( currentGuest.isIncompatibleWith(currentNeighboor) )
          {
            println("incompatible")
            continue = false;
          }

          k = k + 1
        }

        j = j + 1
      }

      if ( i % 1000 == 0 )
      {
        println("processed " + i + " on " + allPermutationsSize + " permutations available")
      }

      i = i + 1
    }
  }

  def checkAffinityDefined()
  {
    var i = 0;
    while(i < guestlist.length)
    {
      var j = i + 1

      while(j < guestlist.length)
      {
        var g1 = guestlist(i);
        var g2 = guestlist(j);

        if ( ! g1.isAffinityDefinedWith(g2) )
        {
          println("affinity undefined between " + g1 + " and " + g2)
        }

        j = j + 1;
      }

      i = i + 1;
    }
  }

  def init()
  {
    alexis.setInCoupleWith(sophie)
    virginie.setInCoupleWith(gregory)
    julien.setInCoupleWith(amelie)
    claire.setInCoupleWith(jb)
    mado.setInCoupleWith(pierre)
    laurent.setInCoupleWith(aurelie)
    stephane.setInCoupleWith(stephanie)
    loic.setInCoupleWith(alexandra)
    christine.setInCoupleWith(bernard)
    monique.setInCoupleWith(michel)

    // incompatibilités
    alexis.addIncompatibleGuest(stephane)
    amelie.addIncompatibleGuest(stephane)
    amelie.addIncompatibleGuest(aurelie)
    elisabeth.addIncompatibleGuest(pierre)
    elisabeth.addIncompatibleGuest(laurent)
    julien.addIncompatibleGuest(pierre)
    aurelie.addIncompatibleGuest(stephane)
    aurelie.addIncompatibleGuest(stephanie)

    // affinités

    // alexis
    alexis.addAffinity(sophie, 10).addAffinity(hugo, 10).addAffinity(quentin, 10).addAffinity(virginie, 10).addAffinity(gregory, 10)
    alexis.addAffinity(julien, 8).addAffinity(amelie, 10).addAffinity(claire, 5).addAffinity(jb, 5)
    alexis.addAffinity(martine, 2).addAffinity(elisabeth, 5).addAffinity(mado, 10).addAffinity(pierre, 6).addAffinity(therese, 8)
    alexis.addAffinity(laurent, 8).addAffinity(aurelie, 3).addAffinity(antoineR, 3).addAffinity(edouardR, 3).addAffinity(stephanie, 2)
    alexis.addAffinity(stephane, 0).addAffinity(loic, 2).addAffinity(alexandra, 3)
    alexis.addAffinity(angelique, 2).addAffinity(jeanine, 5).addAffinity(christine, 7).addAffinity(bernard, 5).addAffinity(monique, 6)
    alexis.addAffinity(michel, 8).addAffinity(thomas, 9).addAffinity(edouard, 10)

    // sophie
    sophie.addAffinity(hugo, 10).addAffinity(quentin, 10).addAffinity(virginie, 10).addAffinity(gregory, 10)
    sophie.addAffinity(julien, 8).addAffinity(amelie, 5).addAffinity(claire, 3).addAffinity(jb, 5)
    sophie.addAffinity(martine, 2).addAffinity(elisabeth, 5).addAffinity(mado, 3).addAffinity(pierre, 4).addAffinity(therese, 4)
    sophie.addAffinity(laurent, 8).addAffinity(aurelie, 8).addAffinity(antoineR, 2).addAffinity(edouardR, 2).addAffinity(stephanie, 6)
    sophie.addAffinity(stephane, 0).addAffinity(loic, 5).addAffinity(alexandra, 8)
    sophie.addAffinity(angelique, 5).addAffinity(jeanine, 5).addAffinity(christine, 7).addAffinity(bernard, 6).addAffinity(monique, 8)
    sophie.addAffinity(michel, 8).addAffinity(thomas, 9).addAffinity(edouard, 5)

    // hugo
    hugo.addAffinity(quentin, 10).addAffinity(virginie, 10).addAffinity(gregory, 10)
    hugo.addAffinity(julien, 0).addAffinity(amelie, 0).addAffinity(claire, 0).addAffinity(jb, 0)
    hugo.addAffinity(martine, 0).addAffinity(elisabeth, 0).addAffinity(mado, 0).addAffinity(pierre, 0).addAffinity(therese, 0)
    hugo.addAffinity(laurent, 0).addAffinity(aurelie, 0).addAffinity(antoineR, 5).addAffinity(edouardR, 5).addAffinity(stephanie, 0)
    hugo.addAffinity(stephane, 0).addAffinity(loic, 0).addAffinity(alexandra, 0)
    hugo.addAffinity(angelique, 0).addAffinity(jeanine, 0).addAffinity(christine, 0).addAffinity(bernard, 0).addAffinity(monique, 0)
    hugo.addAffinity(michel, 0).addAffinity(thomas, 0).addAffinity(edouard, 0)

    // quentin
    quentin.addAffinity(virginie, 10).addAffinity(gregory, 10)
    quentin.addAffinity(julien, 0).addAffinity(amelie, 0).addAffinity(claire, 0).addAffinity(jb, 0)
    quentin.addAffinity(martine, 0).addAffinity(elisabeth, 0).addAffinity(mado, 0).addAffinity(pierre, 0).addAffinity(therese, 0)
    quentin.addAffinity(laurent, 0).addAffinity(aurelie, 0).addAffinity(antoineR, 5).addAffinity(edouardR, 5).addAffinity(stephanie, 0)
    quentin.addAffinity(stephane, 0).addAffinity(loic, 0).addAffinity(alexandra, 0)
    quentin.addAffinity(angelique, 0).addAffinity(jeanine, 0).addAffinity(christine, 0).addAffinity(bernard, 0).addAffinity(monique, 0)
    quentin.addAffinity(michel, 0).addAffinity(thomas, 0).addAffinity(edouard, 0)

    // virginie
    virginie.addAffinity(gregory, 10)
    virginie.addAffinity(julien, 5).addAffinity(amelie, 5).addAffinity(claire, 6).addAffinity(jb, 5)
    virginie.addAffinity(martine, 5).addAffinity(elisabeth, 3).addAffinity(mado, 3).addAffinity(pierre, 3).addAffinity(therese, 3)
    virginie.addAffinity(laurent, 7).addAffinity(aurelie, 7).addAffinity(antoineR, 3).addAffinity(edouardR, 3).addAffinity(stephanie, 7)
    virginie.addAffinity(stephane, 5).addAffinity(loic, 5).addAffinity(alexandra, 7)
    virginie.addAffinity(angelique, 5).addAffinity(jeanine, 5).addAffinity(christine, 7).addAffinity(bernard, 7).addAffinity(monique, 7)
    virginie.addAffinity(michel, 7).addAffinity(thomas, 6).addAffinity(edouard, 0)

    // gregory
    gregory.addAffinity(julien, 5).addAffinity(amelie, 5).addAffinity(claire, 4).addAffinity(jb, 5)
    gregory.addAffinity(martine, 5).addAffinity(elisabeth, 3).addAffinity(mado, 3).addAffinity(pierre, 3).addAffinity(therese, 3)
    gregory.addAffinity(laurent, 8).addAffinity(aurelie, 5).addAffinity(antoineR, 2).addAffinity(edouardR, 2).addAffinity(stephanie, 5)
    gregory.addAffinity(stephane, 5).addAffinity(loic, 6).addAffinity(alexandra, 5)
    gregory.addAffinity(angelique, 3).addAffinity(jeanine, 4).addAffinity(christine, 7).addAffinity(bernard, 7).addAffinity(monique, 5)
    gregory.addAffinity(michel, 7).addAffinity(thomas, 10).addAffinity(edouard, 0)

    // julien
    julien.addAffinity(amelie, 10).addAffinity(claire, 4).addAffinity(jb, 10)
    julien.addAffinity(martine, 3).addAffinity(elisabeth, 3).addAffinity(mado, 3).addAffinity(pierre, 3).addAffinity(therese, 5)
    julien.addAffinity(laurent, 8).addAffinity(aurelie, 8).addAffinity(antoineR, 2).addAffinity(edouardR, 2).addAffinity(stephanie, 7)
    julien.addAffinity(stephane, 3).addAffinity(loic, 7).addAffinity(alexandra, 5)
    julien.addAffinity(angelique, 3).addAffinity(jeanine, 3).addAffinity(christine, 7).addAffinity(bernard, 7).addAffinity(monique, 3)
    julien.addAffinity(michel, 3).addAffinity(thomas, 8).addAffinity(edouard, 0)

    // amelie
    amelie.addAffinity(claire, 6).addAffinity(jb, 4)
    amelie.addAffinity(martine, 3).addAffinity(elisabeth, 5).addAffinity(mado, 10).addAffinity(pierre, 10).addAffinity(therese, 8)
    amelie.addAffinity(laurent, 8).addAffinity(aurelie, 5).addAffinity(antoineR, 2).addAffinity(edouardR, 2).addAffinity(stephanie, 7)
    amelie.addAffinity(stephane, 2).addAffinity(loic, 5).addAffinity(alexandra, 7)
    amelie.addAffinity(angelique, 5).addAffinity(jeanine, 3).addAffinity(christine, 7).addAffinity(bernard, 7).addAffinity(monique, 3)
    amelie.addAffinity(michel, 3).addAffinity(thomas, 10).addAffinity(edouard, 0)

    // claire
    claire.addAffinity(jb, 10)
    claire.addAffinity(martine, 3).addAffinity(elisabeth, 3).addAffinity(mado, 3).addAffinity(pierre, 3).addAffinity(therese, 3)
    claire.addAffinity(laurent, 8).addAffinity(aurelie, 8).addAffinity(antoineR, 2).addAffinity(edouardR, 2).addAffinity(stephanie, 6)
    claire.addAffinity(stephane, 4).addAffinity(loic, 4).addAffinity(alexandra, 6)
    claire.addAffinity(angelique, 3).addAffinity(jeanine, 3).addAffinity(christine, 6).addAffinity(bernard, 5).addAffinity(monique, 5)
    claire.addAffinity(michel, 5).addAffinity(thomas, 5).addAffinity(edouard, 0)

    // jb
    jb.addAffinity(martine, 3).addAffinity(elisabeth, 3).addAffinity(mado, 3).addAffinity(pierre, 3).addAffinity(therese, 3)
    jb.addAffinity(laurent, 8).addAffinity(aurelie, 6).addAffinity(antoineR, 2).addAffinity(edouardR, 2).addAffinity(stephanie, 2)
    jb.addAffinity(stephane, 4).addAffinity(loic, 3).addAffinity(alexandra, 4)
    jb.addAffinity(angelique, 3).addAffinity(jeanine, 3).addAffinity(christine, 5).addAffinity(bernard, 5).addAffinity(monique, 6)
    jb.addAffinity(michel, 6).addAffinity(thomas, 2).addAffinity(edouard, 0)

    // martine
    martine.addAffinity(elisabeth, 3).addAffinity(mado, 4).addAffinity(pierre, 4).addAffinity(therese, 3)
    martine.addAffinity(laurent, 5).addAffinity(aurelie, 5).addAffinity(antoineR, 2).addAffinity(edouardR, 2).addAffinity(stephanie, 2)
    martine.addAffinity(stephane, 2).addAffinity(loic, 3).addAffinity(alexandra, 4)
    martine.addAffinity(angelique, 3).addAffinity(jeanine, 8).addAffinity(christine, 7).addAffinity(bernard, 6).addAffinity(monique, 10)
    martine.addAffinity(michel, 6).addAffinity(thomas, 2).addAffinity(edouard, 0)

    // elisabeth
    elisabeth.addAffinity(mado, 5).addAffinity(pierre, 0).addAffinity(therese, 8)
    elisabeth.addAffinity(laurent, 4).addAffinity(aurelie, 10).addAffinity(antoineR, 10).addAffinity(edouardR, 10).addAffinity(stephanie, 10)
    elisabeth.addAffinity(stephane, 10).addAffinity(loic, 3).addAffinity(alexandra, 3)
    elisabeth.addAffinity(angelique, 3).addAffinity(jeanine, 6).addAffinity(christine, 5).addAffinity(bernard, 5).addAffinity(monique, 7)
    elisabeth.addAffinity(michel, 6).addAffinity(thomas, 10).addAffinity(edouard, 0)

    // mado
    mado.addAffinity(pierre, 10).addAffinity(therese, 10)
    mado.addAffinity(laurent, 10).addAffinity(aurelie, 4).addAffinity(antoineR, 2).addAffinity(edouardR, 2).addAffinity(stephanie, 7)
    mado.addAffinity(stephane, 0).addAffinity(loic, 2).addAffinity(alexandra, 2)
    mado.addAffinity(angelique, 2).addAffinity(jeanine, 4).addAffinity(christine, 6).addAffinity(bernard, 6).addAffinity(monique, 9)
    mado.addAffinity(michel, 8).addAffinity(thomas, 10).addAffinity(edouard, 0)

    // pierre
    pierre.addAffinity(therese, 8)
    pierre.addAffinity(laurent, 9).addAffinity(aurelie, 3).addAffinity(antoineR, 2).addAffinity(edouardR, 2).addAffinity(stephanie, 6)
    pierre.addAffinity(stephane, 2).addAffinity(loic, 2).addAffinity(alexandra, 2)
    pierre.addAffinity(angelique, 2).addAffinity(jeanine, 5).addAffinity(christine, 6).addAffinity(bernard, 6).addAffinity(monique, 9)
    pierre.addAffinity(michel, 8).addAffinity(thomas, 10).addAffinity(edouard, 0)

    // therese
    therese.addAffinity(laurent, 8).addAffinity(aurelie, 3).addAffinity(antoineR, 2).addAffinity(edouardR, 2).addAffinity(stephanie, 6)
    therese.addAffinity(stephane, 2).addAffinity(loic, 2).addAffinity(alexandra, 2)
    therese.addAffinity(angelique, 2).addAffinity(jeanine, 6).addAffinity(christine, 6).addAffinity(bernard, 6).addAffinity(monique, 6)
    therese.addAffinity(michel, 6).addAffinity(thomas, 8).addAffinity(edouard, 0)

    // laurent
    laurent.addAffinity(aurelie, 10).addAffinity(antoineR, 2).addAffinity(edouardR, 2).addAffinity(stephanie, 3)
    laurent.addAffinity(stephane, 2).addAffinity(loic, 7).addAffinity(alexandra, 7)
    laurent.addAffinity(angelique, 5).addAffinity(jeanine, 4).addAffinity(christine, 7).addAffinity(bernard, 7).addAffinity(monique, 5)
    laurent.addAffinity(michel, 5).addAffinity(thomas, 8).addAffinity(edouard, 0)

    // aurelie
    aurelie.addAffinity(antoineR, 2).addAffinity(edouardR, 2).addAffinity(stephanie, 0)
    aurelie.addAffinity(stephane, 0).addAffinity(loic, 7).addAffinity(alexandra, 7)
    aurelie.addAffinity(angelique, 5).addAffinity(jeanine, 4).addAffinity(christine, 7).addAffinity(bernard, 7).addAffinity(monique, 5)
    aurelie.addAffinity(michel, 5).addAffinity(thomas, 4).addAffinity(edouard, 0)

    // antoineR
    antoineR.addAffinity(edouardR, 10).addAffinity(stephanie, 10)
    antoineR.addAffinity(stephane, 10).addAffinity(loic, 0).addAffinity(alexandra, 0)
    antoineR.addAffinity(angelique, 0).addAffinity(jeanine, 0).addAffinity(christine, 0).addAffinity(bernard, 0).addAffinity(monique, 0)
    antoineR.addAffinity(michel, 0).addAffinity(thomas, 0).addAffinity(edouard, 0)

    // edouardR
    edouardR.addAffinity(stephanie, 10)
    edouardR.addAffinity(stephane, 10).addAffinity(loic, 0).addAffinity(alexandra, 0)
    edouardR.addAffinity(angelique, 0).addAffinity(jeanine, 0).addAffinity(christine, 0).addAffinity(bernard, 0).addAffinity(monique, 0)
    edouardR.addAffinity(michel, 0).addAffinity(thomas, 0).addAffinity(edouard, 0)

    // stephanie
    stephanie.addAffinity(stephane, 10).addAffinity(loic, 8).addAffinity(alexandra, 8)
    stephanie.addAffinity(angelique, 3).addAffinity(jeanine, 2).addAffinity(christine, 2).addAffinity(bernard, 2).addAffinity(monique, 2)
    stephanie.addAffinity(michel, 2).addAffinity(thomas, 8).addAffinity(edouard, 0)

    // stephane
    stephane.addAffinity(loic, 8).addAffinity(alexandra, 8)
    stephane.addAffinity(angelique, 3).addAffinity(jeanine, 2).addAffinity(christine, 2).addAffinity(bernard, 2).addAffinity(monique, 2)
    stephane.addAffinity(michel, 2).addAffinity(thomas, 5).addAffinity(edouard, 0)

    // loic
    loic.addAffinity(alexandra, 10)
    loic.addAffinity(angelique, 6).addAffinity(jeanine, 5).addAffinity(christine, 6).addAffinity(bernard, 7).addAffinity(monique, 5)
    loic.addAffinity(michel, 5).addAffinity(thomas, 6).addAffinity(edouard, 0)

    // alexandra
    alexandra.addAffinity(angelique, 9).addAffinity(jeanine, 8).addAffinity(christine, 8).addAffinity(bernard, 8).addAffinity(monique, 6)
    alexandra.addAffinity(michel, 7).addAffinity(thomas, 7).addAffinity(edouard, 0)

    // angelique
    angelique.addAffinity(jeanine, 8).addAffinity(christine, 8).addAffinity(bernard, 8).addAffinity(monique, 4)
    angelique.addAffinity(michel, 4).addAffinity(thomas, 3).addAffinity(edouard, 0)

    // angelique
    jeanine.addAffinity(christine, 9).addAffinity(bernard, 9).addAffinity(monique, 9)
    jeanine.addAffinity(michel, 7).addAffinity(thomas, 3).addAffinity(edouard, 0)

    // christine
    christine.addAffinity(bernard, 10).addAffinity(monique, 8)
    christine.addAffinity(michel, 10).addAffinity(thomas, 6).addAffinity(edouard, 0)

    // bernard
    bernard.addAffinity(monique, 7)
    bernard.addAffinity(michel, 10).addAffinity(thomas, 6).addAffinity(edouard, 0)

    // monique
    monique.addAffinity(michel, 10).addAffinity(thomas, 6).addAffinity(edouard, 0)

    // michel
    michel.addAffinity(thomas, 6).addAffinity(edouard, 0)

    // thomas
    thomas.addAffinity(edouard, 0)

//    guestlist = guestlist.::(alexis).::(sophie).::(hugo).::(quentin).::(virginie).::(gregory).::(julien).::(amelie); // 7
//    guestlist = guestlist.::(claire).::(jb).::(martine).::(elisabeth).::(mado).::(pierre).::(therese).::(laurent); // 15
//    guestlist = guestlist.::(aurelie).::(antoineR).::(edouardR).::(stephane).::(stephanie).::(loic).::(alexandra); // 22
//    guestlist = guestlist.::(angelique).::(jeanine).::(christine).::(bernard).::(monique).::(michel).::(thomas).::(edouard); // 30

    guestlist = guestlist.:+(alexis).:+(sophie).:+(hugo).:+(quentin).:+(virginie).:+(gregory).:+(julien).:+(amelie); // 7
    guestlist = guestlist.:+(claire).:+(jb).:+(martine).:+(elisabeth).:+(mado).:+(pierre).:+(therese).:+(laurent); // 15
    //guestlist = guestlist.:+(aurelie).:+(antoineR).:+(edouardR).:+(stephane).:+(stephanie).:+(loic).:+(alexandra); // 22
    //guestlist = guestlist.:+(angelique).:+(jeanine).:+(christine).:+(bernard).:+(monique).:+(michel).:+(thomas).:+(edouard); // 30
  }
}