package org.siberia.generalities

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 05/09/11
 * Time: 08:43
 * To change this template use File | Settings | File Templates.
 */

object BankAccountTest {

  def main(args : Array[String])
  {
    var account1 = new BankAccount();

    var i = 1;
    println((i = i + 1) + " : " + account1.getBalance())
    account1 deposit 100
    println((i = i + 1) + " : " + account1.getBalance())
    account1 setBalance 67
    println((i = i + 1) + " : " + account1.getBalance())
  }

  class BankAccount {
    private var balance = 0

    def deposit(amount: Int) {
      if (amount > 0) balance += amount
    }

    def withdraw(amount: Int): Int =
      if (0 < amount && amount <= balance) {
        balance -= amount
        balance
      } else error("insufficient funds")

    def getBalance() : Int =
    {
      balance
    }

    def setBalance(a : Int) =
    {
      balance = a;
    }

    override def toString() : String =
    {
      return "bank account : " + balance
    }
  }

}