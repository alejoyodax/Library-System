package org.LMS.interfaces.useCases;

import org.LMS.interfaces.ReadingEntityType;
import org.LMS.models.readingEntities.GenericBook;
import org.LMS.models.readingEntities.ReadingEntityModel;

import java.util.List;

public interface IGetAllReadingEntitiesByType {
   List<GenericBook> execute(ReadingEntityType type);

}
