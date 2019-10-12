-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 12, 2019 at 06:51 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `attendance report system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Username`, `Password`) VALUES
('akibkhan', '2525');

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `StID` varchar(20) NOT NULL,
  `CourseID` varchar(20) NOT NULL,
  `Date` varchar(50) NOT NULL,
  `Attendance` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`StID`, `CourseID`, `Date`, `Attendance`) VALUES
('170041033', 'CSE4402', '12/10/2019', 'Present');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `CourseID` varchar(50) NOT NULL,
  `CourseName` varchar(100) NOT NULL,
  `Department` varchar(50) NOT NULL,
  `Sem` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`CourseID`, `CourseName`, `Department`, `Sem`) VALUES
('CSE4303', 'Data Structures', 'CSE', '3rd'),
('CSE4402', 'Visual Programming', 'CSE', '4th'),
('EEE4604', 'Digital Pulse', 'EEE', '6th');

-- --------------------------------------------------------

--
-- Table structure for table `course_student`
--

CREATE TABLE `course_student` (
  `CourseID` varchar(50) NOT NULL,
  `St_ID` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_student`
--

INSERT INTO `course_student` (`CourseID`, `St_ID`) VALUES
('CSE4402', '170041033');

-- --------------------------------------------------------

--
-- Table structure for table `course_teacher`
--

CREATE TABLE `course_teacher` (
  `CourseID` varchar(50) NOT NULL,
  `T_ID` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_teacher`
--

INSERT INTO `course_teacher` (`CourseID`, `T_ID`) VALUES
('CSE4303', 'si51'),
('CSE4402', '101'),
('CSE4402', 'H12'),
('EEE4604', 'H12');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`Username`, `Password`) VALUES
('akib', '1234'),
('nowshin', '3333');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `StID` varchar(20) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Semester` varchar(50) NOT NULL,
  `Department` varchar(20) NOT NULL,
  `Contact` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Session` int(11) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`StID`, `Name`, `Semester`, `Department`, `Contact`, `Email`, `Gender`, `Session`, `Password`) VALUES
('1230', 'ss', 'EEE', 'EEE', 'sss', 'sss', 'Male', 123, 'aa'),
('170041033', 'Nowshin Tabassum', '4th', 'CSE', '12345', 'qwert', 'Female', 2017, 'n33'),
('33', 'Nowshin', '4th', 'CSE', '', '', '', 0, ''),
('43', 'akib', '4th', 'CSE', '', '', '', 0, '');

-- --------------------------------------------------------

--
-- Table structure for table `teacherinfo`
--

CREATE TABLE `teacherinfo` (
  `Name` varchar(50) NOT NULL,
  `Department` varchar(50) NOT NULL,
  `Course` varchar(50) NOT NULL,
  `Contact_no` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `UserID` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Gender` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacherinfo`
--

INSERT INTO `teacherinfo` (`Name`, `Department`, `Course`, `Contact_no`, `Email`, `UserID`, `Password`, `Gender`) VALUES
('Sabbir Ahmed', 'EEE', 'CSE4403', '01854904321', 'sabbir_khan@gmail.com', '0', '0', ''),
('ABCD', 'MCE', 'CSE 4102', '123456', '123456@uhfu', '101', 'abcd', ''),
('Ridwan Kabir', 'CSE', 'CSE4402', '01234359307', 'mrk@yahoo.com', '102', 'rk', ''),
('asd', 'MCE', 'cxvxcv', 'agdsg', 'asdasf', '123456', '3413', ''),
('Nowshin', 'TVE', 'asfaef', 'a30592395', 'akihsoigsjofkwje', '223', 'askfjasf', ''),
('akib', 'CSE', 'CSE4405', '0159304794', 'khan@gmail.com', '2323', '9090', ''),
('Fayad ', 'EEE', 'EEE4405', '35235', 'fayad@yahoo.com', '245', 'ikr', ''),
('Herok', 'MCE', 'MCE4401', '103513850', 'herok@yahoo.com', 'H12', 'herok', ''),
('Swarupa Islam', 'CSE', 'CSE4407', '0135253567', 'swarupa@gmail.com', 'si51', 'xoxo', 'Female');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`CourseID`);

--
-- Indexes for table `course_student`
--
ALTER TABLE `course_student`
  ADD PRIMARY KEY (`CourseID`,`St_ID`),
  ADD KEY `St_ID` (`St_ID`);

--
-- Indexes for table `course_teacher`
--
ALTER TABLE `course_teacher`
  ADD PRIMARY KEY (`CourseID`,`T_ID`),
  ADD KEY `course_teacher_ibfk_1` (`T_ID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`StID`);

--
-- Indexes for table `teacherinfo`
--
ALTER TABLE `teacherinfo`
  ADD PRIMARY KEY (`UserID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `course_student`
--
ALTER TABLE `course_student`
  ADD CONSTRAINT `course_student_ibfk_1` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`),
  ADD CONSTRAINT `course_student_ibfk_2` FOREIGN KEY (`St_ID`) REFERENCES `student` (`StID`);

--
-- Constraints for table `course_teacher`
--
ALTER TABLE `course_teacher`
  ADD CONSTRAINT `course_teacher_ibfk_1` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
