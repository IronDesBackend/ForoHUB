package com.aluracursos.Challenge.foroHub.Challenge_ForoHub.infra.errores;

public class IntegrityValidation extends RuntimeException {
    public IntegrityValidation(String e) {
        super(e);
    }
}
