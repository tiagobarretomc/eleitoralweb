CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) UNIQUE COLLATE utf8_unicode_ci NOT NULL,
  `nome` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `senha` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `senha_inicial` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ;
ALTER TABLE `usuario` ADD UNIQUE INDEX `login_UNIQUE` (`login` ASC);
CREATE TABLE `grupo_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ;
CREATE TABLE `usuario_grupo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `id_grupo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`id_usuario`,`id_grupo`),
  FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (`id_grupo`) REFERENCES `grupo_usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;

INSERT INTO `usuario`
(`id`,`login`,`nome`,`senha`,`email`,`senha_inicial`,`ativo`)
VALUES (1, 'admin', 'Administrador', '8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918','','8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918',true);

 


