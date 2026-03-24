CREATE DATABASE IF NOT EXISTS sistema_automotivo;
USE sistema_automotivo;

-- Tabela de Usuários (Atendentes N1, N2, N3 e Clientes)
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    perfil ENUM('CLIENTE', 'N1', 'N2', 'N3') NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de Clientes/Empresas
CREATE TABLE clientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT,
    razao_social VARCHAR(150),
    documento VARCHAR(20) UNIQUE NOT NULL, -- CPF ou CNPJ
    telefone VARCHAR(20),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Tabela de Oficinas Parceiras
CREATE TABLE oficinas_parceiras (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    latitude DECIMAL(10, 8) NOT NULL,
    longitude DECIMAL(11, 8) NOT NULL,
    endereco VARCHAR(255) NOT NULL
);

-- Tabela de Ordens de Serviço (OS)
CREATE TABLE ordens_servico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    modelo_veiculo VARCHAR(100) NOT NULL,
    descricao_problema TEXT NOT NULL,
    status ENUM('ABERTA', 'EM_ANDAMENTO', 'AGUARDANDO_PECA', 'FECHADA') DEFAULT 'ABERTA',
    responsavel_id BIGINT, -- Operador N1, N2 ou N3
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_fechamento TIMESTAMP NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    FOREIGN KEY (responsavel_id) REFERENCES usuarios(id)
);

-- Tabela de Chat (Histórico)
CREATE TABLE mensagens_chat (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ordem_servico_id BIGINT NOT NULL,
    remetente_id BIGINT NOT NULL,
    mensagem TEXT NOT NULL,
    data_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ordem_servico_id) REFERENCES ordens_servico(id),
    FOREIGN KEY (remetente_id) REFERENCES usuarios(id)
);