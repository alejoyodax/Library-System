package org.LMS.services.libraryServices;

import org.LMS.interfaces.ReadingEntityType;
import org.LMS.models.readingEntities.Book;
import org.LMS.models.readingEntities.GenericBook;
import org.LMS.models.readingEntities.Novel;
import org.LMS.repositories.LibraryRepository;
import org.LMS.utils.RepositoryUtilActions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetAllEntitiesByTypeServiceTest {

   @BeforeAll
   static void AddReadingEntities(){
      RepositoryUtilActions.addBooksAndNovels();
   }

   @Test
   void getAllBooksCase() {
   LibraryRepository lb = LibraryRepository.getInstance();

      GetAllEntitiesByTypeService getEntitiesByType = new GetAllEntitiesByTypeService();
      List<GenericBook> listBooks = getEntitiesByType.execute(ReadingEntityType.BOOK);

      // check items are books
      for (GenericBook book : listBooks) {
         assertInstanceOf(Book.class, book);
         System.out.println(book.toString());
      }



   }

   @Test
   void getAllNovelCase(){
      LibraryRepository lb = LibraryRepository.getInstance();

      GetAllEntitiesByTypeService getEntitiesByType = new GetAllEntitiesByTypeService();
      List<GenericBook> listNovels = getEntitiesByType.execute(ReadingEntityType.NOVEL);

      // check items are books
      for (GenericBook novel : listNovels) {
         assertInstanceOf(Novel.class, novel);
         System.out.println(novel.toString());
      }

   }

   @Test
   void getAllGenericBooksCase(){
      LibraryRepository lb = LibraryRepository.getInstance();

      List<GenericBook> genericBookList = lb.getAllAsList();

      for(GenericBook genericBook: genericBookList){
         assertInstanceOf(GenericBook.class, genericBook);
         System.out.println(genericBook.toString());
      }
   }
}