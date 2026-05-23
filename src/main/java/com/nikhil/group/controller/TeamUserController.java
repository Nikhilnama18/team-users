package com.nikhil.group.controller;

import com.nikhil.group.dto.request.AddUserToTeamRequest;
import com.nikhil.group.dto.request.UpdateTeamUserRoleRequest;
import com.nikhil.group.dto.response.TeamUserResponse;
import com.nikhil.group.entity.TeamUser;
import com.nikhil.group.service.TeamUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teams/{teamId}/users")
@RequiredArgsConstructor
public class TeamUserController {

    private final TeamUserService teamUserService;

    @PostMapping
    public ResponseEntity<TeamUserResponse> addUserToTeam(
            @PathVariable UUID teamId,
            @Valid @RequestBody AddUserToTeamRequest request
    ) {
        TeamUser teamUser = teamUserService.createTeamUser(
                teamId,
                request.getUserId(),
                request.getRole()
        );

        TeamUserResponse response = TeamUserResponse.builder()
                .id(teamUser.getId())
                .teamId(teamUser.getTeam().getId())
                .teamName(teamUser.getTeam().getName())
                .userId(teamUser.getUser().getId())
                .userName(teamUser.getUser().getName())
                .userEmail(teamUser.getUser().getEmail())
                .role(teamUser.getRole())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TeamUserResponse>> getUsersByTeam(
            @PathVariable UUID teamId
    ) {
        List<TeamUser> teamUsers = teamUserService.getUsersByTeam(teamId);

        List<TeamUserResponse> response = teamUsers.stream()
                .map(teamUser -> TeamUserResponse.builder()
                        .id(teamUser.getId())
                        .teamId(teamUser.getTeam().getId())
                        .teamName(teamUser.getTeam().getName())
                        .userId(teamUser.getUser().getId())
                        .userName(teamUser.getUser().getName())
                        .userEmail(teamUser.getUser().getEmail())
                        .role(teamUser.getRole())
                        .build())
                .toList();

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/users/{userId}")
    public ResponseEntity<TeamUserResponse> updateTeamUserRole(
            @PathVariable UUID teamId,
            @PathVariable UUID userId,
            @Valid @RequestBody UpdateTeamUserRoleRequest request
            ){
        TeamUser teamUser = teamUserService.updateTeamUserRole(teamId, userId, request.getRole());

        TeamUserResponse response = TeamUserResponse.builder()
                .id(teamUser.getId())
                .teamId(teamUser.getTeam().getId())
                .teamName(teamUser.getTeam().getName())
                .userId(teamUser.getUser().getId())
                .userName(teamUser.getUser().getName())
                .userEmail(teamUser.getUser().getEmail())
                .role(teamUser.getRole())
                .build();

        return ResponseEntity.ok(response);
    }
}
