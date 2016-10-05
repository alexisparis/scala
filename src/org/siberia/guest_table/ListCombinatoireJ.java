package org.siberia.guest_table;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: alexis
 * Date: 28/09/11
 * Time: 00:24
 * To change this template use File | Settings | File Templates.
 */
public class ListCombinatoireJ
{
    public static void main(String[] args)
    {
        long time = System.currentTimeMillis();

        Integer[] tab = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        //Integer[] tab = new Integer[]{1, 2, 3};

        traversePermutations(tab, 0, tab.length, new ArrayVisitor()
        {
            @Override
            public void visit(Integer[] tab)
            {
//                for(int i = 0; i < tab.length; i++)
//                {
//                    System.out.print(tab[i] + " ");
//                }
//                    System.out.println("");

            }
        });

        System.out.println("temps d'execution : " + ((System.currentTimeMillis() - time) / 1000) + " secondes");
    }

    private interface ArrayVisitor
    {
        public void visit(Integer[] tab);
    }

    public static void traversePermutations(Integer[] tab, int start, int n, ArrayVisitor visitor)
  {
    if ( start == n - 1 )
    {
      if ( visitor != null )
      {
          visitor.visit(tab);
      }
    }
    else
    {
      int i = start;

      while( i < n )
      {
        Integer tmp = tab[i];

        tab[i] = tab[start];
        tab[start] = tmp;

        traversePermutations(tab, start + 1, n, visitor);

        tab[start] = tab[i];
        tab[i] = tmp;

        i = i + 1;
      }
    }
  }
}
