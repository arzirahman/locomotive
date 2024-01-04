CREATE DATABASE locomotif;
\c locomotif;
CREATE TABLE locomotif_summary (
  id uuid not null,
  total_locomotif int4 not null,
  total_locomotif_poor int4 not null,
  total_locomotif_good int4 not null,
  total_locomotif_excellent int4 not null,
  last_modified_time timestamp null,
  constraint pk_locomotif_summary primary key (id)
);