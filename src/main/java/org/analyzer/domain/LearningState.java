package org.analyzer.domain;

import javax.persistence.*;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Entity
@Table(name = "LEARNING_STATE")
public class LearningState extends IdentityObject {

    @Column(name = "LEARNING_STATUS")
    @Enumerated(EnumType.STRING)
    private LearningStatus learningStatus = LearningStatus.FAILED;

    @OneToOne(mappedBy = "learningState")
    private Dialog dialog;



    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public LearningStatus getLearningStatus() {
        return learningStatus;
    }

    public void setLearningStatus(LearningStatus learningStatus) {
        this.learningStatus = learningStatus;
    }

    public void setFinished() {
        learningStatus = LearningStatus.FINISHED;
    }
}
