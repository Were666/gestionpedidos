INSERT INTO SECUENCIAS VALUES
('LINEAS_PEDIDO_SEQ',1000),
('CLIENTE_SEQ',1000),
('PEDIDO_SEQ',1000);

INSERT INTO CAMAREROS VALUES
(100,'Pepín Gálvez Ridruejo'),
(101,'Honorio Martín Salvador'),
(102,'Anna Vílchez Andrés');

INSERT INTO PRODUCTOS VALUES
(1,'café solo', 1.20, 'Descripción Producto A','2015-10-20 00:00:00',false,'CAFE'),
(2,'café con leche', 1.40, 'Descripción Producto B','2015-10-20 00:00:00',false,'CAFE'),
(3,'café cortado', 1.30, 'Descripción Producto C','2015-10-20 00:00:00',false,'CAFE'),
(4,'plato combinado', 8.00, 'Descripción Producto D','2015-10-20 00:00:00',false,'COMIDA');

INSERT INTO PEDIDOS VALUES
(1,'2018-10-20 00:00:00',10,100),
(2,'2018-10-20 00:00:00',10,101);

INSERT INTO LINEAS_PEDIDO (ID_PEDIDO, INDICE, ID_PRODUCTO,CANTIDAD,PRECIO) VALUES
(1,2,4,1,1.20),
(1,1,2,1,1.40),
(1,0,1,3,8.00),
(2,0,1,1,1.20),
(2,1,3,1,1.30);

INSERT INTO CLIENTES (ID, NOMBRE) VALUES
(1,'CLIENTE 1'),
(2,'CLIENTE 2'),
(3,'CLIENTE 3'),
(4,'CLIENTE 4'),
(5,'CLIENTE 5');

INSERT INTO CONTACTOS_CLIENTE (NOMBRE, TELEFONO, ID_CLIENTE) VALUES
('Contacto 1','932314455',1),
('Contacto 2','932314455',1),
('Contacto 3','932314455',1),
('Contacto 4','932314455',2),
('Contacto 5','932314455',2),
('Contacto 6','932314455',3),
('Contacto 7','932314455',3),
('Contacto 8','932314455',3),
('Contacto 9','932314455',4),
('Contacto 10','932314455',5);






