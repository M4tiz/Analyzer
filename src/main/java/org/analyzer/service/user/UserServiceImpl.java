package org.analyzer.service.user;

import org.analyzer.domain.User;
import org.analyzer.persistence.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDAO userDAO;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public UserVO findByUsername(String username) {
        return new UserVO( userDAO.findByUsername(username) );
    }

    @Override
    public void addUser(UserVO userVO) {
        save(userVO);
    }

    public User save(UserVO userVO) {

        User user = userVO.getDomainObject();
        user.setPassword( passwordEncoder.encode(userVO.getPassword()) );
        if (user.isNew()) {
            userDAO.insert(user);
        } else {
            user = userDAO.update(user);
        }
        return user;
    }
}
