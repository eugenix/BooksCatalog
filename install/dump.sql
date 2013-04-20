/*
SQLyog Ultimate v10.42 
MySQL - 5.1.58-1ubuntu1-log : Database - books_catalog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`books_catalog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `books_catalog`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `imageUrl` varchar(255) NOT NULL,
  `authorName` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  `isbn` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`title`,`description`,`imageUrl`,`authorName`,`publisher`,`isbn`,`price`) values (1,'Анна Каренина','\"Анна Каренина\" - лучший роман о женщине, написанный в XIX веке. По словам Ф.М.Достоевского, \"Анна Каренина\" поразила современников \"не только в','https://static.ozone.ru/multimedia/books_covers/c200/1005695675.jpg','Лев Толстой','Азбука-Аттикус','1234567890',100.00),(2,'Горе от ума','\"Горе от ума\" - одна из первых русских комедий, разодранных на пословицы и поговорки, которыми до сих пор украшена речь всякого мало-мальски ','https://static.ozone.ru/multimedia/books_covers/c200/1002999646.jpg','Александр Грибоедов','Азбука','1234512345',200.99),(3,'Братья Карамазовы','\"Братья Карамазовы\" - одна из немногих в мировой литературе удавшихся попыток сочетать увлекательный роман-триллер, как мы выразись бы тепе','https://static.ozone.ru/multimedia/books_covers/c200/1000864122.jpg','Федор Достоевский','Эксмо','5432154321',300.00),(4,'Преступление и наказание','Одно из \"краеугольных\" произведений русской и мировой литературы, включенный во все школьные и университетские программы, неоднократно эк','https://static.ozone.ru/multimedia/books_covers/c200/1005685179.jpg','Федор Достоевский','Азбука-Аттикус','0987654321',530.00),(5,'Идиот','\"Главная идея... - писал Ф.М.Достоевский о своем романе \"Идиот\", - изобразить положительно-прекрасного человека. ','https://static.ozone.ru/multimedia/books_covers/c200/1005626147.jpg','Федор Достоевский','Азбука-Аттикус','1111111111',140.00),(7,'Отцы и дети','\"Отцы и дети\" - самый философский из всех романов Тургенева, в котором писатель пытался осмыслить характер и направление \"новых людей\" - геро','https://static.ozone.ru/multimedia/books_covers/c200/1005674238.jpg','Иван Тургенев','Азбука-Аттикус','2222222222',150.99),(8,'Мертвые души','В одиннадцатый том второй серии вошли избранный произведения Н.Гоголя - повести \"Невский проспект\", \"Нос\", \"Портрет\", \"Шинель\", \"Записки сумасш','https://static.ozone.ru/multimedia/books_covers/c200/1000015611.jpg','Н. Гоголь','Художественная литература. Москва','3333333333',45.00),(10,'Атлант расправил плечи','К власти в США приходят социалисты и правительство берет курс на \"равные возможности\", считая справедливым за счет талантливых и состоятельных сделать богатыми никчемных и бесталанных. Гонения на бизнес приводят к разрушению экономики, к тому же один за другим при загадочных обстоятельствах начинают исчезать талантливые люди и лучшие предприниматели. Главные герои романа стальной король Хэнк Риарден и вице-президент железнодорожной компании Дагни Таггерт тщетно пытаются противостоять трагическим событиям. Вместо всеобщего процветания общество погружается в апатию и хаос. ','https://static.ozone.ru/multimedia/books_covers/c200/1005679879.jpg','Айн Рэнд','Альпина Паблишер','3211231237',90.00);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Идентификатор пользователя',
  `login` varchar(64) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Сущность пользователь';

/*Data for the table `user` */

insert  into `user`(`id`,`login`,`password`) values (1,'admin','PASSWORD'),(2,'new_login','new_password');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
