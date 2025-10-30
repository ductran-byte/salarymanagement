-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 30, 2025 lúc 01:07 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `salarydb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employees`
--

CREATE TABLE `employees` (
  `id` bigint(20) NOT NULL,
  `allowance` double NOT NULL,
  `basic_salary` double NOT NULL,
  `department` varchar(50) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `position` varchar(50) DEFAULT NULL,
  `total_salary` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `employees`
--

INSERT INTO `employees` (`id`, `allowance`, `basic_salary`, `department`, `email`, `name`, `position`, `total_salary`) VALUES
(1, 300, 1200, 'IT', 'a.nguyen@company.com', 'Nguyen Van A Updated 1', 'Senior Developer', 1500),
(2, 300, 1500, 'HR', 'b.tran@company.com', 'Tran Thi B', 'HR Manager', 1800),
(3, 150, 1200, 'Finance', 'c.le@company.com', 'Le Van C', 'Accountant', 1350),
(4, 250, 1100, 'Sales', 'd.pham@company.com', 'Pham Thi D', 'Sales Executive', 1350),
(5, 100, 1000, 'Marketing', 'e.hoang@company.com', 'Hoang Van E', 'Content Creator', 1100),
(6, 180, 950, 'IT', 'f.do@company.com', 'Do Thi F', 'QA Engineer', 1130),
(7, 220, 1400, 'Operations', 'g.bui@company.com', 'Bui Van G', 'Supervisor', 1620),
(8, 150, 900, 'HR', 'h.nguyen@company.com', 'Nguyen Thi H Update', 'Recruiter', 1050),
(9, 200, 1300, 'Finance', 'i.vu@company.com', 'Vu Van I', 'Auditor', 1500),
(28, 300, 1200, 'IT', 'a.nguyen@comp4any.com', 'Nguyen Van A 1', 'Senior Developer', 1500),
(29, 300, 1200, 'IT', 'a.nguyen@co2mp4any.com', 'Nguyen Van A 3', 'Senior Developer', 1500);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKj9xgmd0ya5jmus09o0b8pqrpb` (`email`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `employees`
--
ALTER TABLE `employees`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
