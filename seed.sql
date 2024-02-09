create table public.cliente
(
    id     serial primary key,
    limite bigint not null,
    saldo  bigint default 0
);

create table public.transacao
(
    cliente_id integer not null constraint transacao_cliente_id_fkey references cliente,
    id         serial primary key,
    data       timestamp(6),
    valor      bigint  not null,
    descricao  varchar(255),
    tipo       varchar(255) constraint transacao_tipo_check check ((tipo)::text = ANY ((ARRAY ['d'::character varying, 'c'::character varying])::text[]))
);


CREATE INDEX TRANSACAO_DATA ON TRANSACAO (DATA DESC);

INSERT INTO public.cliente (id, limite, saldo)
VALUES (1, 100000, 0),
       (2, 80000, 0),
       (3, 1000000, 0),
       (4, 10000000, 0),
       (5, 500000, 0);

