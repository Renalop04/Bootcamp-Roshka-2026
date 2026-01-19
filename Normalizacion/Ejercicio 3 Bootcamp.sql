CREATE TABLE "ciudad" (
  "cod_ciudad" varchar PRIMARY KEY,
  "nombre_ciudad" varchar
);

CREATE TABLE "empresa_origen" (
  "orgn_rif" varchar PRIMARY KEY,
  "orgn_nom" varchar,
  "orgn_act" varchar,
  "cod_ciudad" varchar,
  "orgn_dir" varchar,
  "orgn_tel" varchar,
  "orgn_cel" varchar
);

CREATE TABLE "destinatario" (
  "dest_id" varchar PRIMARY KEY,
  "dest_nom" varchar,
  "dest_dir" varchar,
  "cod_ciudad" varchar,
  "dest_tel" varchar
);

CREATE TABLE "paquete" (
  "codigo" varchar PRIMARY KEY,
  "tipo" varchar,
  "nombre" varchar,
  "descripcion" text
);

CREATE TABLE "guia" (
  "guia_no" integer PRIMARY KEY,
  "guia_fecha" date,
  "guia_hora" time,
  "valr_flete" decimal,
  "orgn_rif" varchar,
  "dest_id" varchar
);

CREATE TABLE "detalle_guia" (
  "guia_no" integer,
  "codigo" varchar,
  PRIMARY KEY ("guia_no", "codigo")
);

ALTER TABLE "empresa_origen" ADD FOREIGN KEY ("cod_ciudad") REFERENCES "ciudad" ("cod_ciudad");

ALTER TABLE "destinatario" ADD FOREIGN KEY ("cod_ciudad") REFERENCES "ciudad" ("cod_ciudad");

ALTER TABLE "guia" ADD FOREIGN KEY ("orgn_rif") REFERENCES "empresa_origen" ("orgn_rif");

ALTER TABLE "guia" ADD FOREIGN KEY ("dest_id") REFERENCES "destinatario" ("dest_id");

ALTER TABLE "detalle_guia" ADD FOREIGN KEY ("guia_no") REFERENCES "guia" ("guia_no");

ALTER TABLE "detalle_guia" ADD FOREIGN KEY ("codigo") REFERENCES "paquete" ("codigo");
