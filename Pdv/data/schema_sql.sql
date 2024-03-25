drop table if exists `item_venda`;
drop table if exists `hospedagem`;
drop table if exists `vendas`;
drop table if exists `quarto`;
drop table if exists `usuario`;
drop table if exists `produto`;

create table `quarto` (
	`id` int(11) not null,
    `tipo_quarto` varchar(100) not null,
    `valor_pernoite` decimal not null,
    `disponivel` boolean not null default true
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
ALTER TABLE `quarto`
	ADD PRIMARY KEY (`id`);
ALTER TABLE `quarto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

create table `usuario` (
	`id` int(11) not null,
    `nome` varchar(150) not null,
    `telefone` varchar(150) not null,
    `cpf` varchar(11) not null,
    `email` varchar(250) not null,
    `senha` varchar(500) not null,
    `tipo_usuario` varchar(100) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
ALTER TABLE `usuario`
	ADD PRIMARY KEY (`id`);
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

create table `produto` (
	`id` int(11) not null,
    `nome` varchar(150) not null,
    `valor_unitario` decimal(10,2) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
ALTER TABLE `produto`
	ADD PRIMARY KEY (`id`);
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

create table `hospedagem` (
	`id` int(11) not null,
    `data_entrada` datetime not null,
    `data_saida` datetime null,
    `quarto_id` int(11) not null,
    `cliente_id` varchar(150) not null,
    `funcionario_id` varchar(150) not null,
    `finalizada` boolean not null default false
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
ALTER TABLE `hospedagem`
	ADD PRIMARY KEY (`id`);
ALTER TABLE `hospedagem`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `hospedagem` ADD CONSTRAINT `fk_quarto`
  FOREIGN KEY (`quarto_id`) REFERENCES `quarto` (`id`) ;

create table `vendas` (
	`id` int(11) not null,
    `data` datetime not null,
    `valor_total` decimal not null,
	`cliente_id` varchar(150) not null,
    `funcionario_id` varchar(150) not null,
    `finalizada` boolean not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
ALTER TABLE `vendas`
	ADD PRIMARY KEY (`id`);
ALTER TABLE `vendas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

create table `item_venda` (
	`id` int(11) not null,
    `quantidade` int(50) not null,
    `subtotal` decimal not null,
    `nome` varchar(150) not null,
    `venda_id` int(11) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
ALTER TABLE `item_venda`
	ADD PRIMARY KEY (`id`);
ALTER TABLE `item_venda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `item_venda` ADD CONSTRAINT `fk_venda`
  FOREIGN KEY (`venda_id`) REFERENCES `vendas`(`id`);

INSERT INTO quarto (tipo_quarto, valor_pernoite, disponivel) VALUES ('Quarto Simples', 100.00, false);
INSERT INTO quarto (tipo_quarto, valor_pernoite, disponivel) VALUES ('Apartamento', 200.00, false);
INSERT INTO quarto (tipo_quarto, valor_pernoite, disponivel) VALUES ('Quarto Simples', 100.00, false);
INSERT INTO quarto (tipo_quarto, valor_pernoite, disponivel) VALUES ('Apartamento', 200.00, true);

INSERT INTO hospedagem (data_entrada, quarto_id, cliente_id, funcionario_id, finalizada)
VALUES (NOW() - INTERVAL 2 DAY, 1, 'cliente1', 'funcionario1', true);

INSERT INTO hospedagem (data_entrada, quarto_id, cliente_id, funcionario_id, finalizada)
VALUES (NOW() - INTERVAL 2 DAY, 2, 'cliente2', 'funcionario2', false);

INSERT INTO hospedagem (data_entrada, quarto_id, cliente_id, funcionario_id, finalizada)
VALUES (NOW() - INTERVAL 15 DAY, 3, 'cliente3', 'funcionario3', false);