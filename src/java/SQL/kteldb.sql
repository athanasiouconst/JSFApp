-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema kteldb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema kteldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kteldb` DEFAULT CHARACTER SET utf8 ;
USE `kteldb` ;

-- -----------------------------------------------------
-- Table `kteldb`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kteldb`.`roles` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kteldb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kteldb`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_lastname` VARCHAR(45) NOT NULL,
  `user_firstname` VARCHAR(45) NOT NULL,
  `user_adt` VARCHAR(45) NOT NULL,
  `user_afm` INT NOT NULL,
  `user_phone` VARCHAR(45) NOT NULL,
  `user_address` VARCHAR(45) NOT NULL,
  `user_email` VARCHAR(45) NOT NULL,
  `user_username` VARCHAR(45) NOT NULL,
  `user_password` VARCHAR(45) NOT NULL,
  `roles_role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `roles_role_id`),
  UNIQUE INDEX `user_adt_UNIQUE` (`user_adt` ASC),
  UNIQUE INDEX `user_afm_UNIQUE` (`user_afm` ASC),
  UNIQUE INDEX `user_phone_UNIQUE` (`user_phone` ASC),
  UNIQUE INDEX `user_email_UNIQUE` (`user_email` ASC),
  UNIQUE INDEX `user_username_UNIQUE` (`user_username` ASC),
  INDEX `fk_users_roles_idx` (`roles_role_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_role_id`)
    REFERENCES `kteldb`.`roles` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kteldb`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kteldb`.`city` (
  `city_id` INT NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`city_id`),
  UNIQUE INDEX `city_name_UNIQUE` (`city_name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kteldb`.`bus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kteldb`.`bus` (
  `bus_id` INT NOT NULL AUTO_INCREMENT,
  `bus_arithmos_kikloforias` VARCHAR(45) NOT NULL,
  `bus_arithmos_theseon` INT NOT NULL,
  `bus_typebus` VARCHAR(45) NOT NULL,
  `bus_xoritikotita_dematon` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`bus_id`),
  UNIQUE INDEX `bus_arithmos_kikloforias_UNIQUE` (`bus_arithmos_kikloforias` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kteldb`.`dromologio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kteldb`.`dromologio` (
  `dromologio_id` INT NOT NULL AUTO_INCREMENT,
  `dromologio_date` DATE NOT NULL,
  `dromologio_time_anaxorisi` DATE NOT NULL,
  `dromologio_time_afiksi` DATE NOT NULL,
  `dromologio_type_dromologio` VARCHAR(45) NOT NULL,
  `dromologio_price` VARCHAR(45) NOT NULL,
  `city_city_id_anaxorisi` INT NOT NULL,
  `city_city_id_afiksi` INT NOT NULL,
  `bus_bus_id` INT NOT NULL,
  PRIMARY KEY (`dromologio_id`, `city_city_id_anaxorisi`, `city_city_id_afiksi`, `bus_bus_id`),
  INDEX `fk_dromologio_city1_idx` (`city_city_id_anaxorisi` ASC),
  INDEX `fk_dromologio_city2_idx` (`city_city_id_afiksi` ASC),
  INDEX `fk_dromologio_bus1_idx` (`bus_bus_id` ASC),
  CONSTRAINT `fk_dromologio_city1`
    FOREIGN KEY (`city_city_id_anaxorisi`)
    REFERENCES `kteldb`.`city` (`city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dromologio_city2`
    FOREIGN KEY (`city_city_id_afiksi`)
    REFERENCES `kteldb`.`city` (`city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dromologio_bus1`
    FOREIGN KEY (`bus_bus_id`)
    REFERENCES `kteldb`.`bus` (`bus_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kteldb`.`busdriver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kteldb`.`busdriver` (
  `busdriver_id` INT NOT NULL AUTO_INCREMENT,
  `busdriver_lastname` VARCHAR(45) NOT NULL,
  `busdriver_firstname` VARCHAR(45) NOT NULL,
  `busdriver_adt` VARCHAR(45) NOT NULL,
  `busdriver_afm` INT NOT NULL,
  `busdriver_arithmos_diplomatos` VARCHAR(45) NOT NULL,
  `busdriver_phone` VARCHAR(45) NOT NULL,
  `busdriver_address` VARCHAR(45) NOT NULL,
  `bus_bus_id` INT NOT NULL,
  PRIMARY KEY (`busdriver_id`, `bus_bus_id`),
  UNIQUE INDEX `busdriver_adt_UNIQUE` (`busdriver_adt` ASC),
  UNIQUE INDEX `busdriver_afm_UNIQUE` (`busdriver_afm` ASC),
  UNIQUE INDEX `busdriver_arithmos_diplomatos_UNIQUE` (`busdriver_arithmos_diplomatos` ASC),
  UNIQUE INDEX `busdriver_phone_UNIQUE` (`busdriver_phone` ASC),
  INDEX `fk_busdriver_bus1_idx` (`bus_bus_id` ASC),
  CONSTRAINT `fk_busdriver_bus1`
    FOREIGN KEY (`bus_bus_id`)
    REFERENCES `kteldb`.`bus` (`bus_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kteldb`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kteldb`.`ticket` (
  `ticket_id` INT NOT NULL AUTO_INCREMENT,
  `ticket_type` VARCHAR(45) NOT NULL,
  `ticket_type_ekptosi` VARCHAR(45) NOT NULL,
  `ticket_date_ekdosi` DATE NOT NULL,
  `ticket_category_ekdosis` VARCHAR(45) NOT NULL,
  `ticket_price` VARCHAR(45) NOT NULL,
  `dromologio_dromologio_id` INT NOT NULL,
  `dromologio_city_city_id_anaxorisi` INT NOT NULL,
  `dromologio_city_city_id_afiksi` INT NOT NULL,
  `dromologio_bus_bus_id` INT NOT NULL,
  PRIMARY KEY (`ticket_id`, `dromologio_dromologio_id`, `dromologio_city_city_id_anaxorisi`, `dromologio_city_city_id_afiksi`, `dromologio_bus_bus_id`),
  INDEX `fk_ticket_dromologio1_idx` (`dromologio_dromologio_id` ASC, `dromologio_city_city_id_anaxorisi` ASC, `dromologio_city_city_id_afiksi` ASC, `dromologio_bus_bus_id` ASC),
  CONSTRAINT `fk_ticket_dromologio1`
    FOREIGN KEY (`dromologio_dromologio_id` , `dromologio_city_city_id_anaxorisi` , `dromologio_city_city_id_afiksi` , `dromologio_bus_bus_id`)
    REFERENCES `kteldb`.`dromologio` (`dromologio_id` , `city_city_id_anaxorisi` , `city_city_id_afiksi` , `bus_bus_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kteldb`.`dema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kteldb`.`dema` (
  `dema_id` INT NOT NULL AUTO_INCREMENT,
  `dema_date_apostoli` DATE NOT NULL,
  `dema_lastname_apostolea` VARCHAR(45) NOT NULL,
  `dema_firstname_apostolea` VARCHAR(45) NOT NULL,
  `dema_lastname_paralipti` VARCHAR(45) NOT NULL,
  `dema_firstname_paralipti` VARCHAR(45) NOT NULL,
  `dema_temaxia` INT NOT NULL,
  `dema_baros` VARCHAR(45) NOT NULL,
  `dema_price` VARCHAR(45) NOT NULL,
  `dromologio_dromologio_id` INT NOT NULL,
  `dromologio_city_city_id_anaxorisi` INT NOT NULL,
  `dromologio_city_city_id_afiksi` INT NOT NULL,
  `dromologio_bus_bus_id` INT NOT NULL,
  PRIMARY KEY (`dema_id`, `dromologio_dromologio_id`, `dromologio_city_city_id_anaxorisi`, `dromologio_city_city_id_afiksi`, `dromologio_bus_bus_id`),
  INDEX `fk_dema_dromologio1_idx` (`dromologio_dromologio_id` ASC, `dromologio_city_city_id_anaxorisi` ASC, `dromologio_city_city_id_afiksi` ASC, `dromologio_bus_bus_id` ASC),
  CONSTRAINT `fk_dema_dromologio1`
    FOREIGN KEY (`dromologio_dromologio_id` , `dromologio_city_city_id_anaxorisi` , `dromologio_city_city_id_afiksi` , `dromologio_bus_bus_id`)
    REFERENCES `kteldb`.`dromologio` (`dromologio_id` , `city_city_id_anaxorisi` , `city_city_id_afiksi` , `bus_bus_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kteldb`.`eUser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kteldb`.`eUser` (
  `eUser_id` INT NOT NULL AUTO_INCREMENT,
  `eUser_username` VARCHAR(45) NOT NULL,
  `eUser_password` VARCHAR(45) NOT NULL,
  `eUser_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`eUser_id`),
  UNIQUE INDEX `eUser_username_UNIQUE` (`eUser_username` ASC),
  UNIQUE INDEX `eUser_email_UNIQUE` (`eUser_email` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
