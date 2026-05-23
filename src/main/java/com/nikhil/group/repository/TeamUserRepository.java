package com.nikhil.group.repository;

import com.nikhil.group.entity.TeamUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamUserRepository extends JpaRepository<TeamUser, UUID> {
}
