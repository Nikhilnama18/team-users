package com.nikhil.group.service;

import com.nikhil.group.entity.Team;
import com.nikhil.group.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public Team createTeam(String name) {
        Team team = Team.builder()
                .name(name)
                .build();

        return teamRepository.save(team);
    }

    public Team getTeamById(UUID teamId) {
        return teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));
    }

}
