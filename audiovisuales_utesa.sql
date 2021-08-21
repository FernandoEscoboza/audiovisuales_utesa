-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 22, 2021 at 01:46 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `audiovisuales_utesa`
--

-- --------------------------------------------------------

--
-- Table structure for table `contador`
--

CREATE TABLE `contador` (
  `num_serial` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contador`
--

INSERT INTO `contador` (`num_serial`) VALUES
(11);

-- --------------------------------------------------------

--
-- Table structure for table `detalle_reserva`
--

CREATE TABLE `detalle_reserva` (
  `id_reserva` int(10) NOT NULL,
  `id_art` int(10) NOT NULL,
  `desde` int(10) NOT NULL,
  `hasta` int(10) NOT NULL,
  `serial_art` varchar(15) NOT NULL,
  `estado` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detalle_reserva`
--

INSERT INTO `detalle_reserva` (`id_reserva`, `id_art`, `desde`, `hasta`, `serial_art`, `estado`) VALUES
(2, 1, 8, 10, 'UTS8', 'Ocupado'),
(1, 2, 8, 10, 'UTS4', 'Ocupado'),
(2, 2, 8, 10, 'UTS2', 'Ocupado'),
(3, 1, 8, 10, 'UTS9', 'Ocupado'),
(4, 3, 8, 10, 'UTS10', 'Ocupado'),
(4, 1, 8, 10, 'UTS6', 'Ocupado'),
(5, 1, 8, 10, 'UTS9', 'Ocupado'),
(6, 2, 8, 10, 'UTS5', 'Ocupado'),
(7, 1, 12, 2, 'UTS9', 'Ocupado'),
(8, 2, 12, 2, 'UTS5', 'Ocupado');

-- --------------------------------------------------------

--
-- Table structure for table `inventario_art`
--

CREATE TABLE `inventario_art` (
  `id_art` int(10) NOT NULL,
  `descri_art` varchar(40) NOT NULL,
  `cant_art` int(10) NOT NULL,
  `costo_art` int(10) NOT NULL,
  `estado_art` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventario_art`
--

INSERT INTO `inventario_art` (`id_art`, `descri_art`, `cant_art`, `costo_art`, `estado_art`) VALUES
(1, 'Data Show Epson', 2, 2000, 'Disponible'),
(2, 'Pantalla Dell', 1, 1500, 'Disponible'),
(3, 'Laptop HP', 2, 25000, 'Disponible');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `user_matri` varchar(10) NOT NULL,
  `pass` varchar(40) NOT NULL,
  `acceso` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`user_matri`, `pass`, `acceso`) VALUES
('2161286', '0417', 'Administrador'),
('2162012', '1704', 'Secundario'),
('1', '1234', 'Secundario');

-- --------------------------------------------------------

--
-- Table structure for table `log_reserva`
--

CREATE TABLE `log_reserva` (
  `id_reserva` int(10) NOT NULL,
  `matricula` int(10) NOT NULL,
  `fecha` date NOT NULL,
  `horario` varchar(5) NOT NULL,
  `desde` int(10) NOT NULL,
  `hasta` int(10) NOT NULL,
  `id_edificio` varchar(15) NOT NULL,
  `id_nivel` varchar(2) NOT NULL,
  `aula` varchar(10) NOT NULL,
  `serial` varchar(15) NOT NULL,
  `estado` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `log_reserva`
--

INSERT INTO `log_reserva` (`id_reserva`, `matricula`, `fecha`, `horario`, `desde`, `hasta`, `id_edificio`, `id_nivel`, `aula`, `serial`, `estado`) VALUES
(1, 2161286, '2018-12-21', 'AM', 8, 10, 'A', '1', '1', 'UTS4', 'Ocupado'),
(2, 2161286, '2018-12-21', 'AM', 8, 10, 'B', '1', '1', 'UTS2', 'Ocupado'),
(3, 2162012, '2018-12-21', 'AM', 8, 10, 'C', '2', '1', 'UTS9', 'Ocupado'),
(7, 2161286, '2021-08-23', 'PM', 12, 2, 'B', '4', '3', 'UTS9', 'Ocupado'),
(8, 2161286, '2021-08-23', 'PM', 12, 2, 'B', '4', '3', 'UTS5', 'Ocupado');

-- --------------------------------------------------------

--
-- Table structure for table `reserva`
--

CREATE TABLE `reserva` (
  `id_reserva` int(10) NOT NULL,
  `matricula` int(10) NOT NULL,
  `fecha` date NOT NULL,
  `horario` varchar(5) NOT NULL,
  `desde` int(10) NOT NULL,
  `hasta` int(10) NOT NULL,
  `id_edificio` varchar(15) NOT NULL,
  `id_nivel` varchar(2) NOT NULL,
  `aula` varchar(10) NOT NULL,
  `serial` varchar(15) NOT NULL,
  `estado` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reserva`
--

INSERT INTO `reserva` (`id_reserva`, `matricula`, `fecha`, `horario`, `desde`, `hasta`, `id_edificio`, `id_nivel`, `aula`, `serial`, `estado`) VALUES
(1, 2161286, '2018-12-21', 'AM', 8, 10, 'A', '1', '1', 'UTS4', 'Ocupado'),
(2, 2161286, '2018-12-21', 'AM', 8, 10, 'B', '1', '1', 'UTS2', 'Ocupado');

--
-- Triggers `reserva`
--
DELIMITER $$
CREATE TRIGGER `log_reserva` AFTER INSERT ON `reserva` FOR EACH ROW BEGIN
	
insert into log_reserva (id_reserva, matricula, fecha, horario, desde, hasta, id_edificio, id_nivel, aula, serial, estado)
values( new.id_reserva, new.matricula, new.fecha, new.horario, new.desde, new.hasta, new.id_edificio, new.id_nivel, new.aula, new.serial, 
new.estado );
	
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `serial_articulo`
--

CREATE TABLE `serial_articulo` (
  `id_art` int(10) NOT NULL,
  `descri_art` varchar(40) NOT NULL,
  `id_serial` varchar(20) NOT NULL,
  `estado` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `serial_articulo`
--

INSERT INTO `serial_articulo` (`id_art`, `descri_art`, `id_serial`, `estado`) VALUES
(2, 'Pantalla Dell', 'UTS1', 'Disponible'),
(2, 'Pantalla Dell', 'UTS2', 'Ocupado'),
(2, 'Pantalla Dell', 'UTS3', 'Disponible'),
(2, 'Pantalla Dell', 'UTS4', 'Ocupado'),
(2, 'Pantalla Dell', 'UTS5', 'Disponible'),
(1, 'Data Show Epson', 'UTS6', 'Disponible'),
(1, 'Data Show Epson', 'UTS7', 'Disponible'),
(1, 'Data Show Epson', 'UTS8', 'Disponible'),
(1, 'Data Show Epson', 'UTS9', 'Disponible'),
(3, 'Laptop HP', 'UTS10', 'Disponible'),
(3, 'Laptop HP', 'UTS11', 'Disponible');

-- --------------------------------------------------------

--
-- Table structure for table `tabla_estudiante`
--

CREATE TABLE `tabla_estudiante` (
  `matricula` int(7) NOT NULL,
  `nom_est` varchar(50) NOT NULL,
  `ape_est` varchar(50) NOT NULL,
  `sex_est` varchar(10) NOT NULL,
  `password` varchar(40) NOT NULL,
  `acceso` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabla_estudiante`
--

INSERT INTO `tabla_estudiante` (`matricula`, `nom_est`, `ape_est`, `sex_est`, `password`, `acceso`) VALUES
(2161286, 'Fernando De Jesus', 'Escoboza Martinez', 'M', '0417', 'Administrador'),
(2162012, 'Angelina', 'Santana Cruz', 'F', '1704', 'Secundario');

-- --------------------------------------------------------

--
-- Table structure for table `tabla_profesor`
--

CREATE TABLE `tabla_profesor` (
  `matricula` int(10) NOT NULL,
  `nom_prof` varchar(40) NOT NULL,
  `ape_prof` varchar(40) NOT NULL,
  `sex_prof` varchar(10) NOT NULL,
  `password` varchar(40) NOT NULL,
  `acceso` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabla_profesor`
--

INSERT INTO `tabla_profesor` (`matricula`, `nom_prof`, `ape_prof`, `sex_prof`, `password`, `acceso`) VALUES
(1, 'Wellington', 'Martinez', 'M', '1234', 'Secundario');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inventario_art`
--
ALTER TABLE `inventario_art`
  ADD PRIMARY KEY (`id_art`);

--
-- Indexes for table `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id_reserva`);

--
-- Indexes for table `tabla_estudiante`
--
ALTER TABLE `tabla_estudiante`
  ADD PRIMARY KEY (`matricula`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inventario_art`
--
ALTER TABLE `inventario_art`
  MODIFY `id_art` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id_reserva` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
