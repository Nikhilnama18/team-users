package com.nikhil.group.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Builder
public class TeamResponse {
    private UUID id;
    private String name;
}
