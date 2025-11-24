package com.uber.authservices.dto;

import com.kaish.uber.dto.entity.AbstractAuditableBean;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerSignupRequestDto extends AbstractAuditableBean {
    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String preferredName;
    private String phoneNumber;
}
