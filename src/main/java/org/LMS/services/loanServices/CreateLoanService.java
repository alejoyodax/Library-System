package org.LMS.services.loanServices;

import org.LMS.interfaces.useCases.ICreateLoanService;
import org.LMS.models.loan.Loan;
import org.LMS.models.readingEntities.GenericBook;
import org.LMS.models.user.AuthorizationCredentials;
import org.LMS.models.user.User;
import org.LMS.repositories.LibraryRepository;
import org.LMS.repositories.LoanRepository;
import org.LMS.repositories.UserRepository;
import org.LMS.services.userServices.GetAuthorizationService;
import org.LMS.services.userServices.GetUserByEmail;

import java.util.List;
import java.util.Objects;

public class CreateLoanService implements ICreateLoanService {

   @Override
   public Loan execute(String userEmail, Integer readingEntityId) {
      LibraryRepository lb = LibraryRepository.getInstance();
      // verify user exists
      User user = new GetUserByEmail().execute(userEmail);
      if(Objects.isNull(user)) {
         System.out.println("(CreateLoanService) --> User '" + userEmail  + "' does not exist");
         return null;
      }

      // verify if book/novel exist
      GenericBook genericBook = lb.get(readingEntityId);
      if(Objects.isNull(genericBook)) {
         System.out.println("(CreateLoanService) --> Reading exemplar id= " + readingEntityId + " does not exist");
         return null;
      }

      // verify if user has already loaned that book/novel
      List<Loan> loans = LoanRepository.getInstance().getAllAsList();
      for(Loan loan : loans) {
         if(loan.getReadingEntity().getId().equals(readingEntityId) && loan.getUser().getEmail().equals(userEmail)) {
            System.out.println("(CreateLoanService) --> User '" + userEmail + "' has already loaned the reading exemplar id= " + readingEntityId + " named '" + genericBook.getTitle() + "' | " + genericBook.getReadingEntityType());
            return null;
         }
      }

      // create loan and add it to the repository
      Loan loan = new Loan(user, genericBook);
      LoanRepository.getInstance().add(loan);
      return LoanRepository.getInstance().get(loan.getId());
   }
}
