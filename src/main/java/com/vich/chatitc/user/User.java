package com.vich.chatitc.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Entity
@Table(name = "data_user")
public class User implements UserDetails {

    private static final long serialVersionUID = 4074374728582967483L;
    @Id
    @GeneratedValue
    private long id;
    @NotNull(message = "{chatitc.constraints.userName.NotNull.message}")
    @Size(min = 3, max = 255)
    @UniqueUserName
    private String userName;
    @NotNull(message = "{chatitc.constraints.displayName.NotNull.message}")
    @Size(min = 3, max = 255)
    private String displayName;
    @NotNull(message = "{chatitc.constraints.password.NotNull.message}")
    @Size(min = 8, max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message="{chatitc.constraints.password.Pattern.message}")
    private String password;

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("Role_USER");
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }

    @Override
    @Transient
    public String getUsername() {
        return this.userName;
    }
    public String getUserName(){
        return this.userName;
    }
//    @Override
//    @Transient
//    public String getPassword() {
//        return this.password;
//    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }
}
