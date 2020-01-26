-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 20, 2018 at 01:56 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mms`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `name` varchar(25) NOT NULL,
  `user_name` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`name`, `user_name`, `password`) VALUES
('Mr.Abcd', 'abcd', '1234'),
('Mr.Efgh', 'efgh', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `buys`
--

CREATE TABLE `buys` (
  `c_id` int(10) NOT NULL,
  `med_id` int(10) NOT NULL,
  `quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `c_id` int(10) NOT NULL,
  `name` varchar(25) NOT NULL,
  `phone` varchar(14) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `user_name` varchar(10) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`c_id`, `name`, `phone`, `address`, `user_name`, `password`) VALUES
(1, 'Mr.Dipto', '12345', 'abcde', 'abcde', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `dealt_emp`
--

CREATE TABLE `dealt_emp` (
  `e_id` int(10) NOT NULL,
  `payment_no` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `e_id` int(10) NOT NULL,
  `name` varchar(25) NOT NULL,
  `availability` tinyint(1) NOT NULL,
  `assoc_vech_no` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `manufacturer`
--

CREATE TABLE `manufacturer` (
  `manu_id` int(10) NOT NULL,
  `name` varchar(25) NOT NULL,
  `e_mail` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `manu_info`
--

CREATE TABLE `manu_info` (
  `batch_no` int(10) NOT NULL,
  `med_id` int(10) NOT NULL,
  `manu_id` int(10) NOT NULL,
  `exp_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `med_id` int(10) NOT NULL,
  `name` varchar(25) NOT NULL,
  `price` float NOT NULL,
  `avl_quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `order_info`
--

CREATE TABLE `order_info` (
  `c_id` int(10) NOT NULL,
  `order_time` datetime NOT NULL,
  `order_no` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payment_info`
--

CREATE TABLE `payment_info` (
  `c_id` int(10) NOT NULL,
  `payment_no` int(10) NOT NULL,
  `payment_time` datetime NOT NULL,
  `payment_amount` decimal(15,5) NOT NULL,
  `order_no` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pharmacy`
--

CREATE TABLE `pharmacy` (
  `p_id` int(10) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `e_mail` varchar(25) NOT NULL,
  `website` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stock_from`
--

CREATE TABLE `stock_from` (
  `med_id` int(10) NOT NULL,
  `manu_id` int(10) NOT NULL,
  `quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buys`
--
ALTER TABLE `buys`
  ADD KEY `med_id` (`med_id`),
  ADD KEY `buys_ibfk_1` (`c_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `dealt_emp`
--
ALTER TABLE `dealt_emp`
  ADD KEY `e_id` (`e_id`),
  ADD KEY `payment_no` (`payment_no`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`e_id`);

--
-- Indexes for table `manufacturer`
--
ALTER TABLE `manufacturer`
  ADD PRIMARY KEY (`manu_id`);

--
-- Indexes for table `manu_info`
--
ALTER TABLE `manu_info`
  ADD PRIMARY KEY (`batch_no`),
  ADD KEY `med_id` (`med_id`),
  ADD KEY `manu_id` (`manu_id`);

--
-- Indexes for table `medicine`
--
ALTER TABLE `medicine`
  ADD PRIMARY KEY (`med_id`);

--
-- Indexes for table `order_info`
--
ALTER TABLE `order_info`
  ADD PRIMARY KEY (`order_no`),
  ADD KEY `c_id` (`c_id`);

--
-- Indexes for table `payment_info`
--
ALTER TABLE `payment_info`
  ADD PRIMARY KEY (`payment_no`),
  ADD KEY `order_no` (`order_no`),
  ADD KEY `payment_info_ibfk_1` (`c_id`);

--
-- Indexes for table `pharmacy`
--
ALTER TABLE `pharmacy`
  ADD PRIMARY KEY (`p_id`);

--
-- Indexes for table `stock_from`
--
ALTER TABLE `stock_from`
  ADD KEY `med_id` (`med_id`),
  ADD KEY `manu_id` (`manu_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `c_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `order_info`
--
ALTER TABLE `order_info`
  MODIFY `order_no` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment_info`
--
ALTER TABLE `payment_info`
  MODIFY `payment_no` int(10) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `buys`
--
ALTER TABLE `buys`
  ADD CONSTRAINT `buys_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `customer` (`c_id`),
  ADD CONSTRAINT `buys_ibfk_2` FOREIGN KEY (`med_id`) REFERENCES `medicine` (`med_id`);

--
-- Constraints for table `dealt_emp`
--
ALTER TABLE `dealt_emp`
  ADD CONSTRAINT `dealt_emp_ibfk_1` FOREIGN KEY (`e_id`) REFERENCES `employee` (`e_id`),
  ADD CONSTRAINT `dealt_emp_ibfk_2` FOREIGN KEY (`e_id`) REFERENCES `payment_info` (`payment_no`),
  ADD CONSTRAINT `dealt_emp_ibfk_3` FOREIGN KEY (`payment_no`) REFERENCES `payment_info` (`payment_no`);

--
-- Constraints for table `manu_info`
--
ALTER TABLE `manu_info`
  ADD CONSTRAINT `manu_info_ibfk_1` FOREIGN KEY (`med_id`) REFERENCES `medicine` (`med_id`),
  ADD CONSTRAINT `manu_info_ibfk_2` FOREIGN KEY (`manu_id`) REFERENCES `manufacturer` (`manu_id`);

--
-- Constraints for table `order_info`
--
ALTER TABLE `order_info`
  ADD CONSTRAINT `order_info_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `customer` (`c_id`);

--
-- Constraints for table `payment_info`
--
ALTER TABLE `payment_info`
  ADD CONSTRAINT `payment_info_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `customer` (`c_id`),
  ADD CONSTRAINT `payment_info_ibfk_2` FOREIGN KEY (`order_no`) REFERENCES `order_info` (`order_no`);

--
-- Constraints for table `stock_from`
--
ALTER TABLE `stock_from`
  ADD CONSTRAINT `stock_from_ibfk_1` FOREIGN KEY (`med_id`) REFERENCES `medicine` (`med_id`),
  ADD CONSTRAINT `stock_from_ibfk_2` FOREIGN KEY (`manu_id`) REFERENCES `manufacturer` (`manu_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
