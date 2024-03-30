package org.LMS.services.loanServices;

import org.LMS.interfaces.ReadingEntityType;
import org.LMS.interfaces.useCases.IGetAllLoansService;
import org.LMS.models.loan.Loan;
import org.LMS.repositories.LoanRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllLoansService implements IGetAllLoansService {

   @Override
   public List<Loan> execute() {
      return LoanRepository.getInstance().getAllAsList();
   }

   @Override
   public List<Loan> execute(ReadingEntityType type) {
      return LoanRepository.getInstance().getAllAsList()
            .stream()
            .filter((loanItem)-> loanItem.getReadingEntity().getReadingEntityType() == type)
            .map(loan -> loan)
            .collect(Collectors.toList());
   }
}
