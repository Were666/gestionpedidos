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

(4,'Pollo Kim Jong-un', 11.00, 'Delicioso pollo con arroz y setas','2015-10-20 00:00:00',false,'COMIDA'),
(5,'Pollo Jimmy Carter', 11.60, 'Delicioso pollo con salsa tejana y patata fritas','2015-10-20 00:00:00',false,'COMIDA'),
(6,'Pollo Fidel', 10.00, 'Delicioso pollo con cebolla y naranja ','2015-10-20 00:00:00',false,'COMIDA'),
(7,'Croquetas de Jamón', 6.00, '3 croquetas del mejor jamón','2015-10-20 00:00:00',false,'COMIDA'),
(8,'Patatas Bravas', 8.00, 'Patatas Bravas con salsa picante especialidad de la casa','2015-10-20 00:00:00',false,'COMIDA'),

(9,'CocaCola 33cl', 1.60, 'Botella de cocacola de 33cl','2015-10-20 00:00:00',false,'REFRESCO'),
(10,'Fanta Naranja 33cl', 1.60, 'Botella de Fanta Naranja de 33cl','2015-10-20 00:00:00',false,'REFRESCO'),
(11,'Fanta Limón 33cl', 1.60, 'Botella de Fanta Limón de 33cl','2015-10-20 00:00:00',false,'REFRESCO'),
(12,'CocaCola Zero 33cl', 1.60, 'Botella de CocaCola Zero de 33cl','2015-10-20 00:00:00',false,'REFRESCO'),

(13,'Macarrones Boloñesa', 8.40, 'Macarrones boloñesa','2015-10-20 00:00:00',false,'COMIDA'),
(14,'Hamburguesa Hulk', 9.50, 'Hamburquesa con patatas fritas y salsa roquefort','2015-10-20 00:00:00',false,'COMIDA'),
(15,'Hamburguesa Clásica', 8.00, 'Hamburguesa con tomate y cebolla acompañada con patatas y ','2015-10-20 00:00:00',false,'COMIDA'),
(16,'Risotto de Setas', 11.20, 'Risotto con setas de la Cerdanya','2015-10-20 00:00:00',false,'COMIDA'),

(17,'Cerveza Pilsner Urquell', 2.70, 'La mejor cerveza checa 4,7%','2015-10-20 00:00:00',false,'CERVEZA'),
(18,'Cerveza Heineken', 2.10, 'La mejor cerveza holandesa 5,0%','2015-10-20 00:00:00',false,'CERVEZA'),
(19,'Estrella Damm', 1.80, 'Cerveza rubia 5,0%','2015-10-20 00:00:00',false,'CERVEZA'),
(20,'Estrella Galicia', 1.80, 'Cerveza rubia 4,9%','2015-10-20 00:00:00',false,'CERVEZA'),

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
(31,'Producto 31', 8.00, 'Descripción Producto 31','2015-10-20 00:00:00',true,'COMIDA'),
(32,'Producto 32', 8.00, 'Descripción Producto 32','2015-10-20 00:00:00',false,'COMIDA'),
(33,'Producto 33', 8.00, 'Descripción Producto 33','2015-10-20 00:00:00',false,'COMIDA'),
(34,'Producto 34', 8.00, 'Descripción Producto 34','2015-10-20 00:00:00',false,'COMIDA'),
(35,'Producto 35', 8.00, 'Descripción Producto 35','2015-10-20 00:00:00',false,'COMIDA'),
(36,'Producto 36', 8.00, 'Descripción Producto 36','2015-10-20 00:00:00',false,'COMIDA'),
(37,'Producto 37', 8.00, 'Descripción Producto 37','2015-10-20 00:00:00',true,'COMIDA'),
(38,'Producto 38', 8.00, 'Descripción Producto 38','2015-10-20 00:00:00',false,'COMIDA'),
(39,'Producto 39', 8.00, 'Descripción Producto 39','2015-10-20 00:00:00',false,'COMIDA'),
(40,'Producto 40', 8.00, 'Descripción Producto 40','2015-10-20 00:00:00',false,'COMIDA'),
(41,'Producto 41', 8.00, 'Descripción Producto 41','2015-10-20 00:00:00',false,'COMIDA');

INSERT INTO PEDIDOS VALUES
(1,'2018-10-20 17:22:14',10,100),
(2,'2018-10-20 18:40:31',10,101),
(3,'2018-10-20 18:42:55',11,101),
(4,'2018-10-20 19:10:07',10,101),
(5,'2018-10-20 19:15:32',12,100),
(6,'2018-10-20 19:21:44',10,101),
(7,'2018-10-20 19:58:10',10,100),
(8,'2018-10-21 09:05:22',10,101),
(9,'2018-10-21 09:06:41',11,101),
(10,'2018-10-21 09:18:35',14,101);

INSERT INTO LINEAS_PEDIDO (ID_PEDIDO, INDICE, ID_PRODUCTO,CANTIDAD,PRECIO) VALUES
(1,0,4,1,11.0),
(1,1,6,2,10.0),
(1,2,9,2,1.6),
(1,3,20,2,1.8),
(1,4,15,1,8.00),
(1,5,17,1,2.70),
(1,6,1,2,1.20),
(1,7,3,1,1.30),

(2,0,1,1,1.20),
(2,1,3,1,1.30),

(3,0,1,1,1.20),
(3,1,9,4,1.60),
(3,2,17,2,2.70),
(3,3,20,1,1.80),
(3,4,12,2,1.60),

(4,0,20,8,1.80),
(4,1,19,4,1.80),
(4,2,17,2,2.70),

(5,0,7,3,6),
(5,1,19,2,1.80),
(5,2,8,1,8),
(5,3,9,1,1.60),
(5,4,20,1,1.80),
(5,5,12,1,1.60),

(6,0,17,1,2.70),

(7,0,4,2,11),
(7,1,6,1,10),
(7,2,8,1,8),
(7,3,14,1,9.5),
(7,4,16,2,11.20),
(7,5,9,2,1.60),
(7,6,10,1,1.60),
(7,7,12,1,1.60),
(7,8,18,1,2.10),
(7,9,20,2,1.80),
(7,10,1,4,1.20),
(7,11,3,1,1.30);














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






