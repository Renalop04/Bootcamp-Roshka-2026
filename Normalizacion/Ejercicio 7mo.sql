CREATE TABLE "Prestamos_libros" (
  "codLibro" int,
  "ID_nombreLector" int,
  "Fechadev" date,
  PRIMARY KEY ("codLibro", "ID_nombreLector")
);

CREATE TABLE "libros" (
  "codLibro" int PRIMARY KEY,
  "Autor" varchar,
  "Editorial" varchar
);

CREATE TABLE "Solicitante" (
  "ID_nombreLector" int PRIMARY KEY,
  "nombreLector" varchar
);

ALTER TABLE "Prestamos_libros" ADD FOREIGN KEY ("ID_nombreLector") REFERENCES "Solicitante" ("ID_nombreLector");

ALTER TABLE "Prestamos_libros" ADD FOREIGN KEY ("codLibro") REFERENCES "libros" ("codLibro");
