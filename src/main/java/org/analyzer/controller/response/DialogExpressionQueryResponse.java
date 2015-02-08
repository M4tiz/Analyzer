package org.analyzer.controller.response;

/**
 * @author mateusz.rutski@sagiton.pl
 */
public class DialogExpressionQueryResponse {

    public String content;
    public boolean isDialogFinished;

    public DialogExpressionQueryResponse(String answer, boolean isDialogFinished) {
        content = answer;
        this.isDialogFinished = isDialogFinished;
    }

    public boolean isDialogFinished() {
        return isDialogFinished;
    }

    public void setDialogFinished(boolean isDialogFinished) {
        this.isDialogFinished = isDialogFinished;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
