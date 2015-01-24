package org.analyzer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Entity
@Table(name = "DIALOG_CATEGORY")
public class DialogCategory extends IdentityObject {

    @Column(name = "NANE")
    private String name;

    @OneToMany(mappedBy = "dialogCategory")
    @Column(name = "DIALOG_EXPRESSION")
    private DialogExpression dialogExpression;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DialogExpression getDialogExpression() {
        return dialogExpression;
    }

    public void setDialogExpression(DialogExpression dialogExpression) {
        this.dialogExpression = dialogExpression;
    }
}
