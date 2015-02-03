package org.analyzer.domain;

import com.mysema.query.annotations.QueryProjection;

import javax.persistence.*;
import java.util.List;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Entity
@Table(name = "USER")
public class User extends IdentityObject {

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany
    private List<LearningState> learningStates;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isStudent() {
        return role == UserRole.STUDENT;
    }

    public boolean isLecturer() {
        return role == UserRole.LECTURER;
    }

    public boolean isAdministrator() {
        return role == UserRole.ADMINISTRATOR;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<LearningState> getLearningStates() {
        return learningStates;
    }

    public void setLearningStates(List<LearningState> learningStates) {
        this.learningStates = learningStates;
    }
}
