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
  `valor_parcial` decimal(10,0) DEFAULT NULL,
  `valor_atraso` decimal(10,0) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `carro_id` int(11) DEFAULT NULL,
  `assegurado` bit(1) DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `carro_id` (`carro_id`),
  KEY `status_id` (`status_id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `aluguel_ibfk_4` FOREIGN KEY (`cliente_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `aluguel_ibfk_1` FOREIGN KEY (`carro_id`) REFERENCES `carro` (`id`),
  CONSTRAINT `aluguel_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `status_aluguel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `aluguel` (`id`, `data_retirada`, `data_entrega`, `prazo`, `atraso`, `valor_parcial`, `valor_atraso`, `status_id`, `carro_id`, `assegurado`, `cliente_id`) VALUES
(1,	'0000-00-00 00:00:00',	'0000-00-00 00:00:00',	10,	2,	1000,	1300,	1,	2,	CONV('1', 2, 10) + 0,	5),
(2,	'2013-11-25 00:00:00',	'2013-11-28 00:00:00',	3,	0,	300,	300,	3,	2,	CONV('1', 2, 10) + 0,	4);

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
  `placa` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fabricante_id` (`fabricante_id`),
  KEY `cambio_id` (`cambio_id`),
  KEY `carroceria_id` (`carroceria_id`),
  KEY `combustivel_id` (`combustivel_id`),
  KEY `direcao_id` (`direcao_id`),
  KEY `lugares_id` (`lugares_id`),
  KEY `portas_id` (`portas_id`),
  KEY `motor_id` (`motor_id`),
  CONSTRAINT `carro_ibfk_1` FOREIGN KEY (`fabricante_id`) REFERENCES `fabricante` (`id`),
  CONSTRAINT `carro_ibfk_2` FOREIGN KEY (`cambio_id`) REFERENCES `cambio` (`id`),
  CONSTRAINT `carro_ibfk_3` FOREIGN KEY (`carroceria_id`) REFERENCES `carroceria` (`id`),
  CONSTRAINT `carro_ibfk_4` FOREIGN KEY (`combustivel_id`) REFERENCES `combustivel` (`id`),
  CONSTRAINT `carro_ibfk_5` FOREIGN KEY (`direcao_id`) REFERENCES `direcao` (`id`),
  CONSTRAINT `carro_ibfk_6` FOREIGN KEY (`lugares_id`) REFERENCES `lugares` (`id`),
  CONSTRAINT `carro_ibfk_7` FOREIGN KEY (`portas_id`) REFERENCES `portas` (`id`),
  CONSTRAINT `carro_ibfk_8` FOREIGN KEY (`motor_id`) REFERENCES `motor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `carro` (`id`, `modelo`, `fabricante_id`, `ano`, `preco`, `portas_id`, `lugares_id`, `motor_id`, `carroceria_id`, `combustivel_id`, `cambio_id`, `direcao_id`, `categoria`, `placa`) VALUES
(2,	'gol 1.6',	2,	1994,	100,	1,	1,	2,	1,	1,	1,	1,	'B',	'cda-1394');

DROP TABLE IF EXISTS `carroceria`;
CREATE TABLE `carroceria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `carroceria` (`id`, `nome`) VALUES
(1,	'hatch2');

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
(1,	'04673948',	'rua avenida endereco',	1891,	'null',	'jd bairro',	'sp',	'sp'),
(2,	'9484746',	'rua vw',	108,	'ccs',	'bai',	'sp',	'sp'),
(3,	'98376476',	'rua vw cs',	1981,	'concess',	'oic',	'rj',	'rj'),
(4,	'9734739',	'rua fiat',	139,	'ccs',	'bai',	'it',	'it'),
(5,	'028y38',	'rua rua ',	189,	'ap',	'jd',	'sp',	'sp'),
(6,	'fsioh090',	'bjbj',	9334,	' fkj',	'jgbljb',	'so',	'os'),
(7,	'92j',	'9n9in',	10,	' on',	'nsi',	'os',	'is'),
(8,	'onwd0n',	'dwnu',	29,	'd wno',	'nu',	'un',	'un');

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
  CONSTRAINT `fabricante_ibfk_1` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`),
  CONSTRAINT `fabricante_ibfk_2` FOREIGN KEY (`id_telefone`) REFERENCES `telefone` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `fabricante` (`id`, `nome`, `email`, `origem`, `id_telefone`, `id_endereco`) VALUES
(2,	'vwe',	'vw@vw.vw',	'ger',	1,	3);

DROP TABLE IF EXISTS `lugares`;
CREATE TABLE `lugares` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `lugares` (`id`, `quantidade`) VALUES
(1,	5);

DROP TABLE IF EXISTS `motor`;
CREATE TABLE `motor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `potencia` int(11) DEFAULT NULL,
  `valvulas` int(11) DEFAULT NULL,
  `cilindros` int(11) DEFAULT NULL,
  `cilindradas` int(11) DEFAULT NULL,
  `alinhamento` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `motor` (`id`, `potencia`, `valvulas`, `cilindros`, `cilindradas`, `alinhamento`) VALUES
(2,	90,	16,	4,	1600,	'em linha'),
(3,	90,	16,	4,	1800,	'em linha');

DROP TABLE IF EXISTS `permissao`;
CREATE TABLE `permissao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `permissao` (`id`, `descricao`) VALUES
(1,	'administrador'),
(2,	'vendedor'),
(3,	'cliente');

DROP TABLE IF EXISTS `portas`;
CREATE TABLE `portas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `portas` (`id`, `quantidade`) VALUES
(1,	4);

DROP TABLE IF EXISTS `status_aluguel`;
CREATE TABLE `status_aluguel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `status_aluguel` (`id`, `descricao`) VALUES
(1,	'em curso'),
(2,	'atrasado'),
(3,	'finalizado');

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
(1,	55,	11,	33333333,	'residencial'),
(2,	55,	11,	66666666,	'comercial'),
(3,	55,	11,	88888888,	'comercial'),
(5,	55,	11,	7287278,	'comercial'),
(6,	88,	11,	513151315,	'nijjj'),
(7,	99,	99,	131,	'niw'),
(8,	92,	2,	31039,	' jwndj');

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
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_telefone`) REFERENCES `telefone` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `usuario_ibfk_3` FOREIGN KEY (`permissao_id`) REFERENCES `permissao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `usuario` (`id`, `nome`, `email`, `senha`, `cpf`, `rg`, `data_nascimento`, `permissao_id`, `cnh`, `categoria_carta`, `id_endereco`, `id_telefone`) VALUES
(3,	'Rafael Baraldi',	'adm',	'123',	'11111111111',	'498785987',	'0000-00-00',	1,	'1111111111111',	'B',	1,	1),
(4,	'jose2',	'mfoa',	'cliente',	'fm',	'pon',	NULL,	3,	'on',	'AD',	6,	6),
(5,	'knaddns',	'jnldw',	'[C@4d3eb23c',	'wdnlj',	'ljnj',	NULL,	2,	'wl',	'C',	7,	7);

-- 2013-11-25 06:22:53
