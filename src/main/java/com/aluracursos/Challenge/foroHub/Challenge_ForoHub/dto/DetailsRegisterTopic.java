package com.aluracursos.Challenge.foroHub.Challenge_ForoHub.dto;

import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.models.Curse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DetailsRegisterTopic(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull @Valid Curse curso
) {
}
