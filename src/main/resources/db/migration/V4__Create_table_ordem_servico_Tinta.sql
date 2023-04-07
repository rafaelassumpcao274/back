DROP TABLE IF EXISTS `ordem_servico_tinta`;

CREATE TABLE `ordemservico_tinta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ordem_servico` int DEFAULT NULL,
  `tinta` int DEFAULT NULL,
  `frenteVerso` varchar(7) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `userInc` varchar(100) DEFAULT NULL,
  `userUpdate` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ordem_servico` (`ordem_servico`),
  KEY `tinta` (`tinta`),
  CONSTRAINT `ordem_servico_tinta_ibfk_1` FOREIGN KEY (`ordem_servico`) REFERENCES `ordem_de_servico` (`id`),
  CONSTRAINT `ordem_servico_tinta_ibfk_2` FOREIGN KEY (`tinta`) REFERENCES `tinta` (`id`)
);