package org.analyzer.service.dialog;

import org.analyzer.domain.Dialog;
import org.analyzer.domain.DialogCategory;
import org.analyzer.domain.DialogExpression;
import org.analyzer.domain.LearningState;
import org.analyzer.persistence.dialog.DialogDAO;
import org.analyzer.persistence.dialog.DialogExpressionDAO;
import org.analyzer.service.category.DialogCategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wrabel
 */

@Service
public class DialogExpressionServiceImpl implements DialogExpressionService {

	@Autowired
	private DialogExpressionDAO dialogExpressionDAO;

	@Override
	public List<DialogExpressionVO> getAllDialogExpressions() {
		List<DialogExpressionVO> dialogExpressionVOs = new ArrayList<>();
		dialogExpressionDAO.findAll().stream().forEach(obj -> dialogExpressionVOs.add(new DialogExpressionVO(obj)));
		return dialogExpressionVOs;
	}

	@Override
	public List<DialogExpressionVO> getDialogExpressionForCategory(DialogCategory dialogCategory) {

		return getAllDialogExpressions().stream()
				.filter(x -> x.getDomainObject().getDialogCategory().getId().equals(dialogCategory.getId()))
				.collect(Collectors.toList());
	}

	@Override
	public List<DialogExpressionVO> getAllUserQuestions() {
		return getAllDialogExpressions().stream().filter(x -> x.getDomainObject().getAnswerID() != null)
				.collect(Collectors.toList());
	}

	@Override
	public List<DialogExpressionVO> getUserQuestionsForCategory(DialogCategory dialogCategory) {
		return getDialogExpressionForCategory(dialogCategory).stream()
				.filter(x -> x.getDomainObject().getAnswerID() != null).collect(Collectors.toList());
	}

	@Override
	public DialogExpressionVO getAnswerForExpression(DialogExpressionVO dialogExpressionVO) {
		return getAllDialogExpressions().stream()
				.filter(x -> x.getDomainObject().getId().equals(dialogExpressionVO.getDomainObject().getAnswerID()))
				.findFirst().get();

	}
}
