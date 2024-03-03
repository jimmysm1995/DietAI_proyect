package com.backend.DietAIbackend.dto;

import java.util.List;

public record LoginResponse(String username,Long idUser, List<String> authorities, String token) {
}
