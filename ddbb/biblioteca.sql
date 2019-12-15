-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-12-2019 a las 11:29:57
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.1.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `id` int(2) NOT NULL,
  `titulo` varchar(27) DEFAULT NULL,
  `autor` varchar(24) DEFAULT NULL,
  `num_pag` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id`, `titulo`, `autor`, `num_pag`) VALUES
(6, 'EL OPALO NEGRO', 'VICTORIA HOLT', 384),
(7, 'POESIA Y OTROS TEXTOS', 'SAN JUAN DE LA CRUZ', 304),
(8, 'EL JUEGO DE HERRALL', 'STEPHEN KING', 400),
(10, 'EL SEÑOR DE LOS ANILLOS', 'J.R. TOLKIEN', 1104),
(12, 'ITTT', 'STEPHEN KING', 1000),
(15, 'COMO SI FUERA DIOS', 'ROBIN COOK', 456),
(16, 'TEMINAL', 'ROBIN COOK', 370),
(17, 'OCEANO', 'ALBERTO VAZQUEZ FIGUEROA', 250),
(18, 'LA IGUANA', 'ALBERTO VAZQUEZ FIGUEROA', 290),
(19, 'YALZA', 'ALBERTO VAZQUEZ FIGUEROA', 350),
(20, 'DON QUIOTE', 'CERVANTES', 1000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `id_libro` int(2) NOT NULL,
  `id_socio` int(1) NOT NULL,
  `fecha` date NOT NULL DEFAULT '2018-01-01',
  `devuelto` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `prestamos`
--

INSERT INTO `prestamos` (`id_libro`, `id_socio`, `fecha`, `devuelto`) VALUES
(7, 5, '2018-04-16', 0),
(10, 2, '2018-04-16', 0),
(12, 1, '2018-04-24', 1),
(17, 1, '2018-01-01', 0),
(17, 2, '2018-04-16', 0),
(17, 8, '2018-04-23', 1),
(18, 1, '2018-04-13', 0),
(18, 7, '2018-04-19', 0),
(19, 1, '2018-01-01', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socios`
--

CREATE TABLE `socios` (
  `id` int(1) NOT NULL,
  `nombre` varchar(8) DEFAULT NULL,
  `apellido` varchar(17) DEFAULT NULL,
  `direccion` varchar(22) DEFAULT NULL,
  `poblacion` varchar(11) DEFAULT NULL,
  `provincia` varchar(15) DEFAULT NULL,
  `dni` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `socios`
--

INSERT INTO `socios` (`id`, `nombre`, `apellido`, `direccion`, `poblacion`, `provincia`, `dni`) VALUES
(1, 'MERTXE', 'MEANA GOMEZ', 'KAREAGA 13', 'BARAKALDO', 'BIZKAIA', '13929563'),
(2, 'JOSEBA', 'ALTUNA GARAY', 'AVDA. MINERO 28', 'ORTUELLA', 'BIZKAIA', '14903129'),
(3, 'JAVIER', 'MARTINEZ BELAUSTE', 'LASAGABAS¡TER , 15, 15', 'ORTUELLA', 'BIZKAIA', '22145980'),
(4, 'JUAN', 'GALARZA IZA', 'CORREOS, 27', 'PORTUGALETE', 'BIZKAIA', '22567412'),
(5, 'MERCEDES', 'PEREZ GARCIA', 'PEREZ GALDOS 30', 'BILBAO', 'BIZKAIA', '22435018'),
(6, 'AITOR', 'RIVAS CARRERAS', 'AVDA. LA LIBERTAD, 26', 'BARAKALDO', 'BIZKAIA', '22768546'),
(7, 'MARTA', 'RIVAS CARRERAS', 'AVDA. LA LIBERTAD, 26', 'BARAKALDO', 'BIZKAIA', '22579061'),
(8, 'AMAIA', 'GONZALEZ GONZALEZ', 'AVDA. EUSKADI', 'BARAKALDO', 'BIZKAIA', '14679405'),
(9, 'IKER', 'GUERRERO', 'BARRENKALE', 'GERNIKA', 'BIZKAIA', '79068000A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `apellido` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `dni` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `admin` tinyint(4) NOT NULL DEFAULT '0',
  `password` varchar(32) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `dni`, `admin`, `password`) VALUES
(1, 'jon', 'santamaria', '11111111a', 1, 'santa'),
(2, 'enaut', 'agirre', '22222222b', 1, 'enaut'),
(3, 'ikaslea', 'ikaslea', '33333333c', 0, 'ikaslea');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`id_libro`,`id_socio`,`fecha`) USING BTREE,
  ADD KEY `id_socio` (`id_socio`);

--
-- Indices de la tabla `socios`
--
ALTER TABLE `socios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `socios`
--
ALTER TABLE `socios`
  MODIFY `id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`id_libro`) REFERENCES `libros` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prestamos_ibfk_2` FOREIGN KEY (`id_socio`) REFERENCES `socios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
