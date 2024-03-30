package org.LMS.models.readingEntities;

import org.LMS.interfaces.ReadingEntityType;
import org.LMS.interfaces.IReadingEntityType;

public class Novel extends GenericBook implements IReadingEntityType {
   private String genre;
   private Integer suggestedReadingAge;
   private final ReadingEntityType readingEntityType = ReadingEntityType.NOVEL;

   public Novel(String title, String author, int year, String genre, Integer suggestedReadingAge, Integer totalCopies) {
      super(title, author, year, totalCopies);
      this.genre = genre;
      this.suggestedReadingAge = suggestedReadingAge;
   }
   public Novel(){}

   public String getGenre() {
      return genre;
   }

   public Integer getSuggestedReadingAge() {
      return suggestedReadingAge;
   }

   @Override
   public ReadingEntityType getReadingEntityType() {
      return readingEntityType;
   }

   // constructor for the builder
   public Novel(Builder builder) {
      super(builder);
      this.genre = builder.genre;
      this.suggestedReadingAge = builder.suggestedReadingAge;
   }

   // ######### BUILDER #########
   public static class Builder extends GenericBook.Builder {
      private String genre;
      private Integer suggestedReadingAge;

      public Builder setGenre(String genre) {
         this.genre = genre;
         return this;
      }

      public Builder setSuggestedReadingAge(Integer suggestedReadingAge) {
         this.suggestedReadingAge = suggestedReadingAge;
         return this;
      }

      public Novel build() {
         return new Novel(this);
      }
   }

   @Override
   public String toString() {
      return "NOVEL | " + this.getId() + " | " + this.getTitle() + " | " + this.getYear() + " | " + genre +
            " | " + this.getAuthor() + " | " + suggestedReadingAge + "+" + " | TOTAL:" + this.getTotalCopies() + " | LOANED:" + this.getLoanedCopies() +
            " | AVAILABLE:" + this.getAvailableCopies();
   }


}
