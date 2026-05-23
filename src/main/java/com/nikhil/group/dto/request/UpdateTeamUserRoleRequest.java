package com.nikhil.group.dto.request;

import com.nikhil.group.enums.TeamRole;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTeamUserRoleRequest {
    @NotNull
    private TeamRole role;
}
