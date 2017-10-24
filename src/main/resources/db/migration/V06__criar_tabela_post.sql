CREATE TABLE post (
  codigo SERIAL NOT NULL,
  titulo VARCHAR(100),
  url_imagem VARCHAR(255),
  sumario text,
  eh_favorito BOOLEAN,
  PRIMARY KEY (codigo)
);

INSERT INTO post(titulo,url_imagem,sumario,eh_favorito) VALUES ('MVP Android','http://www.thiengo.com.br/img/post/80-80/mvp-android.png','Entenda o que é e como utilizar o padrão de arquitetura Model-View-Presenter em aplicativos Android, confira.',false);
INSERT INTO post(titulo,url_imagem,sumario,eh_favorito) VALUES ('Como Colocar Notificações Bolha em Seu Aplicativo Android','http://www.thiengo.com.br/img/post/80-80/como-colocar-notificacoes-bolha-em-seu-aplicativo-android.png','Aprenda, passo a passo, como colocar notificações bolha (Floating Windows) em seus aplicativos Android, para melhor apresentar conteúdos não visualizados. Confira.',true);
INSERT INTO post(titulo,url_imagem,sumario,eh_favorito) VALUES ('Top 10 leituras de 2016 que são boas pedidas para 2017','http://www.thiengo.com.br/img/post/80-80/top-10-leituras-de-2016-que-sao-boas-pedidas-para-2017.png','10 excelentes leituras de 2016, do Blog, que podem fazer parte de sua biblioteca e aumento de produção em 2017, confira.',false);
INSERT INTO post(titulo,url_imagem,sumario,eh_favorito) VALUES ('AndroidAnnotations, Entendendo e Utilizando','http://www.thiengo.com.br/img/post/80-80/androidannotations-entendendo-e-utilizando.png','Melhore a leitura do código de sua APP Android utilizando anotações para construção de scripts padrões que não fazem parte da lógica de negócio, confira.',true);
INSERT INTO post(titulo,url_imagem,sumario,eh_favorito) VALUES ('Estudando Android - Lista de Conteúdos do Blog','http://www.thiengo.com.br/img/post/80-80/estudando-android-lista-de-conteudos-do-blog.png','Estude pela lista, ordenada, de conteúdos em texto e em vídeo, do Blog, para você aprender a construir seus próprios aplicativos Android.',false);
INSERT INTO post(titulo,url_imagem,sumario,eh_favorito) VALUES ('GCMNetworkManager Para Execução de Tarefas no Background Android','http://www.thiengo.com.br/img/post/80-80/gcmnetworkmanager-para-execucao-de-tarefas-no-background-android.png','Aprenda a criar um simples aplicativo Android, de GPS tracking, utilizando, para tarefas de background, o GCMNetworkManager.',false);