package com.nikhil.group.dto.request;

import com.nikhil.group.enums.TeamRole;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AddUserToTeamRequest {
    @NotNull
    private UUID userId;

    @NotNull
    private TeamRole role;
}
