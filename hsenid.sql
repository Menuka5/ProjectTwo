-- phpMyAdmin SQL Dump
-- version 4.5.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 20, 2016 at 01:44 PM
-- Server version: 5.6.30-0ubuntu0.15.10.1
-- PHP Version: 5.6.11-1ubuntu3.3

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
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `city_id` int(11) NOT NULL,
  `country_id` int(11) NOT NULL,
  `city` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`city_id`, `country_id`, `city`) VALUES
(1, 1, 'Matara'),
(2, 1, 'Colombo'),
(3, 1, 'Galle'),
(4, 1, 'Kandy'),
(5, 1, 'Gampaha'),
(6, 2, 'Tokyo'),
(7, 2, 'Kyoto'),
(8, 2, 'Osaka'),
(9, 2, 'Yokohama'),
(10, 2, 'Hiroshima'),
(11, 3, 'London'),
(12, 3, 'Manchester'),
(13, 3, 'Bristol'),
(14, 3, 'Sheffield'),
(15, 3, 'Cambridge'),
(16, 4, 'New York'),
(17, 4, 'Washington'),
(18, 4, 'Miami'),
(19, 4, 'Las Vegas'),
(20, 4, 'Los Angeles'),
(21, 5, 'Sydney'),
(22, 5, 'Melbourne'),
(23, 5, 'Perth'),
(24, 5, 'Brisbane'),
(25, 5, 'Darwin');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `country_id` int(11) NOT NULL,
  `country` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`country_id`, `country`) VALUES
(1, 'Sri Lanka'),
(2, 'Japan'),
(3, 'United Kingdom'),
(4, 'United States'),
(5, 'Australia');

-- --------------------------------------------------------

--
-- Table structure for table `group_name`
--

