## Contexto

Depois de terminar a primeira sprint e realizar uma nova planning para definir tarefas da segunda sprint, você deverá implementar as demais funcionalidades de um CRUD, ou seja, agora, você deve desenvolver uma funcionalidade de consulta, uma para atualização e outra para exclusão dos dados pertinentes ao cadastro de filmes, além de criar uma aplicação executável como protótipo do projeto. Deve ser possível realizar um filtro dinâmico para a busca de categoria de filmes.
Você também deverá fornecer uma documentação técnica das classes desenvolvidas.

1. Checklist - Passos para Implementar o CRUD e Filtro de Filmes

Etapas principais:

    1. Revisar o arquivo FilmeDAO.java:
        - Adicionar os métodos que faltam para as operações de Consulta por Categoria, Atualização e Exclusão.
    2. Revisar o arquivo Cenaflix.java:
        - Implementar a interface gráfica para lidar com o filtro por categoria.
        - Adicionar ações (eventos) para Atualizar, Excluir e Buscar filmes.
    3. Revisar o arquivo Filme.java:
        - Garantir que está correto para suportar todas as operações do CRUD.
    4. Documentar as classes e métodos usando JavaDocs.

2. Lista de Arquivos que Precisam ser Revisados ou Alterados

Arquivos a revisar e suas funcionalidades:
    1. FilmeDAO.java:
        - Implementar ou revisar métodos para: Buscar filmes por categoria ou nome.
        - Atualizar filmes.
        - Excluir filmes.
    2. Cenaflix.java:
        - Adicionar ações para o filtro por categoria.
        - Adicionar funcionalidades de atualizar e excluir filmes.
    3. Filme.java:
        - Revisar se está com todos os campos necessários e se está corretamente implementado.