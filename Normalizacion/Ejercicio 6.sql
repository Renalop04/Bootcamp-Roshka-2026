CREATE TABLE "Alumno" (
  "ID_CODIGO_ALUMNO" int PRIMARY KEY,
  "Nombre_Alumno" varchar,
  "Especialidad" varchar
);

CREATE TABLE "Docente" (
  "ID_Docente" int PRIMARY KEY,
  "Nombre_Docente" varchar,
  "Oficina" varchar
);

CREATE TABLE "Curso" (
  "ID_CODIGO_CURSO" int PRIMARY KEY,
  "Codigo_Curso" varchar,
  "Nombre_Curso" varchar,
  "ID_Docente" int
);

CREATE TABLE "Seccion" (
  "ID_Seccion" int PRIMARY KEY,
  "Seccion" varchar
);

CREATE TABLE "Matriculacion" (
  "ID_CODIGO_ALUMNO" int,
  "ID_CODIGO_CURSO" int,
  "ID_Seccion" int,
  PRIMARY KEY ("ID_CODIGO_ALUMNO", "ID_CODIGO_CURSO")
);

ALTER TABLE "Curso" ADD FOREIGN KEY ("ID_Docente") REFERENCES "Docente" ("ID_Docente");

ALTER TABLE "Matriculacion" ADD FOREIGN KEY ("ID_CODIGO_ALUMNO") REFERENCES "Alumno" ("ID_CODIGO_ALUMNO");

ALTER TABLE "Matriculacion" ADD FOREIGN KEY ("ID_CODIGO_CURSO") REFERENCES "Curso" ("ID_CODIGO_CURSO");

ALTER TABLE "Matriculacion" ADD FOREIGN KEY ("ID_Seccion") REFERENCES "Seccion" ("ID_Seccion");
