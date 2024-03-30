package org.LMS.services.loanServices;

import org.LMS.models.loan.Loan;
import org.LMS.repositories.LoanRepository;
import org.LMS.utils.RepositoryUtilActions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateLoanServiceTest {

   @BeforeEach
   void addUsersAndBooks(){
      LoanRepository.getInstance().clear();
      // add users and books to the repository
      RepositoryUtilActions.addUserToRepository();
      RepositoryUtilActions.addBooksAndNovels();
   }

   @Test
   void createFirstLoan() {
      // create loan for user
      String email = "alejoyodax@gmail.com";
      Loan loan = new CreateLoanService().execute(email,1);
      List<Loan> loanList = LoanRepository.getInstance().getAllAsList();

      assertEquals(1,loanList.size());
      System.out.println(loanList);
      assertNotNull(loan);
   }

   @Test
   void tryMakeLoanWithTheSameBook() {
      // create loan for user
      String email = "alejoyodax@gmail.com";
      Loan loan = new CreateLoanService().execute(email,1);
      Loan loan2 = new CreateLoanService().execute(email,1);
      List<Loan> loanList = LoanRepository.getInstance().getAllAsList();

      assertNotNull(loan);
      assertEquals(1,loanList.size());
      assertNull(loan2);
   }


}