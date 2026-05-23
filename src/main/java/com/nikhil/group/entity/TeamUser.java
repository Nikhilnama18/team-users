package com.nikhil.group.entity;

import com.nikhil.group.enums.TeamRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "team_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamUser {
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "user_id", nullable = false)
    private User user;

    private TeamRole role;
}
