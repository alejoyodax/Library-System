package org.LMS.models.user;

/**
 * This class is used to store the authorization credentials of the user.
 * email and password
 */

public class AuthorizationCredentials {
   private final String email;
   private final String password;

   public AuthorizationCredentials(String email, String password) {
      this.email = email;
      this.password = password;
   }

   public String getEmail() {
      return this.email;
   }

   public String getPassword() {
      return this.password;
   }
}
