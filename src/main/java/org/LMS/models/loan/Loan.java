package org.LMS.models.loan;

import org.LMS.interfaces.UserRole;
import org.LMS.models.readingEntities.GenericBook;
import org.LMS.models.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class Loan {
   public static AtomicInteger NEXT_ID = new AtomicInteger(1);
   private Integer loanId;
   private User user;
   private GenericBook readingEntity;
   private LoanState loanState;
   private LocalDateTime requestDateTime; // datetime when the user requests the book
   private LocalDate startDate;  // day when the user gets the book
   private LocalDate endDate; // limit date for the user to return the book
   private LocalDateTime returnDate; // datetime when the user returns the book

   public Loan(User user, GenericBook readingEntity) {
      if(!user.getRole().equals(UserRole.READER)){
         throw new IllegalArgumentException("Only READERS can request loans.");
      }
      this.loanId = NEXT_ID.getAndIncrement();
      this.user = user;
      this.readingEntity = readingEntity;
      this.loanState = LoanState.REQUESTED;
      this.requestDateTime = LocalDateTime.now();
      this.startDate = null;
      this.endDate = null;
   }

   public Integer getLoanId() {
      return loanId;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public GenericBook getReadingEntity() {
      return readingEntity;
   }

   public void setReadingEntity(GenericBook readingEntity) {
      this.readingEntity = readingEntity;
   }

   public LoanState getLoanState() {
      return loanState;
   }

   public void setLoanState(LoanState loanState) {
      if(loanState.equals(LoanState.CONFIRMED)){
         this.startDate = LocalDate.now();
         this.endDate = LocalDate.now().plusDays(15); // limit date
         this.loanState = loanState;
         return;
      }else if(loanState.equals(LoanState.ENDED)){
         this.returnDate = LocalDateTime.now();
         this.loanState = loanState;
         return;
      }

      System.out.println("Invalid state change my friend.");
   }

   public Integer getId() {
      return loanId;
   }

   public LocalDateTime getRequestDateTime() {
      return requestDateTime;
   }

   public void setRequestDateTime(LocalDateTime requestDateTime) {
      this.requestDateTime = requestDateTime;
   }

   public LocalDate getStartDate() {
      return startDate;
   }

   public void setStartDate(LocalDate startDate) {
      this.startDate = startDate;
   }

   public LocalDate getEndDate() {
      return endDate;
   }

   public void setEndDate(LocalDate endDate) {
      this.endDate = endDate;
   }

   public LocalDateTime getReturnDate() {
      return returnDate;
   }

   public void setReturnDate(LocalDateTime returnDate) {
      this.returnDate = returnDate;
   }

   private Object getFormattedDateTime(){
      return this.requestDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
   }

   @Override
   public String toString() {
      return "LOAN | " + this.loanId + " | User: " + this.user.getEmail() + " | Type: " +
            this.readingEntity.getClass().getSimpleName() + " | " + this.readingEntity.getId() +
            " | Status:" + this.loanState + " | Requested: " + getFormattedDateTime() + " | Start: " +
            this.startDate + " | End: " + this.endDate;
   }

}
