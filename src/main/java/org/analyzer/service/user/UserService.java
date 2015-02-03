package org.analyzer.service.user;

/**
 * @author mateusz.rutski@sagiton.pl
 */
public interface UserService {

    public UserVO findByUsername(String username);

    void addUser(UserVO userVO);
}
