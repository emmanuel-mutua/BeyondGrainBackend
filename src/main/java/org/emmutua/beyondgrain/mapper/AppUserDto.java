package org.emmutua.beyondgrain.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.emmutua.beyondgrain.userManagement.model.UserType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserDto {
    private String id;
    private String username;
    private String email;
    private String phone;
    private String idNumber;
    private UserType role;
    private boolean isEnabled;
}
