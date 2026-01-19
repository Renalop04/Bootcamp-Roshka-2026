set search_path TO Ejercicio5;

CREATE TABLE "Colegio" (
  "id_colegio" int PRIMARY KEY,
  "nombre" varchar
);

CREATE TABLE "Profesor" (
  "id_profesor" int PRIMARY KEY,
  "nombre" varchar
);

CREATE TABLE "Asignatura" (
  "id_asignatura" int PRIMARY KEY,
  "nombre" varchar
);

CREATE TABLE "Curso" (
  "id_curso" int PRIMARY KEY,
  "nombre" varchar
);

CREATE TABLE "Aula" (
  "id_aula" int PRIMARY KEY,
  "nombre" varchar
);

CREATE TABLE "Editorial" (
  "id_editorial" int PRIMARY KEY,
  "nombre" varchar
);

CREATE TABLE "Libro" (
  "id_libro" int PRIMARY KEY,
  "titulo" varchar,
  "id_editorial" int
);

CREATE TABLE "Docencia" (
  "id_profesor" int,
  "id_asignatura" int,
  "id_curso" int,
  "id_aula" int,
  "id_colegio" int,
  PRIMARY KEY ("id_profesor", "id_asignatura", "id_curso", "id_aula", "id_colegio")
);

CREATE TABLE "Prestamo_Libro" (
  "id_prestamo" int PRIMARY KEY,
  "fecha_prestamo" date,
  "id_libro" int,
  "id_profesor" int,
  "id_colegio" int
);

ALTER TABLE "Libro" ADD FOREIGN KEY ("id_editorial") REFERENCES "Editorial" ("id_editorial");

ALTER TABLE "Docencia" ADD FOREIGN KEY ("id_profesor") REFERENCES "Profesor" ("id_profesor");

ALTER TABLE "Docencia" ADD FOREIGN KEY ("id_asignatura") REFERENCES "Asignatura" ("id_asignatura");

ALTER TABLE "Docencia" ADD FOREIGN KEY ("id_curso") REFERENCES "Curso" ("id_curso");

ALTER TABLE "Docencia" ADD FOREIGN KEY ("id_aula") REFERENCES "Aula" ("id_aula");

ALTER TABLE "Docencia" ADD FOREIGN KEY ("id_colegio") REFERENCES "Colegio" ("id_colegio");

ALTER TABLE "Prestamo_Libro" ADD FOREIGN KEY ("id_libro") REFERENCES "Libro" ("id_libro");

ALTER TABLE "Prestamo_Libro" ADD FOREIGN KEY ("id_profesor") REFERENCES "Profesor" ("id_profesor");

ALTER TABLE "Prestamo_Libro" ADD FOREIGN KEY ("id_colegio") REFERENCES "Colegio" ("id_colegio");
