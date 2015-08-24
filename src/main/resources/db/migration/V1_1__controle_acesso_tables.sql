CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `nome` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `senha` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `senha_inicial` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ;
CREATE TABLE `grupo_usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ;
CREATE TABLE `usuario_grupo` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_grupo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`id_usuario`,`id_grupo`),
  FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (`id_grupo`) REFERENCES `grupo_usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;



