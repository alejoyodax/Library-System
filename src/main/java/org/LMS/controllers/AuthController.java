package org.LMS.controllers;

import org.LMS.models.user.AuthorizationCredentials;
import org.LMS.models.user.User;
import org.LMS.services.userServices.GetAuthorizationService;

public class AuthController {
   private static User currentUser;

   public static User login(AuthorizationCredentials credentials) {
      currentUser = new GetAuthorizationService().execute(credentials);
      return currentUser;
   }

   public static User getCurrentUser() {
      return currentUser;
   };

   public static Object logout() {
      currentUser = null;
      return currentUser;
   }


}
