# G5-java
## Repositório para desenvolvimento do projeto do Grupo 5

Na pasta ```"frontend"``` fica o "dashboard", que é o projeto do front-end em Vue. As dependências são organizadas com o npm, e são: "@vue/cli" e "@vue/cli-service".
- ```npm run serve``` 👉 Para compilar e colocar no ar (hot-reload). Comando que será usado regularmente na fase de development.
- ```vue ui``` 👉 Similar ao serve, mas com uma GUI para o desenvolvedor.
- ```npm run build``` 👉 Para compilar e buildar o app para produção. Não será usado até o final do projeto.

Na pasta ```"backend"``` fica o projeto do Spring Web.
- Versão do JDK (mínimo): ```Java 8```.

Na pasta ```"db"``` ficam as ferramentas para gerenciamento da nossa database.
- ```MySQL RDS (free-tier) na AWS```
- **AVISO:** Memória e processamento de DBs na AWS *são abundantes*, mas solicitações de conexão são *caras!*. Quer recuperar MUITOS DADOS ao mesmo tempo? Faça uma query única que busca todos esses dados, ao invés de fazer milhares de solicitações para pegar quantidades pequenas. Isso não só congestionar a nossa aplicação, como também pode acabar com nosso free-trial (e me deixar com uma dívida)! :P
