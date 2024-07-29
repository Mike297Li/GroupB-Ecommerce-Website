
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) DEFAULT NULL,
  `account_password` varchar(255) DEFAULT NULL,
  `account_is_seller` int DEFAULT NULL,
  `account_is_admin` int DEFAULT NULL,
  `account_image` longblob,
  `account_address` varchar(255) DEFAULT NULL,
  `account_first_name` varchar(255) DEFAULT NULL,
  `account_last_name` varchar(255) DEFAULT NULL,
  `account_email` varchar(255) DEFAULT NULL,
  `account_phone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  `category_number_product` int DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for contact_info
-- ----------------------------
DROP TABLE IF EXISTS `contact_info`;
CREATE TABLE `contact_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `message` text NOT NULL,
  `submitted_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `fk_account_id` int DEFAULT NULL,
  `order_total` float DEFAULT NULL,
  `order_date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`),
  KEY `fk_account_id` (`fk_account_id`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`fk_account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `fk_product_id` int DEFAULT NULL,
  `fk_order_id` int DEFAULT NULL,
  `product_quantity` int DEFAULT NULL,
  `product_price` float DEFAULT NULL,
  KEY `fk_product_id` (`fk_product_id`),
  KEY `fk_order_id` (`fk_order_id`),
  CONSTRAINT `order_detail_ibfk_2` FOREIGN KEY (`fk_product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `order_detail_ibfk_3` FOREIGN KEY (`fk_order_id`) REFERENCES `order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) DEFAULT NULL,
  `product_image` longblob,
  `product_price` float DEFAULT NULL,
  `product_description` varchar(3000) DEFAULT NULL,
  `fk_category_id` int DEFAULT NULL,
  `fk_account_id` int DEFAULT NULL,
  `product_is_deleted` tinyint(1) DEFAULT NULL,
  `product_amount` int DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `fk_category_id` (`fk_category_id`),
  KEY `fk_account_id` (`fk_account_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`fk_category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`fk_account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;


ALTER TABLE account MODIFY account_phone VARCHAR(15);
