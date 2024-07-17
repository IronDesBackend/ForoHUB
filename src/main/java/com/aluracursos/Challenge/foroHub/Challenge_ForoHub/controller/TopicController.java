package com.aluracursos.Challenge.foroHub.Challenge_ForoHub.controller;

import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.dto.ActualiceTopic;
import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.dto.DatailsTopic;
import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.dto.DetailsListTopic;
import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.dto.DetailsRegisterTopic;
import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.models.Topic;
import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.repository.TopicRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    @Transactional
    public ResponseEntity insertTopico(
            @RequestBody
            @Valid
            DetailsRegisterTopic detailsRegisterTopic,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        var topico = new Topic(detailsRegisterTopic);
        topicRepository.save(topico);

        var uri = uriComponentsBuilder.path("/topicos/{id}")
                .buildAndExpand(topico.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new DatailsTopic(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DetailsListTopic>> datosListaTopicos(
            @PageableDefault
            (size = 5, sort = {"curso"}) Pageable pageable
    ) {
        var page = topicRepository.findAll(pageable)
                .map(DetailsListTopic::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTopico(
            @RequestBody
            @Valid
            ActualiceTopic datosActualiceTopic
    ) {
        var topico = topicRepository.getReferenceById(datosActualiceTopic.id());
        topico.actualizarInformacion(datosActualiceTopic);
        return ResponseEntity.ok(new DatailsTopic(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteTopico(
            @PathVariable Long id
    ) {
        Topic topic = topicRepository.findById(id)
                .orElse(null);
        if (topic == null) {
            return ResponseEntity.noContent().build();
        }
        topicRepository.delete(topic);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity readTopico(@PathVariable Long id) {
        var topico = topicRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatailsTopic(topico));
    }
}
