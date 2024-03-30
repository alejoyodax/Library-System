package org.LMS.services.userServices;

import org.LMS.models.user.User;
import org.LMS.utils.RepositoryUtilActions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddNewUserServiceTest {

   @BeforeEach
   void AddUsers() {
      RepositoryUtilActions.addUserToRepository();
      // add following users:
      // "alejandro","alejoyodax@gmail.com"
      // "fulanito","fulanito@gmail.com"
      // "cosme","cosme@gmail.com"
   }

   @Test
   void AddExistingUser() {
      User userToAdd = new User.Builder().setEmail("alejoyodax@gmail.com").build(); // user already exists
      User user = new AddNewUserService().execute(userToAdd);
      assertNull(user);
   }

   @Test
   void AddNewUser() {
      User userToAdd = new User.Builder().setEmail("melontusk@gmail.com").build(); // user already exists
      User user = new AddNewUserService().execute(userToAdd);
      assertEquals(userToAdd.getEmail(), user.getEmail());
   }

}