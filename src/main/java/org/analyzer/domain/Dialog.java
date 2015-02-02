package org.analyzer.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Entity
@Table(name = "DIALOG")
public class Dialog extends IdentityObject {

    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @JoinColumn(name = "LEARNING_STATE")
    @OneToOne(cascade = CascadeType.ALL)
    private LearningState learningState;

    @OneToMany(mappedBy = "dialog")
    private List<Expression> expressions;

    @ManyToOne
    @JoinColumn(name = "DIALOG_CATEGORY")
    private DialogCategory dialogCategory;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LearningState getLearningState() {
        return learningState;
    }

    public void setLearningState(LearningState learningState) {
        this.learningState = learningState;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public DialogCategory getDialogCategory() {
        return dialogCategory;
    }

    public void setDialogCategory(DialogCategory dialogCategory) {
        this.dialogCategory = dialogCategory;
    }
}
