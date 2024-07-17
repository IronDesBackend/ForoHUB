package com.aluracursos.Challenge.foroHub.Challenge_ForoHub.dto;

import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.models.Curse;
import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.models.Topic;

import java.time.LocalDateTime;

public record DatailsTopic(
        String titulo,
        String mensaje,
        LocalDateTime fechaPublicación,
        Curse curse
) {
    public DatailsTopic(Topic topic) {
        this(topic.getTitulo(), topic.getMensaje(),
                topic.getFechaPublicacion(), topic.getCurso());
    }
}
