CREATE TABLE `campanha_eleitoral` (
  `id` INT NOT NULL,
  `ano` VARCHAR(4) NULL,
  `id_estado` INT NULL,
  `id_cidade` INT NULL,
  `id_tipo` INT NULL,
  `id_tipo_candidato` INT NULL,
  `id_legenda` INT NULL,
  `registro` VARCHAR(15) NULL,
  `cnpj` VARCHAR(15) NULL,
  `dt_abertura_cnpj` DATETIME NULL,
  `id_banco` INT NULL,
  `agencia` VARCHAR(15) NULL,
  `conta` VARCHAR(15) NULL,
  `dt_abertura_conta` DATETIME NULL,
  `recibo_gerado` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
ALTER TABLE `campanha_eleitoral`
ADD CONSTRAINT `fk_estado_campanha_eleitoral`
  FOREIGN KEY (`id_cidade`)
  REFERENCES `cidade` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_cidade_campanha_eleitoral`
  FOREIGN KEY (`id_cidade`)
  REFERENCES `cidade` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_banco_campanha_eleitoral`
  FOREIGN KEY (`id_banco`)
  REFERENCES `banco` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_legenda_campanha_eleitoral`
  FOREIGN KEY (`id_legenda`)
  REFERENCES `legenda` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;