-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Dim 05 Mai 2013 à 17:14
-- Version du serveur: 5.5.25
-- Version de PHP: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `yumyum`
--
CREATE DATABASE `yumyum` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `yumyum`;

-- --------------------------------------------------------

--
-- Structure de la table `food`
--

CREATE TABLE `food` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `type` enum('food','drink','','') NOT NULL,
  `from` time NOT NULL,
  `to` time NOT NULL,
  `frequency` int(11) NOT NULL,
  `price` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=39 ;

--
-- Contenu de la table `food`
--

INSERT INTO `food` (`id`, `name`, `type`, `from`, `to`, `frequency`, `price`) VALUES
(1, 'pizza', 'food', '12:00:00', '14:00:00', 5, 5),
(9, 'plveknkz', 'drink', '08:00:00', '10:00:00', 5, 2),
(11, 'peperoni', 'food', '15:53:37', '17:00:00', 2, 15),
(13, 'apple', 'food', '00:00:00', '00:00:00', 2, 3),
(16, 'ssss', 'drink', '03:00:00', '04:00:00', 2, 1),
(21, 'coca', 'drink', '03:00:00', '04:00:00', 2, 5),
(23, 'couscous', 'food', '03:00:00', '04:00:00', 6, 20),
(35, 'quiche', 'food', '14:00:00', '15:00:00', 2, 15),
(36, 'kebab', 'food', '00:00:00', '01:00:00', 2, 15),
(37, 'dim-sum', 'food', '10:00:00', '12:00:00', 6, 13),
(38, 'tapas', 'food', '12:00:00', '15:00:00', 10, 17);

-- --------------------------------------------------------

--
-- Structure de la table `foodItem`
--

