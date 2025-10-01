# Challenge

## Integrantes do Grupo

| Nome            |   RM   | Sala   |
|:----------------|:------:|:-------|
| Julia Monteiro  | 557023 | 2TDSPV |
| Victor Henrique | 556206 | 2TDSPH |
| Sofia Petruk    | 556585 | 2TDSPV |


### Solução do projeto

    O projeto propõe o desenvolvimento de uma plataforma inteligente para gestão de pátios da Mottu, integrando visão computacional, sensores IoT e QR Code.
    Com câmeras 360° instaladas no local, o sistema identificará visualmente motos em tempo real, mesmo sem placa ou com chassi oculto. Cada moto terá um QR Code 
    vinculado ao seu cadastro completo, incluindo imagem, modelo e status. A plataforma permitirá a localização rápida dos veículos, rastreabilidade de movimentações 
    e histórico de manutenções, eliminando perdas internas e aumentando a eficiência operacional. A solução visa resolver um dos principais gargalos logísticos da empresa 
    com precisão e escalabilidade

### Descrição do projeto

    Até o final do ano, o projeto contará com todas as funcionalidades propostas na solução. Por enquanto, foram criadas as classes básicas necessárias para dar início ao desenvolvimento.
    Criamos a classe do usuário, que servirá para login e cadastro, mas também permitirá acompanhar o status da própria moto ou realizar a compra de uma nova.
    Também desenvolvemos uma classe exclusiva para a moto, que será utilizada para identificá-la no pátio e registrar o que precisa ser feito nela.

## Como Rodar o Projeto

### Pré-requisitos
    IntelliJ IDEA
    JDK-23
    Oracle 11
### Clonar repositorio

    https://github.com/sofiapetruk/smartmottu-3.git

### Abra o projeto no IntelliJ IDEA:

    Inicie o IntelliJ

    Vá em File > Open... e selecione a pasta do projeto clonado

    Aguarde a indexação e o carregamento do Maven

### Execute o projeto:

    Clique na seta verde ▶ no canto superior direito

    Ou use o atalho Shift + F10

### Como entrar no projeto
    - localhost:8080/login
        - Faça o cadastro do seu usuário **OU** use Usuário ADMIN
            - email: admin@email.com
            - senha: admin123

