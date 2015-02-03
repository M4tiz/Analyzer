package org.analyzer.persistence.user;

import org.analyzer.domain.User;
import org.analyzer.persistence.DataAccessObject;

/**
 * @author mateusz.rutski@sagiton.pl
 */
public interface UserDAO extends DataAccessObject<User> {

    User findByUsername(String username);
}
