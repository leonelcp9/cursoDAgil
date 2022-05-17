-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2022 at 05:03 AM
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
(1, 'Samuel', 'Guerrero', 'itougn15@gmail.com', 'Masculino', 1),
(2, 'Jorge', 'Narváez', 'jorgito123@gmail.com', 'Femenino', 1),
(4, 'Test', 'asdasd', 'asdas@gmail.com', 'femenino', 1),
(5, 'Test', 'asdasd', 'asdas@gmail.com', 'femenino', 1),
(6, 'Test', 'asdasd', 'asdas@gmail.com', 'femenino', 1),
(7, 'Test', 'asdasd', 'asdas@gmail.com', 'femenino', 1),
(8, 'Test', 'asdasd', 'asdas@gmail.com', 'femenino', 1),
(9, 'Test', 'asdasd', 'asdas@gmail.com', 'femenino', 1),
(10, 'Test', 'asdasd', 'asdas@gmail.com', 'femenino', 1);

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
(5, 3, 233),
(1, 5, 2),
(1, 3, 2);

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
(3, 'Micaela Galindo', 3, 'Centro', 'Huajuapan', 'Oaxaca', 'Mexico', 69000),
(4, 'Micaela Galindo', 3, 'Centro', 'Huajuapan', 'Oaxaca', 'Mexico', 69000),
(5, 'Micaela Galindo', 3, 'Centro', 'Huajuapan', 'Oaxaca', 'Mexico', 69000),
(6, 'Micaela Galindo', 3, 'Centro', 'Huajuapan', 'Oaxaca', 'Mexico', 69000),
(7, 'Micaela Galindo', 3, 'Centro', 'Huajuapan', 'Oaxaca', 'Mexico', 69000),
(8, 'Micaela Galindo', 3, 'Centro', 'Huajuapan', 'Oaxaca', 'Mexico', 69000);

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
(1, 1, 10, '2022-04-28'),
(2, 1, 10, '2022-04-28'),
(3, 2, 10, '2022-04-23'),
(4, 3, 230, '2022-04-20'),
(5, 1, 15550.5, '2022-05-01'),
(6, 1, 15550.5, '2022-05-02'),
(7, 1, 15550.5, '2022-05-02'),
(8, 1, 15550.5, '2022-05-02'),
(9, 1, 15550.5, '2022-05-02'),
(10, 1, 15550.5, '2022-05-02'),
(11, 1, 15550.5, '2022-05-02'),
(12, 1, 15550.5, '2022-05-02'),
(13, 1, 15550.5, '2022-05-02'),
(14, 1, 15550.5, '2022-05-02'),
(15, 1, 15550.5, '2022-05-02'),
(16, 1, 15550.5, '2022-05-02'),
(17, 1, 15550.5, '2022-05-02'),
(18, 1, 15550.5, '2022-05-02'),
(19, 1, 15550.5, '2022-05-02');

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
(5, 'Gamesa'),
(7, 'Gamesa'),
(8, 'Gamesa'),
(9, 'Gamesa');

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
(3, 'Fresca', 25, 27, 100, 1),
(5, 'Fresca', 25, 27, 100, 1);

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
(1, 2, 5412, '2022-04-13'),
(2, 1, 564.5, '2022-04-10'),
(3, 1, 900, '2022-04-28'),
(4, 1, 900, '2022-04-28'),
(5, 1, 900, '2022-04-30'),
(6, 1, 900, '2022-04-30'),
(7, 1, 900, '2022-05-02'),
(8, 1, 900, '2022-05-02'),
(9, 1, 900, '2022-05-02'),
(10, 1, 900, '2022-05-02'),
(11, 1, 900, '2022-05-02'),
(12, 1, 900, '2022-05-02'),
(13, 1, 900, '2022-05-02'),
(14, 1, 900, '2022-05-02'),
(15, 1, 900, '2022-05-02'),
(16, 1, 900, '2022-05-02'),
(17, 1, 900, '2022-05-02'),
(18, 1, 900, '2022-05-02');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `direccion`
--
ALTER TABLE `direccion`
  MODIFY `idDireccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `ganancias`
--
ALTER TABLE `ganancias`
  MODIFY `idGanancia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `marcas`
--
ALTER TABLE `marcas`
  MODIFY `idMarca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

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
