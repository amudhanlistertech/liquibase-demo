DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
   `id` long,
  `customer_number` int(11) NOT NULL,
  `customer_name` varchar(50) NOT NULL,
   PRIMARY KEY (`id`)
 );
insert  into `customer`(`id`,`customer_number`,`customer_name`) values 
(1,101,'Schmitt'),(2,102,'Jean');