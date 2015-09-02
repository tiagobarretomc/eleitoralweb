CREATE TABLE `recurso_grupo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_grupo` INT NOT NULL,
  `id_recurso` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_grupo_recurso_grupo_idx` (`id_grupo` ASC),
  INDEX `fk_grupo_recurso_recurso_idx` (`id_recurso` ASC),
  CONSTRAINT `fk_grupo_recurso_grupo`
    FOREIGN KEY (`id_grupo`)
    REFERENCES `grupo_usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_recurso_recurso`
    FOREIGN KEY (`id_recurso`)
    REFERENCES `recurso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

  INSERT INTO `recurso_grupo` (`id_grupo`, `id_recurso`) VALUES (1,1);
  INSERT INTO `recurso_grupo` (`id_grupo`, `id_recurso`) VALUES (1,2);
  INSERT INTO `recurso_grupo` (`id_grupo`, `id_recurso`) VALUES (1,3);
  INSERT INTO `recurso_grupo` (`id_grupo`, `id_recurso`) VALUES (1,4);
  INSERT INTO `recurso_grupo` (`id_grupo`, `id_recurso`) VALUES (1,5);
  INSERT INTO `recurso_grupo` (`id_grupo`, `id_recurso`) VALUES (1,6);