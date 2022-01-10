-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema servicecallsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `servicecallsdb` ;

-- -----------------------------------------------------
-- Schema servicecallsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `servicecallsdb` DEFAULT CHARACTER SET utf8 ;
USE `servicecallsdb` ;

-- -----------------------------------------------------
-- Table `customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `customer` ;

CREATE TABLE IF NOT EXISTS `customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state_abbv` VARCHAR(45) NOT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_customer1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_address_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `service_call`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `service_call` ;

CREATE TABLE IF NOT EXISTS `service_call` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  `date_called` DATE NULL,
  `date_scheduled` DATE NOT NULL,
  `time_slot` INT NOT NULL,
  `address_id` INT NOT NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_service_call_address_idx` (`address_id` ASC),
  CONSTRAINT `fk_service_call_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipment` ;

CREATE TABLE IF NOT EXISTS `equipment` (
  `serial_number` INT NOT NULL,
  `model_number` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NULL,
  `fuel_type` VARCHAR(45) NULL,
  `description` VARCHAR(250) NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`serial_number`),
  UNIQUE INDEX `serial_number_UNIQUE` (`serial_number` ASC),
  INDEX `fk_equipment_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_equipment_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS tech@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'tech'@'localhost' IDENTIFIED BY 'tech';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'tech'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `customer`
-- -----------------------------------------------------
START TRANSACTION;
USE `servicecallsdb`;
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `phone_number`) VALUES (1, 'John', 'Doe', '1231231111');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `phone_number`) VALUES (2, 'Test', 'Testerson', '1231232222');

COMMIT;


-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `servicecallsdb`;
INSERT INTO `address` (`id`, `address`, `city`, `state_abbv`, `customer_id`) VALUES (1, '62 Fake St.', 'Hanover', 'PA', 1);
INSERT INTO `address` (`id`, `address`, `city`, `state_abbv`, `customer_id`) VALUES (2, '3522 Notreal Ave.', 'Hampstead', 'MD', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `service_call`
-- -----------------------------------------------------
START TRANSACTION;
USE `servicecallsdb`;
INSERT INTO `service_call` (`id`, `description`, `date_called`, `date_scheduled`, `time_slot`, `address_id`, `active`) VALUES (1, 'No heat', '2022-01-01', '2022-01-02', 0800, 1, DEFAULT);
INSERT INTO `service_call` (`id`, `description`, `date_called`, `date_scheduled`, `time_slot`, `address_id`, `active`) VALUES (2, 'maintenance', '2022-01-01', '2022-01-02', 0930, 2, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `equipment`
-- -----------------------------------------------------
START TRANSACTION;
USE `servicecallsdb`;
INSERT INTO `equipment` (`serial_number`, `model_number`, `type`, `fuel_type`, `description`, `address_id`) VALUES (123456789, 'hvac123', 'furnace', 'oil', '75-70b nozzle, inline oil filter', 1);
INSERT INTO `equipment` (`serial_number`, `model_number`, `type`, `fuel_type`, `description`, `address_id`) VALUES (123123, 'hvac111', 'boiler', 'gas', NULL, 2);

COMMIT;

