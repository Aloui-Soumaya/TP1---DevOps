package com.paulous.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersDto {
    private String username;
    private String firstName;
    private String lastName;
    private String userRole;
}
