package com.aluracursos.Challenge.foroHub.Challenge_ForoHub.models;

import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.dto.ActualiceTopic;
import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.dto.DetailsRegisterTopic;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public Curse getCurso() {
        return curso;
    }

    private String mensaje;

    @CreationTimestamp
    private LocalDateTime fechaPublicacion;

    @Enumerated(EnumType.STRING)
    private Curse curso;

    public Topic(DetailsRegisterTopic detailsRegisterTopic) {
        this.titulo = detailsRegisterTopic.titulo();
        this.mensaje = detailsRegisterTopic.mensaje();
        this.fechaPublicacion = LocalDateTime.now();
        this.curso = detailsRegisterTopic.curso();
    }

    public void actualizarInformacion(ActualiceTopic datosActualiceTopic) {
        if(datosActualiceTopic.titulo() != null) {
            this.titulo = datosActualiceTopic.titulo();
        }

        if(datosActualiceTopic.mensaje() != null) {
            this.mensaje = datosActualiceTopic.mensaje();
        }
    }
}
