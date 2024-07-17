package com.aluracursos.Challenge.foroHub.Challenge_ForoHub.dto;

import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.models.Curse;
import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.models.Topic;

public record DetailsListTopic(Long id, String titulo, String mensaje, Curse curso) {
    public DetailsListTopic(Topic topic) {
        this(topic.getId(), topic.getTitulo(), topic.getMensaje(), topic.getCurso());
    }
}
