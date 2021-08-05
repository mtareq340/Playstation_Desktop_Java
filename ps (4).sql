-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 24, 2019 at 11:20 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ps`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `b_id` int(11) NOT NULL,
  `b_from` varchar(100) NOT NULL,
  `b_to` varchar(100) NOT NULL,
  `b_duration` varchar(100) NOT NULL,
  `b_price` varchar(100) NOT NULL,
  `b_date` varchar(100) NOT NULL,
  `total` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bill`
--

-- --------------------------------------------------------

--
-- Table structure for table `billdrink`
--

CREATE TABLE `billdrink` (
  `bd_id` int(11) NOT NULL,
  `b_id` int(11) NOT NULL,
  `dr_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `billdrink`
--


-- --------------------------------------------------------

--
-- Table structure for table `buy`
--

CREATE TABLE `buy` (
  `bu_id` int(11) NOT NULL,
  `bu_name` varchar(150) NOT NULL,
  `bu_price` varchar(150) NOT NULL,
  `bu_date` varchar(100) NOT NULL,
  `bu_time` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `buy`
--

-- --------------------------------------------------------

--
-- Table structure for table `device`
--

CREATE TABLE `device` (
  `d_id` int(11) NOT NULL,
  `d_name` varchar(150) NOT NULL,
  `d_price` varchar(150) NOT NULL,
  `d_multi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `device`
--

INSERT INTO `device` (`d_id`, `d_name`, `d_price`, `d_multi`) VALUES
(1, 'Room 1', '20', '5'),
(2, 'Room 2', '20', '5'),
(3, 'Room 3', '25', '5'),
(4, 'Room 4', '20', '5'),
(5, 'Room 5', '30', '5'),
(6, 'Room 6(1)', '20', '5'),
(7, 'Room 6(2)', '20', '5'),
(8, 'Room 7', '20', '5');

-- --------------------------------------------------------

--
-- Table structure for table `drink`
--

CREATE TABLE `drink` (
  `dr_id` int(11) NOT NULL,
  `dr_name` varchar(150) NOT NULL,
  `dr_price` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `drink`
--


-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `u_id` int(11) NOT NULL,
  `u_name` varchar(150) NOT NULL,
  `u_password` varchar(150) NOT NULL,
  `u_role` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`u_id`, `u_name`, `u_password`, `u_role`) VALUES
(1, 'admin', 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`b_id`);

--
-- Indexes for table `billdrink`
--
ALTER TABLE `billdrink`
  ADD PRIMARY KEY (`bd_id`,`b_id`,`dr_id`),
  ADD KEY `BILLFK` (`b_id`),
  ADD KEY `DRINKFK20` (`dr_id`);

--
-- Indexes for table `buy`
--
ALTER TABLE `buy`
  ADD PRIMARY KEY (`bu_id`);

--
-- Indexes for table `device`
--
ALTER TABLE `device`
  ADD PRIMARY KEY (`d_id`);

--
-- Indexes for table `drink`
--
ALTER TABLE `drink`
  ADD PRIMARY KEY (`dr_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `b_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `billdrink`
--
ALTER TABLE `billdrink`
  MODIFY `bd_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `buy`
--
ALTER TABLE `buy`
  MODIFY `bu_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `device`
--
ALTER TABLE `device`
  MODIFY `d_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `drink`
--
ALTER TABLE `drink`
  MODIFY `dr_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `billdrink`
--
ALTER TABLE `billdrink`
  ADD CONSTRAINT `BILLFK` FOREIGN KEY (`b_id`) REFERENCES `bill` (`b_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `DRINKFK20` FOREIGN KEY (`dr_id`) REFERENCES `drink` (`dr_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
