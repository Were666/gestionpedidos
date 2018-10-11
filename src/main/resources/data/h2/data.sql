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
(4,'plato combinado', 8.00, 'Descripción Producto D','2015-10-20 00:00:00',false,'COMIDA'),
(5,'Producto 5', 8.00, 'Descripción Producto 5','2015-10-20 00:00:00',false,'COMIDA'),
(6,'Producto 6', 8.00, 'Descripción Producto 6','2015-10-20 00:00:00',false,'COMIDA'),
(7,'Producto 7', 8.00, 'Descripción Producto 7','2015-10-20 00:00:00',false,'COMIDA'),
(8,'Producto 8', 8.00, 'Descripción Producto 8','2015-10-20 00:00:00',false,'COMIDA'),
(9,'Producto 9', 8.00, 'Descripción Producto 9','2015-10-20 00:00:00',false,'COMIDA'),
(10,'Producto 10', 8.00, 'Descripción Producto 10','2015-10-20 00:00:00',false,'COMIDA'),
(11,'Producto 11', 8.00, 'Descripción Producto 11','2015-10-20 00:00:00',false,'COMIDA'),
(12,'Producto 12', 8.00, 'Descripción Producto 12','2015-10-20 00:00:00',false,'COMIDA'),
(13,'Producto 13', 8.00, 'Descripción Producto 13','2015-10-20 00:00:00',false,'COMIDA'),
(14,'Producto 14', 8.00, 'Descripción Producto 14','2015-10-20 00:00:00',false,'COMIDA'),
(15,'Producto 15', 8.00, 'Descripción Producto 15','2015-10-20 00:00:00',false,'COMIDA'),
(16,'Producto 16', 8.00, 'Descripción Producto 16','2015-10-20 00:00:00',false,'COMIDA'),
(17,'Producto 17', 8.00, 'Descripción Producto 17','2015-10-20 00:00:00',false,'COMIDA'),
(18,'Producto 18', 8.00, 'Descripción Producto 18','2015-10-20 00:00:00',false,'COMIDA'),
(19,'Producto 19', 8.00, 'Descripción Producto 19','2015-10-20 00:00:00',false,'COMIDA'),
(20,'Producto 20', 8.00, 'Descripción Producto 20','2015-10-20 00:00:00',false,'COMIDA'),
(21,'Producto 21', 8.00, 'Descripción Producto 21','2015-10-20 00:00:00',false,'COMIDA'),
(22,'Producto 22', 8.00, 'Descripción Producto 22','2015-10-20 00:00:00',false,'COMIDA'),
(23,'Producto 23', 8.00, 'Descripción Producto 23','2015-10-20 00:00:00',false,'COMIDA'),
(24,'Producto 24', 8.00, 'Descripción Producto 24','2015-10-20 00:00:00',false,'COMIDA'),
(25,'Producto 25', 8.00, 'Descripción Producto 25','2015-10-20 00:00:00',false,'COMIDA'),
(26,'Producto 26', 8.00, 'Descripción Producto 26','2015-10-20 00:00:00',false,'COMIDA'),
(27,'Producto 27', 8.00, 'Descripción Producto 27','2015-10-20 00:00:00',false,'COMIDA'),
(28,'Producto 28', 8.00, 'Descripción Producto 28','2015-10-20 00:00:00',false,'COMIDA'),
(29,'Producto 29', 8.00, 'Descripción Producto 29','2015-10-20 00:00:00',false,'COMIDA'),
(30,'Producto 30', 8.00, 'Descripción Producto 30','2015-10-20 00:00:00',false,'COMIDA'),
(31,'Producto 31', 8.00, 'Descripción Producto 31','2015-10-20 00:00:00',false,'COMIDA'),
(32,'Producto 32', 8.00, 'Descripción Producto 32','2015-10-20 00:00:00',false,'COMIDA'),
(33,'Producto 33', 8.00, 'Descripción Producto 33','2015-10-20 00:00:00',false,'COMIDA'),
(34,'Producto 34', 8.00, 'Descripción Producto 34','2015-10-20 00:00:00',false,'COMIDA'),
(35,'Producto 35', 8.00, 'Descripción Producto 35','2015-10-20 00:00:00',false,'COMIDA'),
(36,'Producto 36', 8.00, 'Descripción Producto 36','2015-10-20 00:00:00',false,'COMIDA'),
(37,'Producto 37', 8.00, 'Descripción Producto 37','2015-10-20 00:00:00',false,'COMIDA'),
(38,'Producto 38', 8.00, 'Descripción Producto 38','2015-10-20 00:00:00',false,'COMIDA'),
(39,'Producto 39', 8.00, 'Descripción Producto 39','2015-10-20 00:00:00',false,'COMIDA'),
(40,'Producto 40', 8.00, 'Descripción Producto 40','2015-10-20 00:00:00',false,'COMIDA'),
(41,'Producto 41', 8.00, 'Descripción Producto 41','2015-10-20 00:00:00',false,'COMIDA');

INSERT INTO PEDIDOS VALUES
(1,'2018-10-20 17:22:14',10,100),
(2,'2018-10-20 18:40:31',10,101);

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






