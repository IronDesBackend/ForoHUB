CREATE TABLE usuarios (
    id bigint not null generated always as identity,
    login varchar(100) not null,
    password varchar(255) not null,

    PRIMARY KEY(id)
);