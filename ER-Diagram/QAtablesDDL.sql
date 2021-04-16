-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema qa_platform
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema qa_platform
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `qa_platform` DEFAULT CHARACTER SET utf8 ;
USE `qa_platform` ;

-- -----------------------------------------------------
-- Table `qa_platform`.`Company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qa_platform`.`Company` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qa_platform`.`Topic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qa_platform`.`Topic` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qa_platform`.`Subtopic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qa_platform`.`Subtopic` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Topic_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `Topic_ID`),
  INDEX `fk_Subtopic_Topic_idx` (`Topic_ID` ASC) VISIBLE,
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE,
  CONSTRAINT `fk_Subtopic_Topic`
    FOREIGN KEY (`Topic_ID`)
    REFERENCES `qa_platform`.`Topic` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qa_platform`.`Tags`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qa_platform`.`Tags` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qa_platform`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qa_platform`.`User` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qa_platform`.`Qestions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qa_platform`.`Qestions` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Text` VARCHAR(500) NOT NULL,
  `UserID` VARCHAR(45) NULL,
  `Subtopic_ID` INT NOT NULL,
  `Subtopic_Topic_ID` INT NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `Subtopic_ID`, `Subtopic_Topic_ID`),
  INDEX `fk_Qestions_Subtopic1_idx` (`Subtopic_ID` ASC, `Subtopic_Topic_ID` ASC) VISIBLE,
  INDEX `fk_Qestions_User1_idx` (`User_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Qestions_Subtopic1`
    FOREIGN KEY (`Subtopic_ID` , `Subtopic_Topic_ID`)
    REFERENCES `qa_platform`.`Subtopic` (`ID` , `Topic_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Qestions_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `qa_platform`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qa_platform`.`Question_likes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qa_platform`.`Question_likes` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Qestions_ID` INT NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Question_likes_Qestions1_idx` (`Qestions_ID` ASC) VISIBLE,
  INDEX `fk_Question_likes_User1_idx` (`User_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Question_likes_Qestions1`
    FOREIGN KEY (`Qestions_ID`)
    REFERENCES `qa_platform`.`Qestions` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Question_likes_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `qa_platform`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qa_platform`.`Questions_Company_Map`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qa_platform`.`Questions_Company_Map` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Company_ID` INT NOT NULL,
  `Qestions_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Company_Questions_Map_Company1_idx` (`Company_ID` ASC) VISIBLE,
  INDEX `fk_Company_Questions_Map_Qestions1_idx` (`Qestions_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Company_Questions_Map_Company1`
    FOREIGN KEY (`Company_ID`)
    REFERENCES `qa_platform`.`Company` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Company_Questions_Map_Qestions1`
    FOREIGN KEY (`Qestions_ID`)
    REFERENCES `qa_platform`.`Qestions` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qa_platform`.`Questions_Tags_Map`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qa_platform`.`Questions_Tags_Map` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Tags_ID` INT NOT NULL,
  `Qestions_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Questions_Tags_Map_Tags1_idx` (`Tags_ID` ASC) VISIBLE,
  INDEX `fk_Questions_Tags_Map_Qestions1_idx` (`Qestions_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Questions_Tags_Map_Tags1`
    FOREIGN KEY (`Tags_ID`)
    REFERENCES `qa_platform`.`Tags` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Questions_Tags_Map_Qestions1`
    FOREIGN KEY (`Qestions_ID`)
    REFERENCES `qa_platform`.`Qestions` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qa_platform`.`Answers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qa_platform`.`Answers` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Text` VARCHAR(500) NOT NULL,
  `User_ID` INT NOT NULL,
  `Qestions_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `Qestions_ID`),
  INDEX `fk_Answers_User1_idx` (`User_ID` ASC) VISIBLE,
  INDEX `fk_Answers_Qestions1_idx` (`Qestions_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Answers_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `qa_platform`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Answers_Qestions1`
    FOREIGN KEY (`Qestions_ID`)
    REFERENCES `qa_platform`.`Qestions` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `qa_platform`.`Comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qa_platform`.`Comments` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Text` VARCHAR(45) NOT NULL,
  `User_ID` INT NOT NULL,
  `Answers_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Comments_User1_idx` (`User_ID` ASC) VISIBLE,
  INDEX `fk_Comments_Answers1_idx` (`Answers_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Comments_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `qa_platform`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comments_Answers1`
    FOREIGN KEY (`Answers_ID`)
    REFERENCES `qa_platform`.`Answers` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qa_platform`.`Answer_Likes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qa_platform`.`Answer_Likes` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Answers_ID` INT NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Answer_Likes_Answers1_idx` (`Answers_ID` ASC) VISIBLE,
  INDEX `fk_Answer_Likes_User1_idx` (`User_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Answer_Likes_Answers1`
    FOREIGN KEY (`Answers_ID`)
    REFERENCES `qa_platform`.`Answers` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Answer_Likes_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `qa_platform`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
