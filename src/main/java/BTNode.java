//Ashley Barton
//October 11th, 2013
//Project 1 - BTNode class

import java.util.*;


public class BTNode<E extends Integer> {
   private E data;
   private BTNode<E> left;
   private BTNode<E> right;

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

   private BTNode<E> extractMaxNode()
   {
      if(right == null) {
         return this;
      } else {
         BTNode<E> node = this.right.extractMaxNode();
         if(node == right) {
            this.right = node.left;
         }
         return node;
      }
   }

   public BTNode<E> remove(E value)
   {
      if(value == this.data) {
         if(hasLeft() && hasRight()) {
            BTNode<E> node = left.extractMaxNode();
            node.right = right;
            node.left = left;
            return node;
         } else if(hasRight()) {
            return right;
         } else if(hasLeft()) {
            return left;
         } else {
            return null;
         }

      } else if(value > data && hasRight()) {
         right = right.remove(value);
      } else if(value < data && hasLeft()) {
         left = left.remove(value);
      }
      return this;
   }

   private BTNode<E> walkMin() {
      if(hasLeft()) return left.walkMin();
      else return this;
   }

   private BTNode<E> walkMax() {
      if(hasRight()) return right.walkMax();
      else return this;
   }

   public BTNode<E> predecessor(E value) {
      if(value < data && hasLeft()) {
         return left.predecessor(value);
      } else if(value > data && hasRight()) {
         return right.predecessor(value);
      } else if(value == data && hasLeft()) {
         return this.left.walkMax();
      }

      return null;
   }

   public BTNode<E> successor(E value) {
      if(value < data && hasLeft()) {
         return left.successor(value);
      } else if(value > data && hasRight()) {
         return right.successor(value);
      } else if(value == data && hasRight()) {
         return this.right.walkMin();
      }

      return null;
   }
}
// vim: set expandtab sts=3 ts=3 sw=3:
