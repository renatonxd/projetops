 Padrões de Projeto e Suas Motivações
Para garantir que o sistema fosse fácil de usar, entender e modificar, optamos por usar alguns padrões de projeto. Esses padrões ajudam a organizar o código e tornar as mudanças mais simples no futuro.

- Decorator
O padrão Decorator foi usado porque o relatório de cada atividade precisa de informações adicionais, como observações sobre o ajuste das horas (por exemplo, se o aluno ultrapassou o limite de horas). Com esse padrão, conseguimos adicionar essas informações de maneira flexível, sem mexer na estrutura do relatório original.

Para isso, criamos um relatório básico que mostra as atividades e suas horas. Esse relatório pode ser "decorado" com mais informações, como ajustes de horas e comentários adicionais, sem precisar alterar o relatório inicial.

- Chain of Responsibility
O padrão Chain of Responsibility foi escolhido para lidar com as diferentes etapas da validação das atividades. Cada regra de validação (como o limite de horas ou a verificação de documentos) precisa ser verificada de forma independente, sem sobrecarregar um único processo.

A ideia é que cada validador (que verifica um critério, como limite de horas ou documentação) passe a responsabilidade para o próximo validador, se necessário. Isso facilita a adição de novas validações no futuro, sem complicar o código.

- Command
O padrão Command foi usado para separar a interface com o usuário (onde o aluno interage com o sistema) da lógica de execução das ações do sistema. Isso torna o código mais organizado e facilita a adição de novas funcionalidades no futuro.

Cada ação que o aluno faz (como adicionar uma atividade ou finalizar o requerimento) é tratada como uma ação independente, e o sistema mantém um controle dessas ações. Isso também abre a possibilidade de adicionar funções de desfazer e refazer no futuro.

- Null Object
O padrão Null Object foi utilizado para evitar um possível erro que pode ocorrer ao tentar acessar algo que não existe (o famoso NullPointerException). Com esse padrão, garantimos que, se algum validador não processar a atividade, o sistema continuará funcionando corretamente, sem falhas.

- Observer
O padrão Observer foi escolhido para separar a validação da geração do relatório. Isso significa que a validação das atividades e a criação do parecer final são tratadas separadamente, o que facilita a manutenção e a expansão do sistema.

Aqui, o Requerimento (onde ficam as informações das atividades do aluno) é o "publicador", e o GeradorRelatorio é o "observador". Quando a validação termina, o Requerimento notifica o GeradorRelatorio para criar e exibir o parecer.

- Estrutura do Projeto
A estrutura do código foi organizada de forma simples e clara para que cada parte do sistema tenha uma responsabilidade bem definida. Aqui está como os pacotes estão organizados:

modelo: Aqui ficam as informações sobre as atividades do aluno, como a atividade em si, as horas registradas e os tipos de atividades.

avaliacao: Este pacote contém as regras de validação, como a verificação de horas e documentos.

acoes: Esse pacote cuida das ações do menu, como adicionar atividades ou finalizar o requerimento.

relatorios: Responsável por gerar o relatório final com as horas validadas e observações.

notificacao: Aqui é onde o sistema lida com a notificação de que a validação foi concluída e o relatório precisa ser gerado.

apresentacao: O pacote que lida com a interface de usuário no console, permitindo que o aluno interaja com o sistema.
