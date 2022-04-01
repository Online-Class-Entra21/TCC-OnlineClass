
create database onlineclass;
\c onlineclass

CREATE TABLE public.escola
(
    idescola SERIAL NOT NULL,
    nome varchar(45) COLLATE pg_catalog."default" NOT NULL,
    datainicioletivo date,
    datafinalletivo date,
    CONSTRAINT escola_pkey PRIMARY KEY (idescola)
);


CREATE TABLE public.endereco
(
    idendereco SERIAL NOT NULL,
    estado varchar(45) COLLATE pg_catalog."default" NOT NULL,
    cidade varchar(45) COLLATE pg_catalog."default" NOT NULL,
    bairro varchar(45) COLLATE pg_catalog."default" NOT NULL,
    rua varchar(45) COLLATE pg_catalog."default" NOT NULL,
    numero integer NOT NULL,
    cep varchar(45) COLLATE pg_catalog."default" NOT NULL,
    complemento varchar(45) COLLATE pg_catalog."default",
    CONSTRAINT endereco_pkey PRIMARY KEY (idendereco)
);


CREATE TABLE public.usuario
(
    idusuario SERIAL NOT NULL,
    nome varchar(45) COLLATE pg_catalog."default" NOT NULL,
    sobrenome varchar(45) COLLATE pg_catalog."default" NOT NULL,
    cpf varchar(14) COLLATE pg_catalog."default",
    telefone varchar(45) COLLATE pg_catalog."default",
    celular varchar(45) COLLATE pg_catalog."default",
    tipousuario integer NOT NULL,
    email varchar(60) COLLATE pg_catalog."default" NOT NULL,
    senha varchar(45) COLLATE pg_catalog."default" NOT NULL,
    horafinalexpediente time without time zone,
    horainicioexpediente time without time zone,
    fotousuario varchar(1000) COLLATE pg_catalog."default",
    fk_endereco integer,
    fk_escola integer,
    datanasc date,
    CONSTRAINT usuario_pkey PRIMARY KEY (idusuario),
    CONSTRAINT usuario_cpf_key UNIQUE (cpf),
    CONSTRAINT usuario_email_key UNIQUE (email),
    CONSTRAINT usuario_fk_endereco_fkey FOREIGN KEY (fk_endereco)
        REFERENCES public.endereco (idendereco) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT usuario_fk_escola_fkey FOREIGN KEY (fk_escola)
        REFERENCES public.escola (idescola) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);


