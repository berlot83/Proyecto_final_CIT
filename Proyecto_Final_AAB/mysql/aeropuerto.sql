-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-03-2017 a las 00:41:03
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
  `nombre` text NOT NULL,
  `apellido` text NOT NULL,
  `usuario` text NOT NULL,
  `pass` text NOT NULL,
  `email` text NOT NULL,
  `direccion` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`id`, `nombre`, `apellido`, `usuario`, `pass`, `email`, `direccion`) VALUES
(1, 'q', 'a', 'e', 'r', 't', 't'),
(2, 'Axel', 'Berlot', 'Berlot83', 'rh5', 'berlot83@yahoo.com.ar', 'pinzon 425'),
(4, 'Dana', 'Berlot', 'D2', '2911', 'asdsd', 'asdasd'),
(5, 'Dana', 'Berlot', 'D2', '2911', 'asdsd', 'asdasd'),
(6, 'asd', 'asd', 'asd', 'asd', 'asd', 'asd'),
(7, 'asd', 'asd', 'asd', 'asd', 'asd', 'asd'),
(8, 'asd', 'asd', 'asd', 'asd', 'asd', 'asd'),
(9, 'o', 'o', 'o', 'o', 'o', 'o'),
(10, 'h', 'h', 'h', 'h', 'h', 'h'),
(11, 'i', 'i', 'i', 'i', 'i', 'i'),
(12, 'Dana', 'hija', 'muy', 'buena', 'nena', 'estudiante'),
(13, 'dfg', 'dfg', 'dfg', 'dfg', 'dfg', 'dfg'),
(14, 's', 's', 's', 's', 's', 's'),
(15, 'r', 'r', 'r', 'r', 'r', 'r'),
(16, 'gth', 'gh', 'gh', 'gh', 'gh', 'gh'),
(17, '123', '123', '123', '23', '123', '123'),
(18, 'd', 'd', 'd', 'd', 'd', 'd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id` int(11) NOT NULL,
  `usuario` text NOT NULL,
  `pass` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id`, `usuario`, `pass`) VALUES
(6, 'sdf', 'sdfsg'),
(7, 'tyu', 'tyutyutyu'),
(8, 'tyhjt', 'fghj');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administradores`
--
ALTER TABLE `administradores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
