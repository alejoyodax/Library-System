package org.LMS.repositories;

import org.LMS.models.readingEntities.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryRepositoryTest {
   // here we will test the singleton pattern of the LibraryRepository
   // creating instances of the LibraryRepository and playing with them

   @BeforeEach
   void clearRepository(){
      LibraryRepository.getInstance().clear(); // i know this is not the best way to do it, but it's just for testing
   }

   @Test
   void getInstanceReturnAnInstanceOfRepository() {
      // create 2 instances and compare them
      LibraryRepository lb1 = LibraryRepository.getInstance();
      assertInstanceOf(LibraryRepository.class, lb1);
   }

   @Test
   void haveTheSameSizeDifferentInstances(){
      // create 2 instances and compare them
      LibraryRepository lb1 = LibraryRepository.getInstance();
      LibraryRepository lb2 = LibraryRepository.getInstance();

      lb1.add(new Book());
      System.out.println("ADDED A BOOK TO INSTANCE 1");
      System.out.println("Instance 1 size: " + lb1.getSize());
      System.out.println("Instance 2 size: " + lb2.getSize());
      assertEquals(lb1.getSize(), lb2.getSize());

      // verify that the size is now 2
      lb2.add(new Book());
      System.out.println("ADDED A BOOK TO INSTANCE 2");
      System.out.println("Instance 1 size: " + lb1.getSize());
      System.out.println("Instance 2 size: " + lb2.getSize());
      assertEquals(lb1.getSize(), lb2.getSize());
   }

   @Test
   void lastItemAddedIsTheSameInDifferentInstances(){
      Book book = new Book("proof book", "jon doe", 1954, "Fantasy", 10);
      LibraryRepository lb1 = LibraryRepository.getInstance();
      lb1.add(book);
      // compare the last item added in the two instances
      LibraryRepository lb2 = LibraryRepository.getInstance();
      Book bookInstance1 = (Book) lb1.get(book.getId());
      Book bookInstance2 = (Book) lb2.get(book.getId());
      assertEquals(bookInstance1.getId(), bookInstance2.getId());

      System.out.println("Item in instance 1");
      System.out.println(bookInstance1);
      System.out.println("Same Item in instance 2");
      System.out.println(bookInstance2);

   }
}