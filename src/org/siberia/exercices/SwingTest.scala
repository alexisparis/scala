package org.siberia.exercices

import javax.swing.{JLabel, JPanel, JFrame, SwingUtilities}

/**
 * Created by IntelliJ IDEA.
 * User: paria
 * Date: 23/08/11
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */

object SwingTest
{
  def main(args : Array[String])
  {
    SwingUtilities invokeAndWait new Runnable()
    {
      println ((1 to 5).map( _*2 ))
      println ((1 to 5).reduceLeft( _+_ ))

      def run() =
      {
        val frame = new JFrame()
        frame setDefaultCloseOperation JFrame.EXIT_ON_CLOSE
        val panel = new JPanel()
        frame setContentPane panel
        panel add  new JLabel("toto")
        frame setSize (500, 500)
        frame setVisible true
      }
    }
  }
}