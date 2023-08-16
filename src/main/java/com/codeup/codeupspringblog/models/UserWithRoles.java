package com.codeup.codeupspringblog.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public class UserWithRoles extends AdUser implements UserDetails {

    public UserWithRoles(AdUser user) {
        super(user);
    }

    @Override
    public String toString() {
        return "UserWithRoles{} " + this.getId() + " " + this.getUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = "";
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

