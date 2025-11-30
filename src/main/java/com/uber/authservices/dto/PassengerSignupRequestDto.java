package com.uber.authservices.dto;

import com.kaish.uber.dto.entity.AbstractAuditableBean;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerSignupRequestDto extends AbstractAuditableBean implements UserDetails {
    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String preferredName;
    private String phoneNumber;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
