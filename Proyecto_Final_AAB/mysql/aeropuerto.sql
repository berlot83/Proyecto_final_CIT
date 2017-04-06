-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-04-2017 a las 01:31:24
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
  `id` int(11) NOT NULL,
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

INSERT INTO `administradores` (`id`, `tipo_admin`, `nombre`, `apellido`, `usuario`, `pass`, `email`, `direccion`) VALUES
(2, 'adminRH', 'Axel', 'Berlot', 'user', '1234', 'berlot83@yahoo.com.ar', 'Pinzon');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `personaId` int(11) NOT NULL,
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
  `tipo_administrador` varchar(100) NOT NULL,
  `id_administradores` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`personaId`, `dni`, `cuit`, `nacimiento`, `nombre`, `apellido`, `direccion`, `cargo`, `sueldo_cargo`, `cargas_sociales`, `vacaciones`, `sueldo_neto`, `tipo_administrador`, `id_administradores`) VALUES
(111, 47350168, 40356189302, '2017-04-19', 'Javier', 'Polanco', 'Penia', 'Piloto', 25000, 4250, 1000, 19750, 'adminRH', 'user'),
(112, 67350168, 30356189301, '2017-04-12', 'Marcos', 'Garca', 'Uruguay', 'Piloto', 27000, 4590, 1080, 21330, 'adminRH', 'user'),
(113, 27350168, 20376189300, '2017-04-26', 'Daniel', 'Marsan', 'Paraguay', 'CoPiloto', 22000, 3740, 880, 17380, 'adminRH', 'user'),
(114, 21301253, 30253163693, '2017-04-09', 'Adelina', 'Velez', 'CoronelDaz', 'Azafata', 16000, 2720, 640, 12640, 'adminRH', 'user'),
(115, 30158619, 20301586192, '2017-04-19', 'Carlos', 'Tomada', 'Peron', 'Cadete', 12300, 2091, 492, 9717, 'adminRH', 'marce'),
(116, 30145619, 20301159192, '2017-04-19', 'Carlos', 'Tomada', 'Peron', 'Cadete', 12300, 2091, 492, 9717, 'adminRH', 'marce');

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
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_admin` (`tipo_admin`),
  ADD KEY `usuario` (`usuario`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`personaId`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `cuit` (`cuit`),
  ADD KEY `id_administrador` (`tipo_administrador`),
  ADD KEY `id_administradores` (`id_administradores`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `personaId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=117;
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
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
