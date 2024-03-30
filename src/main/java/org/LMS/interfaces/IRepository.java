package org.LMS.interfaces;

import java.util.LinkedHashMap;
import java.util.List;
/**
 * Due to the particular necessity of the project, the IRepository interface was created to be
 * implemented by the repositories classes. It contains the basic CRUD operations that are needed.
 * **/
public interface IRepository<T> {
   public static Object getInstance()  // Singleton pattern
   {
      return null;
   }

   public T add(T object);
      public T remove(T object);
      public T update(T object);
      public List<T> getAllAsList();
      public Integer getSize();

      public void PrintItems();
}
