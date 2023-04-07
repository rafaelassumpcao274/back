DROP TABLE IF EXISTS `ordemservico_vias`;

CREATE TABLE `ordemservico_vias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ordem_servico` int DEFAULT NULL,
  `vias` int DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `userInc` varchar(100) DEFAULT NULL,
  `userUpdate` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ordem_servico` (`ordem_servico`),
  KEY `vias` (`vias`),
  CONSTRAINT `ordemservico_vias_ibfk_1` FOREIGN KEY (`ordem_servico`) REFERENCES `ordem_de_servico` (`id`),
  CONSTRAINT `ordemservico_vias_ibfk_2` FOREIGN KEY (`vias`) REFERENCES `via_cores` (`id`)
);