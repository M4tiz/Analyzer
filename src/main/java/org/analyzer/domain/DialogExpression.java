package org.analyzer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
}
