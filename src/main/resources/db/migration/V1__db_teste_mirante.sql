CREATE TABLE tb_cidades
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    nome            VARCHAR(50),
    estado          VARCHAR(2),
    cep             VARCHAR(9),
    renda_per_capta DOUBLE PRECISION,
    populacao       BIGINT,
    idh             FLOAT,
    latitude        DOUBLE PRECISION,
    longitude       DOUBLE PRECISION,
    CONSTRAINT pk_tb_cidades PRIMARY KEY (id)
);