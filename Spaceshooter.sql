-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server Version:               5.6.20 - MySQL Community Server (GPL)
-- Server Betriebssystem:        Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Exportiere Datenbank Struktur für spaceshooter
CREATE DATABASE IF NOT EXISTS `spaceshooter` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `spaceshooter`;


-- Exportiere Struktur von Tabelle spaceshooter.rankings
CREATE TABLE IF NOT EXISTS `rankings` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Punktzahl` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Exportiere Daten aus Tabelle spaceshooter.rankings: ~5 rows (ungefähr)
/*!40000 ALTER TABLE `rankings` DISABLE KEYS */;
INSERT INTO `rankings` (`ID`, `Name`, `Punktzahl`) VALUES
	(1, 'DevT', 155558),
	(2, 'Malte', 178000),
	(3, 'Turag', 175000),
	(4, 'Yannik', 1),
	(5, 'Simme', 50000);
/*!40000 ALTER TABLE `rankings` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
