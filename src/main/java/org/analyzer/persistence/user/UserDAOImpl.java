package org.analyzer.persistence.user;

import com.mysema.query.jpa.impl.JPAQuery;
import org.analyzer.domain.QUser;
import org.analyzer.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    private final QUser USER = QUser.user;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findById(Long id) {
        return new JPAQuery(entityManager).from(USER).where(USER.id.eq(id)).singleResult(USER);
    }

    @Override
    public User findByUsername(String username) {
        return new JPAQuery(entityManager).from(USER).where(USER.username.eq(username)).singleResult(USER);
    }

    @Override
    public List<User> findAll() {
        return new JPAQuery(entityManager).from(USER).list(USER);
    }

    @Override
    public void insert(User object) {
        entityManager.persist(object);
    }

    @Override
    public User update(User object) {
        return entityManager.merge(object);
    }

    @Override
    public void delete(User object) {
        entityManager.remove(object);
    }
}
