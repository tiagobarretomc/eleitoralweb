CREATE TABLE `recurso` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `url` VARCHAR(80) NULL,
  `menu` BINARY NOT NULL,
  `id_recurso_pai` INT NULL,
  PRIMARY KEY (`id`));
ALTER TABLE `recurso`
ADD INDEX `fk_recurso_pai_idx` (`id_recurso_pai` ASC);
ALTER TABLE `eleitoralw`.`recurso`
ADD CONSTRAINT `fk_recurso_pai`
  FOREIGN KEY (`id_recurso_pai`)
  REFERENCES `eleitoralw`.`recurso` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


INSERT INTO `recurso`(`id`,`nome`,`url`,`menu`,`id_recurso_pai`)
 VALUES (1, 'Cadastro básico',null,true,null);
INSERT INTO `recurso`(`id`,`nome`,`url`,`menu`,`id_recurso_pai`)
 VALUES (2, 'Usuário','/usuario/lista/',true,1);
INSERT INTO `recurso`(`id`,`nome`,`url`,`menu`,`id_recurso_pai`)
 VALUES (3, 'Gerenciar contas',null,true,null);
INSERT INTO `recurso`(`id`,`nome`,`url`,`menu`,`id_recurso_pai`)
 VALUES (4, 'Comunicação',null,true,null);

