package org.analyzer.service;

import org.analyzer.service.user.UserService;
import org.analyzer.service.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author mateusz.rutski@sagiton.pl
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO vo = userService.findByUsername(username);

        if (vo == null) {
            throw new UsernameNotFoundException("Username " + username + " does not exists");
        }

        return new User(vo.getUsername(), vo.getPassword(), Arrays.asList( new SimpleGrantedAuthority(vo.getRole().toString())) );
    }
}
