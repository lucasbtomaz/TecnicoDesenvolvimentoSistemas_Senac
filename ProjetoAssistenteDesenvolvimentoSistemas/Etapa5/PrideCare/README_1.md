-- Criação do banco de dados PrideCare
CREATE DATABASE IF NOT EXISTS PrideCare;

-- Consultas
USE PrideCare;
SELECT * FROM usuarios;
-- SELECT * FROM receita;
SELECT * FROM receita_medicamentos;


-- Criação da tabela Usuarios para armazenar dados de cadastro
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_completo VARCHAR(200) NOT NULL,
    cpf VARCHAR(20) UNIQUE NOT NULL,
    data_nascimento DATE NOT NULL,
    genero ENUM('Cisgênero', 'Transgênero', 'Gênero neutro', 'Não-binário', 'Bigênero') NOT NULL,
    orientacao_sexual ENUM('Heterossexual', 'Homossexual', 'Bissexual', 'Pansexual', 'Outro') NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    senha VARCHAR(100) NOT NULL,
    alterar_senha BOOLEAN NOT NULL DEFAULT true,
    data_entrada DATE, 
    tipo_usuario VARCHAR(50) NOT NULL,
    especialidade VARCHAR(100), 
    crm VARCHAR(20),
    idade INT
);

USE PrideCare;
ALTER TABLE usuarios ADD COLUMN prontuario TEXT;

-- Criação da tabela Receita para armazenar dados de consulta
USE PrideCare;
-- Criação da tabela Receita
CREATE TABLE IF NOT EXISTS receita (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cpf_usuario VARCHAR(20) NOT NULL,
    data_criacao DATE NOT NULL,
    status ENUM('LIBERADO', 'DISPONIVEL', 'FALTANDO') NOT NULL
);

USE PrideCare;
-- Criação da tabela Receita Medicamentos
CREATE TABLE IF NOT EXISTS receita_medicamentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    receita_id INT NOT NULL,
    medicamento VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY (receita_id) REFERENCES receita(id)
);


