CREATE TABLE Endereco (
                          ID BIGINT PRIMARY KEY,
                          Logradouro VARCHAR(255),
                          Estado VARCHAR(255),
                          Cidade VARCHAR(255),
                          Numero VARCHAR(255),
                          CEP VARCHAR(255)
);

CREATE TABLE Funcionario (
                             ID BIGINT PRIMARY KEY,
                             Matricula VARCHAR(255),
                             Tempo_de_experiencia INT,
                             Endereco_ID BIGINT,
                             FOREIGN KEY (Endereco_ID) REFERENCES Endereco(ID)
);

CREATE TABLE Nutricionista (
                               ID BIGINT PRIMARY KEY,
                               CRN VARCHAR(255),
                               Especialidade VARCHAR(255)
);

CREATE TABLE Paciente (
                          ID BIGINT PRIMARY KEY,
                          Nome VARCHAR(255),
                          Data_de_Nascimento DATE,
                          CPF VARCHAR(255),
                          Telefone VARCHAR(255),
                          Email VARCHAR(255),
                          Endereco_ID BIGINT,
                          FOREIGN KEY (Endereco_ID) REFERENCES Endereco(ID)
);

CREATE TABLE Consulta (
                          ID BIGINT PRIMARY KEY,
                          Nutricionista_ID BIGINT,
                          Paciente_ID BIGINT,
                          Data_da_Consulta DATE,
                          Observacoes VARCHAR(255),
                          FOREIGN KEY (Nutricionista_ID) REFERENCES Nutricionista(ID),
                          FOREIGN KEY (Paciente_ID) REFERENCES Paciente(ID)
);


INSERT INTO Endereco VALUES (1, 'Rua A', 'Estado A', 'Cidade A', '123', '12345-678');
INSERT INTO Endereco VALUES (2, 'Rua B', 'Estado B', 'Cidade B', '456', '23456-789');
INSERT INTO Endereco VALUES (3, 'Rua C', 'Estado C', 'Cidade C', '789', '34567-890');

INSERT INTO Funcionario VALUES (1, 'Matricula1', 1, 1);
INSERT INTO Funcionario VALUES (2, 'Matricula2', 2, 2);
INSERT INTO Funcionario VALUES (3, 'Matricula3', 3, 3);

INSERT INTO Nutricionista VALUES (1, 'CRN1', 'Especialidade1');
INSERT INTO Nutricionista VALUES (2, 'CRN2', 'Especialidade2');
INSERT INTO Nutricionista VALUES (3, 'CRN3', 'Especialidade3');

INSERT INTO Paciente VALUES (1, 'Nome1', '2000-01-01', 'CPF1', 'Telefone1', 'Email1', 1);
INSERT INTO Paciente VALUES (2, 'Nome2', '2000-02-02', 'CPF2', 'Telefone2', 'Email2', 2);
INSERT INTO Paciente VALUES (3, 'Nome3', '2000-03-03', 'CPF3', 'Telefone3', 'Email3', 3);

INSERT INTO Consulta VALUES (1, 1, 1, '2022-01-01', 'Observacoes1');
INSERT INTO Consulta VALUES (2, 2, 2, '2022-02-02', 'Observacoes2');
INSERT INTO Consulta VALUES (3, 3, 3, '2022-03-03', 'Observacoes3');

UPDATE Paciente SET Telefone = 'NovoTelefone' WHERE ID = 1;

DELETE FROM Funcionario WHERE ID = 1;