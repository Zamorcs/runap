-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema runap
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `runap` ;

-- -----------------------------------------------------
-- Schema runap
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `runap` DEFAULT CHARACTER SET utf8 ;
USE `runap` ;

-- -----------------------------------------------------
-- Table `runap`.`tipo_corredor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`tipo_corredor` ;

CREATE TABLE IF NOT EXISTS `runap`.`tipo_corredor` (
  `tipo_corredor_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`tipo_corredor_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`sexo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`sexo` ;

CREATE TABLE IF NOT EXISTS `runap`.`sexo` (
  `sexo_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`sexo_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`avatar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`avatar` ;

CREATE TABLE IF NOT EXISTS `runap`.`avatar` (
  `avatar_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(180) NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`avatar_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`corredor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`corredor` ;

CREATE TABLE IF NOT EXISTS `runap`.`corredor` (
  `corredor_id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `tipo_corredor_id` INT NOT NULL,
  `sexo_id` INT NOT NULL,
  `social` VARCHAR(90) NULL,
  `email` VARCHAR(90) NULL,
  `fecha_registro` DATE NOT NULL,
  `fecha_ultimo_login` DATE NOT NULL,
  `avatar_id` INT NULL,
  `running_team_id` INT NULL,
  `friendlist_id` INT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`corredor_id`),
  INDEX `fk_corredor_tipo_corredor_idx` (`tipo_corredor_id` ASC) VISIBLE,
  INDEX `fk_corredor_sexo1_idx` (`sexo_id` ASC) VISIBLE,
  INDEX `fk_corredor_avatar1_idx` (`avatar_id` ASC) VISIBLE,
  CONSTRAINT `fk_corredor_tipo_corredor`
    FOREIGN KEY (`tipo_corredor_id`)
    REFERENCES `runap`.`tipo_corredor` (`tipo_corredor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_corredor_sexo1`
    FOREIGN KEY (`sexo_id`)
    REFERENCES `runap`.`sexo` (`sexo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_corredor_avatar1`
    FOREIGN KEY (`avatar_id`)
    REFERENCES `runap`.`avatar` (`avatar_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`organizador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`organizador` ;

CREATE TABLE IF NOT EXISTS `runap`.`organizador` (
  `organizador_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(90) NOT NULL,
  `webpage` VARCHAR(90) NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`organizador_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`tipo_carrera`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`tipo_carrera` ;

CREATE TABLE IF NOT EXISTS `runap`.`tipo_carrera` (
  `tipo_carrera_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`tipo_carrera_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`distancia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`distancia` ;

CREATE TABLE IF NOT EXISTS `runap`.`distancia` (
  `distancia_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`distancia_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`precio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`precio` ;

CREATE TABLE IF NOT EXISTS `runap`.`precio` (
  `precio_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `fecha_inicio` DATE NULL,
  `fecha_fin` DATE NULL,
  `moneda` VARCHAR(45) NOT NULL,
  `monto` INT NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`precio_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`imagen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`imagen` ;

CREATE TABLE IF NOT EXISTS `runap`.`imagen` (
  `imagen_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`imagen_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`recorrido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`recorrido` ;

CREATE TABLE IF NOT EXISTS `runap`.`recorrido` (
  `recorrido_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`recorrido_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`formato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`formato` ;

CREATE TABLE IF NOT EXISTS `runap`.`formato` (
  `formato_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`formato_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`carrera`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`carrera` ;

CREATE TABLE IF NOT EXISTS `runap`.`carrera` (
  `carrera_id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(90) NULL,
  `organizador_id` INT NOT NULL,
  `fecha_inicio` DATE NOT NULL,
  `fecha_fin` DATE NOT NULL,
  `tipo_carrera_id` INT NOT NULL,
  `webpage` VARCHAR(45) NULL,
  `pais` VARCHAR(45) NOT NULL,
  `imagen_id` INT NOT NULL,
  `fecha_inicio_inscripcion` DATE NOT NULL,
  `novedades` VARCHAR(90) NULL,
  `recorrido_id` INT NULL,
  `formato_id` INT NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`carrera_id`),
  INDEX `fk_carrera_tipo_carrera1_idx` (`tipo_carrera_id` ASC) VISIBLE,
  INDEX `fk_carrera_organizador1_idx` (`organizador_id` ASC) VISIBLE,
  INDEX `fk_carrera_imagen1_idx` (`imagen_id` ASC) VISIBLE,
  INDEX `fk_carrera_recorrido1_idx` (`recorrido_id` ASC) VISIBLE,
  INDEX `fk_carrera_formato1_idx` (`formato_id` ASC) VISIBLE,
  CONSTRAINT `fk_carrera_tipo_carrera1`
    FOREIGN KEY (`tipo_carrera_id`)
    REFERENCES `runap`.`tipo_carrera` (`tipo_carrera_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_carrera_organizador1`
    FOREIGN KEY (`organizador_id`)
    REFERENCES `runap`.`organizador` (`organizador_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_carrera_imagen1`
    FOREIGN KEY (`imagen_id`)
    REFERENCES `runap`.`imagen` (`imagen_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_carrera_recorrido1`
    FOREIGN KEY (`recorrido_id`)
    REFERENCES `runap`.`recorrido` (`recorrido_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_carrera_formato1`
    FOREIGN KEY (`formato_id`)
    REFERENCES `runap`.`formato` (`formato_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`lista_precios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`lista_precios` ;

CREATE TABLE IF NOT EXISTS `runap`.`lista_precios` (
  `numero` INT NOT NULL,
  `precio_id` INT NOT NULL,
  `carrera_id` INT NOT NULL,
  `enabled` TINYINT NULL,
  INDEX `fk_lista_precios_precio1_idx` (`precio_id` ASC) VISIBLE,
  INDEX `fk_lista_precios_carrera1_idx` (`carrera_id` ASC) VISIBLE,
  CONSTRAINT `fk_lista_precios_precio1`
    FOREIGN KEY (`precio_id`)
    REFERENCES `runap`.`precio` (`precio_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lista_precios_carrera1`
    FOREIGN KEY (`carrera_id`)
    REFERENCES `runap`.`carrera` (`carrera_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`tipo_direccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`tipo_direccion` ;

CREATE TABLE IF NOT EXISTS `runap`.`tipo_direccion` (
  `tipo_direccion_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`tipo_direccion_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`direccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`direccion` ;

CREATE TABLE IF NOT EXISTS `runap`.`direccion` (
  `direccion_id` INT NOT NULL AUTO_INCREMENT,
  `tipo_direccion_id` INT NOT NULL,
  `calle` VARCHAR(45) NOT NULL,
  `numero` INT NOT NULL,
  `localidad` VARCHAR(45) NOT NULL,
  `codigo_postal` VARCHAR(45) NOT NULL,
  `provincia` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `notas` VARCHAR(90) NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`direccion_id`),
  INDEX `fk_direccion_tipo_direccion1_idx` (`tipo_direccion_id` ASC) VISIBLE,
  CONSTRAINT `fk_direccion_tipo_direccion1`
    FOREIGN KEY (`tipo_direccion_id`)
    REFERENCES `runap`.`tipo_direccion` (`tipo_direccion_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`lista_direcciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`lista_direcciones` ;

CREATE TABLE IF NOT EXISTS `runap`.`lista_direcciones` (
  `numero` INT NOT NULL,
  `direccion_id` INT NOT NULL,
  `carrera_id` INT NOT NULL,
  `enabled` TINYINT NULL,
  INDEX `fk_lista_direcciones_direccion1_idx` (`direccion_id` ASC) VISIBLE,
  INDEX `fk_lista_direcciones_carrera1_idx` (`carrera_id` ASC) VISIBLE,
  CONSTRAINT `fk_lista_direcciones_direccion1`
    FOREIGN KEY (`direccion_id`)
    REFERENCES `runap`.`direccion` (`direccion_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lista_direcciones_carrera1`
    FOREIGN KEY (`carrera_id`)
    REFERENCES `runap`.`carrera` (`carrera_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`documentacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`documentacion` ;

CREATE TABLE IF NOT EXISTS `runap`.`documentacion` (
  `documentacion_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `obligatorio` TINYINT NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`documentacion_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`rec_kit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`rec_kit` ;

CREATE TABLE IF NOT EXISTS `runap`.`rec_kit` (
  `rec_kit_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `fecha_inicio` DATE NOT NULL,
  `fecha_fin` DATE NOT NULL,
  `documentacion_id` INT NOT NULL,
  `direccion_id` INT NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`rec_kit_id`),
  INDEX `fk_rec_kit_documentacion1_idx` (`documentacion_id` ASC) VISIBLE,
  INDEX `fk_rec_kit_direccion1_idx` (`direccion_id` ASC) VISIBLE,
  CONSTRAINT `fk_rec_kit_documentacion1`
    FOREIGN KEY (`documentacion_id`)
    REFERENCES `runap`.`documentacion` (`documentacion_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rec_kit_direccion1`
    FOREIGN KEY (`direccion_id`)
    REFERENCES `runap`.`direccion` (`direccion_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`estado_calendario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`estado_calendario` ;

CREATE TABLE IF NOT EXISTS `runap`.`estado_calendario` (
  `estado_calendario_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`estado_calendario_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`calendario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`calendario` ;

CREATE TABLE IF NOT EXISTS `runap`.`calendario` (
  `calendario_id` INT NOT NULL AUTO_INCREMENT,
  `estado_calendario_id` INT NOT NULL,
  `corredor_id` INT NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`calendario_id`),
  INDEX `fk_calendario_estado_calendario1_idx` (`estado_calendario_id` ASC) VISIBLE,
  INDEX `fk_calendario_corredor1_idx` (`corredor_id` ASC) VISIBLE,
  CONSTRAINT `fk_calendario_estado_calendario1`
    FOREIGN KEY (`estado_calendario_id`)
    REFERENCES `runap`.`estado_calendario` (`estado_calendario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_calendario_corredor1`
    FOREIGN KEY (`corredor_id`)
    REFERENCES `runap`.`corredor` (`corredor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`lista_carreras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`lista_carreras` ;

CREATE TABLE IF NOT EXISTS `runap`.`lista_carreras` (
  `carrera_id` INT NOT NULL,
  `calendario_id` INT NOT NULL,
  `inscripto` TINYINT NOT NULL,
  `enabled` TINYINT NULL,
  INDEX `fk_lista_carreras_carrera1_idx` (`carrera_id` ASC) VISIBLE,
  INDEX `fk_lista_carreras_calendario1_idx` (`calendario_id` ASC) VISIBLE,
  CONSTRAINT `fk_lista_carreras_carrera1`
    FOREIGN KEY (`carrera_id`)
    REFERENCES `runap`.`carrera` (`carrera_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lista_carreras_calendario1`
    FOREIGN KEY (`calendario_id`)
    REFERENCES `runap`.`calendario` (`calendario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`lista_rec_kits`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`lista_rec_kits` ;

CREATE TABLE IF NOT EXISTS `runap`.`lista_rec_kits` (
  `carrera_id` INT NOT NULL,
  `rec_kit_id` INT NOT NULL,
  `enabled` TINYINT NULL,
  INDEX `fk_lista_carreras_carrera1_idx` (`carrera_id` ASC) VISIBLE,
  INDEX `fk_lista_rec_kit_rec_kit1_idx` (`rec_kit_id` ASC) VISIBLE,
  CONSTRAINT `fk_lista_carreras_carrera10`
    FOREIGN KEY (`carrera_id`)
    REFERENCES `runap`.`carrera` (`carrera_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lista_rec_kit_rec_kit1`
    FOREIGN KEY (`rec_kit_id`)
    REFERENCES `runap`.`rec_kit` (`rec_kit_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `runap`.`lista_distancias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `runap`.`lista_distancias` ;

CREATE TABLE IF NOT EXISTS `runap`.`lista_distancias` (
  `numero` INT NOT NULL,
  `carrera_id` INT NOT NULL,
  `distancia_id` INT NOT NULL,
  `enabled` TINYINT NULL,
  INDEX `fk_lista_direcciones_carrera1_idx` (`carrera_id` ASC) VISIBLE,
  CONSTRAINT `fk_lista_direcciones_carrera10`
    FOREIGN KEY (`carrera_id`)
    REFERENCES `runap`.`carrera` (`carrera_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lista_distancias_distancia1`
    FOREIGN KEY (`distancia_id`)
    REFERENCES `runap`.`distancia` (`distancia_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
