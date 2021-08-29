-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-08-2021 a las 05:27:20
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_final`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `ID_Alumnos` varchar(50) NOT NULL,
  `Nombres` varchar(100) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `Telefono` varchar(15) NOT NULL,
  `Edad` int(10) NOT NULL,
  `Sexo` varchar(40) NOT NULL,
  `Curso` varchar(50) NOT NULL,
  `Seccion` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`ID_Alumnos`, `Nombres`, `Apellidos`, `Telefono`, `Edad`, `Sexo`, `Curso`, `Seccion`) VALUES
('23', 'Pedro', 'Aleadfed', '343434', 12, 'Femenino', '4to de secundaria', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `director`
--

CREATE TABLE `director` (
  `cedula` int(50) NOT NULL,
  `Nombre_Director` varchar(100) NOT NULL,
  `Apellido_Director` varchar(100) NOT NULL,
  `Edad` int(10) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Sexo` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `director`
--

INSERT INTO `director` (`cedula`, `Nombre_Director`, `Apellido_Director`, `Edad`, `Direccion`, `Sexo`) VALUES
(3432, 'Pedro', 'Zapata de Leon', 45, 'La caletat #34', 'Femenino'),
(6656, 'ss', 'sss', 20, 'dsd', 'Masculino'),
(45545, 'ddd', 'dd', 93, 'dds', 'Masculino'),
(3341323, 'Alexander', 'Polanco Moreno', 26, 'Don juan Monte Plata', 'Masculino'),
(888888999, 'Alexander', 'Polanco Moreno', 20, 'Don Juan / Monte Plata', 'Femenino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maestro_1`
--

CREATE TABLE `maestro_1` (
  `ID_maestro` varchar(20) NOT NULL,
  `nombre_maestro` varchar(100) NOT NULL,
  `apellido_Maestro` varchar(100) NOT NULL,
  `Telefono_Maestro` varchar(20) NOT NULL,
  `edad` int(2) NOT NULL,
  `sexo` varchar(40) NOT NULL,
  `Tanda` varchar(50) NOT NULL,
  `grado_a_impartir` varchar(70) NOT NULL,
  `materia` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `maestro_1`
--

INSERT INTO `maestro_1` (`ID_maestro`, `nombre_maestro`, `apellido_Maestro`, `Telefono_Maestro`, `edad`, `sexo`, `Tanda`, `grado_a_impartir`, `materia`) VALUES
('34', 'Daniel', 'De la Rosa', '4434', 25, 'Masculino', 'Vespertino ', '4to de secundaria', 'Matematicas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `secretaria`
--

CREATE TABLE `secretaria` (
  `cedula` varchar(20) NOT NULL,
  `Nombres` varchar(100) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `Edad` int(10) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Sexo` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `secretaria`
--

INSERT INTO `secretaria` (`cedula`, `Nombres`, `Apellidos`, `Edad`, `Direccion`, `Sexo`) VALUES
('23233', 'Alba', 'sdds', 23, '323sdaddasddas#3', 'Femenino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subdirector`
--

CREATE TABLE `subdirector` (
  `Cedula` varchar(20) NOT NULL,
  `Nombres` varchar(100) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `Edad` int(10) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Sexo` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `subdirector`
--

INSERT INTO `subdirector` (`Cedula`, `Nombres`, `Apellidos`, `Edad`, `Direccion`, `Sexo`) VALUES
('12', 'Alexander', 'Polanco Moreno', 14, '34434', 'Masculino'),
('2', 'dsddsds', 'sdsds', 23, 'dswsd', 'Masculino'),
('23', '23', '23', 93, '23', 'Masculino'),
('232323', '2323', '23', 23, '23', 'Masculino');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`ID_Alumnos`);

--
-- Indices de la tabla `director`
--
ALTER TABLE `director`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `maestro_1`
--
ALTER TABLE `maestro_1`
  ADD PRIMARY KEY (`ID_maestro`);

--
-- Indices de la tabla `secretaria`
--
ALTER TABLE `secretaria`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `subdirector`
--
ALTER TABLE `subdirector`
  ADD PRIMARY KEY (`Cedula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
