package org.LMS.interfaces.useCases;

import org.LMS.interfaces.ReadingEntityType;
import org.LMS.models.loan.Loan;

import java.util.List;

public interface IGetAllLoansService {
   List<Loan> execute();
   List<Loan> execute(ReadingEntityType type);

}
