package org.analyzer.controller;

/**
 * @author mateusz.rutski@sagiton.pl
 */

import org.analyzer.controller.response.DialogExpressionQueryResponse;
import org.analyzer.domain.DialogExpression;
import org.analyzer.service.category.DialogCategoryService;
import org.analyzer.service.category.DialogCategoryVO;
import org.analyzer.service.dialog.DialogExpressionService;
import org.analyzer.service.dialog.DialogExpressionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Known as 'BotController' in Sequence Diagram of 'Dialog conducting
 * (Prowadzenie dialogu)' use case
 **/
@Component
public class BotEngine {

	private static final int SEQ_START = 1;
	private static final int SEQ_CHAT = 2;
	private static final int SEQ_END = 3;
	private static final String ANSWER_TOO_LATE = "We were talking about that in the past, let's go forward";
	private static final String ANSWER_TOO_FAST = "Hey, say at least hi before conversation!";
	private static final String ANSWER_ALREADY_ENDED = "We already ended conversation, sorry, see you soon.";
	private static final String DEFAULT_ANSWER = "Sorry, but I do not understand you! Please enter correct expression:)";

	private DialogCategoryVO currentDialogCategory;
	private int sequence;

	@Autowired
	private DialogExpressionService dialogExpressionService;
	@Autowired
	private DialogCategoryService dialogCategoryService;
	private boolean isDialogEnded = false;

	public boolean isDialogEnded() {
		return isDialogEnded;
	}

	public void initializeBot(DialogCategoryVO dialogCategory) {
		sequence = 1;
		currentDialogCategory = dialogCategory;
	}

	public DialogExpressionQueryResponse getResponse(String userExpression) {
		String answer = DEFAULT_ANSWER;
		checkInitialization();
		if (isDialogEnded()) {
			answer = ANSWER_ALREADY_ENDED;
		} else {
			userExpression = escapeExpressionForComparision(userExpression);

			List<DialogExpressionVO> userQuestions = dialogExpressionService
			        .getUserQuestionsForCategory(currentDialogCategory.getDomainObject());

			for (DialogExpressionVO dialogExpressionVO : userQuestions) {
				DialogExpression domainObject = dialogExpressionVO.getDomainObject();
				String expression = domainObject.getContent();
				expression = escapeExpressionForComparision(expression);

				if (areExpressionsEquals(userExpression, expression)) {
					System.out.println("Matching expression: " + expression);
					DialogExpressionVO answerForExpression = dialogExpressionService
					        .getAnswerForExpression(dialogExpressionVO);
					if (answerForExpression != null) {
						DialogExpression answerExpression = answerForExpression.getDomainObject();
						if (answerExpression.getSequence() > sequence && sequence < SEQ_END) {
							answer = ANSWER_TOO_FAST;
						} else if (answerExpression.getSequence() == SEQ_START && sequence != SEQ_START) {
							answer = ANSWER_TOO_LATE;
						} else {
							if (sequence < SEQ_END) {
								sequence++;
							} else if (answerExpression.getSequence() == SEQ_END) {
								isDialogEnded = true;
								sequence = SEQ_END;
							}
							System.out.println("Answer for expression: " + answerExpression);
							answer = answerExpression.getContent();
						}
						break;
					}
				}
			}
		}
		return new DialogExpressionQueryResponse(answer, isDialogEnded);
	}

	private static boolean areExpressionsEquals(String expr1, String expr2) {
		int allowedMistakes = 0;

		int minLength = Math.min(expr1.length(), expr2.length());
		if (minLength < 3) {
			allowedMistakes = 0;
		} else if (minLength < 5) {
			allowedMistakes = 1;
		} else if (minLength < 10) {
			allowedMistakes = 2;
		} else {
			allowedMistakes = 3;
		}

		int index1 = 0;
		int index2 = 0;

		while (index1 < expr1.length() && index2 < expr2.length()) {
			if (expr1.charAt(index1) != expr2.charAt(index2)) {
				allowedMistakes--;
				if (allowedMistakes < 0) {
					return false;
				} else if (index1 + 1 < expr1.length() && expr1.charAt(index1 + 1) == expr2.charAt(index2)) {
					index1++;
				} else if (index2 + 1 < expr2.length() && expr2.charAt(index2 + 1) == expr1.charAt(index1)) {
					index2++;
				}
			}

			index1++;
			index2++;
		}

		int diff1 = Math.abs(index1 - expr1.length());
		int diff2 = Math.abs(index2 - expr2.length());
		return diff1 <= allowedMistakes && diff2 <= allowedMistakes;
	}

	public static void main(String[] args) {
		System.out.println(areExpressionsEquals("apples", "aplex"));
	}

	private String escapeExpressionForComparision(String expression) {
		return expression.toLowerCase().trim().replace(".", "").replace("!", "").replace("?", "").replace(" ", "");
	}

	public void finish() {
		checkInitialization();
		currentDialogCategory = null;
	}

	public void checkInitialization() {
		if (!isInitialized()) {
			throw new IllegalStateException("Bot must be initialized first");
		}
	}

	public boolean isInitialized() {
		return currentDialogCategory != null;
	}
}
