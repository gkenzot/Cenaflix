-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 23-Jan-2023 às 16:41
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `cenaflix`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `filmes`
--
DROP DATABASE cenaflix;
CREATE DATABASE cenaflix;

use cenaflix;

CREATE TABLE `filmes` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `datalancamento` date NOT NULL,
  /* `datalancamento` varchar(20) NOT NULL, */
  `categoria` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `filmes`
--
ALTER TABLE `filmes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `filmes`
--
ALTER TABLE `filmes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

INSERT INTO filmes (nome, datalancamento, categoria) VALUES
('Velozes e Furiosos', '2012-03-02','Acao e Aventura'),
('It a coisa', '1992-02-12', 'Terror'),
('Os Vingadores', '2012-04-27', 'Acao e Aventura'),
('Musical filme', '2010-01-10', 'Musical'),
('Click', '2006-09-11', 'Comedia'),
('Titanic', '2019-02-21','Drama');

SELECT * FROM filmes;


