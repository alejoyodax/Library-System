package org.LMS.repositories;

import org.LMS.interfaces.IRepository;
import org.LMS.models.loan.Loan;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LoanRepository implements IRepository<Loan> {
   private final static Map<Integer, Loan> loanRepo = new LinkedHashMap<>();

   private LoanRepository() {
   }

   public static LoanRepository getInstance() {
      if (loanRepo.isEmpty()) {
         // add some loans
         //System.out.println("** THE LOAN REPO IS EMPTY, PLEASE ADD SOME ** (LoanRepository)");
      }
      return new LoanRepository();
   }

   @Override
   public Loan add(Loan loan) {
      loanRepo.put(loan.getLoanId(), loan);
      return loanRepo.get(loan.getLoanId());
   }

   @Override
   public Loan remove(Loan loan) {
      return loanRepo.remove(loan.getLoanId());
   }

   @Override
   public Loan update(Loan loan) {
      loanRepo.put(loan.getLoanId(), loan);
      return loanRepo.get(loan.getLoanId());
   }

   public Loan get(int loanId) {
      return loanRepo.get(loanId);
   }

   @Override
   public List<Loan> getAllAsList() {
      return new ArrayList<>(loanRepo.values());
   }

   @Override
   public Integer getSize() {
      return loanRepo.size();
   }

   @Override
   public void PrintItems() {
      loanRepo.forEach((k,v)-> System.out.println(v.toString()));
   }

   public void clear() {
      loanRepo.clear();
   }
}
