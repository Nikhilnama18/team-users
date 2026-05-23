package com.nikhil.group.controller;

import com.nikhil.group.dto.request.CreateTeamRequest;
import com.nikhil.group.dto.response.TeamResponse;
import com.nikhil.group.entity.Team;
import com.nikhil.group.service.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @PostMapping
    public ResponseEntity<TeamResponse> createTeam(@Valid @RequestBody CreateTeamRequest request){
        Team team = teamService.createTeam(request.getName());

        TeamResponse response = TeamResponse.builder()
                .id(team.getId())
                .name(team.getName())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
