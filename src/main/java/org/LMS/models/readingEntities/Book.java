package org.LMS.models.readingEntities;

import org.LMS.interfaces.ReadingEntityType;
import org.LMS.interfaces.IReadingEntityType;

public class Book extends GenericBook implements IReadingEntityType {
   private String knowledgeArea;
   private final ReadingEntityType readingEntityType = ReadingEntityType.BOOK;

   public Book(String title, String author, int year, String knowledgeArea, Integer totalCopies) {
      super(title, author, year, totalCopies);
      this.knowledgeArea = knowledgeArea;
   }

   public Book() {
      super();
   }

   public String getKnowledgeArea() {
      return knowledgeArea;
   }

   public void setKnowledgeArea(String knowledgeArea) {
      this.knowledgeArea = knowledgeArea;
   }

   @Override
   public ReadingEntityType getReadingEntityType() {
      return readingEntityType;
   }

   // constructor for the builder
   public Book(Builder builder) {
      super(builder);
      this.knowledgeArea = builder.knowledgeArea;
   }

   @Override
   public String toString() {
      return "BOOK | " + this.getId() + " | " + this.getTitle() + " | " + this.getYear() + " | " + this.getKnowledgeArea() +
            " | " + this.getAuthor() + " | TOTAL:" + this.getTotalCopies() + " | LOANED:" + this.getLoanedCopies() +
            " | AVAILABLE:" + this.getAvailableCopies();
   }

   // ######### BOOK BUILDER #########
   public static class Builder extends GenericBook.Builder {
      private String knowledgeArea;

      public Builder setKnowledgeArea(String knowledgeArea) {
         this.knowledgeArea = knowledgeArea;
         return this;
      }

      @Override
      public Book build() {
         return new Book(this);
      }
   }


}
