*ALTERAÇÕES QUE FORAM FEITAS NO SISTEMA*

Essas melhorias tem o objetivo de deixar o código mais seguro e fácil de manter, além de garantir que os recursos sejam gerenciados corretamente.

-Try-with-Resources:
Descrição: Utilização da estrutura try-with-resources.
Benefício: Garantia de fechamento automático dos recursos, diminuindo a possibilidade de vazar os recursos.

-Método Auxiliar setPreparedStatementForProduto:
Descrição: Criação de um método auxiliar para configurar o PreparedStatement.
Benefício: Evita a repetição de código para definir os parâmetros do PreparedStatement.

-Método Auxiliar createProdutoFromResultSet:
Descrição: Criação de um método auxiliar para centralizar a lógica de criação de objetos Produto a partir do ResultSet.
Benefício: Centraliza a lógica de criação de objetos Produto a partir do ResultSet, fazendo o código mais limpo e reutilizável.

- Correção no Método remover:
Descrição: Ajuste no nome da coluna de cdCliente para cdProduto.
Benefício: Corrige um erro potencial, garantindo que a operação de remoção funcione corretamente.

- Mensagens de Log Melhores:
Descrição: Adição de mensagens de log mais detalhadas.
Benefício: Facilita a identificação de problemas durante a execução do código, tornando o processo de depuração mais eficiente.
![Captura de tela 2024-06-18 165452](https://github.com/pedroteixeira02/Atividades-Unima/assets/129986058/3be85861-af76-400c-b43c-a684cd6ebd35)
