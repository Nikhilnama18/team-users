package com.nikhil.group.dto.response;

import com.nikhil.group.enums.TeamRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Builder
public class TeamUserResponse {

    private UUID id;

    private UUID teamId;
    private String teamName;

    private UUID userId;
    private String userName;
    private String userEmail;

    private TeamRole role;
}