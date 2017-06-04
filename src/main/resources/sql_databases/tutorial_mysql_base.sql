Create database IF NOT EXISTS tech_shop;

use  tech_shop;

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Структура таблицы `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ShopID` int(11) NOT NULL,
  `Name` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Дамп данных таблицы `products`
--

INSERT INTO `products` (`id`, `ShopID`, `Name`) VALUES
(1, 4, 'Процессоры Pentium II'),
(2, 4, 'Процессоры Pentium III'),
(3, 4, 'Оптическая мышь Atech'),
(4, 4, 'DVD-R'),
(5, 4, 'DVD-RW'),
(6, 4, 'Клавиатура MS 101'),
(7, 4, 'SDRAM II'),
(8, 4, 'Flash RAM 8Gb'),
(9, 4, 'Flash RAM 4Gb');

-- --------------------------------------------------------

--
-- Структура таблицы `replace_com`
--

CREATE TABLE IF NOT EXISTS `replace_com` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sProductID` int(11) NOT NULL,
  `rProductID` int(11) NOT NULL,
  `Date` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`id`),
  KEY `sProductID` (`sProductID`,`rProductID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Дамп данных таблицы `replace_com`
--

INSERT INTO `replace_com` (`id`, `sProductID`, `rProductID`, `Date`) VALUES
(1, 1, 2, '2014-09-15'),
(2, 9, 8, '2014-09-17'),
(3, 4, 5, '2014-09-18');

-- --------------------------------------------------------

--
-- Структура таблицы `statistics`
--

CREATE TABLE IF NOT EXISTS `statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ProductID` bigint(20) NOT NULL,
  `Orders` int(11) NOT NULL,
  `Date` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`id`),
  KEY `ProductID` (`ProductID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Дамп данных таблицы `statistics`
--

INSERT INTO `statistics` (`id`, `ProductID`, `Orders`, `Date`) VALUES
(1, 1, 1, '2014-09-04'),
(3, 2, 1, '2014-09-04'),
(4, 3, 10, '2014-09-04'),
(5, 4, 2, '2014-09-04'),
(6, 5, 22, '2014-09-04'),
(7, 6, 5, '2014-09-04'),
(8, 7, 26, '2014-09-04'),
(9, 8, 8, '2014-09-04'),
(10, 9, 18, '2014-09-04'),
(11, 1, 1, '2014-09-12'),
(12, 2, 10, '2014-09-12'),
(13, 3, 3, '2014-09-12'),
(14, 4, 5, '2014-09-12'),
(15, 5, 18, '2014-09-12'),
(16, 6, 1, '2014-09-12'),
(17, 7, 12, '2014-09-12'),
(18, 8, 7, '2014-09-12'),
(19, 9, 30, '2014-09-12'),
(20, 1, 2, '2014-09-14'),
(21, 1, 2, '2014-09-15');