CREATE TABLE `foodItem` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `time` time NOT NULL,
  `status` enum('available','ordered','in preparation','out of stock') NOT NULL,
  `food_id` int(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `food_id` (`food_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=295 ;

--
-- Contenu de la table `foodItem`
--

INSERT INTO `foodItem` (`id`, `time`, `status`, `food_id`) VALUES
(4, '11:58:05', 'available', 1),
(36, '03:00:00', 'available', 21),
(37, '03:02:00', 'available', 21),
(38, '03:04:00', 'available', 21),
(41, '03:10:00', 'available', 21),
(42, '03:12:00', 'available', 21),
(43, '03:14:00', 'available', 21),
(44, '03:16:00', 'available', 21),
(45, '03:18:00', 'available', 21),
(46, '03:20:00', 'available', 21),
(47, '03:22:00', 'available', 21),
(48, '03:24:00', 'available', 21),
(49, '03:26:00', 'available', 21),
(50, '03:28:00', 'available', 21),
(51, '03:30:00', 'available', 21),
(52, '03:32:00', 'available', 21),
(53, '03:34:00', 'available', 21),
(54, '03:36:00', 'available', 21),
(55, '03:38:00', 'available', 21),
(56, '03:40:00', 'available', 21),
(57, '03:42:00', 'available', 21),
(58, '03:44:00', 'available', 21),
(59, '03:46:00', 'available', 21),
(60, '03:48:00', 'available', 21),
(61, '03:50:00', 'available', 21),
(62, '03:52:00', 'available', 21),
(63, '03:54:00', 'available', 21),
(64, '03:56:00', 'available', 21),
(65, '03:58:00', 'available', 21),
(76, '03:00:00', 'available', 23),
(77, '03:06:00', 'available', 23),
(78, '03:12:00', 'available', 23),
(79, '03:18:00', 'available', 23),
(80, '03:24:00', 'available', 23),
(81, '03:30:00', 'available', 23),
(82, '03:36:00', 'available', 23),
(83, '03:42:00', 'available', 23),
(84, '03:48:00', 'available', 23),
(85, '03:54:00', 'available', 23),
(196, '14:00:00', 'available', 35),
(197, '14:02:00', 'available', 35),
(198, '14:04:00', 'available', 35),
(199, '14:06:00', 'available', 35),
(200, '14:08:00', 'available', 35),
(201, '14:10:00', 'available', 35),
(202, '14:12:00', 'available', 35),
(203, '14:14:00', 'available', 35),
(204, '14:16:00', 'available', 35),
(205, '14:18:00', 'available', 35),
(206, '14:20:00', 'available', 35),
(207, '14:22:00', 'available', 35),
(208, '14:24:00', 'available', 35),
(209, '14:26:00', 'available', 35),
(210, '14:28:00', 'available', 35),
(211, '14:30:00', 'available', 35),
(212, '14:32:00', 'available', 35),
(213, '14:34:00', 'available', 35),
(214, '14:36:00', 'available', 35),
(215, '14:38:00', 'available', 35),
(216, '14:40:00', 'available', 35),
(217, '14:42:00', 'available', 35),
(218, '14:44:00', 'available', 35),
(219, '14:46:00', 'available', 35),
(220, '14:48:00', 'available', 35),
(221, '14:50:00', 'available', 35),
(222, '14:52:00', 'available', 35),
(223, '14:54:00', 'available', 35),
(224, '14:56:00', 'available', 35),
(225, '14:58:00', 'available', 35),
(226, '20:03:14', 'available', 1),
(227, '00:00:00', 'available', 36),
(228, '00:02:00', 'available', 36),
(229, '00:04:00', 'available', 36),
(230, '00:06:00', 'available', 36),
(231, '00:08:00', 'available', 36),
(232, '00:10:00', 'available', 36),
(233, '00:12:00', 'available', 36),
(234, '00:14:00', 'available', 36),
(235, '00:16:00', 'available', 36),
(236, '00:18:00', 'available', 36),
(237, '00:20:00', 'available', 36),
(238, '00:22:00', 'available', 36),
(239, '00:24:00', 'available', 36),
(240, '00:26:00', 'available', 36),
(241, '00:28:00', 'available', 36),
(242, '00:30:00', 'available', 36),
(243, '00:32:00', 'available', 36),
(244, '00:34:00', 'available', 36),
(245, '00:36:00', 'available', 36),
(246, '00:38:00', 'available', 36),
(247, '00:40:00', 'available', 36),
(248, '00:42:00', 'available', 36),
(249, '00:44:00', 'available', 36),
(250, '00:46:00', 'available', 36),
(251, '00:48:00', 'available', 36),
(252, '00:50:00', 'available', 36),
(253, '00:52:00', 'available', 36),
(254, '00:54:00', 'available', 36),
(255, '00:56:00', 'available', 36),
(256, '00:58:00', 'available', 36),
(257, '10:00:00', 'available', 37),
(258, '10:06:00', 'available', 37),
(259, '10:12:00', 'available', 37),
(260, '10:18:00', 'available', 37),
(261, '10:24:00', 'available', 37),
(262, '10:30:00', 'available', 37),
(263, '10:36:00', 'available', 37),
(264, '10:42:00', 'available', 37),
(265, '10:48:00', 'available', 37),
(266, '10:54:00', 'available', 37),
(267, '11:00:00', 'available', 37),
(268, '11:06:00', 'available', 37),
(269, '11:12:00', 'available', 37),
(270, '11:18:00', 'available', 37),
(271, '11:24:00', 'available', 37),
(272, '11:30:00', 'available', 37),
(273, '11:36:00', 'available', 37),
(274, '11:42:00', 'available', 37),
(275, '11:48:00', 'available', 37),
(276, '11:54:00', 'available', 37),
(277, '12:00:00', 'available', 38),
(278, '12:10:00', 'available', 38),
(279, '12:20:00', 'available', 38),
(280, '12:30:00', 'available', 38),
(281, '12:40:00', 'available', 38),
(282, '12:50:00', 'available', 38),
(283, '13:00:00', 'available', 38),
(284, '13:10:00', 'available', 38),
(285, '13:20:00', 'available', 38),
(286, '13:30:00', 'available', 38),
(287, '13:40:00', 'available', 38),
(288, '13:50:00', 'available', 38),
(289, '14:00:00', 'available', 38),
(290, '14:10:00', 'available', 38),
(291, '14:20:00', 'available', 38),
(292, '14:30:00', 'available', 38),
(293, '14:40:00', 'available', 38),
(294, '14:50:00', 'available', 38);

-- --------------------------------------------------------

--
-- Structure de la table `login`
--

CREATE TABLE `login` (
  `user` varchar(8) CHARACTER SET latin1 NOT NULL,
  `pass` varchar(8) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `login`
--

INSERT INTO `login` (`user`, `pass`) VALUES
('titi', 'bibi'),
('toto', 'bobo');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `foodItem`
--
ALTER TABLE `foodItem`
  ADD CONSTRAINT `foodItem_ibfk_1` FOREIGN KEY (`food_id`) REFERENCES `food` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
