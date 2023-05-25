package com.thor.culturaracional.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LoggedUserDTO {
    private String username;
    private List<String> permissions;
}
