CREATE TABLE topicos(
    id bigint not null generated always as identity,
    titulo varchar(100)not null UNIQUE,
    mensaje varchar(500) varchar UNIQUE,
    fecha_creacion timestamp not null,
    status varchar(20) not null,
    curso varchar(100) not null,

    PRIMARY KEY (id)
);