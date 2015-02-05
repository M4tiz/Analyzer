package org.analyzer.service.category;

import java.util.List;

/**
 * @author mateusz.rutski@sagiton.pl
 */

public interface DialogCategoryService {

    List<DialogCategoryVO> getCategoryList();

    DialogCategoryVO findById(Long categoryId);
}
