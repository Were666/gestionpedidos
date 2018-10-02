/*
 * http://localhost:8080/h2-console
 * 
 * JDBC URL: jdbc:h2:mem:testdb
 * 
 * 
 * 
 * 
 */

DROP TABLE CAMAREROS IF EXISTS ;

CREATE TABLE CAMAREROS (
	ID			BIGINT			NOT NULL,
	NOMBRE		VARCHAR(100)	NOT NULL,
	PRIMARY KEY (ID)
);