package org.LMS.interfaces.useCases;

import org.LMS.models.loan.Loan;
import org.LMS.models.readingEntities.GenericBook;
import org.LMS.models.user.User;

public interface ICreateLoanService {
   Loan execute( String userEmail, Integer readingEntityId);
}
