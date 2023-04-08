DROP TABLE IF EXISTS `via_cores`;

CREATE TABLE `via_cores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(10) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `userInc` varchar(100) DEFAULT NULL,
  `userUpdate` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
  );
