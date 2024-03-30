package org.LMS.services.userServices;

import org.LMS.interfaces.useCases.IUseCaseParams;
import org.LMS.models.user.User;
import org.LMS.repositories.UserRepository;

public class GetUserByEmail implements IUseCaseParams {
   @Override
   public User execute(Object userEmail) {
      return UserRepository.getInstance().get((String) userEmail);
   }
}
