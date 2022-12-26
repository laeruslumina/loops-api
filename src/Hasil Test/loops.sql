-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 26, 2022 at 07:34 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `loops`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank_list`
--

CREATE TABLE `bank_list` (
  `virtual_acc` bigint(20) NOT NULL,
  `balance` decimal(19,2) DEFAULT NULL,
  `bank_list_id` bigint(20) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank_list`
--

INSERT INTO `bank_list` (`virtual_acc`, `balance`, `bank_list_id`, `bank_name`) VALUES
(8099111, '50000.00', 1, 'BCA'),
(8099222, '100000.00', 2, 'BRI'),
(8099333, '150000.00', 3, 'BCA'),
(8099444, '500000.00', 4, 'BRI');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoice_id` bigint(20) NOT NULL,
  `base_price` decimal(19,2) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `discount` decimal(19,2) DEFAULT NULL,
  `merchant_id` bigint(20) DEFAULT NULL,
  `total_price` decimal(19,2) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `virtual_acc` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `merchant`
--

CREATE TABLE `merchant` (
  `payment_id` bigint(20) NOT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `merchant_id` bigint(20) DEFAULT NULL,
  `merchant_name` varchar(255) DEFAULT NULL,
  `pay_amount` decimal(19,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `merchant`
--

INSERT INTO `merchant` (`payment_id`, `customer_name`, `merchant_id`, `merchant_name`, `pay_amount`) VALUES
(101010, 'Fuad Mubarak', 1, 'BPJS', '40000.00'),
(202020, 'Pariz', 2, 'PLN', '100000.00'),
(303030, 'Farah', 3, 'PDAM', '150000.00'),
(404040, 'Rizqi Nurdin', 2, 'PLN', '220000.00'),
(505050, 'Candra Aji T N', 1, 'BPJS', '500000.00');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `address_alter` varchar(255) DEFAULT NULL,
  `balance` decimal(19,2) DEFAULT NULL,
  `cities` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `address`, `address_alter`, `balance`, `cities`, `country`, `email`, `gender`, `name`, `password`, `phone_number`, `postal_code`, `province`) VALUES
(1, 'lidah', 'wiyung', '0.00', 'sby', 'indosiar', 'Candraaji@gmail.com', 'Male', 'Muhammad Candra Aji Taruna Nugraha', 'Candra@123', '085791475192', '60213', 'jawa timur'),
(2, NULL, NULL, '0.00', NULL, NULL, 'fuadmubarak@gmail.com', 'Male', 'Fuad Mubarak', 'Fuad@123', '0833912351912', NULL, NULL),
(3, NULL, NULL, '0.00', NULL, NULL, 'nurdinmtop@gmail.com', 'Male', 'Muhammad Rizqinurdin', 'Nurdin@123', '0833912351912', NULL, NULL),
(4, NULL, NULL, '0.00', NULL, NULL, 'semzudin@gmail.com', 'Female', 'Luthfiana Faradillah', 'Semzudin@123', '0833912351912', NULL, NULL),
(5, NULL, NULL, '0.00', NULL, NULL, 'predator@gmail.com', 'Male', 'Pariz Aja', 'Predator@123', '0833912351912', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank_list`
--
ALTER TABLE `bank_list`
  ADD PRIMARY KEY (`virtual_acc`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoice_id`);

--
-- Indexes for table `merchant`
--
ALTER TABLE `merchant`
  ADD PRIMARY KEY (`payment_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `invoice_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
