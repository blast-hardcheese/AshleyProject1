//Ashley Barton
//October 11th, 2013
//Project 1 - BTNode class

import java.util.*;


public class BTNode<E extends Integer> {
   private E data;
   private BTNode<E> left;
   private BTNode<E> right;
   private BTNode<E> parent;
   private Boolean isLeft = false;

   public BTNode()
   {
   }

   public BTNode(E initialData)
   {
      setData(initialData);
   }

   public BTNode(E initialData, BTNode<E> initialLeft, BTNode<E> initialRight)
   {
      this.data = initialData;
      this.left = initialLeft;
      this.right = initialRight;
   }

   public BTNode(E initialData, BTNode<E> initialParent)
   {
      setData(initialData);
      setParent(initialParent);
   }

   public void setIsLeft(Boolean isLeft)
   {
      this.isLeft = isLeft;
   }

   public void setIsRight(Boolean isRight)
   {
      this.isLeft = ! isRight;
   }

   public Boolean isLeft()
   {
      return this.isLeft;
   }

   public Boolean isRight()
   {
      return ! this.isLeft;
   }

   public E getData()
   {
      return this.data;
   }

   public BTNode<E> getLeft()
   {
      return this.left;
   }

   public BTNode<E> getRight()
   {
      return this.right;
   }

   public void setParent(BTNode<E> newParent)
   {
      this.parent = newParent;
   }

   public BTNode<E> getParent()
   {
      return this.parent;
   }

   public void setData(E newData)
   {
      this.data = newData;
   }

   public void setLeft(BTNode<E> newLeft)
   {
      this.left = newLeft;
   }

   public void setRight(BTNode<E> newRight)
   {
      this.right= newRight;
   }

   public Boolean hasLeft()
   {
      return this.left != null;
   }

   public Boolean hasRight()
   {
      return this.right != null;
   }

   public BTNode<E> popRightmost()
   {
      BTNode<E> r = null;
      if(this.hasRight() && this.right.hasRight()) {
         r = this.right.popRightmost();
      }
      else if(this.hasRight() && ! this.right.hasRight())
      {
         r = this.right;      // This is the node we're returning
         this.right = r.left; // Get the left value (null is OK) and set it as our right (maintain the tree)

         // Null out the return's properties
         r.left = null;
         r.right = null;
         r.parent = null;
      }

      return r;
   }

/*
   public void remove(E removeValue, BTNode <E> node)
   {
      if(node == null)
      {
         System.out.println(removeValue + "does not exist");
      }
      else if(removeValue < node.getData())
      {
         this.left.remove(removeValue, left.node);
      }
      else if(removeValue > node.getData())
      {
         right.remove(removeValue, right.node);
      }
      else(removeValue == node.getData()
      {
         //remove node
         //find the largest of the smallest node
         //replace that value with the current node and set it equal to null
      }

   }
*/

   public void insert(E insertValue)
   {
      if(getData() == null)
      {
         setData(insertValue);
      }
      else if(insertValue < getData())
      {
         if(this.left == null) {
            this.left = new BTNode<E>();
         }
         this.left.insert(insertValue);
      }
      else if(insertValue > getData())
      {
         if(this.right == null) {
            this.right = new BTNode<E>();
         }
         this.right.insert(insertValue);
      }
      else if(insertValue == getData())
      {
         System.out.println(insertValue + " already exists, ignore.");
      }
   }


   public String inOrderTrav()
   {
      String r = "";

      if(this.left !=null)
      {
         r = r + " " + this.left.inOrderTrav();
      }

      if(getData() != null)
      {
         r = r + " " + getData();
      }

      if(this.right != null)
      {
         r = r + " " + this.right.inOrderTrav();
      }

      return r.trim();
   }

   public String preOrderTrav()
   {
      String r = "";

      if(getData() != null)
      {
         r = r + " " + getData();
      }

      if(this.left !=null)
      {
         r = r + " " + this.left.preOrderTrav();
      }

      if(this.right != null)
      {
         r = r + " " + this.right.preOrderTrav();
      }

      return r.trim();
   }

   public String postOrderTrav()
   {
      String r = "";

      if(this.left != null)
      {
         r = r + " " + this.left.postOrderTrav();
      }

      if(this.right != null)
      {
         r = r + " " + this.right.postOrderTrav();
      }

      if(getData() != null)
      {
         r = r + " " + getData();
      }

      return r.trim();
   }

/*
   public BTNode<E> predecessor(BTNode<E> source)
   {

   }
*/

/*
   public BTNode<E> successor(BTNode <E> source)
   {
      if(source.getData() == data)

      if(left !=null)
      {
         left.inOrderTrav();
      }
      if(right != null)
      {
         right.inOrderTrav();
      }
    }
*/
}
// vim: set expandtab sts=3 ts=3 sw=3:
