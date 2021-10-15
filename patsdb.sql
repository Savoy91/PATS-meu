-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 17-Set-2021 às 02:59
-- Versão do servidor: 10.4.17-MariaDB
-- versão do PHP: 7.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `patsdb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `ajuste`
--

CREATE TABLE `ajuste` (
  `id` int(30) NOT NULL,
  `id_ponto` int(30) NOT NULL,
  `novo_horario_entrrada` datetime NOT NULL,
  `novo_horario_saida` datetime NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresa`
--

CREATE TABLE `empresa` (
  `id_empresa` int(30) NOT NULL,
  `nome` varchar(50) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Extraindo dados da tabela `empresa`
--

INSERT INTO `empresa` (`id_empresa`, `nome`) VALUES
(1, 'Teste');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(30) NOT NULL,
  `pin` int(30) NOT NULL,
  `nome` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `cargo` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `id_empresa` int(30) NOT NULL,
  `endereco` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `cep` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `pin`, `nome`, `cargo`, `id_empresa`, `endereco`, `cep`) VALUES
(1, 123456, 'Teste', 'Teste', 1, 'Teste', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `ponto`
--

CREATE TABLE `ponto` (
  `id` int(30) NOT NULL,
  `horario_entrada` datetime NOT NULL,
  `horario_saida` datetime DEFAULT NULL,
  `id_func` int(30) NOT NULL,
  `data` date NOT NULL,
  `statusPonto` int(1) NOT NULL DEFAULT 0,
  `id_empresa` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Extraindo dados da tabela `ponto`
--

INSERT INTO `ponto` (`id`, `horario_entrada`, `horario_saida`, `id_func`, `data`, `statusPonto`, `id_empresa`) VALUES
(1, '2021-09-16 21:57:37', '2021-09-16 21:58:35', 1, '2021-09-16', 0, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `ajuste`
--
ALTER TABLE `ajuste`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ajuste_ponto_id_ponto` (`id_ponto`);

--
-- Índices para tabela `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`id_empresa`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `empresa_func_idempresa` (`id_empresa`);

--
-- Índices para tabela `ponto`
--
ALTER TABLE `ponto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ponto_empresa_id` (`id_empresa`),
  ADD KEY `ponto_funcionario_id` (`id_func`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `ajuste`
--
ALTER TABLE `ajuste`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `empresa`
--
ALTER TABLE `empresa`
  MODIFY `id_empresa` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `ponto`
--
ALTER TABLE `ponto`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `ajuste`
--
ALTER TABLE `ajuste`
  ADD CONSTRAINT `ajuste_ponto_id_ponto` FOREIGN KEY (`id_ponto`) REFERENCES `ponto` (`id`);

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `empresa_func_idempresa` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id_empresa`);

--
-- Limitadores para a tabela `ponto`
--
ALTER TABLE `ponto`
  ADD CONSTRAINT `ponto_empresa_id` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id_empresa`),
  ADD CONSTRAINT `ponto_funcionario_id` FOREIGN KEY (`id_func`) REFERENCES `funcionario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
