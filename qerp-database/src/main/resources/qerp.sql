-- MySQL Script generated by MySQL Workbench
-- 07/17/17 13:27:51
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema qerp
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `qerp` ;

-- -----------------------------------------------------
-- Schema qerp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `qerp` DEFAULT CHARACTER SET utf8 ;
USE `qerp` ;

-- -----------------------------------------------------
-- Table `currency`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `currency` ;

CREATE TABLE IF NOT EXISTS `currency` (
  `id_currency` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_currency`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `language` ;

CREATE TABLE IF NOT EXISTS `language` (
  `id_language` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_language`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `company` ;

CREATE TABLE IF NOT EXISTS `company` (
  `id_company` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_currency` INT UNSIGNED NOT NULL,
  `id_language` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_company`),
  CONSTRAINT `fk_brand_currency1`
    FOREIGN KEY (`id_currency`)
    REFERENCES `currency` (`id_currency`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_company_language1`
    FOREIGN KEY (`id_language`)
    REFERENCES `language` (`id_language`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_brand_currency1_idx` ON `company` (`id_currency` ASC);

CREATE INDEX `fk_company_language1_idx` ON `company` (`id_language` ASC);


-- -----------------------------------------------------
-- Table `employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee` ;

CREATE TABLE IF NOT EXISTS `employee` (
  `id_employee` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_company` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_employee`),
  CONSTRAINT `fk_employee_company`
    FOREIGN KEY (`id_company`)
    REFERENCES `company` (`id_company`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_employee_brand_idx` ON `employee` (`id_company` ASC);


-- -----------------------------------------------------
-- Table `physical_resource_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `physical_resource_type` ;

CREATE TABLE IF NOT EXISTS `physical_resource_type` (
  `id_physical_resource_type` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_physical_resource_type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `physical_resource`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `physical_resource` ;

CREATE TABLE IF NOT EXISTS `physical_resource` (
  `id_physical_resource` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_company` INT UNSIGNED NOT NULL,
  `id_physical_resource_type` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_physical_resource`),
  CONSTRAINT `fk_physical_resource_company1`
    FOREIGN KEY (`id_company`)
    REFERENCES `company` (`id_company`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_physical_resource_physical_resource_type1`
    FOREIGN KEY (`id_physical_resource_type`)
    REFERENCES `physical_resource_type` (`id_physical_resource_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_physical_resource_company1_idx` ON `physical_resource` (`id_company` ASC);

CREATE INDEX `fk_physical_resource_physical_resource_type1_idx` ON `physical_resource` (`id_physical_resource_type` ASC);


-- -----------------------------------------------------
-- Table `resource_feature`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `resource_feature` ;

CREATE TABLE IF NOT EXISTS `resource_feature` (
  `id_resource_feature` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_physical_resource_type` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_resource_feature`),
  CONSTRAINT `fk_resource_feature_physical_resource_type1`
    FOREIGN KEY (`id_physical_resource_type`)
    REFERENCES `physical_resource_type` (`id_physical_resource_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_resource_feature_physical_resource_type1_idx` ON `resource_feature` (`id_physical_resource_type` ASC);


-- -----------------------------------------------------
-- Table `physical_resource_has_feature`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `physical_resource_has_feature` ;

CREATE TABLE IF NOT EXISTS `physical_resource_has_feature` (
  `id_physical_resource` INT UNSIGNED NOT NULL,
  `id_resource_feature` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_physical_resource`, `id_resource_feature`),
  CONSTRAINT `fk_resource_feature_has_physical_resource_resource_feature1`
    FOREIGN KEY (`id_resource_feature`)
    REFERENCES `resource_feature` (`id_resource_feature`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resource_feature_has_physical_resource_physical_resource1`
    FOREIGN KEY (`id_physical_resource`)
    REFERENCES `physical_resource` (`id_physical_resource`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_resource_feature_has_physical_resource_physical_resource_idx` ON `physical_resource_has_feature` (`id_physical_resource` ASC);

CREATE INDEX `fk_resource_feature_has_physical_resource_resource_feature1_idx` ON `physical_resource_has_feature` (`id_resource_feature` ASC);


-- -----------------------------------------------------
-- Table `physical_resource_assignation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `physical_resource_assignation` ;

CREATE TABLE IF NOT EXISTS `physical_resource_assignation` (
  `id_physical_resource_assignation` INT NOT NULL,
  `id_employee` INT UNSIGNED NOT NULL,
  `id_physical_resource` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_physical_resource_assignation`),
  CONSTRAINT `fk_physical_resource_assignation_employee1`
    FOREIGN KEY (`id_employee`)
    REFERENCES `employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_physical_resource_assignation_physical_resource1`
    FOREIGN KEY (`id_physical_resource`)
    REFERENCES `physical_resource` (`id_physical_resource`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_physical_resource_assignation_employee1_idx` ON `physical_resource_assignation` (`id_employee` ASC);

CREATE INDEX `fk_physical_resource_assignation_physical_resource1_idx` ON `physical_resource_assignation` (`id_physical_resource` ASC);


-- -----------------------------------------------------
-- Table `payroll_incident_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `payroll_incident_type` ;

CREATE TABLE IF NOT EXISTS `payroll_incident_type` (
  `id_payroll_incident_type` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_payroll_incident_type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `payroll_incident`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `payroll_incident` ;

CREATE TABLE IF NOT EXISTS `payroll_incident` (
  `id_payroll_incident` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_payroll_incident_type` INT UNSIGNED NOT NULL,
  `id_employee` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_payroll_incident`),
  CONSTRAINT `fk_payroll_incident_payroll_incident_type1`
    FOREIGN KEY (`id_payroll_incident_type`)
    REFERENCES `payroll_incident_type` (`id_payroll_incident_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_payroll_incident_employee1`
    FOREIGN KEY (`id_employee`)
    REFERENCES `employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_payroll_incident_payroll_incident_type1_idx` ON `payroll_incident` (`id_payroll_incident_type` ASC);

CREATE INDEX `fk_payroll_incident_employee1_idx` ON `payroll_incident` (`id_employee` ASC);


-- -----------------------------------------------------
-- Table `employee_address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee_address` ;

CREATE TABLE IF NOT EXISTS `employee_address` (
  `id_employee_address` INT UNSIGNED NOT NULL,
  `id_employee` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_employee_address`),
  CONSTRAINT `fk_employee_address_employee1`
    FOREIGN KEY (`id_employee`)
    REFERENCES `employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_employee_address_employee1_idx` ON `employee_address` (`id_employee` ASC);


-- -----------------------------------------------------
-- Table `employee_education`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee_education` ;

CREATE TABLE IF NOT EXISTS `employee_education` (
  `id_employee_education` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_employee` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_employee_education`),
  CONSTRAINT `fk_employee_education_employee1`
    FOREIGN KEY (`id_employee`)
    REFERENCES `employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_employee_education_employee1_idx` ON `employee_education` (`id_employee` ASC);


-- -----------------------------------------------------
-- Table `employee_curse`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee_curse` ;

CREATE TABLE IF NOT EXISTS `employee_curse` (
  `id_employee_curse` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_employee` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_employee_curse`),
  CONSTRAINT `fk_employee_curse_employee1`
    FOREIGN KEY (`id_employee`)
    REFERENCES `employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_employee_curse_employee1_idx` ON `employee_curse` (`id_employee` ASC);


-- -----------------------------------------------------
-- Table `employee_language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee_language` ;

CREATE TABLE IF NOT EXISTS `employee_language` (
  `id_employee_language` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_employee` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_employee_language`),
  CONSTRAINT `fk_employee_language_employee1`
    FOREIGN KEY (`id_employee`)
    REFERENCES `employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_employee_language_employee1_idx` ON `employee_language` (`id_employee` ASC);


-- -----------------------------------------------------
-- Table `employee_reference`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee_reference` ;

CREATE TABLE IF NOT EXISTS `employee_reference` (
  `id_employee_reference` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_employee` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_employee_reference`),
  CONSTRAINT `fk_employee_reference_employee1`
    FOREIGN KEY (`id_employee`)
    REFERENCES `employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_employee_reference_employee1_idx` ON `employee_reference` (`id_employee` ASC);


-- -----------------------------------------------------
-- Table `skill_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skill_type` ;

CREATE TABLE IF NOT EXISTS `skill_type` (
  `id_skill_type` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_skill_type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skill` ;

CREATE TABLE IF NOT EXISTS `skill` (
  `id_skill` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_skill_type` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_skill`),
  CONSTRAINT `fk_skill_skill_type1`
    FOREIGN KEY (`id_skill_type`)
    REFERENCES `skill_type` (`id_skill_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_skill_skill_type1_idx` ON `skill` (`id_skill_type` ASC);


-- -----------------------------------------------------
-- Table `employee_skill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee_skill` ;

CREATE TABLE IF NOT EXISTS `employee_skill` (
  `id_employee_skill` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_employee` INT UNSIGNED NOT NULL,
  `id_skill` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_employee_skill`),
  CONSTRAINT `fk_employee_skill_employee1`
    FOREIGN KEY (`id_employee`)
    REFERENCES `employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_skill_skill1`
    FOREIGN KEY (`id_skill`)
    REFERENCES `skill` (`id_skill`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_employee_skill_employee1_idx` ON `employee_skill` (`id_employee` ASC);

CREATE INDEX `fk_employee_skill_skill1_idx` ON `employee_skill` (`id_skill` ASC);


-- -----------------------------------------------------
-- Table `employee_recruiting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee_recruiting` ;

CREATE TABLE IF NOT EXISTS `employee_recruiting` (
  `id_employee_recruiting` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_employee` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_employee_recruiting`),
  CONSTRAINT `fk_employee_recruiting_employee1`
    FOREIGN KEY (`id_employee`)
    REFERENCES `employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_employee_recruiting_employee1_idx` ON `employee_recruiting` (`id_employee` ASC);


-- -----------------------------------------------------
-- Table `employee_salary`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee_salary` ;

CREATE TABLE IF NOT EXISTS `employee_salary` (
  `id_employee_salary` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_employee` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_employee_salary`),
  CONSTRAINT `fk_employee_salary_employee1`
    FOREIGN KEY (`id_employee`)
    REFERENCES `employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_employee_salary_employee1_idx` ON `employee_salary` (`id_employee` ASC);


-- -----------------------------------------------------
-- Table `client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `client` ;

CREATE TABLE IF NOT EXISTS `client` (
  `id_client` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_client`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `employee_assignment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee_assignment` ;

CREATE TABLE IF NOT EXISTS `employee_assignment` (
  `id_employee_assignment` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_employee` INT UNSIGNED NOT NULL,
  `id_client` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_employee_assignment`),
  CONSTRAINT `fk_employee_assignment_employee1`
    FOREIGN KEY (`id_employee`)
    REFERENCES `employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_assignment_client1`
    FOREIGN KEY (`id_client`)
    REFERENCES `client` (`id_client`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_employee_assignment_employee1_idx` ON `employee_assignment` (`id_employee` ASC);

CREATE INDEX `fk_employee_assignment_client1_idx` ON `employee_assignment` (`id_client` ASC);


-- -----------------------------------------------------
-- Table `document_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `document_type` ;

CREATE TABLE IF NOT EXISTS `document_type` (
  `id_document_type` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_document_type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `employee_document`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee_document` ;

CREATE TABLE IF NOT EXISTS `employee_document` (
  `id_employee_document` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_employee` INT UNSIGNED NOT NULL,
  `id_document_type` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_employee_document`),
  CONSTRAINT `fk_employee_document_employee1`
    FOREIGN KEY (`id_employee`)
    REFERENCES `employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_document_document_type1`
    FOREIGN KEY (`id_document_type`)
    REFERENCES `document_type` (`id_document_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_employee_document_employee1_idx` ON `employee_document` (`id_employee` ASC);

CREATE INDEX `fk_employee_document_document_type1_idx` ON `employee_document` (`id_document_type` ASC);


-- -----------------------------------------------------
-- Table `employee_vacations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee_vacations` ;

CREATE TABLE IF NOT EXISTS `employee_vacations` (
  `id_employee_vacations` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_employee` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_employee_vacations`),
  CONSTRAINT `fk_employee_vacations_employee1`
    FOREIGN KEY (`id_employee`)
    REFERENCES `employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_employee_vacations_employee1_idx` ON `employee_vacations` (`id_employee` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;