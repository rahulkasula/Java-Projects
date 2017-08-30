-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 09, 2015 at 02:06 AM
-- Server version: 5.6.27-log
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rahul`
--

-- --------------------------------------------------------

--
-- Table structure for table `temp`
--

CREATE TABLE IF NOT EXISTS `temp` (
  `powerconsumption` varchar(10) DEFAULT NULL,
  `start` varchar(2) DEFAULT NULL,
  `end` varchar(2) DEFAULT NULL,
  `username` varchar(35) DEFAULT NULL,
  `appliance` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `userlogin`
--

CREATE TABLE IF NOT EXISTS `userlogin` (
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `userlogin`
--

INSERT INTO `userlogin` (`username`, `password`) VALUES
('rahul', 'rahul');

-- --------------------------------------------------------

--
-- Table structure for table `utility`
--

CREATE TABLE IF NOT EXISTS `utility` (
  `appliance` varchar(25) NOT NULL,
  `powerconsumption` int(11) DEFAULT NULL,
  `start` varchar(20) DEFAULT NULL,
  `end` varchar(20) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `utility`
--

INSERT INTO `utility` (`appliance`, `powerconsumption`, `start`, `end`, `username`) VALUES
('cooler', 6000, '10', '11', 'rahul'),
('tv', 5000, '9', '10', 'rahul');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `utility`
--
ALTER TABLE `utility`
  ADD UNIQUE KEY `appliance` (`appliance`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
