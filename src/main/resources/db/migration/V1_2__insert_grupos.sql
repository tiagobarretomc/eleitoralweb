INSERT INTO `grupo_usuario` (`id`,`nome`) VALUES (1,'administrador');
INSERT INTO `grupo_usuario` (`id`,`nome`) VALUES (2,'gestor');
INSERT INTO `grupo_usuario` (`id`,`nome`) VALUES (3,'candidato');

INSERT INTO `usuario_grupo`(`id`,`id_usuario`,`id_grupo`)
VALUES (1,1,1);