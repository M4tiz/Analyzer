package org.analyzer.persistence;

import org.analyzer.domain.IdentityObject;
import org.analyzer.domain.User;

import java.util.List;

/**
 * @author mateusz.rutski@sagiton.pl
 */
public interface DataAccessObject<T extends IdentityObject> {

    T findById(Long id);

    List<T> findAll();

    void insert(T object);

    T update(T object);

    void delete(T object);
}
