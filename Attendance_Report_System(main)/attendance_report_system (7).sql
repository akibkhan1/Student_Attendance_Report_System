-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 13, 2019 at 02:36 PM
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
('170041001', 'CSE4403', '11/10/2019', 'Present'),
('170041001', 'CSE4403', '12/10/19', 'Present'),
('170041001', 'CSE4403', '13/10/2019', 'Absent'),
('170041002', 'CSE4403', '11/10/2019', 'Present'),
('170041002', 'CSE4403', '12/10/2019', 'Present'),
('170041002', 'CSE4403', '13/10/2019', 'Present'),
('170041043', 'CSE4403', '11/10/2019', 'Absent'),
('170041043', 'CSE4403', '12/10/2019', 'Absent'),
('170041043', 'CSE4403', '13/10/2019', 'Present');

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
('CSE4403', 'Algorithms', 'CSE', '4th'),
('CSE4404', 'Algorithms Lab', 'CSE', '4th'),
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
('CSE4402', '170041001'),
('CSE4402', '170041002'),
('CSE4402', '170041003'),
('CSE4402', '170041004'),
('CSE4403', '170041001'),
('CSE4403', '170041002'),
('CSE4403', '170041003'),
('CSE4403', '170041004'),
('CSE4404', '170041001'),
('CSE4404', '170041002'),
('CSE4404', '170041003'),
('CSE4404', '170041004');

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
('CSE4303', '12kushol'),
('CSE4403', 'Sabbir101');

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
('170041001', 'Anika Tasnim', '4th', 'CSE', '019249035', 'asfa', 'Female', 2017, '1234'),
('170041002', 'Akib Mahmud Rime', '4th', 'CSE', '35246', 'asd', 'Male', 2017, '1234'),
('170041003', 'Ali Abir Shuvro', '4th', 'CSE', '235', 'asd', 'Male', 2017, '1234'),
('170041004', 'Abdullah Abu Sayed', '4th', 'CSE', '20935', 'adsf', 'Male', 2017, '1234'),
('170041043', 'Akib Khan', '4th', 'CSE', '245', 'asf', 'Male', 2017, '1234');

-- --------------------------------------------------------

--
-- Table structure for table `teacherinfo`
--

CREATE TABLE `teacherinfo` (
  `Name` varchar(50) NOT NULL,
  `Department` varchar(50) NOT NULL,
  `Contact_no` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `UserID` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Gender` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacherinfo`
--

INSERT INTO `teacherinfo` (`Name`, `Department`, `Contact_no`, `Email`, `UserID`, `Password`, `Gender`) VALUES
('Rafsanjany Kushol', 'CSE', '01530234631', 'kushol@gmail.com', '12kushol', '1234', 'Male'),
('Safayet Hakim', 'EEE', '01539234691', 'hakim@gmail.com', 'Hakim22', '1234', 'Male'),
('Ridwan Kabir', 'CSE', '0185930323', 'ridwan@yahoo.com', 'Ridwan303', '1234', 'Male'),
('Sabbir Ahmed', 'CSE', '0170743291', 'sabbir@gmail.com', 'Sabbir101', '1234', 'Male');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`StID`,`CourseID`,`Date`);

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
