package org.analyzer.controller;

import org.analyzer.constants.HtmlViews;
import org.analyzer.constants.HttpPaths;
import org.analyzer.controller.response.DialogExpressionQueryResponse;
import org.analyzer.service.category.DialogCategoryService;
import org.analyzer.service.category.DialogCategoryVO;
import org.analyzer.service.dialog.DialogService;
import org.analyzer.service.dialog.DialogVO;
import org.analyzer.service.dialog.ExpressionVO;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.io.IOException;

import static org.analyzer.constants.HtmlViews.DASHBOARD;
import static org.analyzer.constants.HtmlViews.DIALOG_VIEW;
import static org.analyzer.constants.HttpPaths.DIALOG_INPUT;
import static org.analyzer.constants.HttpPaths.DIALOG_START;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Controller
@SessionAttributes(value = "newDialog")
public class DialogController {

	@Autowired
	private BotEngine botEngine;

	@Autowired
	private DialogCategoryService dialogCategoryService;

	@Autowired
	private DialogService dialogService;

	private ObjectMapper objectMapper = new ObjectMapper();

	@ModelAttribute("newDialog")
	public DialogVO newDialog(@PathVariable Long categoryId) {
		DialogCategoryVO category = dialogCategoryService.findById(categoryId);
		return dialogService.createNewDialog(category);
	}

	@RequestMapping(value = DIALOG_START, method = RequestMethod.GET)
	public String startDialog(@PathVariable Long categoryId, Model model) {

		DialogCategoryVO category = dialogCategoryService.findById(categoryId);
		botEngine.initializeBot(category);

		model.addAttribute("category", category.getName());

		return DIALOG_VIEW;
	}

	@RequestMapping(value = DIALOG_INPUT, method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public String queryExpression(@ModelAttribute("newDialog") DialogVO dialog, @RequestParam String expression) throws IOException {

		if (StringUtils.isBlank(expression)) {
			throw new IllegalStateException("Expression cannot be null");
		}

		DialogExpressionQueryResponse response = botEngine.getResponse(expression);
		dialog.addExpression(ExpressionVO.from(dialog, expression));
		dialog.addExpression(ExpressionVO.from(dialog, response.getContent()));

		return objectMapper.writeValueAsString(response);
	}

	private void finishAndSaveDialog(DialogVO dialog) {
		dialog.finishDialog();
		dialogService.save(dialog);
	}

	@RequestMapping(value = HttpPaths.DIALOG_CANCEL, method = RequestMethod.GET)
	public String cancelDialog() {
		return HtmlViews.DASHBOARD;
	}

	@RequestMapping(value = HttpPaths.DIALOG_FINISH, method = RequestMethod.GET)
	public String finishDialog(@ModelAttribute("newDialog") DialogVO dialog, SessionStatus sessionStatus) {

		finishAndSaveDialog(dialog);
		sessionStatus.setComplete();

		return DASHBOARD;
	}
}
