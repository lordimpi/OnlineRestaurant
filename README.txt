//Run this script in mysql

CREATE DATABASE `restaurante`

CREATE TABLE `restaurante`.`maindish`( 
		`id_dish` VARCHAR(50) NOT NULL , 
		`dish_name` VARCHAR(50) NOT NULL , 
		`dish_price` DOUBLE NOT NULL , 
		PRIMARY KEY (`id_dish`)) ENGINE = InnoDB;


INSERT INTO `maindish` (`id_dish`, `dish_name`, `dish_price`) 
VALUES ('1', 'cuy asado', '20000'), ('2', 'bandeja paisa', '10000');