CREATE TABLE `group_name` (
  `group_id` int(10) UNSIGNED NOT NULL,
  `group_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `group_name`
--

INSERT INTO `group_name` (`group_id`, `group_name`) VALUES
(1, 'Administrator'),
(2, 'Customer care'),
(3, 'Translator'),
(4, 'Blocked');

-- --------------------------------------------------------

--
-- Table structure for table `group_permission`
--

CREATE TABLE `group_permission` (
  `group_id` int(10) UNSIGNED NOT NULL,
  `permission_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `group_permission`
--

INSERT INTO `group_permission` (`group_id`, `permission_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(2, 3),
(2, 5),
(3, 5);

-- --------------------------------------------------------

--
-- Table structure for table `permissions`
--

CREATE TABLE `permissions` (
  `permission_id` int(10) UNSIGNED NOT NULL,
  `permission` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `permissions`
--

INSERT INTO `permissions` (`permission_id`, `permission`) VALUES
(1, 'Add user'),
(2, 'Edit user'),
(3, 'Search user'),
(4, 'Delete user'),
(5, 'Translate');

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
  `city_id` int(11) NOT NULL,
  `mnumber` bigint(11) NOT NULL,
  `group_id` int(10) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userdetails`
--

INSERT INTO `userdetails` (`fname`, `lname`, `dob`, `country`, `email`, `city_id`, `mnumber`, `group_id`, `username`, `password`) VALUES
('Blocked', 'User', '1991-04-29', 'Sri Lanka', 'dsfdfffewf@gmail.com', 4, 94716310123, 4, 'blocked', 'df88b84d816d3358b3793a61b73d80e93913e627'),
('Conflict', 'Over', '1985-02-13', 'United Kingdom', 'conflict@gmail.com', 15, 94716310375, 2, 'conflict', 'ae214513a0d21125291c9566dfdb0fcb1fdd1d2b'),
('dateEdgfd', 'pickerEd', '1970-01-27', 'Sri Lanka', 'menuka@gmail.com', 3, 94716310375, 4, 'datepicker', '40bd001563085fc35165329ea1ff5c5ecbdbbeef'),
('Fourthof', 'May', '1991-04-29', 'Australia', 'fourth@gmail', 25, 94716316542, 3, 'fourthmay', '7c4a8d09ca3762af61e59520943dc26494f8941b'),
('unique', 'username', '1980-07-07', 'United Kingdom', 'modaua@gmail.com', 15, 94716319875, 1, 'gfdgsdfawer', '7110eda4d09e062aa5e4a390b0a572ac0d2c0220'),
('help', 'help', '1111-03-08', 'United States', 'meefgartqtnuka@gmail.com', 17, 94713314375, 3, 'help', '92005ecf3788faea8346a7919fba0232188561ab'),
('Mmmmmm', 'mnskaka', '1990-05-23', 'United States', 'dsdfgfdvxcva@gmail.com', 18, 94716312345, 2, 'hhhhhh', '8cb2237d0679ca88db6464eac60da96345513964'),
('hulk', '', '1990-04-13', 'Japan', 'dsfsafsdfa@gmail.com', 7, 94716710375, 2, 'hulk', 'c829575cb9bdd27191cb3377c4f2e1794d6dd236'),
('testlast', '', '1994-07-07', 'Sri Lanka', 'menuka@gmail.com', 1, 94716310375, 3, 'nbvnbv', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2'),
('NewOne', 'LastName', '1991-03-14', 'Sri Lanka', 'menuka@gmail.com', 2, 94716310375, 3, 'NewOne', 'a8c49bd30caee87a85185aee43d226d6a0715e50'),
('Spidey', 'Manna', '1990-06-13', 'United States', 'spiderman@gmail.com', 19, 94719346546, 1, 'spiderman', '368f976940775c710aec525fe1e349f8a1fb9a39'),
('superman', 'Kent', '1989-03-23', 'Sri Lanka', 'gfsdgdsg@gmail.com', 5, 94719910375, 2, 'superman', '18c28604dd31094a8d69dae60f1bcd347f1afc5a'),
('Menuka', 'Ishan', '2016-04-12', 'Sri Lanka', 'menuka@gmail.com', 2, 947166423, 1, 'test', '7288edd0fc3ffcbe93a0cf06e3568e28521687bc'),
('testeeee', 'ddfg', '1991-03-16', 'Sri Lanka', 'menuka@gmail.com', 3, 94716310375, 3, 'test1', 'aaa'),
('hello', 'hiu', '1991-03-16', 'Sri Lanka', 'mgbdfsggenuka@gmail.com', 4, 94716310375, 3, 'test122', '40bd001563085fc35165329ea1ff5c5ecbdbbeef'),
('Test SHA', 'SHAAA', '1991-03-16', 'United States', 'menmvbmnuka@gmail.com', 19, 94716310375, 3, 'test2', '7e240de74fb1ed08fa08d38063f6a6a91462a815'),
('Test', 'Alerts', '1993-11-15', 'Sri Lanka', 'nivfvd@gmail.com', 2, 94716310456, 2, 'testalert', 'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3'),
('test date', 'thada', '1995-07-06', 'Australia', 'menuka@gmail.com', 22, 94716310375, 3, 'tttyyyywfgd', '186154712b2d5f6791d85b9a0987b98fa231779c');

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
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`city_id`),
  ADD KEY `FK_city_foreign` (`country_id`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`country_id`);

--
-- Indexes for table `group_name`
--
ALTER TABLE `group_name`
  ADD PRIMARY KEY (`group_id`);

--
-- Indexes for table `group_permission`
--
ALTER TABLE `group_permission`
  ADD PRIMARY KEY (`group_id`,`permission_id`);

--
-- Indexes for table `permissions`
--
ALTER TABLE `permissions`
  ADD PRIMARY KEY (`permission_id`);

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

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `city_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
  MODIFY `country_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `city`
--
ALTER TABLE `city`
  ADD CONSTRAINT `FK_city_foreign` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
