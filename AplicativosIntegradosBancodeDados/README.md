## Conexão com banco de dados: bibliotecas e operações de conexão

 - Criação
```create database exemplo```

 - Indicar ao MySQL Workbench qual é o banco que será utilizado
```Use exemplo```

 - Exemplo de tabela
```create table usuario(id int not null auto_increment, nome varchar(70), PRIMARY KEY (id));```

- Inserindo valor
```INSERT INTO usuario (nome) VALUES ('João')```
