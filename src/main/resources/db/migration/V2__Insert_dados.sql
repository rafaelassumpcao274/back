LOCK TABLES `uf` WRITE;

INSERT INTO `uf` VALUES (1,'Pr','2022-09-03 14:52:00','2022-09-03 14:52:00','Rafael','Rafael'),
(2,'Sc','2022-09-03 14:52:00','2022-09-03 14:52:00','Rafael','Rafael'),
(3,'Sp','2022-09-03 14:52:00','2022-09-03 14:52:00','Rafael','Rafael');

UNLOCK TABLES;



LOCK TABLES `cidades` WRITE;

INSERT INTO `cidades` VALUES (1,'Curitiba',1,'2022-09-06 00:32:28','2022-09-06 00:32:28','Rafael','Rafael');

UNLOCK TABLES;


LOCK TABLES `bairros` WRITE;

INSERT INTO `bairros` VALUES (1,'CIC',1,'2022-09-06 00:32:28','2022-09-06 00:32:28','Rafael','Rafael');

UNLOCK TABLES;




LOCK TABLES `enderecos` WRITE;

INSERT INTO `enderecos` VALUES (1,'Estrada velha',81450020,1,'2022-09-06 00:32:28','2022-09-06 00:32:28','Rafael','Rafael');

UNLOCK TABLES;



LOCK TABLES `empresas` WRITE;

INSERT INTO `empresas` VALUES (1,'Rafateste','Teste ltda',44444444444444,'teste@teste.com',1,'Gabriel',NULL,'2022-09-06 00:32:28','2022-09-06 00:32:28','Rafael','Rafael');

UNLOCK TABLES;


LOCK TABLES `tinta` WRITE;

INSERT INTO `tinta` VALUES (1,'Preto','2022-09-06 00:30:55','2022-09-06 00:30:55','Rafael','Rafael'),
(2,'Amarelo','2022-09-06 00:30:55','2022-09-06 00:30:55','Rafael','Rafael'),
(3,'Ciano','2022-09-06 00:30:55','2022-09-06 00:30:55','Rafael','Rafael'),
(4,'Magenta','2022-09-06 00:30:55','2022-09-06 00:30:55','Rafael','Rafael'),
(5,'Verde Bandeira','2022-09-06 00:30:55','2022-09-06 00:30:55','Rafael','Rafael');

UNLOCK TABLES;


LOCK TABLES `papel` WRITE;

INSERT INTO `papel` VALUES (1,500,'Offset 56gr','2022-09-03 14:52:00','2022-09-03 14:52:00','Rafael','Rafael');

UNLOCK TABLES;



LOCK TABLES `material` WRITE;

UNLOCK TABLES;


LOCK TABLES `formato` WRITE;

INSERT INTO `formato` VALUES (1,'F9 22X32','2022-09-03 14:52:00','2022-09-03 14:52:00','Rafael','Rafael'),
(2,'F18 22X16','2022-09-03 14:52:00','2022-09-03 14:52:00','Rafael','Rafael'),
(3,'F16 22X16,5','2022-09-03 14:52:00','2022-09-03 14:52:00','Rafael','Rafael');

UNLOCK TABLES;



LOCK TABLES `acabamento` WRITE;

INSERT INTO `acabamento` VALUES (1,'Picote','2022-09-06 00:31:04','2022-09-06 00:31:04','Rafael','Rafael'),
(2,'Cole','2022-09-06 00:31:04','2022-09-06 00:31:04','Rafael','Rafael'),
(3,'Corte e Vinco','2022-09-06 00:31:04','2022-09-06 00:31:04','Rafael','Rafael'),
(4,'Meio Corte','2022-09-06 00:31:04','2022-09-06 00:31:04','Rafael','Rafael'),
(5,'Plastificação Brilho','2022-09-06 00:31:04','2022-09-06 00:31:04','Rafael','Rafael'),
(6,'Plastificação Fosca','2022-09-06 00:31:04','2022-09-06 00:31:04','Rafael','Rafael'),
(7,'Laminação Fosca','2022-09-06 00:31:04','2022-09-06 00:31:04','Rafael','Rafael'),
(8,'Verniz UV Total','2022-09-06 00:31:04','2022-09-06 00:31:04','Rafael','Rafael'),
(9,'Verniz UV Localizado','2022-09-06 00:31:04','2022-09-06 00:31:04','Rafael','Rafael'),
(10,'Dobra','2022-09-06 00:31:04','2022-09-06 00:31:04','Rafael','Rafael'),
(11,'Grampo','2022-09-06 00:31:04','2022-09-06 00:31:04','Rafael','Rafael');
;
UNLOCK TABLES;




LOCK TABLES `suprimentos` WRITE;

UNLOCK TABLES;



LOCK TABLES `distribuidora_tinta` WRITE;

UNLOCK TABLES;


LOCK TABLES `distribuidora_papel` WRITE;

UNLOCK TABLES;



LOCK TABLES `distribuidora_material` WRITE;

UNLOCK TABLES;



LOCK TABLES `ordem_de_servico` WRITE;

UNLOCK TABLES;



LOCK TABLES `ordemservico_acabamento` WRITE;

UNLOCK TABLES;


LOCK TABLES `orcamento` WRITE;

UNLOCK TABLES;



