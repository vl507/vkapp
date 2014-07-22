CREATE TABLE `users` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT(10),
  `first_name` VARCHAR(20),
  `last_name` VARCHAR(20),
  `bdate` VARCHAR(20),
  `city` VARCHAR(20),
  `country` VARCHAR(20),
  PRIMARY KEY (`id`)
) CHARSET=utf8;