package org.LMS.repositories;

import org.LMS.interfaces.IRepository;
import org.LMS.interfaces.ReadingEntityType;
import org.LMS.models.readingEntities.GenericBook;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LibraryRepository implements IRepository<GenericBook> {
   private final static Map<Integer, GenericBook> libraryRepo = new LinkedHashMap<Integer, GenericBook>();

   private LibraryRepository(){}

   public static LibraryRepository getInstance() {
      if(libraryRepo.isEmpty()) {
         // add some books
         //System.out.println("** THE LIBRARY IS EMPTY, PLEASE ADD SOME ** (LibraryRepository)");
      }
      return new LibraryRepository();
   }

   @Override
   public  GenericBook add(GenericBook object) {
      libraryRepo.put(object.getId(), object);
      return libraryRepo.get(object.getId()); // to be sure that the object is added
   }

   @Override
   public GenericBook remove(GenericBook object) {
      return libraryRepo.remove(object.getId());
   }

   @Override
   public GenericBook update(GenericBook object) {
      libraryRepo.put(object.getId(), object);
      return libraryRepo.get(object.getId()); // to be sure that the object is updated
   }

   public GenericBook get(int id) {
      return libraryRepo.get(id);
   }

   @Override
   public List<GenericBook> getAllAsList() {
      return new ArrayList<>(libraryRepo.values()); // to return a copy of the values
   }

   public List<GenericBook> getAllAsListByType(ReadingEntityType type) {
      List<GenericBook> books = new ArrayList<>();
      libraryRepo.forEach((k, v) -> {
         if(v.getReadingEntityType().equals(type)) {
            books.add(v);
         }
      });
      return books;
   }

   @Override
   public Integer getSize() {
      return libraryRepo.size();
   }

   @Override
   public void PrintItems() {
      libraryRepo.forEach((k, v) -> {
         System.out.println(v.toString());
      });
   }

   public void clear() {
      libraryRepo.clear();
   }

}

