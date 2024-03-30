package org.LMS.services.userServices;

import org.LMS.interfaces.useCases.IGetUserAuthorizationService;
import org.LMS.models.user.AuthorizationCredentials;
import org.LMS.models.user.User;
import org.LMS.repositories.UserRepository;

import java.util.Objects;

public class GetAuthorizationService implements IGetUserAuthorizationService {

   @Override
   public User execute(AuthorizationCredentials authorizationCredentials) {
      UserRepository userRepository = UserRepository.getInstance();
      User userToAuth = userRepository.get(authorizationCredentials.getEmail());

      if(Objects.isNull(userToAuth)){
         System.out.println("(GetAuthorizationService) --> Email does not exist");
         return null;
      }

      if(!userToAuth.getPassword().equals(authorizationCredentials.getPassword())){
         System.out.println("(GetAuthorizationService) --> Incorrect password");
         return null;
      }

      System.out.println("(GetAuthorizationService) --> User '" + userToAuth.getEmail() + "' successfully authenticated !!!");
      return userToAuth;
   }
}
