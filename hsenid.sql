-- phpMyAdmin SQL Dump
-- version 4.5.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 27, 2016 at 02:33 PM
-- Server version: 5.6.30-0ubuntu0.15.10.1
-- PHP Version: 5.6.11-1ubuntu3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hsenid`
--

-- --------------------------------------------------------

--
-- Table structure for table `userdetails`
--

CREATE TABLE `userdetails` (
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `dob` date NOT NULL,
  `country` enum('Sri Lanka','Japan','United Kingdom','United States','Australia') NOT NULL,
  `email` varchar(100) NOT NULL,
  `mnumber` bigint(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userdetails`
--

INSERT INTO `userdetails` (`fname`, `lname`, `dob`, `country`, `email`, `mnumber`, `username`, `password`) VALUES
('huhhh', 'fhf', '1991-07-11', 'United Kingdom', 'menuka@gmail.com', 94716310375, 'grs', '40bd001563085fc35165329ea1ff5c5ecbdbbeef'),
('nm ,nb', '', '1994-07-07', 'Sri Lanka', 'menuka@gmail.com', 94716310375, 'nbvnbv', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2'),
('Menuka', 'Ishan', '2016-04-12', 'Sri Lanka', 'menuka@gmail.com', 947166423, 'test', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc'),
('testeeee', 'ddfg', '1991-03-16', 'Sri Lanka', 'menuka@gmail.com', 94716310375, 'test1', 'aaa'),
('Test SHA', 'SHAAA', '1991-03-16', 'United States', 'menmvbmnuka@gmail.com', 94716310375, 'test2', '7e240de74fb1ed08fa08d38063f6a6a91462a815'),
('test date', 'thada', '1995-07-06', 'Australia', 'menuka@gmail.com', 94716310375, 'tttyyyywfgd', '186154712b2d5f6791d85b9a0987b98fa231779c');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`) VALUES
('test', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `userdetails`
--
ALTER TABLE `userdetails`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
