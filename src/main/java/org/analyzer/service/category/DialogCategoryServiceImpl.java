package org.analyzer.service.category;

import org.analyzer.persistence.category.DialogCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Service
public class DialogCategoryServiceImpl implements DialogCategoryService {

    @Autowired
    private DialogCategoryDAO dialogCategoryDAO;

    @Override
    public List<DialogCategoryVO> getCategoryList() {
        return dialogCategoryDAO.findAll()
                .stream()
                .map(DialogCategoryVO::new)
                .collect(Collectors.toList());
    }

    @Override
    public DialogCategoryVO findById(Long categoryId) {
        return new DialogCategoryVO( dialogCategoryDAO.findById(categoryId) );
    }
}
