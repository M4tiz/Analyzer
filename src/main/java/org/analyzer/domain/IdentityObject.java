package org.analyzer.domain;

import javax.persistence.*;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@MappedSuperclass
public abstract class IdentityObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    @SequenceGenerator(name = "ID_SEQUENCE", initialValue = 1, allocationSize = 1)
    @Column(name = "ID")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNew() {
        return id == null;
    }
}
