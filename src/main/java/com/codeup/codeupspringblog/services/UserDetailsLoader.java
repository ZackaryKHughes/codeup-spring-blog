package com.codeup.codeupspringblog.services;

import com.codeup.codeupspringblog.models.AdUser;
import com.codeup.codeupspringblog.models.UserWithRoles;
import com.codeup.codeupspringblog.repositories.AdUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailsLoader implements UserDetailsService {
    private final AdUserRepository usersDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdUser user = usersDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        return new UserWithRoles(user);
    }
}
