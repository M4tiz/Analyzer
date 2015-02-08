package org.analyzer.service.dialog;

import org.analyzer.domain.DialogCategory;

import java.util.List;

/**
 * @author wrabel
 */
public interface DialogExpressionService {
    List<DialogExpressionVO> getAllDialogExpressions();
    List<DialogExpressionVO> getAllUserQuestions();
    List<DialogExpressionVO> getDialogExpressionForCategory(DialogCategory dialogCategory);
	List<DialogExpressionVO> getUserQuestionsForCategory(
			DialogCategory domainObject);
	DialogExpressionVO getAnswerForExpression(DialogExpressionVO dialogExpressionVO);

    List<String> getUserExpressionsByCategoryId(Long categoryId);
}
