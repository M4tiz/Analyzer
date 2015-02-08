package org.analyzer.service.dialog;

import java.util.List;

import org.analyzer.domain.DialogCategory;

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
}
