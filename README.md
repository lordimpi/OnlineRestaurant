## Run this script in mysql

Database creation
```ssh
	CREATE DATABASE `restaurante`
```
Tables creations
```ssh
	CREATE TABLE `restaurante`.`maindish`( 
		`id_dish` VARCHAR(50) NOT NULL , 
		`dish_name` VARCHAR(50) NOT NULL , 
		`dish_price` DOUBLE NOT NULL , 
		PRIMARY KEY (`id_dish`)) ENGINE = InnoDB;
```
Inserts
```ssh
	INSERT INTO `maindish` (`id_dish`, `dish_name`, `dish_price`) 
	VALUES ('1', 'cuy asado', '20000'), ('2', 'bandeja paisa', '10000');
```
