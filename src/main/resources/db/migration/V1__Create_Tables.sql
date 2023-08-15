    DROP TABLE IF EXISTS `papel`;
    CREATE TABLE `papel` (
      `id` int NOT NULL AUTO_INCREMENT,
      `quantidade_papel` int DEFAULT NULL,
      `descricao` varchar(255) DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`)
    );

    DROP TABLE IF EXISTS `usuario`;

    CREATE TABLE `usuario`(
      `id` int NOT NULL AUTO_INCREMENT,
      `nome` varchar(255) DEFAULT NULL,
      `password` varchar(255) DEFAULT NULL,
      `email` varchar(255) DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`)
    );

    DROP TABLE IF EXISTS `acabamento`;

    CREATE TABLE `acabamento` (
      `id` int NOT NULL AUTO_INCREMENT,
      `descricao` varchar(255) DEFAULT NULL,
      `createdAt` datetime NOT NULL DEFAULT '2022-09-06 00:31:04',
      `updatedAt` datetime NOT NULL DEFAULT '2022-09-06 00:31:04',
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`)
    );

    DROP TABLE IF EXISTS `material`;

    CREATE TABLE `material` (
      `id` int NOT NULL AUTO_INCREMENT,
      `descricao` varchar(255) DEFAULT NULL,
      `quantidade` int DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`)
    );


    DROP TABLE IF EXISTS `uf`;

    CREATE TABLE `uf` (
      `id` int NOT NULL AUTO_INCREMENT,
      `descricao_uf` varchar(255) DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`)
    );

    DROP TABLE IF EXISTS `tinta`;

    CREATE TABLE `tinta` (
      `id` int NOT NULL AUTO_INCREMENT,
      `descricao` varchar(255) DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`)
    );


    DROP TABLE IF EXISTS `formato`;

    CREATE TABLE `formato` (
      `id` int NOT NULL AUTO_INCREMENT,
      `descricao_formato` varchar(255) DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`)
    );

    DROP TABLE IF EXISTS `telefone`;

    CREATE TABLE `telefone` (
      `id` int NOT NULL AUTO_INCREMENT,
      `cod_area` int DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `descricao_telefone` int DEFAULT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`)
    );

    DROP TABLE IF EXISTS `cidades`;

    CREATE TABLE `cidades` (
      `id` int NOT NULL AUTO_INCREMENT,
      `descricao_cidade` varchar(255) DEFAULT NULL,
      `uf_id` int DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`),
      KEY `uf_id` (`uf_id`),
      CONSTRAINT `cidades_ibfk_1` FOREIGN KEY (`uf_id`) REFERENCES `uf` (`id`)
    );

    DROP TABLE IF EXISTS `bairros`;

    CREATE TABLE `bairros` (
      `id` int NOT NULL AUTO_INCREMENT,
      `descricao_bairro` varchar(255) DEFAULT NULL,
      `cidade_id` int DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`),
      KEY `cidade_id` (`cidade_id`),
      CONSTRAINT `bairros_ibfk_1` FOREIGN KEY (`cidade_id`) REFERENCES `cidades` (`id`)

    );

    DROP TABLE IF EXISTS `enderecos`;

    CREATE TABLE `enderecos` (
      `id` int NOT NULL AUTO_INCREMENT,
      `descricao_endereco` varchar(255) DEFAULT NULL,
      `cep` int DEFAULT NULL,
      `complemento` varchar(50) DEFAULT NULL,
      `numero` int DEFAULT NULL,
      `bairro_id` int DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`),
      KEY `bairro_id` (`bairro_id`),
      CONSTRAINT `enderecos_ibfk_1` FOREIGN KEY (`bairro_id`) REFERENCES `bairros` (`id`)
    );


    DROP TABLE IF EXISTS `empresas`;

    CREATE TABLE `empresas` (
      `id` int NOT NULL AUTO_INCREMENT,
      `nome_empresa` varchar(255) DEFAULT NULL,
      `razao_social` varchar(255) DEFAULT NULL,
      `cnpj` double DEFAULT NULL,
      `email` varchar(255) DEFAULT NULL,
      `endereco_id` int DEFAULT NULL,
      `contato` varchar(255) DEFAULT NULL,
      `telefone` int DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`),
      UNIQUE KEY `cnpj` (`cnpj`),
      KEY `endereco_id` (`endereco_id`),
      CONSTRAINT `empresas_ibfk_1` FOREIGN KEY (`endereco_id`) REFERENCES `enderecos` (`id`)
    );

    DROP TABLE IF EXISTS `acabamento`;

    CREATE TABLE `acabamento` (
      `id` int NOT NULL AUTO_INCREMENT,
      `descricao` varchar(255) DEFAULT NULL,
      `createdAt` datetime NOT NULL DEFAULT '2022-09-06 00:31:04',
      `updatedAt` datetime NOT NULL DEFAULT '2022-09-06 00:31:04',
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`)
    );

    DROP TABLE IF EXISTS `acabamentos`;

    CREATE TABLE `acabamentos` (
      `id` int NOT NULL AUTO_INCREMENT,
      `descricao` varchar(255) DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`)
    );


    DROP TABLE IF EXISTS `ordem_de_servico`;

    CREATE TABLE `ordem_de_servico` (
      `id` int NOT NULL AUTO_INCREMENT,
      `cliente` int DEFAULT NULL,
      `material` varchar(255) DEFAULT NULL,
      `papel` int DEFAULT NULL,
      `cor_frente` varchar(255) DEFAULT NULL,
      `cor_verso` varchar(255) DEFAULT NULL,
      `formato` int DEFAULT NULL,
      `quantidade_folhas` int DEFAULT NULL,
      `numeracao_ini` float DEFAULT NULL,
      `numeracao_final` float DEFAULT NULL,
      `observacao` varchar(255) DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`),
      KEY `papel` (`papel`),
      KEY `formato` (`formato`),
      KEY `cliente` (`cliente`),
      CONSTRAINT `ordem_de_servico_ibfk_1` FOREIGN KEY (`cliente`) REFERENCES `empresas` (`id`) ON UPDATE CASCADE,
      CONSTRAINT `ordem_de_servico_ibfk_2` FOREIGN KEY (`papel`) REFERENCES `papel` (`id`) ON UPDATE CASCADE,
      CONSTRAINT `ordem_de_servico_ibfk_3` FOREIGN KEY (`formato`) REFERENCES `formato` (`id`) ON UPDATE CASCADE
    );

    DROP TABLE IF EXISTS `ordemservico_acabamento`;

    CREATE TABLE `ordemservico_acabamento` (
      `id` int NOT NULL AUTO_INCREMENT,
      `ordemServico` int DEFAULT NULL,
      `acabamento` int DEFAULT NULL,
      `createdAt` datetime NOT NULL DEFAULT '2022-09-06 00:31:04',
      `updatedAt` datetime NOT NULL DEFAULT '2022-09-06 00:31:04',
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`),
      KEY `ordemServico` (`ordemServico`),
      KEY `acabamento` (`acabamento`),
      CONSTRAINT `ordemservico_acabamento_ibfk_1` FOREIGN KEY (`ordemServico`) REFERENCES `ordem_de_servico` (`id`),
      CONSTRAINT `ordemservico_acabamento_ibfk_2` FOREIGN KEY (`acabamento`) REFERENCES `acabamento` (`id`)
    );


    DROP TABLE IF EXISTS `distribuidora_tinta`;

    CREATE TABLE `distribuidora_tinta` (
      `id` int NOT NULL AUTO_INCREMENT,
      `nome_distribuidora` varchar(255) DEFAULT NULL,
      `valor_total` float DEFAULT NULL,
      `tinta_id` int DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      `observacao` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`id`),
      KEY `tinta_id` (`tinta_id`),
      CONSTRAINT `distribuidora_tinta_ibfk_1` FOREIGN KEY (`tinta_id`) REFERENCES `tinta` (`id`)
    );

    DROP TABLE IF EXISTS `distribuidora_papel`;

    CREATE TABLE `distribuidora_papel` (
      `id` int NOT NULL AUTO_INCREMENT,
      `nome_distribuidora` varchar(255) DEFAULT NULL,
      `papel_id` int DEFAULT NULL,
      `quantidade_pacote` float DEFAULT NULL,
      `valor_pacote` float DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`),
      KEY `papel_id` (`papel_id`),
      CONSTRAINT `distribuidora_papel_ibfk_1` FOREIGN KEY (`papel_id`) REFERENCES `papel` (`id`)

    );

    DROP TABLE IF EXISTS `distribuidora_material`;

    CREATE TABLE `distribuidora_material` (
      `id` int NOT NULL AUTO_INCREMENT,
      `nome_distribuidora` varchar(255) DEFAULT NULL,
      `valor_material` float DEFAULT NULL,
      `material_id` int DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`),
      KEY `material_id` (`material_id`),
      CONSTRAINT `distribuidora_material_ibfk_1` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`)

    );

    DROP TABLE IF EXISTS `suprimentos`;

    CREATE TABLE `suprimentos` (
      `id` int NOT NULL AUTO_INCREMENT,
      `descricao_suprimentos` varchar(255) DEFAULT NULL,
      `quantidade` double DEFAULT NULL,
      `observacao` varchar(255) DEFAULT NULL,
      `comprado` tinyint(1) DEFAULT NULL,
      `qual_suprimento` int DEFAULT NULL,
      `createdAt` datetime DEFAULT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`)
    );

    DROP TABLE IF EXISTS `orcamento`;

    CREATE TABLE `orcamento` (
      `id` int NOT NULL AUTO_INCREMENT,
      `cliente` varchar(255) DEFAULT NULL,
      `servico` varchar(255) DEFAULT NULL,
      `folhas` int DEFAULT NULL,
      `cor` varchar(255) DEFAULT NULL,
      `medida` varchar(255) DEFAULT NULL,
      `preco` decimal(10,0) DEFAULT NULL,
      `corte_vinco` float DEFAULT NULL,
      `faca` float DEFAULT NULL,
      `Acerto` float DEFAULT NULL,
      `silk_screen` float DEFAULT NULL,
      `impressao` float DEFAULT NULL,
      `lavagem` float DEFAULT NULL,
      `chapa` float DEFAULT NULL,
      `fotolito` float DEFAULT NULL,
      `arte` float DEFAULT NULL,
      `tinta` float DEFAULT NULL,
      `materia_prima` float DEFAULT NULL,
      `plastico` float DEFAULT NULL,
      `cliche` float DEFAULT NULL,
      `acabamento` varchar(255) DEFAULT NULL,
      `entrega` float DEFAULT NULL,
      `Quantidade` int DEFAULT NULL,
      `valor_papel` float DEFAULT NULL,
      `valor` decimal(10,0) DEFAULT NULL,
      `createdAt` datetime NOT NULL,
      `updatedAt` datetime NOT NULL,
      `userInc` varchar(100) DEFAULT NULL,
      `userUpdate` varchar(100) DEFAULT NULL,
      PRIMARY KEY (`id`)
    );