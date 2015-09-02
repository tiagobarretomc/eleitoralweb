CREATE TABLE `recurso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `url` VARCHAR(80) NULL,
  `menu` BINARY NOT NULL,
  `id_recurso_pai` INT NULL,
  PRIMARY KEY (`id`));
ALTER TABLE `recurso`
ADD INDEX `fk_recurso_pai_idx` (`id_recurso_pai` ASC);
ALTER TABLE `recurso`
ADD CONSTRAINT `fk_recurso_pai`
  FOREIGN KEY (`id_recurso_pai`)
  REFERENCES `recurso` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


INSERT INTO `recurso`(`id`,`nome`,`descricao`,`url`,`menu`,`id_recurso_pai`)
 VALUES (1, 'Cadastro básico','Cadastro das tabelas básica', null,true,null);
 INSERT INTO `recurso`(`id`,`nome`,`descricao`,`url`,`menu`,`id_recurso_pai`)
 VALUES (6, 'Tipo de contas', 'Cadastro de tipos de contas', null,true,null);
INSERT INTO `recurso`(`id`,`nome`,`descricao`,`url`,`menu`,`id_recurso_pai`)
 VALUES (2, 'Gerenciar contas','Módulo de Gerenciamento de contas',null,true,null);
INSERT INTO `recurso`(`id`,`nome`,`descricao`,`url`,`menu`,`id_recurso_pai`)
 VALUES (3, 'Gerencial','Módulo Gerencial',null,true,null);
 INSERT INTO `recurso`(`id`,`nome`,`descricao`,`url`,`menu`,`id_recurso_pai`)
 VALUES (4, 'Segurança','Módulo de segurança',null,true,null);
 INSERT INTO `recurso`(`id`,`nome`,`descricao`,`url`,`menu`,`id_recurso_pai`)
 VALUES (5, 'Usuário','Cadastro de Usuário','/usuario/lista/',true,4);

