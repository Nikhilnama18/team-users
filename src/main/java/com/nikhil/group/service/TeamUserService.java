package com.nikhil.group.service;

import com.nikhil.group.entity.Team;
import com.nikhil.group.entity.TeamUser;
import com.nikhil.group.entity.User;
import com.nikhil.group.enums.TeamRole;
import com.nikhil.group.repository.TeamRepository;
import com.nikhil.group.repository.TeamUserRepository;
import com.nikhil.group.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeamUserService {
    private final TeamUserRepository teamUserRepository;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    public TeamUser createTeamUser(UUID teamId, UUID userId, TeamRole role){
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        TeamUser teamUser = TeamUser.builder()
                .team(team)
                .user(user)
                .role(role)
                .build();

        return teamUserRepository.save(teamUser);
    }

    public List<TeamUser> getUsersByTeam(UUID teamId){

        if (!teamRepository.existsById(teamId)) {
            throw new RuntimeException("Team not found");
        }

        return teamUserRepository.findByTeamId(teamId);
    }
}
