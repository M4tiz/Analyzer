package org.analyzer.domain;

import javax.persistence.*;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Entity
@Table(name = "EXPRESSION")
public class Expression extends IdentityObject {

    @Column(name = "CONTENT")
    private String content;

    @JoinColumn(name = "DIALOG")
    @ManyToOne
    private Dialog dialog;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }
}
