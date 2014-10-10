CREATE TABLE `candidato` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `foto` varchar(300) NOT NULL,
  `partido` varchar(45) NOT NULL,
  `cargo` varchar(45) NOT NULL,
  `numero` varchar(5) NOT NULL,
  `votos` int(11) NOT NULL DEFAULT '0',
  `numero` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;