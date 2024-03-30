package org.LMS.models.readingEntities;

import org.LMS.interfaces.ReadingEntityType;
import org.LMS.interfaces.IReadingEntityType;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * It's represents the most basic form of a book,
 * it has the most basic attributes of a book.
 * **/
public class GenericBook extends ReadingEntityModel implements IReadingEntityType {
   public static AtomicInteger NEXT_ID = new AtomicInteger(1);
   private Integer id;
   private String title;
   private String author;
   private Integer year;
   private Integer totalCopies;
   private Integer availableCopies;
   private Integer loanedCopies;
   private final ReadingEntityType readingEntityType = ReadingEntityType.GENERIC_BOOK;

   public ReadingEntityType getReadingEntityType() {
      return readingEntityType;
   }

   public GenericBook(String title, String author, int year, Integer totalCopies) {
      this.id = NEXT_ID.getAndIncrement();
      this.title = title;
      this.author = author;
      this.year = year;
      this.totalCopies = totalCopies;
      this.availableCopies = totalCopies;
      this.loanedCopies = 0;
   }

   public GenericBook(Builder builder) {
      this.id = NEXT_ID.getAndIncrement();
      this.title = builder.title;
      this.author = builder.author;
      this.year = builder.year;
      this.totalCopies = builder.totalCopies;
      this.availableCopies = builder.totalCopies;
      this.loanedCopies = 0;
   }

   public GenericBook() {
      this.id = NEXT_ID.getAndIncrement();
   }


   public static Integer getNextId() {
      return NEXT_ID.get();
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public Integer getYear() {
      return year;
   }

   public void setYear(Integer year) {
      this.year = year;
   }

   public Integer getTotalCopies() {
      return totalCopies;
   }

   public void setTotalCopies(Integer totalCopies) {
      this.totalCopies = totalCopies;
   }

   public Integer getAvailableCopies() {
      return availableCopies;
   }

   public void setAvailableCopies(Integer availableCopies) {
      this.availableCopies = availableCopies;
   }

   public Integer getLoanedCopies() {
      return loanedCopies;
   }

   public void setLoanedCopies(Integer loanedCopies) {
      this.loanedCopies = loanedCopies;
   }


   public String toString() {
      return "GENERIC BOOK |" + this.id + " | " + this.title + " | " + this.getAuthor();
   }

   public static class Builder {
      private String title;
      private String author;
      private Integer year;
      private Integer totalCopies;

      public Builder setTitle(String title) {
         this.title = title;
         return this;
      }

      public Builder setAuthor(String author) {
         this.author = author;
         return this;
      }

      public Builder setYear(Integer year) {
         this.year = year;
         return this;
      }

      public Builder setTotalCopies(Integer totalCopies) {
         this.totalCopies = totalCopies;
         return this;
      }

      public GenericBook build() {
         return new GenericBook(this);
      }

   }

}