CREATE TABLE public.relatorio
(
    idrelatorio SERIAL NOT NULL,
    titulo varchar(45) COLLATE pg_catalog."default" NOT NULL,
    destinatario integer NOT NULL,
    texto text COLLATE pg_catalog."default" NOT NULL,
    fk_usuario integer NOT NULL,
    datarelatorio timestamp without time zone NOT NULL,
    CONSTRAINT relatorio_pkey PRIMARY KEY (idrelatorio),
    CONSTRAINT relatorio_fk_usuario_fkey FOREIGN KEY (fk_usuario)
        REFERENCES public.usuario (idusuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);


CREATE TABLE public.sala
(
    idsala SERIAL NOT NULL,
    nome varchar(45) COLLATE pg_catalog."default" NOT NULL,
    descricao varchar(45) COLLATE pg_catalog."default" NOT NULL,
    situacaoacesso boolean NOT NULL,
    tiposala boolean NOT NULL,
    link varchar(1000) COLLATE pg_catalog."default",
    CONSTRAINT sala_pkey PRIMARY KEY (idsala)
);



CREATE TABLE public.turma
(
    idturma SERIAL NOT NULL,
    ano varchar(45) COLLATE pg_catalog."default" NOT NULL,
    qtdaluno integer,
    horainicioaula time without time zone NOT NULL,
    horafinalaula time without time zone NOT NULL,
    fk_sala integer,
    fk_escola integer,
    CONSTRAINT turma_pkey PRIMARY KEY (idturma),
    CONSTRAINT turma_fk_escola_fkey FOREIGN KEY (fk_escola)
        REFERENCES public.escola (idescola) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT turma_fk_sala_fkey FOREIGN KEY (fk_sala)
        REFERENCES public.sala (idsala) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);



CREATE TABLE public.aluno
(
    idaluno SERIAL NOT NULL,
    ra varchar(45) NOT NULL,
    matricula varchar(45) NOT NULL,
    deficiencia boolean NOT NULL,
    nomemae varchar(45) COLLATE pg_catalog."default",
    nomepai varchar(45) COLLATE pg_catalog."default",
    nomeresponsavel varchar(45) COLLATE pg_catalog."default",
    situacaoanoletivo boolean,
    fk_usuario integer NOT NULL,
    fk_turma integer NOT NULL,
    CONSTRAINT aluno_pkey PRIMARY KEY (idaluno),
    CONSTRAINT aluno_fk_turma_fkey FOREIGN KEY (fk_turma)
        REFERENCES public.turma (idturma) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT aluno_fk_usuario_fkey FOREIGN KEY (fk_usuario)
        REFERENCES public.usuario (idusuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);



CREATE TABLE public.disciplina
(
    iddisciplina SERIAL NOT NULL,
    nome varchar(45) COLLATE pg_catalog."default" NOT NULL,
    fk_escola integer NOT NULL DEFAULT 1,
    CONSTRAINT disciplina_pkey PRIMARY KEY (iddisciplina),
    CONSTRAINT escola_fk FOREIGN KEY (fk_escola)
        REFERENCES public.escola (idescola) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);


CREATE TABLE public.usuario_disciplina
(
    id_usuario_disciplina SERIAL NOT NULL,
    fk_usuario integer NOT NULL,
    fk_disciplina integer NOT NULL,
    CONSTRAINT usuario_disciplina_pkey PRIMARY KEY (id_usuario_disciplina),
    CONSTRAINT usuario_disciplina_fk_disciplina_fkey FOREIGN KEY (fk_disciplina)
        REFERENCES public.disciplina (iddisciplina) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT usuario_disciplina_fk_usuario_fkey FOREIGN KEY (fk_usuario)
        REFERENCES public.usuario (idusuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE TABLE public.arquivo
(
    idarquivo SERIAL NOT NULL,
    extensao varchar(45) COLLATE pg_catalog."default" NOT NULL,
    dataenvio timestamp with time zone NOT NULL,
    remetente integer NOT NULL,
    arquivo varchar(1000) COLLATE pg_catalog."default",
    CONSTRAINT arquivo_pkey PRIMARY KEY (idarquivo)
);

CREATE TABLE public.atividade
(
    idatividade SERIAL NOT NULL,
    descricao varchar(500) COLLATE pg_catalog."default" NOT NULL,
    inicioatividade timestamp with time zone NOT NULL,
    finalatividade timestamp with time zone NOT NULL,
    tipoatividade integer NOT NULL,
    pesonota real,
    fk_usuario_disciplina integer NOT NULL,
    titulo varchar(45) COLLATE pg_catalog."default" NOT NULL DEFAULT 'o'::varchar,
    fk_arquivo integer,
    CONSTRAINT atividade_pkey PRIMARY KEY (idatividade),
    CONSTRAINT atividade_fk_arquivo FOREIGN KEY (fk_arquivo)
        REFERENCES public.arquivo (idarquivo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT atividade_fk_usuario_disciplina_fkey FOREIGN KEY (fk_usuario_disciplina)
        REFERENCES public.usuario_disciplina (id_usuario_disciplina) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);



CREATE TABLE public.resposta
(
    idresposta SERIAL NOT NULL,
    nota real,
    comentarioatividade varchar(45) COLLATE pg_catalog."default",
    correcaoatividade boolean,
    dataentrega timestamp with time zone NOT NULL,
    fk_aluno integer NOT NULL,
    fk_atividade integer NOT NULL,
    fk_arquivo integer NOT NULL,
    CONSTRAINT resposta_pkey PRIMARY KEY (idresposta),
    CONSTRAINT resposta_fk_aluno_fkey FOREIGN KEY (fk_aluno)
        REFERENCES public.aluno (idaluno) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT resposta_fk_arquivo_fkey FOREIGN KEY (fk_arquivo)
        REFERENCES public.arquivo (idarquivo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT resposta_fk_atividade_fkey FOREIGN KEY (fk_atividade)
        REFERENCES public.atividade (idatividade) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);




CREATE TABLE public.salapersonalizada
(
    idsalapersonalizada SERIAL NOT NULL,
    dono integer NOT NULL,
    fk_sala integer NOT NULL,
    CONSTRAINT salapersonalizada_pkey PRIMARY KEY (idsalapersonalizada),
    CONSTRAINT salapersonalizada_fk_sala_fkey FOREIGN KEY (fk_sala)
        REFERENCES public.sala (idsala) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);




CREATE TABLE public.usuario_disciplina_turma
(
    idusuario_disciplina_turma SERIAL NOT NULL,
    fk_usuario_disciplina integer NOT NULL,
    fk_turma integer NOT NULL,
    CONSTRAINT usuario_disciplina_turma_pkey PRIMARY KEY (idusuario_disciplina_turma),
    CONSTRAINT usuario_disciplina_turma_fk_turma_fkey FOREIGN KEY (fk_turma)
        REFERENCES public.turma (idturma) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT usuario_disciplina_turma_fk_usuario_disciplina_fkey FOREIGN KEY (fk_usuario_disciplina)
        REFERENCES public.usuario_disciplina (id_usuario_disciplina) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);





CREATE TABLE public.reuniao
(
    idreuniao SERIAL NOT NULL,
    descricao varchar(45) COLLATE pg_catalog."default" NOT NULL,
    datainicio timestamp with time zone NOT NULL,
    dono integer NOT NULL,
    notamediaaula real,
    fk_sala integer NOT NULL,
    fk_usuario_disciplina_turma integer,
    CONSTRAINT reuniao_pkey PRIMARY KEY (idreuniao),
    CONSTRAINT reuniao_fk_sala_fkey FOREIGN KEY (fk_sala)
        REFERENCES public.sala (idsala) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT reuniao_fk_usuario_disciplina_turma_fkey FOREIGN KEY (fk_usuario_disciplina_turma)
        REFERENCES public.usuario_disciplina_turma (idusuario_disciplina_turma) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);



CREATE TABLE public.reuniao_usuario
(
    id_reuniao_usuario SERIAL NOT NULL,
    fk_reuniao integer NOT NULL,
    fk_usuario integer NOT NULL,
    entradareuniao time without time zone,
    notareuniao real,
    comentarioreuniao varchar(45) COLLATE pg_catalog."default",
    CONSTRAINT reuniao_usuario_pkey PRIMARY KEY (id_reuniao_usuario),
    CONSTRAINT reuniao_usuario_fk_reuniao_fkey FOREIGN KEY (fk_reuniao)
        REFERENCES public.reuniao (idreuniao) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT reuniao_usuario_fk_usuario_fkey FOREIGN KEY (fk_usuario)
        REFERENCES public.usuario (idusuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);



CREATE TABLE public.usuario_salapersonalizada
(
    id_usuario_salapersonalizada SERIAL NOT NULL,
    fk_usuario integer NOT NULL,
    fk_salapersonalizada integer NOT NULL,
    CONSTRAINT usuario_salapersonalizada_pkey PRIMARY KEY (id_usuario_salapersonalizada),
    CONSTRAINT usuario_salapersonalizada_fk_salapersonalizada_fkey FOREIGN KEY (fk_salapersonalizada)
        REFERENCES public.salapersonalizada (idsalapersonalizada) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT usuario_salapersonalizada_fk_usuario_fkey FOREIGN KEY (fk_usuario)
        REFERENCES public.usuario (idusuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);


CREATE TABLE public.turma_atividade
(
    id_turma_atividade SERIAL NOT NULL,
    fk_turma integer NOT NULL,
    fk_atividade integer NOT NULL,
    CONSTRAINT turma_atividade_pkey PRIMARY KEY (id_turma_atividade),
    CONSTRAINT turma_atividade_fk_atividade_fkey FOREIGN KEY (fk_atividade)
        REFERENCES public.atividade (idatividade) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT turma_atividade_fk_turma_fkey FOREIGN KEY (fk_turma)
        REFERENCES public.turma (idturma) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);




CREATE TABLE public.chamada
(
    idchamada SERIAL NOT NULL,
    situacao boolean NOT NULL,
    fk_aluno integer NOT NULL,
    fk_reuniao integer NOT NULL,
    CONSTRAINT chamada_pkey PRIMARY KEY (idchamada),
    CONSTRAINT chamada_fk_aluno_fkey FOREIGN KEY (fk_aluno)
        REFERENCES public.aluno (idaluno) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT chamada_fk_reuniao_fkey FOREIGN KEY (fk_reuniao)
        REFERENCES public.reuniao (idreuniao) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);




CREATE TABLE public.arquivo_usuario
(
    id_arquivo_usuario SERIAL NOT NULL,
    fk_arquivo integer NOT NULL,
    fk_usuario integer NOT NULL,
    tipoenvio integer,
    CONSTRAINT arquivo_usuario_pkey PRIMARY KEY (id_arquivo_usuario),
    CONSTRAINT arquivo_usuario_fk_arquivo_fkey FOREIGN KEY (fk_arquivo)
        REFERENCES public.arquivo (idarquivo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT arquivo_usuario_fk_usuario_fkey FOREIGN KEY (fk_usuario)
        REFERENCES public.usuario (idusuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);




CREATE TABLE public.convite
(
    idconvite SERIAL NOT NULL,
    destinatario integer NOT NULL,
    salaconvite integer NOT NULL,
    situacaoconvite boolean,
    fk_usuario integer NOT NULL,
    CONSTRAINT convite_pkey PRIMARY KEY (idconvite, fk_usuario),
    CONSTRAINT convite_fk_usuario_fkey FOREIGN KEY (fk_usuario)
        REFERENCES public.usuario (idusuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);



CREATE TABLE public.periodoavaliacao
(
    idperiodoavaliacao SERIAL NOT NULL,
    datainicial timestamp with time zone NOT NULL,
    datafinal timestamp with time zone NOT NULL,
    descricao varchar(45) COLLATE pg_catalog."default" NOT NULL,
    fk_escola integer NOT NULL,
    CONSTRAINT periodoavaliacao_pkey PRIMARY KEY (idperiodoavaliacao),
    CONSTRAINT periodoavaliacao_fk_escola_fkey FOREIGN KEY (fk_escola)
        REFERENCES public.escola (idescola) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);


CREATE FUNCTION public.atualizar_qtd_aluno_delete()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
DECLARE numAlunos int;
BEGIN
	SELECT COUNT(*) into numAlunos FROM aluno where fk_turma = OLD.fk_turma;
    update turma set qtdaluno = numAlunos where idturma=OLD.fk_turma;
	return OLD;
END;
$BODY$;


CREATE FUNCTION public.atualizar_qtd_aluno_insert()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
DECLARE numAlunos int;
BEGIN
	SELECT COUNT(*) into numAlunos FROM aluno where fk_turma = NEW.fk_turma;
    update turma set qtdaluno = numAlunos where idturma=NEW.fk_turma;
	return NEW;
END;
$BODY$;


CREATE FUNCTION public.data_enviado()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN
	NEW.dataentrega = now();
    RETURN NEW;
END;
$BODY$;

CREATE TRIGGER data_reposta_enviada
    BEFORE INSERT
    ON public.resposta
    FOR EACH ROW
    EXECUTE PROCEDURE public.data_enviado();

CREATE TRIGGER atualizar_qtd_alunos_delete
    AFTER DELETE
    ON public.aluno
    FOR EACH ROW
    EXECUTE PROCEDURE public.atualizar_qtd_aluno_delete();

CREATE TRIGGER atualizar_qtd_alunos_insert
    AFTER INSERT
    ON public.aluno
    FOR EACH ROW
    EXECUTE PROCEDURE public.atualizar_qtd_aluno_insert();
    
    
    

-- Insert Administrador
insert into usuario (nome, sobrenome, tipoUsuario, email, senha, fotoUsuario) values
('André Luís','Ovidio',1,'andre@gmail.com','99999999','OnlineClass-imagens-000001.png'),
('Andrey Alan','Romig',1,'andrey@gmail.com','99999999','OnlineClass-imagens-000002.png'),
('Breno Augusto','Comandolli',1,'breno@gmail.com','99999999','OnlineClass-imagens-000003.png'),
('Ian Vicenzo','Meneghelli',1,'ian@gmail.com','99999999','OnlineClass-imagens-000004.png'),
('Ruan Daniel Camargo','de Souza',1,'ruan@gmail.com','99999999','OnlineClass-imagens-000005.png');

-- Insert Escola 
insert into escola (nome,datainicioletivo,datafinalletivo) values ('Quartz','2021-02-12','2021-12-02');

insert into endereco (estado,cidade,bairro,rua,numero,cep,complemento) values 
('SC','Tubarão','Centro','Rua Ferreira Lima','10','88701-305',null),
('SC','Joinville','Nova Brasília','Rua Américo Vespúcio','526','89213-401',null),
('SC','Blumenau','Progresso','Rua Helvis José Sborz','27','89026-692',null),
('SC','Joinville','Costa e Silva','Rua Inambu','87','89220-001',null),
('SC','Navegantes','São Domingos','Rua Gracilides Coelho Reiser','65','88370-552',null),
('SC','Florianópolis','Rio Tavares','Travessa da Moita Verde','86','88048-369',null),
('SC','Rio do Sul','Taboão','Beco São Domingos Sávio','34','89160-358',null),
('SC','Criciúma','Quarta Linha','Rua Olavio Rosso','20','88812-382',null),
('SC','Blumenau','Itoupava Norte','Rua Nilton Pershun','23','89053-183',null),
('SC','Florianópolis','Cachoeira do Bom Jesus','Rua Júlio César Corrêa','10','88056-675',null),
('SC','Itajaí','São Vicente','Rua Israel de Almeida','44','88312-050',null),
('SC','Jaraguá do Sul','Ilha da Figueira','Rua Francisco Assis Martins Costa','33','89258-476',null),
('SC','Joinville','Iririú','Rua Alberto T Veiga','9','89227-553',null),
('SC','Joinville','Centro','Rua do Príncipe','777','89201-000',null),
('SC','Tubarão','Humaitá de Cima','Patrício Lima','555','88708-200','Avenida'),
('SC','Blumenau','Itoupava Central','Rua Augusto Ruschi','12','89069-080',null),
('SC','Florianópolis','Barra da Lagoa','Servidão da Prainha','11','88061-240',null),
('SC','Blumenau','Itoupava Central','Rua Doutor Pedro Zimmermann','2456','89068-005',null),
('SC','Joinville','Fátima','Rua Pedro Ribeiro do Nascimento','123','89229-014',null),
('SC','Jaraguá do Sul','Vila Lenzi','Rua Maria Umbelina da Silva','3','89252-483',null),
('SC','Brusque','Souza Cruz','Rua Baviera','2','88354-495',null),
('SC','Blumenau','Velha Central','Rua Eugênio Liesenberg','33','89046-090',null),
('SC','Blumenau','Vila Nova','Rua Curitibanos','76','89035-060',null),
('SC','Blumenau','Velha','Rua Pindorama','9','89045-150',null),
('SC','Blumenau','Itoupava Norte','Rua Alan dos Santos','10','89053-604',null),
('SC','Blumenau','Salto do Norte','Rua Professor Max Humpl','100','89065-501',null),
('SC','Blumenau','Vila Itoupava','Rua Erwin Manzke','102','89095-400',null),
('SC','Blumenau','Escola Agrícola','Rua Germano Grosch','14','89037-490',null),
('SC','Blumenau','Velha Grande','Rua Três Marias','16','89045-446',null),
('SC','Blumenau','Badenfurt','Rua Elke Hansen','35','89070-160',null),
('SC','Blumenau','Garcia','Rua Murici','17','89020-310',null),
('SC','Blumenau','Badenfurt','Rua Maria Geralda Paulo','237','89070-660',null),
('SC','Blumenau','Salto Weissbach','Rua Werner Selzer','29','89032-260',null),
('SC','Blumenau','Itoupava Central','Rua Gustavo Zeck','65','89095-040',null),
('SC','Blumenau','Do Salto','Rua Josef Bernhard Kunze','92','89030-380',null),
('SC','Blumenau','Velha Central','Rua José Rautenberg','281','89046-643',null),
('SC','Blumenau','Itoupava Central','Rua José Joos','54','89063-150',null),
('SC','Blumenau','Garcia','Rua August Muller','36','89022-060',null),
('SC','Blumenau','Progresso','Rua Valentin Rosenbrock','80','89027-460',null),
('SC','Blumenau','Centro','Rua São José','64','89010-220',null);

--insert usuarios
insert into usuario (nome, sobrenome, cpf, celular, telefone, tipoUsuario, email, senha, horaFinalExpediente, horaInicioExpediente, fotoUsuario,dataNasc,fk_escola, fk_endereco) VALUES

-- Insert diretor
('Serena Fonseca','Águeda','265.180.909-87','(47) 98551-3751','(47) 3226-3026',2,'agueda@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000006.png','1990-04-03',1,1),

--insert coordenadores
('Katia Matias','Coelho','333.010.829-04','(47) 98524-4559','(47) 3383-3312',3,'coelho@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000007.png','1955-05-13',1,2),
('Magda Mortágua','Remígio','387.280.079-56','(47) 9999-6325','(47) 3183-3289',3,'remigio@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000008.png','1969-06-03',1,3),
('Briana Olivares','Furtado','863.071.779-34','(47) 99276-8032','(47) 3265-3193',3,'furtado@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000009.png','1978-07-08',1,4),

--insert professores
('Maria Regodeiro','Regueira','668.581.209-55','(47) 96411-7626','(47) 3155-3337',4,'regueira@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000010.png','1988-12-12',1,5),
('Gina Bessa','Carvalheira','251.566.179-30','(47) 98806-6008','(47) 3052-3082',4,'carvalheira@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000011.png','1977-12-23',1,6),
('Maura Faia','Aragão','780.178.239-91','(47) 94066-5965','(47) 3201-3088',4,'aragao@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000012.png','1974-11-13',1,7),
('Atílio Sintra','Lousado','758.401.809-20','(47) 95058-3356','(47) 3204-3215',4,'lousado@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000013.png','1987-10-14',1,8),
('Ísis Padilha','Cachoeira','784.045.819-08','(47) 93247-3679','(47) 3248-3011',4,'cachoeira@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000014.png','1989-09-17',1,9),
('Maia Olivares','Valverde','291.775.979-82','(47) 95823-8940','(47) 3026-3187',4,'valverde@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000015.png','1982-08-19',1,10),

--insert aluno
('Kendrick Coutinho','Machado','297.262.759-89','(47) 92922-4341','(47) 3317-3122',5,'machado@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000016.png','2005-08-19',1,11),
('Milton Pescada','Lira','542.052.649-25','(47) 98894-6695','(47) 3214-3015',5,'lira@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000017.png','2005-01-06',1,12),
('Yasmin Sampaio','Ramos','409.065.929-92','(47) 93760-5837','(47) 3115-3111',5,'ramos@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000018.png','2006-02-13',1,13),
('Martín Alcaide','Borja','756.696.339-20','(47) 95064-5390','(47) 3372-3063',5,'borja@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000019.png','2005-04-01',1,14),
('Yassna Palhares','Toledo','883.668.799-76','(47) 98828-6943','(47) 3179-3074',5,'toledo@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000020.png','2004-06-03',1,15),
('Íris Gouveia','Pardo','898.375.609-83','(47) 92867-4453','(47) 3301-3113',5,'pardo@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000021.png','2005-09-05',1,16),
('Lev Torres','Lima','103.290.669-35','(47) 99916-1256','(47) 3034-3375',5,'lima@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000022.png','2006-08-03',1,17),
('Daisi Amorim','Botelho','750.713.329-06','(47) 98790-6598','(47) 3271-3031',5,'botelho@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000023.png','2005-05-23',1,18),
('Juan Valério','Inácio','238.865.129-83','(47) 90932-5171','(47) 3309-3198',5,'inacio@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000024.png','2005-11-30',1,19),
('Cássia Monte','Almeida','121.903.879-22','(47) 94334-7856','(47) 3015-3259',5,'almeida@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000025.png','2005-12-27',1,20),
('Joelma Madeira','Toledo','851.208.129-53','(47) 94172-7856','(47) 3285-3113',5,'toledo2@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000026.png','2004-08-23',1,21),
('Letizia Carmona','Manso','674.893.649-73','(47) 95631-9036','(47) 3134-3169',5,'manso@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000027.png','2005-06-26',1,22),
('Angela Viveiros','Moutinho','291.195.189-19','(47) 99294-4099','(47) 3226-3156',5,'moutinho@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000028.png','2005-04-27',1,23),
('Miguel Berenguer','Cardim','190.355.379-20','(47) 94299-4275','(47) 3155-3026',5,'cardim@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000029.png','2006-03-25',1,24),
('Viriato Bezerra','Neves','939.295.249-02','(47) 99216-4218','(47) 3249-3049',5,'neves@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000030.png','2005-09-24',1,25),
('Emmanuel Benevides','Pinheiro','991.824.759-20','(47) 93407-6420','(47) 3176-3373',5,'pinheiro@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000031.png','2005-10-22',1,26),
('Glória Alencar','Carromeu','001.345.129-44','(47) 95290-5820','(47) 3016-3066',5,'carromeu@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000032.png','2004-02-19',1,27),
('Henzo Lamego','Mansilha','749.837.309-23','(47) 93730-6494','(47) 3094-3322',5,'mansilha@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000033.png','2005-04-14',1,28),
('Eliseu Junqueira','Santana','709.204.189-96','(47) 96596-4704','(47) 3176-3082',5,'santana@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000034.png','2005-03-12',1,29),
('Dayra Vilarinho','Pimenta','162.129.969-46','(47) 99210-9793','(47) 3227-3066',5,'pimenta@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000035.png','2005-04-11',1,30),
('Messias Faria','Filgueiras','709.312.869-64','(47) 96102-2063','(47) 3096-3022',5,'filgueiras@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000036.png','2004-09-22',1,31),
('Jandira Quaresma','Quadros','071.685.519-49','(47) 91228-7455','(47) 3002-3046',5,'quadros@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000037.png','2005-07-27',1,32),
('Jacyara Brandão','Marques','349.817.879-28','(47) 98710-4352','(47) 3210-3096',5,'marques@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000038.png','2005-03-30',1,33),
('Anthony Furtado','Viveiros','022.537.319-00','(47) 98592-7388','(47) 3280-3113',5,'viveiros@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000039.png','2006-03-24',1,34),
('Marcos Arouca','Breia','599.080.029-02','(47) 90505-5488','(47) 3268-3175',5,'breia@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000040.png','2005-09-25',1,35),
('Adalberto Freire','Mamouros','519.064.099-00','(47) 95122-1978','(47) 3366-3061',5,'mamouros@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000041.png','2005-12-13',1,36),
('Brenda Batata','Parente','448.815.169-81','(47) 97398-3396','(47) 3333-3212',5,'parente@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000042.png','2004-03-14',1,37),
('Bella Lobato','Colares','143.552.319-92','(47) 94571-3396','(47) 3070-3395',5,'colares@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000043.png','2005-04-24',1,38),
('Abrão Gadelha','Cidreira','605.843.429-77','(47) 90180-1453','(47) 3171-3088',5,'cidreira@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000044.png','2004-06-26',1,39),
('Arthur Doutel','Telinhos','812.560.109-01','(47) 90645-1453','(47) 3181-3096',5,'Telinhos@gmail.com','99999999','17:30:00','07:30:00','OnlineClass-imagens-000045.png','2006-02-23',1,40);


--insert disciplinas
insert into disciplina (nome,fk_escola) values 
('Matemática',1),
('Português',1),
('Física',1),
('Inglês',1),
('Geografia',1),
('História',1),
('Biologia',1),
('Educação Fisica',1),
('Sociologia',1),
('Filosofia',1);

--insert sala
insert into sala (nome,descricao,situacaoAcesso,tipoSala,link) values 
('1º Ano A','sala da turma 1º Ano A',true,false,'1anoA'),
('1º Ano B','sala da turma 1º Ano B',true,false,'1anoB');

--insert turma
insert into turma (ano,horaInicioAula,horaFinalAula,fk_sala,fk_escola) values
('1º Ano A','07:30:00','11:30:00',1,1),
('1º Ano B','07:30:00','11:30:00',2,1);

-- insert usuario_disciplina
insert into usuario_disciplina (fk_usuario,fk_disciplina) values
(10,1),
(10,3),
(11,2),
(11,4),
(12,5),
(12,6),
(13,6),
(13,8),
(14,9),
(14,10),
(15,10),
(15,7);

--insert usuario_disciplina_turma
insert into usuario_disciplina_turma (fk_usuario_disciplina,fk_turma) values
(6,1),
(10,1),
(1,1),
(2,1),
(3,1),
(4,1),
(5,1),
(8,1),
(9,1),
(12,1),
(7,2),
(11,2),
(1,2),
(2,2),
(3,2),
(4,2),
(5,2),
(8,2),
(9,2),
(12,2);


--insert alunos
insert into aluno (ra,matricula,deficiencia,nomeMae,nomePai,nomeResponsavel,situacaoAnoLetivo,fk_usuario,fk_turma) values

('7598339386-9/SC','4546694856',false,'Rita','Wesley',null,true,16,1),
('7438616923-5/SC','8874700992',false,'Julia','Junior',null,true,17,1),
('3381079223-3/SC','5972825756',false,'Amanda','Lucas',null,true,18,1),
('1638767083-8/SC','9845841847',false,'Andriy','Agostinho',null,true,19,1),
('8960320544-9/SC','2841327277',false,'Jana','Martinho',null,true,20,1),
('2928211558-3/SC','7026006605',false,'Liana','Mark',null,true,21,1),
('5459449299-1/SC','9934610816',false,'Ohana','Mauri',null,true,22,1),
('7231315426-0/SC','2977948443',false,'Stéphanie','Alfredo',null,true,23,1),
('2995323985-6/SC','1685344426',false,'Naiara','Daniel',null,true,24,1),
('6981746216-4/SC','8699352340',false,'Ivana','Giovanni',null,true,25,1),
('3447833442-3/SC','4439501728',false,'Gabrielly','Marcelo',null,true,26,1),
('2644616959-6/SC','1733094934',false,'Marta','Alexandre',null,true,27,1),
('6607897112-9/SC','4138270030',false,'Mirela','Jordan',null,true,28,1),
('2131297390-2/SC','3278374657',false,'Louise','Ayrton',null,true,29,1),
('7728252967-4/SC','4681012669',false,'Emília','Gelson',null,true,30,1),
('8091509785-9/SC','9717429741',false,'Carol','Ravi',null,true,31,2),
('5283732137-9/SC','3363501220',false,'Jia','Bryan',null,true,32,2),
('9782826950-9/SC','4000381683',false,'Rita','Rodolfo',null,true,33,2),
('5723218358-9/SC','3456122863',false,'Lilian','Mateo',null,true,34,2),
('3464424380-9/SC','5819709604',false,'Alana','Élson',null,true,35,2),
('1840376086-9/SC','6675786437',false,'Pietra','Matthias',null,true,36,2),
('6986582440-9/SC','8522256619',false,'Louisa','Wesley',null,true,37,2),
('8723068009-9/SC','8698226139',false,'Stefany','Rayan',null,true,38,2),
('3937998338-9/SC','9877721678',false,'Nadine','Diniz',null,true,39,2),
('9054251617-9/SC','4551882489',false,'Inês','Érico',null,true,40,2),
('9940337072-9/SC','9717139325',false,'Margarida','Mariano',null,true,41,2),
('5402042256-9/SC','4378657204',false,'Maísa','Dante',null,true,42,2),
('9072949388-9/SC','4684498120',false,'Glória','Gonçalo',null,true,43,2),
('6052582611-9/SC','4517700975',false,'Izabella','Manuel',null,true,44,2),
('7611048912-9/SC','8123676910',false,'Clarisse','Mário',null,true,45,2);

insert into sala (nome,descricao,situacaoacesso,tiposala,link) values 
('Sala 1','Alguma coisa',true,false,'Reuniao_Gestao_01'),
('Sala 2','Alguma coisa',true,false,'Reuniao_Gestao_02'),
('Sala 3','Alguma coisa',true,false,'Reuniao_Gestao_03');

insert into reuniao (descricao,datainicio,dono,notamediaaula,fk_sala,fk_usuario_disciplina_turma) values 
('Reuniao Gestao 1','2021-02-18 12:00',6,0,3,null),
('Reuniao Gestao 2','2021-02-22 12:00',6,0,4,null),
('Reuniao Gestao 3','2021-02-24 12:00',6,0,5,null);

insert into reuniao_usuario(fk_reuniao,fk_usuario) values
(1,7),
(1,15),
(2,7),
(2,15),
(3,7),
(3,15);

insert into relatorio (titulo,destinatario,texto,fk_usuario,datarelatorio) values
('Comunicado Urgente',7,'O retorno das aulas está previsto para o dia 15/02/2021, 
 segundo nosso calendário escolar, espero que esteja bem. atenciosamente Agueda',6,'2021-02-14 11:02:00'),
 ('Requisição de Livros',7,'Boa Tarde, gostaria de requisitar um novo livro didático para o ano de 2021, 
  na disciplina de Biologia para os segundos anos, atenciosamente Prof. Valverde',15,'2021-02-16 09:34:00');



