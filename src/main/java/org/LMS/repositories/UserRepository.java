package org.LMS.repositories;

import org.LMS.interfaces.IRepository;
import org.LMS.interfaces.UserRole;
import org.LMS.models.user.User;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserRepository implements IRepository<User> {
   // Singleton pattern
   private final static Map<String, User> userRepo = new LinkedHashMap<String, User>();

   private UserRepository(){}

   public static UserRepository getInstance(){
      if(userRepo.isEmpty()) {
         // add some books
         //System.out.println("** THE LIBRARY IS EMPTY, PLEASE ADD SOME USERS** (LibraryRepository)");
      }
      return new UserRepository();
   }

   @Override
   public User add(User user) {
      userRepo.put(user.getEmail(), user);
      return userRepo.get(user.getEmail());
   }

   @Override
   public User remove(User user) {
      return userRepo.remove(user.getId());
   }

   @Override
   public User update(User user) {
      return userRepo.put(user.getEmail(), user);
   }

   public User get(String userEmail) {
      return userRepo.get(userEmail);
   }

   @Override
   public List<User> getAllAsList() {
      return new ArrayList<>(userRepo.values());
   }

   public Map<String, User> getAllAsMap(){ return userRepo;}

   @Override
   public Integer getSize() {
      return userRepo.size();
   }

   @Override
   public void PrintItems() {
      userRepo.forEach((k, v) -> {
         System.out.println(v.toString());
      });
   }

   public void clear() {
      userRepo.clear();
   }

}
