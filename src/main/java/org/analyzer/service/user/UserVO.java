package org.analyzer.service.user;

import org.analyzer.domain.User;
import org.analyzer.domain.UserRole;
import org.analyzer.service.ValueObject;

/**
 * @author mateusz.rutski@sagiton.pl
 */
public class UserVO extends ValueObject<User> {

    public UserVO(User domainObject) {
        super(domainObject);
    }

    public String getUsername() {
        return domainObject.getUsername();
    }

    public String getPassword() {
        return domainObject.getPassword();
    }

    public UserRole getRole() {
        return domainObject.getRole();
    }
}
