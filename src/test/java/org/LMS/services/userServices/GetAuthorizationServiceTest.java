package org.LMS.services.userServices;

import org.LMS.models.user.AuthorizationCredentials;
import org.LMS.models.user.User;
import org.LMS.services.userServices.GetAuthorizationService;
import org.LMS.utils.RepositoryUtilActions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetAuthorizationServiceTest {

   @BeforeEach
   void AddUsers(){
      RepositoryUtilActions.addUserToRepository();
      // add following users:
      // "alejandro","alejoyodax@gmail.com"
      // "fulanito","fulanito@gmail.com"
      // "cosme","cosme@gmail.com"
   }

   @Test
   void EmailUserNotExistCase() {
      AuthorizationCredentials authData = new AuthorizationCredentials("caracortada@gmail.com","12345");
      User user = new GetAuthorizationService().execute(authData);
      assertNull(user);
   }

   @Test
   void PasswordIncorrectCase() {
      AuthorizationCredentials authData = new AuthorizationCredentials("alejoyodax@gmail.com","INCORRECT PASSWORD");
      User user = new GetAuthorizationService().execute(authData);
      assertNull(user);
   }

   @Test
   void UserAuthorizedCase(){
      AuthorizationCredentials authData = new AuthorizationCredentials("fulanito@gmail.com","12345");
      User user = new GetAuthorizationService().execute(authData);
      assertEquals(authData.getEmail(), user.getEmail());
   }


}