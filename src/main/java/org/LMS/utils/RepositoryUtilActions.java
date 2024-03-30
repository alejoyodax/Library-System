package org.LMS.utils;

import org.LMS.interfaces.UserRole;
import org.LMS.models.readingEntities.Book;
import org.LMS.models.readingEntities.Novel;
import org.LMS.models.user.User;
import org.LMS.repositories.LibraryRepository;
import org.LMS.repositories.UserRepository;

public class RepositoryUtilActions {

   public static void addUsers() {
      User user1 = new User.Builder()
            .setName("John Doe")
            .setEmail("jhondoe@gmail.com")
            .setPassword("12345")
            .setRole(UserRole.ADMIN)
            .build();

      User user2 = new User.Builder()
            .setName("cosme fulanito")
            .setEmail("fulanito@gmail.com")
            .setPassword("12345")
            .setRole(UserRole.ASSISTANT)
            .build();

      User user3 = new User.Builder()
            .setName("alejandro")
            .setEmail("alejoyodax@gmail.com")
            .setPassword("12345")
            .setRole(UserRole.READER)
            .build();


   }

   public static void addBooksAndNovels() {
      // Add 3 books and 4 novels
      LibraryRepository lb = LibraryRepository.getInstance();
      // add some books
      lb.add(new Book("black holes", "kumi karaki", 1984, "science", 10));
      lb.add(new Book("advanced calculus", "cosme mathematics", 2004, "mathematics", 10));
      lb.add(new Book("general history", "hachi miyoki", 2015, "mathematics", 10));

      // add some novels
      lb.add(new Novel("the lord of the rings", "j.r.r. tolkien", 1954, "fantasy", 11, 10));
      lb.add(new Novel("the hobbit", "j.r.r. tolkien", 1937, "fantasy", 11, 10));
      lb.add(new Novel("the silmarillion", "j.r.r. tolkien", 1977, "fantasy", 11, 10));
      lb.add(new Novel("the rose","luisa maria", 2010, "romance", 12, 10));
   }

   public static void addUserToRepository(){
      UserRepository ur = UserRepository.getInstance();

      ur.add(new User("alejandro","alejoyodax@gmail.com","12345", UserRole.READER));
      ur.add(new User("fulanito","fulanito@gmail.com","12345", UserRole.ASSISTANT));
      ur.add(new User("cosme","cosme@gmail.com","12345", UserRole.ADMIN));
   }
}
