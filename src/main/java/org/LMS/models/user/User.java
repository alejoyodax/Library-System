package org.LMS.models.user;

import org.LMS.interfaces.UserRole;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
   public static AtomicInteger NEXT_ID = new AtomicInteger(1); // This belongs to the User class not the instances
   private Integer id;
   private String name;
   private String email;
   private String password;
   private UserRole role;

   public User(String name, String email, String password, UserRole role) {
      this.id = NEXT_ID.getAndIncrement();
      this.name = name;
      this.email = email;
      this.password = password;
      this.role = role;
   }

   public User(Builder builder) {
      this.id = NEXT_ID.getAndIncrement();
      this.name = builder.name;
      this.email = builder.email;
      this.password = builder.password;
      this.role = builder.role;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public UserRole getRole() {
      return role;
   }

   public void setRole(UserRole role) {
      this.role = role;
   }

   @Override
   public String toString() {
      return "USER | " + this.id + " | " + this.role + " | " + this.name + " | " + this.email;
   }
   public static class Builder {
      private String name;
      private String email;
      private String password;
      private UserRole role;

      public Builder setName(String name) {
         this.name = name;
         return this;
      }

      public Builder setEmail(String email) {
         this.email = email;
         return this;
      }

      public Builder setPassword(String password) {
         this.password = password;
         return this;
      }

      public Builder setRole(UserRole role) {
         this.role = role;
         return this;
      }

      public User build() {
         return new User(this);
      }
   }

}
