-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.5.60-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- example 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `example` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `example`;

-- 테이블 example.example 구조 내보내기
CREATE TABLE IF NOT EXISTS `example` (
  `IDX` int(8) DEFAULT NULL,
  `NAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `AGE` int(8) DEFAULT NULL,
  `COUNTRY` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 테이블 데이터 example.example:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `example` DISABLE KEYS */;
INSERT INTO `example` (`IDX`, `NAME`, `AGE`, `COUNTRY`) VALUES
	(1, 'Karl Heinrich Marx', 64, 'Germany'),
	(2, 'Socrates', 70, 'Greece'),
	(3, 'René Descartes', 53, 'France');
/*!40000 ALTER TABLE `example` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
