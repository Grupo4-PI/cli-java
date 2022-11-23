CREATE DATABASE nocrash;
USE nocrash;

CREATE TABLE Hardware (
idHardware VARCHAR(20) PRIMARY KEY,
nomeProcessador VARCHAR(80), 
fabricante VARCHAR(80),
frequencia VARCHAR(80),
memoriaTotal DECIMAL,
qntDisco INT,
fkDesktop CHAR(8) UNIQUE
);

CREATE TABLE Dado (
idDado INT AUTO_INCREMENT PRIMARY KEY,
memoriaDisponivel DECIMAL,
usoProcessador DECIMAL,
columnData TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
fkHardware VARCHAR(20),
FOREIGN KEY (fkHardware) REFERENCES Hardware(idHardware)
);

CREATE TABLE Disco (
idDisco INT AUTO_INCREMENT PRIMARY KEY,
modelo VARCHAR(80),
serial VARCHAR(90) UNIQUE,
bytesEscrita INT,
bytesLeitura INT,
escritas INT,
leituras INT,
tamanho INT,
tamanhoAtualFila INT,
tempoTransferencia INT,
columnData TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
fkHardware VARCHAR(20),
FOREIGN KEY (fkHardware) REFERENCES Hardware(idHardware)
);
