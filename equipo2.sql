-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2022 at 10:33 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `equipo2`
--

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `idDireccion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`, `apellido`, `email`, `sexo`, `idDireccion`) VALUES
(1, 'Samuel', 'Guerrero', 'itougn15@gmail.com', 'Femenino', 1),
(2, 'Jorge', 'Narváez', 'jorgito123@gmail.com', 'Femenino', 1),
(24, 'David', 'Martínez Torres', 'dtorres@gmail.com', 'M', 1);

-- --------------------------------------------------------

--
-- Table structure for table `detalleventas`
--

CREATE TABLE `detalleventas` (
  `ventaId` int(11) NOT NULL,
  `productoId` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detalleventas`
--

INSERT INTO `detalleventas` (`ventaId`, `productoId`, `cantidad`) VALUES
(46, 3, 1),
(47, 3, 1),
(49, 17, 1),
(51, 17, 1),
(52, 3, 1),
(54, 22, 1),
(58, 3, 2),
(58, 17, 3),
(62, 3, 1),
(62, 33, 1),
(63, 34, 1);

-- --------------------------------------------------------

--
-- Table structure for table `direccion`
--

CREATE TABLE `direccion` (
  `idDireccion` int(11) NOT NULL,
  `calle` varchar(80) NOT NULL,
  `numero` int(11) NOT NULL,
  `colonia` varchar(100) NOT NULL,
  `ciudad` varchar(80) NOT NULL,
  `estado` varchar(80) NOT NULL,
  `pais` varchar(80) NOT NULL,
  `codigoPostal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `direccion`
--

INSERT INTO `direccion` (`idDireccion`, `calle`, `numero`, `colonia`, `ciudad`, `estado`, `pais`, `codigoPostal`) VALUES
(1, 'Alamos', 4, 'Los Presidentes', 'Huajuapan', 'Oaxaca', 'Mexico', 690007),
(3, 'Micaela Galindo', 3, 'Centro', 'Huajuapan', 'Oaxaca', 'Mexico', 69000);

-- --------------------------------------------------------

--
-- Table structure for table `ganancias`
--

CREATE TABLE `ganancias` (
  `idGanancia` int(11) NOT NULL,
  `ventaId` int(11) NOT NULL,
  `totalGanancia` double NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ganancias`
--

INSERT INTO `ganancias` (`idGanancia`, `ventaId`, `totalGanancia`, `fecha`) VALUES
(35, 55, 10, '2022-06-23'),
(36, 56, 10, '2022-06-23'),
(37, 57, 15, '2022-06-23'),
(38, 58, 15, '2022-06-23'),
(39, 59, 10, '2022-06-23'),
(40, 60, 15, '2022-06-23'),
(41, 61, 10, '2022-06-23'),
(42, 62, 402, '2022-06-23'),
(43, 63, 5000, '2022-06-23');

-- --------------------------------------------------------

--
-- Table structure for table `marcas`
--

CREATE TABLE `marcas` (
  `idMarca` int(11) NOT NULL,
  `nombreMarca` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `marcas`
--

INSERT INTO `marcas` (`idMarca`, `nombreMarca`) VALUES
(1, 'NVIDIA'),
(3, 'Gamesa'),
(4, 'Adidas'),
(22, 'CocaCola'),
(23, 'Nike'),
(24, 'Marinela'),
(25, 'Logitech'),
(26, 'Samsung'),
(27, 'Xiaomi'),
(28, 'Apple'),
(29, 'Sony'),
(30, 'Microsoft'),
(31, 'Tupperware');

-- --------------------------------------------------------

--
-- Table structure for table `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `precioVta` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `marcaId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `productos`
--

INSERT INTO `productos` (`idProducto`, `nombre`, `precio`, `precioVta`, `cantidad`, `marcaId`) VALUES
(3, 'Fresca', 25, 27, 99, 1),
(17, 'Manzanita', 25, 28, 150, 3),
(22, 'Coke', 25, 27, 100, 3),
(32, 'NVIDIA RTX 3080Ti', 70000, 80000, 10, 1),
(33, 'Licencia Microsoft Windows 11', 2600, 3000, 49, 30),
(34, 'iPhone 13 Pro Max', 30000, 35000, 19, 28),
(35, 'Bocinas Logitec z506', 2400, 2900, 36, 25);

-- --------------------------------------------------------

--
-- Table structure for table `ventas`
--

CREATE TABLE `ventas` (
  `idVenta` int(11) NOT NULL,
  `clienteId` int(11) NOT NULL,
  `totalVenta` double NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ventas`
--

INSERT INTO `ventas` (`idVenta`, `clienteId`, `totalVenta`, `fecha`) VALUES
(46, 1, 27, '2022-06-23'),
(47, 2, 147, '2022-06-23'),
(48, 1, 120, '2022-06-23'),
(49, 1, 28, '2022-06-23'),
(50, 2, 240, '2022-06-23'),
(51, 1, 28, '2022-06-23'),
(52, 1, 27, '2022-06-23'),
(53, 1, 60, '2022-06-23'),
(54, 1, 27, '2022-06-23'),
(56, 1, 60, '2022-06-23'),
(58, 2, 378, '2022-06-23'),
(59, 1, 60, '2022-06-23'),
(60, 1, 115, '2022-06-23'),
(61, 1, 60, '2022-06-23'),
(62, 24, 3027, '2022-06-23'),
(63, 1, 35000, '2022-06-23');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idDireccion` (`idDireccion`);

--
-- Indexes for table `detalleventas`
--
ALTER TABLE `detalleventas`
  ADD KEY `idProductos` (`productoId`),
  ADD KEY `ventaId` (`ventaId`);

--
-- Indexes for table `direccion`
--
ALTER TABLE `direccion`
  ADD PRIMARY KEY (`idDireccion`);

--
-- Indexes for table `ganancias`
--
ALTER TABLE `ganancias`
  ADD PRIMARY KEY (`idGanancia`);

--
-- Indexes for table `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`idMarca`);

--
-- Indexes for table `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `idMarcas` (`marcaId`);

--
-- Indexes for table `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `clienteId` (`clienteId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `direccion`
--
ALTER TABLE `direccion`
  MODIFY `idDireccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `ganancias`
--
ALTER TABLE `ganancias`
  MODIFY `idGanancia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `marcas`
--
ALTER TABLE `marcas`
  MODIFY `idMarca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `idDireccion` FOREIGN KEY (`idDireccion`) REFERENCES `direccion` (`idDireccion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `detalleventas`
--
ALTER TABLE `detalleventas`
  ADD CONSTRAINT `idProductos` FOREIGN KEY (`productoId`) REFERENCES `productos` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ventaId` FOREIGN KEY (`ventaId`) REFERENCES `ventas` (`idVenta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `idMarcas` FOREIGN KEY (`marcaId`) REFERENCES `marcas` (`idMarca`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `clienteId` FOREIGN KEY (`clienteId`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
