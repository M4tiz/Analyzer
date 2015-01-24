package org.analyzer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Entity
@Table(name = "EXPRESSION")
public class Expression extends IdentityObject {

    @Column(name = "CONTENT")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
