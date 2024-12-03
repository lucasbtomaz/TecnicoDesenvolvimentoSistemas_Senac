USE cenaflix;
SELECT * FROM filmes;

USE cenaflix;
SELECT * FROM podcasts;

USE cenaflix;
SELECT * FROM usuario;


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

CREATE TABLE `filmes` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `datalancamento` date NOT NULL,
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

USE cenaflix;

-- Criação da tabela 'podcasts'
CREATE TABLE `podcasts` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `produtor` VARCHAR(100) NOT NULL,
  `nome` VARCHAR(150) NOT NULL,
  `numero_episodio` INT(11) NOT NULL,
  `duracao` VARCHAR(50) NOT NULL,
  `url_repositorio` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

SHOW TABLES;
DESCRIBE podcasts;


-- Criação da nova tabela de usuários
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    login VARCHAR(100) UNIQUE,
    senha VARCHAR(255), -- Certifique-se de que está usando a criptografia necessária (bcrypt, por exemplo)
    tipo ENUM('Admin', 'Operador', 'Usuario')
);

-- Insere os dados conforme a nova estrutura
INSERT INTO usuario (nome, login, senha, tipo) VALUES
('Lucas', 'lucas@email.com', '123', 'Admin'),
('Laura', 'laura@email.com', '123', 'Usuario'),
('Luis', 'luis@email.com', '123', 'Operador');


DELETE FROM podcasts WHERE id='aaa';
USE cenaflix;
SELECT * FROM podcasts;


