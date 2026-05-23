package com.nikhil.group.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TeamResponse {
    private UUID id;
    private String name;
}
