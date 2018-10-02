/*
 * http://localhost:8080/h2-console
 * 
 * JDBC URL: jdbc:h2:mem:testdb
 * 
 */

DROP TABLE CAMAREROS IF EXISTS;
DROP TABLE PRODUCTOS IF EXISTS;

CREATE TABLE CAMAREROS (
	ID				BIGINT			NOT NULL,
	NOMBRE			VARCHAR(100)	NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE PRODUCTOS (
	CODIGO			BIGINT			NOT NULL,
	NOMBRE			VARCHAR(100)	NOT NULL,
	PRECIO			DOUBLE			NOT NULL,
	DESCRIPCION		VARCHAR(100)	NOT NULL,
	FECHA_ALTA		TIMESTAMP		NOT NULL,
	DESCATALOGADO	BOOLEAN			NOT NULL,
	CATEGORIA		VARCHAR(100)	NOT NULL,
	PRIMARY KEY(CODIGO)
);
