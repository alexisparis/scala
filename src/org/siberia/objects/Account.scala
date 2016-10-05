package org.siberia.objects

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing.Validation

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 13/09/11
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */

class Account(val balance: Int, val surname : String, val forename : String)
{
  def isGood() =
  {
    balance >= 0
  }
}

object Account
{
  def apply(balance : Int, surname : String, forename : String) =
  {
    new Account(balance, surname, forename)
  }
}
