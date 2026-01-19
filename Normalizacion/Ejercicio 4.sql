CREATE TABLE "Pelicula" (
  "cod_pelicula" int PRIMARY KEY,
  "titulo" varchar,
  "categoria" varchar
);

CREATE TABLE "Cassette" (
  "cod_cassette" int PRIMARY KEY,
  "formato" varchar,
  "cod_pelicula" int
);

CREATE TABLE "Actor" (
  "cod_actor" int PRIMARY KEY,
  "nom_actor" varchar,
  "fechanac_actor" date
);

CREATE TABLE "Pelicula_Actor" (
  "cod_pelicula" int,
  "cod_actor" int,
  PRIMARY KEY ("cod_pelicula", "cod_actor")
);

CREATE TABLE "Cliente" (
  "cod_cliente" int PRIMARY KEY,
  "num_membresia" int,
  "nom_cliente" varchar,
  "dir_cliente" varchar,
  "telef_cliente" varchar
);

CREATE TABLE "Alquiler" (
  "cod_alquiler" int PRIMARY KEY,
  "cod_cliente" int,
  "fecha_alquiler" date,
  "fecha_dev" date,
  "valor_alquiler" decimal
);

CREATE TABLE "Detalle_Alquiler" (
  "cod_alquiler" int,
  "cod_cassette" int,
  "cantidad" int,
  PRIMARY KEY ("cod_alquiler", "cod_cassette")
);

ALTER TABLE "Cassette" ADD FOREIGN KEY ("cod_pelicula") REFERENCES "Pelicula" ("cod_pelicula");

ALTER TABLE "Pelicula_Actor" ADD FOREIGN KEY ("cod_pelicula") REFERENCES "Pelicula" ("cod_pelicula");

ALTER TABLE "Pelicula_Actor" ADD FOREIGN KEY ("cod_actor") REFERENCES "Actor" ("cod_actor");

ALTER TABLE "Alquiler" ADD FOREIGN KEY ("cod_cliente") REFERENCES "Cliente" ("cod_cliente");

ALTER TABLE "Detalle_Alquiler" ADD FOREIGN KEY ("cod_alquiler") REFERENCES "Alquiler" ("cod_alquiler");

ALTER TABLE "Detalle_Alquiler" ADD FOREIGN KEY ("cod_cassette") REFERENCES "Cassette" ("cod_cassette");
