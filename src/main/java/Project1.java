//Ashley Barton
//October 10th, 2013
//Project 1

import java.util.*;
import java.io.*;

public class Project1
{
   public static void main( String [] args)
   {
      String input = "2 1 5 4 3\n";

//      Scanner kb = new Scanner(System.in);
      Scanner kb = new Scanner(input);

      int targetElement = 2;
      boolean quit = false;
      String treeSequence = "";
      String currentCommand = "";
      String menu = "I Insert \n" +
                    "D Delete a value \n" +
                    "P Find Predecessor \n" +
                    "S Find Successor \n" +
                    "E Exit the program \n" +
                    "H Display the message\n";

      System.out.println("Please enter the initial sequence of values: ");
      treeSequence = kb.nextLine();

      String[] tokens = treeSequence.split("\\s+");

      BTNode<Integer> myTree = new BTNode<Integer>(Integer.parseInt(tokens[0]));

      for(int i = 1; i < tokens.length; i++)
      {
         Integer v = Integer.parseInt(tokens[i]);
         myTree.insert(v);
      }

      System.out.println("Here is the sequence of values: " + treeSequence);

      System.out.println("In pre-order: >" + myTree.preOrderTrav() + "<");
      System.out.println("In order: >" + myTree.inOrderTrav() + "<");
      System.out.println("In post-order: >" + myTree.postOrderTrav() + "<");
/*
//      System.out.println("Here is the sequence of values: " + treeSequence);

      while(!quit)
      {
         System.out.print("Command? ");

         currentCommand = kb.next();

         if(currentCommand.equalsIgnoreCase("e"))
         {
            System.out.println("Thank you for using this tree program!");
            quit = true;
         }
         else if(currentCommand.equalsIgnoreCase("h"))
               System.out.println(menu);

         else if(currentCommand.equalsIgnoreCase("i")) //Inserts Value
         {
            targetElement = kb.nextInt();
         }
         else if(currentCommand.equalsIgnoreCase("d")) //Deletes Value
         {
         }
         else if(currentCommand.equalsIgnoreCase("p")) //Predecessor
         {
         }
         else if(currentCommand.equalsIgnoreCase("s")) //Successor
         {
         }
         else
            System.out.println("Please enter valid input.\n" + menu);
      }
*/
      }
}
// vim: set expandtab sts=3 ts=3 sw=3:
