import java.util.*;
import java.io.File;
import java.io.IOException;




public class mantoothv06
{
   public static void main(String[]args)
   {
   
   }
}

class MantoothNode <E>
{
   private E thing;
   private MantoothNode<E> next;
   private MantoothNode<E> prev;
   public MantoothNode(E e)
   {
   thing = e;
   }
   public void setPrev(MantoothNode<E> p)
   {
   prev = p;
   }
   public void setNext(MantoothNode<E> n)
   {
   next = n;
   }
   public  MantoothNode getPrev()
   {
      return prev;
   }
   public  MantoothNode getNext()
   {
      return next;
   }
   public E getThing()
   {
      return thing;
   }
   public void setThing(E thingy)
   {
      thing = thingy;
   }
}

class MantoothLinkedList <E>
{
   MantoothNode<E> Head;
   MantoothNode<E> Tail;
   int length = 0;
   
   public String toString()
   {
      String temp = "";
      MantoothNode<E> thing = Head;
      if(length == 1)
      {
      temp += thing.getThing();
      }
      if(Head != null)
      {
      
      MantoothNode<E> next = Head.getNext();
      while(next != null)
      {
         temp += thing.getThing()+" ";
         thing = next;
         next = thing.getNext();
      }
      if(Tail !=null)
         temp += Tail.getThing();
      }
      return temp;
   }
   
   public boolean isEmpty()
   {
   if(Head.getNext() ==  null && Head.getThing() == null)
      return true;
   return false;
   }
   
   public void addHead(E thing)
   {
   if(length == 0)
   {
   Head = new MantoothNode<E>(thing);
   Tail = Head;
   }
   else
   {
   MantoothNode<E> temp = Head;
   Head = new MantoothNode<E>(thing);
   Head.setNext(temp);
   if(temp !=null)
      temp.setPrev(Head);
   }
   length ++;
   }
   
   public void addTail(E thing)
   {
   length ++;
   if(length == 1)
   {
   Head = new MantoothNode<E>(thing);
   Tail = Head;
   Tail.setPrev(Head);
   Head.setNext(Tail);
   }
   if(length>1)
   {MantoothNode<E> temp = Tail;
   Tail = new MantoothNode<E>(thing);
   Tail.setPrev(temp);
   if(temp !=null)
      temp.setNext(Tail);}
   }
   
   public void removeTail()
   {
   length --;
   MantoothNode<E> temp = Tail;
   Tail = temp.getPrev();
   temp.setPrev(null);
   if(Tail != null)
      Tail.setNext(null);
   }
   
   public void removeHead()
   {
   length --;
   MantoothNode<E> temp = Head;
   Head = temp.getNext();
   temp.setNext(null);
   if(Head != null)
      Head.setPrev(null);
   }
   
   public void add(int index, E thing)
   {
   if(index == 0)
     addHead(thing);
     
   else
   if(index == length-1)
      addTail(thing);
   else
   {
      MantoothNode<E> next = Head;
      for(int i = 0; i<index; i++)
      {
      if(next != null)
      {
      next = next.getNext();
      }
      }
      MantoothNode<E> thing2 = new MantoothNode<E>(thing);
      if(next !=null)
         thing2.setPrev(next.getPrev());
      thing2.setNext(next);
      if(next !=null)
         next.getPrev().setNext(thing2);
      if(next != null)
         next.setPrev(thing2);
   }
   length++;
   }
   
   public void remove(int index)
   {
      if(index == 0)
         removeHead();
      else
      if(index == length-1)
         removeTail();
      else
       {
       MantoothNode<E> next = Head;
       for(int i=0; i<index; i++)
       {
         next = next.getNext();
       }
       MantoothNode<E> prev = next.getPrev();
       prev.setNext(next.getNext());
       next.getNext().setPrev(prev);
       next.setNext(null);
       next.setPrev(null);
       }
       
   }
   
   public void set(int index, E thing)
   {
      MantoothNode<E> current = Head;
      for(int i = 0; i<index; i++)
      {
      current = current.getNext();
      }
      if(current !=null)
         current.setThing(thing);
   } 
}