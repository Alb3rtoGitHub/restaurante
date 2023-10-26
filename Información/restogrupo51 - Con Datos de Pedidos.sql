-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-10-2023 a las 22:24:45
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `restogrupo51`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesa`
--

CREATE TABLE `mesa` (
  `idMesa` int(11) NOT NULL,
  `numeroMesa` int(11) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `disponibilidad` tinyint(1) NOT NULL,
  `estadoMesa` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mesa`
--

INSERT INTO `mesa` (`idMesa`, `numeroMesa`, `capacidad`, `disponibilidad`, `estadoMesa`) VALUES
(1, 1, 2, 0, 1),
(2, 2, 4, 1, 1),
(3, 3, 4, 1, 1),
(4, 4, 6, 1, 0),
(5, 5, 2, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL,
  `idMesa` int(11) NOT NULL,
  `nombreMesero` varchar(30) NOT NULL,
  `fechaHoraPedido` datetime NOT NULL,
  `importe` double NOT NULL,
  `cobrada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`idPedido`, `idMesa`, `nombreMesero`, `fechaHoraPedido`, `importe`, `cobrada`) VALUES
(1, 3, 'Lionel', '2023-10-26 17:03:02', 15800, 1),
(2, 1, 'Carlitos', '2023-10-26 17:05:26', 8200, 1),
(3, 1, 'Carlitos', '2023-10-26 17:08:38', 3300, 1),
(4, 1, 'Carlitos', '2023-10-26 17:20:04', 2000, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidoproducto`
--

CREATE TABLE `pedidoproducto` (
  `idPedidoProducto` int(11) NOT NULL,
  `idPedido` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedidoproducto`
--

INSERT INTO `pedidoproducto` (`idPedidoProducto`, `idPedido`, `idProducto`, `cantidad`) VALUES
(1, 1, 8, 2),
(2, 1, 10, 1),
(3, 1, 12, 3),
(4, 1, 5, 2),
(5, 2, 1, 1),
(6, 2, 6, 1),
(7, 2, 7, 1),
(8, 2, 11, 1),
(9, 3, 5, 1),
(10, 3, 13, 1),
(11, 4, 3, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `codigoProducto` varchar(40) NOT NULL,
  `nombreProducto` varchar(30) NOT NULL,
  `precio` double NOT NULL,
  `stock` int(11) NOT NULL,
  `estadoProducto` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `codigoProducto`, `nombreProducto`, `precio`, `stock`, `estadoProducto`) VALUES
(1, 'BS001', 'Agua Mineral 5', 500, 100, 1),
(2, 'BS002', 'Coca-Cola 2,25L', 1100, 90, 1),
(3, 'BS003', 'Sprite 2,25L', 1000, 200, 1),
(4, 'BC001', 'Vino Malbec 750ml', 2200, 200, 1),
(5, 'BC002', 'Fernet - Vaso', 1800, 200, 1),
(6, 'C001', 'Hamburguesa Clasica', 3000, 100, 1),
(7, 'C002', 'Hamburgesa Vegana', 3500, 100, 1),
(8, 'C003', 'Pizza - 8 Porciones', 3500, 300, 1),
(9, 'C004', 'Lomo Clasico', 3200, 200, 1),
(10, 'C005', 'Tacos Picantes', 2800, 200, 1),
(11, 'BC003', 'Cerveza Brahma 1L', 1200, 80, 1),
(12, 'BS004', 'Agua Saborizada', 800, 300, 1),
(13, 'P001', 'Flan', 1500, 100, 1),
(14, 'P002', 'Helado', 800, 100, 0),
(15, 'P003', 'Budin de Pan', 1200, 100, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `mesa`
--
ALTER TABLE `mesa`
  ADD PRIMARY KEY (`idMesa`),
  ADD UNIQUE KEY `numeroMesa` (`numeroMesa`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `id_mesa` (`idMesa`);

--
-- Indices de la tabla `pedidoproducto`
--
ALTER TABLE `pedidoproducto`
  ADD PRIMARY KEY (`idPedidoProducto`),
  ADD KEY `id_pedido` (`idPedido`,`idProducto`),
  ADD KEY `pedidoproducto_ibfk_2` (`idProducto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD UNIQUE KEY `codigoProducto` (`codigoProducto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `mesa`
--
ALTER TABLE `mesa`
  MODIFY `idMesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `pedidoproducto`
--
ALTER TABLE `pedidoproducto`
  MODIFY `idPedidoProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`idMesa`) REFERENCES `mesa` (`idMesa`);

--
-- Filtros para la tabla `pedidoproducto`
--
ALTER TABLE `pedidoproducto`
  ADD CONSTRAINT `pedidoproducto_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idPedido`) ON DELETE CASCADE,
  ADD CONSTRAINT `pedidoproducto_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
