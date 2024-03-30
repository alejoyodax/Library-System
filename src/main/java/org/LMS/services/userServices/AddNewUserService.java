package org.LMS.services.userServices;

import org.LMS.interfaces.useCases.IUseCaseParams;
import org.LMS.models.user.User;
import org.LMS.repositories.UserRepository;

import java.util.Objects;

public class AddNewUserService implements IUseCaseParams {
   UserRepository userRepository = UserRepository.getInstance();

   public User execute(Object object) {
      User user = (User) object;
      User userInRepository = userRepository.get(user.getEmail());

      if(Objects.nonNull(userInRepository)) {
         System.out.println("(AddNewUserService) --> User email '" + user.getEmail() + "' is already registered");
         return null;
      };

      System.out.println("(AddNewUserService) --> User '" + user.getEmail() + "' was successfully registered");
      return userRepository.add(user);
   }

}
