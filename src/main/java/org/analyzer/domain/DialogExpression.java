package org.analyzer.domain;

import javax.persistence.*;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Entity
@Table(name = "DIALOG_EXPRESSION")
public class DialogExpression extends IdentityObject {

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "SEQUENCE")
	private Integer sequence;

	@Column(name = "ANSWER_ID")
	private Long answerID;

	@JoinColumn(name = "DIALOG_CATEGORY")
	@ManyToOne
	private DialogCategory dialogCategory;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public DialogCategory getDialogCategory() {
		return dialogCategory;
	}

	public void setDialogCategory(DialogCategory dialogCategory) {
		this.dialogCategory = dialogCategory;
	}

	public Long getAnswerID() {
		return answerID;
	}

	public void setAnswerID(Long answerID) {
		this.answerID = answerID;
	}

	@Override
	public String toString() {
		return "DialogExpression [content=" + content + ", sequence=" + sequence + ", answerID=" + answerID
				+ ", dialogCategory=" + dialogCategory + "]";
	}

}
