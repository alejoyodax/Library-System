package org.LMS.services.libraryServices;

import org.LMS.interfaces.ReadingEntityType;
import org.LMS.interfaces.useCases.IGetAllReadingEntitiesByType;
import org.LMS.models.readingEntities.GenericBook;
import org.LMS.repositories.LibraryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllEntitiesByTypeService implements IGetAllReadingEntitiesByType {
   LibraryRepository libraryRepository = LibraryRepository.getInstance();

   @Override
   public List<GenericBook> execute(ReadingEntityType type) {
      return libraryRepository.getAllAsList().stream()
            .filter(readingEntity -> readingEntity.getReadingEntityType().equals(type))
            .collect(Collectors.toList());
   }
}
