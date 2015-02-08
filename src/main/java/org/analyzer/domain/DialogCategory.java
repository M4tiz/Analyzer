package org.analyzer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Entity
@Table(name = "DIALOG_CATEGORY")
public class DialogCategory extends IdentityObject {

    @Column(name = "NANE")
    private String name;

    @OneToMany(mappedBy = "dialogCategory")
    @Column(name = "DIALOG_EXPRESSION", unique = true, nullable = false)
    private List<DialogExpression> dialogExpressions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DialogExpression> getDialogExpressions() {
        return dialogExpressions;
    }

    public void setDialogExpressions(List<DialogExpression> dialogExpressions) {
        this.dialogExpressions = dialogExpressions;
    }
    
}