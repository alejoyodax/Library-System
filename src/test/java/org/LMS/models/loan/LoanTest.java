package org.LMS.models.loan;

import org.LMS.interfaces.UserRole;
import org.LMS.models.readingEntities.Book;
import org.LMS.models.readingEntities.Novel;
import org.LMS.models.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LoanTest {

   @Test
   void createLoan(){
      //create a fictional user and book
      User user1 = new User("alejo","alejoyodax@gmail.com","12345", UserRole.READER);
      Novel novel1 = new Novel("The Hobbit", "J.R.R. Tolkien", 1937, "fantasy", 11, 5);

      Loan loan1 = new Loan(user1, novel1);
      // id must be 1
      assertEquals(1, loan1.getLoanId());
      // status must be requested
      assertEquals(LoanState.REQUESTED, loan1.getLoanState());
      // user email must be the same as user1
      assertEquals(user1.getEmail(), loan1.getUser().getEmail());

      // set the loan state to confirmed must change the start and end date
      loan1.setLoanState(LoanState.CONFIRMED);
      assertNotNull(loan1.getStartDate());
      assertNotNull(loan1.getEndDate());

      //difference between start and end date must be 15 days
      assertEquals(15, loan1.getEndDate().toEpochDay() - loan1.getStartDate().toEpochDay());
   }


}