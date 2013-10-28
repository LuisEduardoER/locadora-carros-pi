-- Adminer 3.7.1 MySQL dump

SET NAMES utf8;
SET foreign_key_checks = 0;
SET time_zone = '-02:00';
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `aluguel`;
CREATE TABLE `aluguel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_retirada` datetime DEFAULT NULL,
  `data_entrega` datetime DEFAULT NULL,
  `prazo` int(11) DEFAULT NULL,
  `atraso` int(11) DEFAULT NULL,
  `valor_parcial` decimal(10,0) NOT NULL,
  `valor_atraso` decimal(10,0) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `carro_id` int(11) DEFAULT NULL,
  `assegurado` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `carro_id` (`carro_id`),
  KEY `status_id` (`status_id`),
  CONSTRAINT `aluguel_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `status_aluguel` (`id`),
  CONSTRAINT `aluguel_ibfk_1` FOREIGN KEY (`carro_id`) REFERENCES `carro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `cambio`;
CREATE TABLE `cambio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `cambio` (`id`, `nome`) VALUES
(1,	'manual');

DROP TABLE IF EXISTS `carro`;
CREATE TABLE `carro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `modelo` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fabricante_id` int(11) DEFAULT NULL,
  `ano` int(11) DEFAULT NULL,
  `preco` decimal(10,0) DEFAULT NULL,
  `portas_id` int(11) DEFAULT NULL,
  `lugares_id` int(11) DEFAULT NULL,
  `motor_id` int(11) DEFAULT NULL,
  `carroceria_id` int(11) DEFAULT NULL,
  `combustivel_id` int(11) DEFAULT NULL,
  `cambio_id` int(11) DEFAULT NULL,
  `direcao_id` int(11) DEFAULT NULL,
  `categoria` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fabricante_id` (`fabricante_id`),
  KEY `cambio_id` (`cambio_id`),
  KEY `carroceria_id` (`carroceria_id`),
  KEY `combustivel_id` (`combustivel_id`),
  KEY `direcao_id` (`direcao_id`),
  KEY `lugares_id` (`lugares_id`),
  KEY `portas_id` (`portas_id`),
  CONSTRAINT `carro_ibfk_7` FOREIGN KEY (`portas_id`) REFERENCES `portas` (`id`),
  CONSTRAINT `carro_ibfk_1` FOREIGN KEY (`fabricante_id`) REFERENCES `fabricante` (`id`),
  CONSTRAINT `carro_ibfk_2` FOREIGN KEY (`cambio_id`) REFERENCES `cambio` (`id`),
  CONSTRAINT `carro_ibfk_3` FOREIGN KEY (`carroceria_id`) REFERENCES `carroceria` (`id`),
  CONSTRAINT `carro_ibfk_4` FOREIGN KEY (`combustivel_id`) REFERENCES `combustivel` (`id`),
  CONSTRAINT `carro_ibfk_5` FOREIGN KEY (`direcao_id`) REFERENCES `direcao` (`id`),
  CONSTRAINT `carro_ibfk_6` FOREIGN KEY (`lugares_id`) REFERENCES `lugares` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `carroceria`;
CREATE TABLE `carroceria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `carroceria` (`id`, `nome`) VALUES
(1,	'hatch');

DROP TABLE IF EXISTS `combustivel`;
CREATE TABLE `combustivel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `combustivel` (`id`, `nome`) VALUES
(1,	'etanol');

DROP TABLE IF EXISTS `direcao`;
CREATE TABLE `direcao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `direcao` (`id`, `nome`) VALUES
(1,	'hidraulica');

DROP TABLE IF EXISTS `endereco`;
CREATE TABLE `endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cep` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `logradouro` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `complemento` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `bairro` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `cidade` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `estado` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `endereco` (`id`, `cep`, `logradouro`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
(1,	'04673948',	'rua avenida endereco',	189,	NULL,	'jd bairro',	'sp',	'sp'),
(2,	'9484746',	'rua vw',	108,	'ccs',	'bai',	'sp',	'sp'),
(3,	'98376476',	'rua vw cs',	198,	'concess',	'oic',	'rj',	'rj');

DROP TABLE IF EXISTS `fabricante`;
CREATE TABLE `fabricante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `origem` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_telefone` int(11) DEFAULT NULL,
  `id_endereco` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_endereco` (`id_endereco`),
  KEY `id_telefone` (`id_telefone`),
  CONSTRAINT `fabricante_ibfk_2` FOREIGN KEY (`id_telefone`) REFERENCES `telefone` (`id`),
  CONSTRAINT `fabricante_ibfk_1` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `fabricante` (`id`, `nome`, `email`, `origem`, `id_telefone`, `id_endereco`) VALUES
(2,	'vw',	'vw@vw.vw',	'Alemanha',	1,	3);

DROP TABLE IF EXISTS `lugares`;
CREATE TABLE `lugares` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `lugares` (`id`, `quantidade`) VALUES
(1,	5);

DROP TABLE IF EXISTS `permissao`;
CREATE TABLE `permissao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `permissao` (`id`, `descricao`) VALUES
(1,	'administrador');

DROP TABLE IF EXISTS `portas`;
CREATE TABLE `portas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `portas` (`id`, `quantidade`) VALUES
(1,	3);

DROP TABLE IF EXISTS `status_aluguel`;
CREATE TABLE `status_aluguel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `telefone`;
CREATE TABLE `telefone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ddi` int(11) NOT NULL,
  `ddd` int(11) NOT NULL,
  `numero` int(20) NOT NULL,
  `tipo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `telefone` (`id`, `ddi`, `ddd`, `numero`, `tipo`) VALUES
(1,	55,	11,	55555555,	'residencial'),
(2,	55,	11,	66666666,	'comercial'),
(3,	55,	11,	88888888,	'comercial');

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `senha` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `cpf` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `rg` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `permissao_id` int(11) DEFAULT NULL,
  `cnh` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `categoria_carta` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `id_endereco` int(11) DEFAULT NULL,
  `id_telefone` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_telefone` (`id_telefone`),
  KEY `id_endereco` (`id_endereco`),
  KEY `permissao_id` (`permissao_id`),
  CONSTRAINT `usuario_ibfk_3` FOREIGN KEY (`permissao_id`) REFERENCES `permissao` (`id`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_telefone`) REFERENCES `telefone` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `usuario` (`id`, `nome`, `email`, `senha`, `cpf`, `rg`, `data_nascimento`, `permissao_id`, `cnh`, `categoria_carta`, `id_endereco`, `id_telefone`) VALUES
(3,	'Rafael Baraldi',	'adm',	'123',	'11111111111',	'498785987',	'0000-00-00',	1,	'1111111111111',	'b',	1,	1);

-- 2013-10-27 23:45:16
