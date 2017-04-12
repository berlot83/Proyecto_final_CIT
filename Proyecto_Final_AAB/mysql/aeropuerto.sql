-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-04-2017 a las 03:12:04
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aeropuerto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `id_administrador` int(11) NOT NULL,
  `tipo_admin` varchar(100) NOT NULL,
  `nombre` text NOT NULL,
  `apellido` text NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `pass` text NOT NULL,
  `email` text NOT NULL,
  `direccion` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`id_administrador`, `tipo_admin`, `nombre`, `apellido`, `usuario`, `pass`, `email`, `direccion`) VALUES
(24, 'adminRH', 'Axel', 'Berlot', 'user', '1234', 'asd', 'asd'),
(37, 'adminVuelos', 'pepe', 'argento', 'pepe', '1234', 'asd', 'asd'),
(38, 'adminRH', 'Dana', 'Berlot', 'dana', '1234', 'asd', 'asd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aviones`
--

CREATE TABLE `aviones` (
  `id` int(11) NOT NULL,
  `tipo_avion` varchar(50) NOT NULL,
  `matricula` varchar(50) NOT NULL,
  `cantidad_pasajeros` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aviones`
--

INSERT INTO `aviones` (`id`, `tipo_avion`, `matricula`, `cantidad_pasajeros`) VALUES
(2, 'Jumbo 747', 'LM-505', 0),
(3, 'Jumbo 747', 'LM-505', 0),
(4, 'MD5', 'MD-605', 250),
(5, 'Boing 777-700', 'LV-205', 320);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id_empleado` int(11) NOT NULL,
  `dni` int(8) NOT NULL,
  `cuit` bigint(11) NOT NULL,
  `nacimiento` date NOT NULL,
  `nombre` tinytext NOT NULL,
  `apellido` tinytext NOT NULL,
  `direccion` tinytext NOT NULL,
  `cargo` tinytext NOT NULL,
  `sueldo_cargo` float NOT NULL,
  `cargas_sociales` float NOT NULL,
  `vacaciones` float NOT NULL,
  `sueldo_neto` float NOT NULL,
  `id_administrador` int(11) NOT NULL,
  `tipo_administrador` varchar(100) NOT NULL,
  `usuario_administrador` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id_empleado`, `dni`, `cuit`, `nacimiento`, `nombre`, `apellido`, `direccion`, `cargo`, `sueldo_cargo`, `cargas_sociales`, `vacaciones`, `sueldo_neto`, `id_administrador`, `tipo_administrador`, `usuario_administrador`) VALUES
(140, 30158619, 20301586192, '2017-04-11', 'asd', 'asd', 'asd', 'asd', 123, 20.91, 4.92, 97.17, 24, 'adminRH', 'user');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `super_administradores`
--

CREATE TABLE `super_administradores` (
  `id` int(11) NOT NULL,
  `usuario` text NOT NULL,
  `pass` text NOT NULL,
  `token` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `super_administradores`
--

INSERT INTO `super_administradores` (`id`, `usuario`, `pass`, `token`) VALUES
(1, 'admin', 'admin', 1234);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelos`
--

CREATE TABLE `vuelos` (
  `id` int(11) NOT NULL,
  `empresa` text NOT NULL,
  `destino` text NOT NULL,
  `escalas` int(2) NOT NULL,
  `pasajes` int(11) NOT NULL,
  `fechaSalida` date NOT NULL,
  `horarioSalida` text NOT NULL,
  `fechaArribo` date NOT NULL,
  `horarioArribo` text NOT NULL,
  `pago` text NOT NULL,
  `precio` int(11) NOT NULL,
  `id_administradores` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vuelos`
--

INSERT INTO `vuelos` (`id`, `empresa`, `destino`, `escalas`, `pasajes`, `fechaSalida`, `horarioSalida`, `fechaArribo`, `horarioArribo`, `pago`, `precio`, `id_administradores`) VALUES
(26, 'souther', 'YT', 3, 300, '2017-04-19', '05:05', '2017-04-17', '14:08', 'diners', 23000, 'vivi'),
(27, 'alitalia', 'SI', 3, 230, '2017-04-14', '03:04', '2017-04-18', '13:59', 'amex', 1234, 'vivi');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`id_administrador`),
  ADD KEY `usuario` (`usuario`),
  ADD KEY `tipo_admin` (`tipo_admin`) USING BTREE;

--
-- Indices de la tabla `aviones`
--
ALTER TABLE `aviones`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id_empleado`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `cuit` (`cuit`),
  ADD KEY `usuario_administrador` (`usuario_administrador`) USING BTREE,
  ADD KEY `tipo_administrador` (`tipo_administrador`) USING BTREE,
  ADD KEY `admin` (`id_administrador`);

--
-- Indices de la tabla `super_administradores`
--
ALTER TABLE `super_administradores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `vuelos`
--
ALTER TABLE `vuelos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_adminVuelo` (`id_administradores`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administradores`
--
ALTER TABLE `administradores`
  MODIFY `id_administrador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- AUTO_INCREMENT de la tabla `aviones`
--
ALTER TABLE `aviones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id_empleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=141;
--
-- AUTO_INCREMENT de la tabla `super_administradores`
--
ALTER TABLE `super_administradores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `vuelos`
--
ALTER TABLE `vuelos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `admin` FOREIGN KEY (`id_administrador`) REFERENCES `administradores` (`id_administrador`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
