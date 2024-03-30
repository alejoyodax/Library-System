package org.LMS.services.userServices;

import org.LMS.interfaces.useCases.IUseCase;
import org.LMS.models.user.User;
import org.LMS.repositories.UserRepository;

import java.util.List;

public class GetAllUsersService implements IUseCase {

   public List<User> execute() {
      return UserRepository.getInstance().getAllAsList();
   }
}
