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
}
