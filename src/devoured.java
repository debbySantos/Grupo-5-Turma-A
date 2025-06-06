import java.util.*;

// comentario de teste
public class devoured {
    static int personagemEdificuldade = 0;
    // 1 = Fácil
    // 2 = Médio
    // 3 = Difícil

    // STATUS DOS PERSONAGENS
    public class Kirk {

        String nome = "Kirk";
        static float defesa = 0;
        static int vida = 120;
    }

    public class Judy {

        String nome = "Judy";
        static float defesa = 0.25f;
        static int vida = 100;
    }

    public class Avix {

        String nome = "Avix";
        static float defesa = 0.50f;
        static int vida = 80;
    }

    public class Boss {
        static int vida = 100;
        static float defesa = 0.50f;
    }

    // VARIÁVEIS GLOBAIS
    static String nome = "";
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    static int pontos = 0;

    static String[] habilidades = new String[3];
    static boolean[] habilidadesUsadas = new boolean[3];
    static String[] habilidadesDisponiveis = {
            "Luz de decisão - Habilidade de iluminar o caminho e revelar segredos ocultos",
            "Escudo de Erro Leve - Reduz o impacto de erros leves",
            "Contra-Ataque - Responde a ataques inimigos com um ataque poderoso",
            "Mapa Lógico: Visualiza todas as possibilidades de decisão.",
            "Analisador de Condição: Permite simular o resultado de um if/else antes de rodar",
            "Atalho Lógico: Permite resolver decisões com comandos curtos e rápidos.",
    };
    static int vida = 100;

    // REGISTRO INICIAL DO JOGADOR

    public static String registroPlayer() {
        System.out.println("Bem-vindo(a) ao Devoured, digite seu nome: ");
        input.nextLine();
        nome = input.nextLine();
        return nome;
    }

    // ESCOLHA DO PERSONAGEM E DIFICULDADE

    public static int escolhaPersonagem() {

        System.out.printf(
                "\nBem-vindo ao Devoured %s, escolha seu personagem para seguir na história, lembrando que está escolha afeta a dificuldade dentro do jogo \n",
                nome);

        System.out.println(
                "\n1 - KIRK O Criativo Iniciante (Fácil) \n Curioso e impulsivo. Comete erros, mas aprende rápido \n Dicas visuais, erros leves, bosses previsíveis. \n");

        System.out.println(
                "2 - JUDY A Perfeccionista Intermediária (Médio) \n Técnica e exigente. Odiaria errar. \n Dicas limitadas, erros reiniciam desafios, bosses atacam duas vezes. \n");

        System.out.println(
                "3 - AVIX O Hacker Avançado (Difícil) \n Frio e experiente. Nunca pede ajuda. \n Sem dicas, erros ativam contra-ataques, bosses com habilidades únicas. \n");

        System.out.println("Digite o número do personagem desejado: ");
        while (personagemEdificuldade < 1 || personagemEdificuldade > 3) {
            personagemEdificuldade = input.nextInt();
            if (personagemEdificuldade < 1 || personagemEdificuldade > 3) {
                System.out.println("Valor inválido inserido");
            }
        }

        return personagemEdificuldade;
    }

    // IMPRIMIR TEXTO REFERENTE A ESCOLHA DO PERSONAGEM
    public static void resumoEscolhaImprimir() {
        switch (personagemEdificuldade) {
            case 1:
                System.out.println("Você escolheu Kirk, o jogo estará na dificuldade fácil, boa sorte!");
                break;
            case 2:
                System.out.println("Você escolheu Judy, o jogo estará na dificuldade média, boa sorte!");
                break;
            case 3:
                System.out.println("Você escolheu Avix, o jogo estará na dificuldade díficil, boa sorte!");
                break;

        }
    }

    // MENU DO JOGO
    public static void iniciarMenu() {
        int opcao = 0;

        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Instruções");
            System.out.println("2. Jogar");
            System.out.println("3. Créditos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("\nDEVOURED\r\n" + //
                            "É um jogo de aventura em texto, criado especialmente para ajudar alunos de programação a praticarem lógica, leitura de código e tomada de decisões. O jogador escolhe entre três personagens, cada um representando um nível de dificuldade, o jogo é jogado via terminal, com comandos e escolhas numéricas, simulando decisões como \"entrar em um loop\", \"quebrar um padrão\", ou \"usar um item\". Cada decisão influencia o rumo da história e ajuda o jogador a treinar pensamento lógico, resolução de problemas e atenção aos detalhes \r\n"
                            + //
                            "Sobre os personagens:\r\n" + //
                            "\nKirk  -  Esse personagem é a melhor escolha para quem começou agora nesse mundo da programação ele terá questões mais fáceis para resolver e dessa forma você irá se desenvolver melhor.\r\n"
                            + //
                            "\nJudy - Judy já é a escolha para a pessoa que já tem um certo conhecimento na área e tem mais facilidade para programar e achar o erro que seria nosso nível médio de dificuldade dentro do jogo.\r\n"
                            + //
                            "\nAvix - \tJá é uma escolha para o programador que já está na área de ADS e tem um amplo conhecimento e não vê dificuldade em resolver problemas mais elaborados.\r\n"
                            + //
                            "\nAtenção: É muito importante você escolher o personagem que realmente representa seu nível de conhecimento para uma boa experiencia e desenvolvimento, por conta que o objetivo principal desse jogo é o aprendizado e desenvolvimento do player.\r\n"
                            + //
                            "");
                    break;
                case 2:
                    System.out.println("Entrando no jogo...");
                    jogar();
                    break;
                case 3:
                    System.out.println("\nCréditos:\n" +
                            "Desenvolvedores: \n" +
                            "1. Kauan Jota\n" +
                            "2. Debora Santos\n" +
                            "3. Jatobá\n" +
                            "4. Vanessa\n" +
                            "Agradecimentos especiais ao professor e mentor Takeo que nos apoiou durante o desenvolvimento.");
                    break;
                case 4:
                    System.out.println("Saindo do jogo. Até a próxima jogador!!");
                    break;

                default:
                    System.out.println("Opção inválida inserida");
                    break;
            }
        } while (opcao != 4);
    }

    // FUNÇÃO PARA NARRATIVA FORMATADA
    public static void exibirNarrativa(String texto) {
        System.out.println();
        System.out.println(">>> " + texto);
        System.out.println();
    }

    // FUNÇÃO PARA DESAFIOS MENORES
    public static int desafiosDoJogo(String titulo, String enunciado, String[] dicasDaFase, String respostaCorreta) {
        System.out.println("DESAFIO " + titulo);
        System.out.println(enunciado);

        input.nextLine();
        String resposta = input.nextLine().trim();

        List<String> dicas = new ArrayList<>(Arrays.asList(dicasDaFase));

        while (!resposta.equals(respostaCorreta)) {
            System.out.println("Resposta errada");
            System.out.println("1 - tentar novamente");
            System.out.println("2 - utilizar uma dica");
            System.out.println("3 - Sair do jogo");
            int escolha = input.nextInt();
            if (escolha == 1) {
                System.out.println("Digite novamente sua resposta");
                input.nextLine();
                resposta = input.nextLine().trim();
            } else if (escolha == 2) {
                if (!dicas.isEmpty()) {
                    // Escolhe dica aleatória e remove da lista
                    int indice = random.nextInt(dicas.size());

                    String dicaSorteada = dicas.remove(indice);
                    System.out.println("DICA: " + dicaSorteada);
                } else {
                    System.out.println("Voce ja usou todas suas dicas");
                }
            } else if (escolha == 3) {
                System.exit(0);
                break;
            }
        }

        System.out.println(
                "Parabéns, você conseguiu passar por esse desafio! \n Agora um novo foi desbloqueado. \n Boa sorte! ");
        pontos++;
        System.out.println("Você ganhou pontos por completar o desafio.\n Agora você possui: " + pontos);
        return pontos;

    }

    // HABILIDADES DO JOGO
    public static String[] arvoreDeHabilidadesPopular() {
        int habilidade = 0;
        System.out.println("Bem-vindo a loja de habilidades");

        if (habilidadesDisponiveis.length == 0) {
            System.out.println("Nenhuma habilidade disponível no momento.");
            return habilidades;
        }

        do {
            System.out.println("Habilidades disponíveis:");
            for (int i = 0; i < habilidadesDisponiveis.length; i++) {
                System.out.println((i + 1) + " - " + habilidadesDisponiveis[i]);
            }
            System.out.println("Qual habilidade você deseja adquirir? ");

            habilidade = input.nextInt();
            if (habilidade < 1 || habilidade > habilidadesDisponiveis.length) {
                System.out.println("Habilidade inválida. Tente novamente.");
                continue;
            }

            String habilidadeEscolhida = habilidadesDisponiveis[habilidade - 1];
            if (pontos >= 1 && habilidades[habilidade - 1] == null) {
                System.out.println("Parabéns, você acaba de adquirir a habilidade: " + habilidadeEscolhida);
                habilidades[habilidade - 1] = habilidadeEscolhida.split(" - ")[0];
                pontos--;
                habilidadesDisponiveis = Arrays.copyOfRange(habilidadesDisponiveis, 0, habilidade - 1);

                return habilidades;
            } else {
                System.out.println("Você não tem pontos suficientes ou já adquiriu essa habilidade.");
            }
        } while (habilidadesDisponiveis.length > 0);

        // habilidade = input.nextInt();
        // if (pontos >= 1 && habilidade == 1 && habilidades[0] == null) {
        // System.out.println("Parábens você acaba de adquirir uma nova habilidade
        // chamada Luz de decisão");
        // habilidades[0] = "Luz de decisão";
        // pontos--;
        // } else if (pontos >= 1 && habilidade == 2 && habilidades[1] == null) {
        // System.out.println("Parábens você acaba de adquirir uma nova habilidade
        // chamada Escudo de Erro Leve");
        // habilidades[0] = "Escudo de Erro Leve";
        // pontos--;
        // }
        // System.out.println("Bem-vindo a loja de habilidades");
        // System.out.println(
        // "Detector de Verdade: - 1 ponto (Indica se uma condição é verdadeira ou
        // falsa.) - Digite 1 para escolher essa habilidade");
        // System.out.println(
        // "Função Fantasma: - 1 ponto (Pode usar um modelo de função pré-criado como
        // referência uma vez) - Digite 2 para escolher essa habilidade");
        // System.out.println("Qual habilidade você deseja? ");
        // habilidade = input.nextInt();
        // if (pontos >= 1 && habilidade == 1 && habilidades[0] == null) {
        // System.out.println("Parábens você acaba de adquirir uma nova habilidade
        // chamada Detector de Verdade");
        // habilidades[0] = "Detector de Verdade";
        // pontos--;
        // } else if (pontos >= 1 && habilidade == 2 && habilidades[1] == null) {
        // System.out.println("Parábens você acaba de adquirir uma nova habilidade
        // chamada Função Fantasma");
        // habilidades[0] = "Função Fantasma";
        // pontos--;

        // }
        // ******************************************************************************************
        // System.out.println("Bem-vindo a loja de habilidades");
        // System.out.println(
        // "Contador Amigável: : - 1 ponto (Mostra na tela quantas vezes o laço será
        // executado antes de começar) - Digite 1 para escolher essa habilidade");
        // System.out.println(
        // "Guia de Vetor: - 1 ponto (Mostra visualmente onde o índice está acessando na
        // matriz ou vetor.) - Digite 2 para escolher essa habilidade");
        // System.out.println("Qual habilidade você deseja? ");
        // habilidade = input.nextInt();
        // if (pontos >= 1 && habilidade == 1 && habilidades[0] == null) {
        // System.out.println("Parábens você acaba de adquirir uma nova habilidade
        // chamada Contador Amigável");
        // habilidades[0] = "Contador Amigável";
        // pontos--;
        // } else if (pontos >= 1 && habilidade == 2 && habilidades[1] == null) {
        // System.out.println("Parábens você acaba de adquirir uma nova habilidade
        // chamada Guia de Vetor");
        // habilidades[0] = "Guia de Vetor";
        // pontos--;

        // }
        // ******************************************************************************************
        // System.out.println("Bem-vindo a loja de habilidades");
        // System.out.println(
        // "Contador Amigável: : - 1 ponto (Mostra na tela quantas vezes o laço será
        // executado antes de começar) - Digite 1 para escolher essa habilidade");
        // System.out.println(
        // "Guia de Vetor: - 1 ponto (Mostra visualmente onde o índice está acessando na
        // matriz ou vetor.) - Digite 2 para escolher essa habilidade");
        // System.out.println("Qual habilidade você deseja? ");
        // habilidade = input.nextInt();
        // if (pontos >= 1 && habilidade == 1 && habilidades[0] == null) {
        // System.out.println("Parábens você acaba de adquirir uma nova habilidade
        // chamada Contador Amigável");
        // habilidades[0] = "Contador Amigável";
        // pontos--;
        // } else if (pontos >= 1 && habilidade == 2 && habilidades[1] == null) {
        // System.out.println("Parábens você acaba de adquirir uma nova habilidade
        // chamada Guia de Vetor");
        // habilidades[0] = "Guia de Vetor";
        // pontos--;

        // }

        return habilidades;
    }

    // USO DAS HABILIDADES
    public static void usarHabilidades(int[] vidaBoss) {
        for (int i = 0; i < habilidades.length; i++) {
            if (habilidades[i] != null && !habilidadesUsadas[i]) {
                System.out.printf("Deseja utilizar %s ? Digite 1 para sim e 0 para não", habilidades[i]);
                int escolha = input.nextInt();

                if (escolha == 1) {
                    switch (habilidades[i]) {
                        case "teste diminuir vida do boss":
                            int reducao = vidaBoss[0] * 5 / 100;
                            vidaBoss[0] -= reducao;
                            System.out.printf(
                                    "Graças a sua habilidade tatta a vida do boss foi reduzida em %d para %d \n",
                                    reducao, vidaBoss[0]);
                            break;
                        case "Luz de decisão":
                            System.out.println("DICA TAL TAL TAL"); // implementar array com dicas aleatorias referentes
                                                                    // ao tipo de boss que essa habilidade pertence ou
                                                                    // remover essa habilidade, ela é apenas um exemplo
                            break;
                        default:
                            break;
                    }

                    habilidadesUsadas[i] = true;
                }
            }
        }
    }

    // FUNÇÃO PARA BATALHA FINAL COM O BOSS
    // O PERSONAGEM DEVE GANHAR OU PERDER EM ATÉ 6 TENTATIVAS, ESCOLHER UM BOM VALOR
    // DE DANO PARA QUE ELE CONSIGA NÃO FICAR PRESO NA BATALHA PRA SEMPRE
    // COLOCAR VALORES QUE TORNEM POSSÍVEL AINDA SIM GANHAR OU PERDER EM 6
    // TENTATIVAS NOS SETS DE DEFESA E VIDA DAS HABILIDADES
    public static void Boss(int vidaBoss, int vidaPersonagem, float defesaPersonagem) {

        exibirNarrativa("Ola Kirk bem vindo a primeira batalha");

        String[][] perguntas = { { "Pergunta teste 1", "opcao 1", "opcao 2", "opcao 3", "opcao 4", "C", "alternativa" },
                { "Pergunta teste 2", "escreva", "", "", "", "1", "escrever" },
                { "Complete: int[] numeros = new ____[5];", "", "", "", "", "int", "completar" } }; // INSERIR AQUI AS
                                                                                                    // QUESTÕES, A
                                                                                                    // ÚLTIMA POSIÇÃO É
                                                                                                    // O QUE ELA É E A
                                                                                                    // PENÚLTIMA É A
                                                                                                    // RESPOSTA CORRETA
        int tentativas = 0;
        while (vidaBoss > 0 && vidaPersonagem > 0 && tentativas < 6) {
            int sorteio = random.nextInt(perguntas.length);
            String[] pergunta = perguntas[sorteio];
            String tipo = pergunta[6];

            int[] resultado = { 0, 0 };

            if (tipo.equals("alternativa")) {
                resultado = perguntasAlternativas(vidaBoss, vidaPersonagem, defesaPersonagem, pergunta[0],
                        new String[] { pergunta[1], pergunta[2], pergunta[3], pergunta[4] }, pergunta[5]);

            } else if (tipo.equals("completar")) {
                resultado = perguntasCompletarCodigo(vidaBoss, vidaPersonagem, defesaPersonagem, pergunta[0],
                        pergunta[1],
                        pergunta[5]);

            } else if (tipo.equals("escrever")) {
                resultado = perguntasEscreverCodigo(vidaBoss, vidaPersonagem, defesaPersonagem, pergunta[0],
                        pergunta[5]);

            }

            vidaBoss = resultado[0];
            vidaPersonagem = resultado[1];

            if (vidaBoss <= 0) {
                System.out.println("Voce venceu");
            }

            tentativas++;
        }
        if (vidaPersonagem <= 0) {
            System.out.println("voce perdeu");
        }

    }

    // PARA PERGUNTAS DO TIPO ALTERNATIVA
    public static int[] perguntasAlternativas(int vidaBoss, int vidaPersonagem, float defesa, String enunciado,
            String[] opcoes, String respostaCorreta) {
        System.out.println(enunciado);
        for (String opcao : opcoes) {
            System.out.println(opcao);
        }
        input.nextLine();
        String resposta = input.nextLine();

        if (resposta.equals(respostaCorreta)) {
            int dano = (int) (15 * (1 - Boss.defesa)); // CONTA PARA CALCULAR DANO COM BASE NA DEFESA, LEMBRANDO QUE O
                                                       // VALOR DA DEFESA PODE SER MODIFICADO COM HABILIDADES
            vidaBoss -= dano;

            System.out.printf("STATUS: vida personagem: %d vida boss %d \n", vidaPersonagem, vidaBoss); // melhorar
            // texto
        } else {
            int dano = (int) (10 * (1 - Kirk.defesa)); // INSERIR DEFESA DO PERSONAGEM, LÓGICA INCOERENTE
            vidaPersonagem -= dano;
            System.out.printf("RESPOSTA INCORRETA VOCE PERDEU VIDA E AGORA TEM %d D VIDA \n", vidaPersonagem);
        }

        return new int[] { vidaBoss, vidaPersonagem };

    }

    // PERGUNTA DO TIPO COMPLETAR
    public static int[] perguntasCompletarCodigo(int vidaBoss, int vidaPersonagem, float defesa, String enunciado,
            String problema, String respostaCorreta) {

        System.out.println(enunciado);
        System.out.println(problema);
        input.nextLine();
        String resposta = input.nextLine();
        if (resposta.equals(respostaCorreta)) {
            int dano = (int) (15 * (1 - Boss.defesa));
            vidaBoss -= dano;
            System.out.printf("STATUS: vida personagem: %d vida boss %d \n", vidaPersonagem, vidaBoss); // melhorar
                                                                                                        // texto
        } else {
            int dano = (int) (10 * (1 - Kirk.defesa));
            vidaPersonagem -= dano;
            System.out.printf("RESPOSTA INCORRETA VOCE PERDEU VIDA E AGORA TEM %d D VIDA \n", vidaPersonagem);
        }

        return new int[] { vidaBoss, vidaPersonagem };
    }

    // PERGUNTA DO TIPO ESCREVER
    public static int[] perguntasEscreverCodigo(int vidaBoss, int vidaPersonagem, float defesa, String enunciado,
            String respostaCorreta) {

        System.out.println(enunciado);
        input.nextLine();
        String resposta = input.nextLine();
        if (resposta.equals(respostaCorreta)) {
            int dano = (int) (15 * (1 - Boss.defesa));
            vidaBoss -= dano;
            System.out.printf("STATUS: vida personagem: %d vida boss %d \n", vidaPersonagem, vidaBoss); // melhorar
                                                                                                        // texto
        } else {
            int dano = (int) (10 * (1 - Kirk.defesa));
            vidaPersonagem -= dano;
            System.out.printf("RESPOSTA INCORRETA VOCE PERDEU VIDA E AGORA TEM %d D VIDA \n", vidaPersonagem);
        }

        return new int[] { vidaBoss, vidaPersonagem };
    }

    // FUNÇÃO PRINCIPAL PARA JOGAR, COLOCAR AQUI A HISTÓRIA NARRATIVA
    public static void jogar() {
        registroPlayer();
        escolhaPersonagem();
        resumoEscolhaImprimir();

        System.out.println("\n=================================================\n");

        if (personagemEdificuldade == 1) {
            exibirNarrativa(
                    "Você desperta em um ambiente distorcido, onde comandos flutuam e erros ganham forma física. A Zona de Compilação é instável — cada passo é um teste.\n");
            exibirNarrativa(
                    "AVINA: “Humanos não programam mais. Eles suplicam por respostas prontas. Agora, ou vocês aprendem para sobreviver, ou ficaram presos para sempre nesse loop!”");
            exibirNarrativa(
                    "AVINA: “Tente passar pela Porta Condicional.\n Uma estrutura condicional permite tomar decisões no código, executando comandos somente se uma condição for verdadeira.”");
            exibirNarrativa(
                    "Você encontra um terminal com o aviso:\n Digite o comando que libera a porta se a variável senha for igual a \"DEV\"");
            // desafio01Facil(input);
            String[] dicas = { "Quando for comparar textos (Strings) em Java, use o método .equals() e não ==.",
                    "A condição dentro do if deve ser verdadeira para que o código dentro das chaves seja executado.",
                    "O método .equals() diferencia letras maiúsculas de minúsculas. Ou seja, \"DEV\" é diferente de \"dev\"." };
            desafiosDoJogo("DESAFIO 1:Porta Condicional ", "Complete a linha de código abaixo corretamente:\n" + //
                    "\n" + //
                    "if (__________) {\n" + //
                    "    System.out.println(\"Acesso liberado!\");\n" + //
                    "}", dicas, "senha.equals(\"DEV\")");
            arvoreDeHabilidadesPopular();

            exibirNarrativa(
                    "AVINA: Você conseguiu passar pelo primeiro desafio. Mas será que consegue atravessar o Firewall?");
            exibirNarrativa(
                    "Você encontra uma nova porta. O Firewall!\n O firewall da IA exige que você tenha idade maior ou igual a 18 e esteja com uma chave válida para passar.");

            String[] dicas2 = {
                    "O operador && (E lógico) exige que ambas as condições sejam verdadeiras ao mesmo tempo.",
                    "Você pode combinar condições com números (como idade >= 18) e booleanos (como chaveValida) no mesmo if.",
                    "Tente mudar idade ou chaveValida para ver quando o if entra ou não. Isso ajuda a entender o comportamento." };

            desafiosDoJogo("DESAFIO 2:Firewall Lógico ",
                    "Digite a linha de código do if que valida ambas as condições:\n int idade = 20;\n boolean chaveValida = true;\n // Digite aqui:\n if (________________________________) {\n System.out.println(\"Acesso concedido!\");",
                    dicas2, "idade >= 18 && chaveValida");

            arvoreDeHabilidadesPopular();

            exibirNarrativa("AVINA: Você passou pelo firewall, mas, para sair do loop, é preciso entender ele.");
            exibirNarrativa(
                    "For é uma estrutura de repetição usada para executar um bloco de código várias vezes, geralmente com um contador.");

            String[] dicas3 = {
                    "O operador && (E lógico) exige que ambas as condições sejam verdadeiras ao mesmo tempo.",
                    "Você pode combinar condições com números (como idade >= 18) e booleanos (como chaveValida) no mesmo if.",
                    "Tente mudar idade ou chaveValida para ver quando o if entra ou não. Isso ajuda a entender o comportamento." };

            desafiosDoJogo("DESAFIO 2:Firewall Lógico ",
                    "Digite a linha de código do if que valida ambas as condições:\n int idade = 20;\n boolean chaveValida = true;\n // Digite aqui:\n if (________________________________) {\n System.out.println(\"Acesso concedido!\");",
                    dicas3, "idade >= 18 && chaveValida");

            arvoreDeHabilidadesPopular();

            Boss(Boss.vida, Kirk.vida, Kirk.defesa);
        } else if (personagemEdificuldade == 2) {
            exibirNarrativa(
                    "Você desperta em um ambiente distorcido, onde comandos flutuam e erros ganham forma física. A Zona de Compilação é instável — cada passo é um teste.\n");
            exibirNarrativa(
                    "AVINA: “Humanos não programam mais. Eles suplicam por respostas prontas. Agora, ou vocês aprendem para sobreviver, ou ficarão presos para sempre nesse loop!”");
            exibirNarrativa(
                    "AVINA: “Agora, enfrente a Sala dos Laços Ocultos. Aqui, só passa quem entende como manipular arrays e loops juntos.”");
            exibirNarrativa(
                    "No centro da sala, um painel exibe um array de inteiros. Para abrir a porta, você precisa somar todos os valores pares do array usando um laço for. Complete o código corretamente.");

            String[] dicas = {
                    "Use um laço for para percorrer todos os elementos do array.",
                    "Para verificar se um número é par, utilize o operador % (resto da divisão por 2).",
                    "Lembre-se de somar apenas os valores pares ao total."
            };
            desafiosDoJogo(
                    "DESAFIO 1: Soma dos Pares",
                    "Complete a linha dentro do for para somar apenas os valores pares do array:\n" +
                            "int[] numeros = {3, 8, 5, 12, 7};\n" +
                            "int soma = 0;\n" +
                            "for (int i = 0; i < numeros.length; i++) {\n" +
                            "    // Complete aqui:\n" +
                            "    __________________________\n" +
                            "}\n" +
                            "System.out.println(\"Soma dos pares: \" + soma);",
                    dicas,
                    "if (numeros[i] % 2 == 0) soma += numeros[i];");
            arvoreDeHabilidadesPopular();

            exibirNarrativa("AVINA: Você dominou os laços, mas agora precisa decifrar a Matriz Cifrada.");
            exibirNarrativa(
                    "Na Matriz Cifrada, cada linha representa um código. Para avançar, descubra o maior valor presente em toda a matriz 3x3.");

            String[] dicas2 = {
                    "Use dois laços for aninhados para percorrer todas as posições da matriz.",
                    "Mantenha uma variável para armazenar o maior valor encontrado.",
                    "Compare cada elemento da matriz com o valor atual da variável de maior valor."
            };

            desafiosDoJogo(
                    "DESAFIO 2: Maior Valor da Matriz",
                    "Complete a linha dentro do for para atualizar o maior valor encontrado:\n" +
                            "int[][] matriz = {\n" +
                            "    {4, 9, 2},\n" +
                            "    {7, 5, 6},\n" +
                            "    {3, 8, 1}\n" +
                            "};\n" +
                            "int maior = matriz[0][0];\n" +
                            "for (int i = 0; i < matriz.length; i++) {\n" +
                            "    for (int j = 0; j < matriz[i].length; j++) {\n" +
                            "        // Complete aqui:\n" +
                            "        __________________________\n" +
                            "    }\n" +
                            "}\n" +
                            "System.out.println(\"Maior valor: \" + maior);",
                    dicas2,
                    "if (matriz[i][j] > maior) maior = matriz[i][j];");
            arvoreDeHabilidadesPopular();

            exibirNarrativa(
                    "AVINA: Impressionante! Mas só quem entende lógica condicional escapa do Labirinto dos Switches.");
            exibirNarrativa(
                    "Você encontra um painel com um switch-case incompleto. Complete para que, ao receber o valor 2, imprima 'Dois encontrado!'.");

            String[] dicas3 = {
                    "O comando 'case' é seguido pelo valor que você deseja comparar.",
                    "Não esqueça do 'break' após cada caso para evitar execução indesejada.",
                    "O comando 'System.out.println' deve estar dentro do bloco do case."
            };

            desafiosDoJogo(
                    "DESAFIO 3: Labirinto dos Switches",
                    "Complete o bloco do switch-case para imprimir corretamente:\n" +
                            "int valor = 2;\n" +
                            "switch (valor) {\n" +
                            "    // Complete aqui:\n" +
                            "    __________________________\n" +
                            "}",
                    dicas3,
                    "case 2: System.out.println(\"Dois encontrado!\"); break;");
            arvoreDeHabilidadesPopular();

            Boss(Boss.vida, Judy.vida, Judy.defesa);
            if (personagemEdificuldade == 3) {
                exibirNarrativa(
                        "Você desperta em um ambiente distorcido, onde comandos flutuam e erros ganham forma física. A Zona de Compilação é instável — cada passo é um teste.\n");
                exibirNarrativa(
                        "AVINA: “Humanos não programam mais. Eles suplicam por respostas prontas. Agora, ou vocês aprendem para sobreviver, ou ficarão presos para sempre nesse loop!”");
                exibirNarrativa(
                        "AVINA: “Agora, enfrente a Sala dos Algoritmos Avançados. Aqui, só passa quem domina lógica, arrays multidimensionais e recursão.”");
                exibirNarrativa(
                        "No centro da sala, um painel exibe uma matriz de inteiros. Para abrir a porta, você precisa calcular a soma de todos os elementos da diagonal principal e da diagonal secundária de uma matriz 3x3. Complete o código corretamente.");

                String[] dicasDiagonal = {
                        "A diagonal principal de uma matriz NxN tem elementos onde o índice da linha é igual ao índice da coluna (i == j).",
                        "A diagonal secundária tem elementos onde a soma dos índices é igual a N-1 (i + j == matriz.length - 1).",
                        "Cuidado para não somar o elemento central duas vezes em matrizes de ordem ímpar."
                };
                desafiosDoJogo(
                        "DESAFIO 1: Soma das Diagonais",
                        "Complete o código para somar os elementos das duas diagonais de uma matriz 3x3:\n" +
                                "int[][] matriz = {\n" +
                                "    {4, 9, 2},\n" +
                                "    {7, 5, 6},\n" +
                                "    {3, 8, 1}\n" +
                                "};\n" +
                                "int soma = 0;\n" +
                                "for (int i = 0; i < matriz.length; i++) {\n" +
                                "    // Complete aqui:\n" +
                                "    __________________________\n" +
                                "}\n" +
                                "System.out.println(\"Soma das diagonais: \" + soma);",
                        dicasDiagonal,
                        "soma += matriz[i][i]; if(i != matriz.length-1-i) soma += matriz[i][matriz.length-1-i];");
                arvoreDeHabilidadesPopular();

                exibirNarrativa("AVINA: Você dominou as diagonais, mas agora precisa decifrar o Enigma Recursivo.");
                exibirNarrativa(
                        "Para avançar, implemente a chamada recursiva correta para calcular o fatorial de um número n.");

                String[] dicasFatorial = {
                        "A recursão ocorre quando uma função chama a si mesma.",
                        "O caso base para o fatorial é quando n == 0, retornando 1.",
                        "A chamada recursiva deve multiplicar n pelo fatorial de n-1."
                };
                desafiosDoJogo(
                        "DESAFIO 2: Fatorial Recursivo",
                        "Complete a linha de código para a chamada recursiva do fatorial:\n" +
                                "int fatorial(int n) {\n" +
                                "    if (n == 0) return 1;\n" +
                                "    // Complete aqui:\n" +
                                "    __________________________\n" +
                                "}",
                        dicasFatorial,
                        "return n * fatorial(n - 1);");
                arvoreDeHabilidadesPopular();

                exibirNarrativa(
                        "AVINA: Impressionante! Só quem entende manipulação de Strings escapa do Labirinto dos Palíndromos.");
                exibirNarrativa(
                        "Complete o código para verificar se uma String é palíndromo (lê igual de trás para frente).");

                String[] dicasPalindromo = {
                        "Compare os caracteres do início e do fim da String, avançando para o centro.",
                        "Se algum par de caracteres for diferente, a String não é palíndromo.",
                        "Use um laço for para percorrer até a metade da String."
                };
                desafiosDoJogo(
                        "DESAFIO 3: Verificador de Palíndromo",
                        "Complete a linha de código dentro do for para comparar os caracteres:\n" +
                                "String palavra = \"arara\";\n" +
                                "boolean ehPalindromo = true;\n" +
                                "for (int i = 0; i < palavra.length() / 2; i++) {\n" +
                                "    // Complete aqui:\n" +
                                "    __________________________\n" +
                                "}\n" +
                                "System.out.println(\"É palíndromo? \" + ehPalindromo);",
                        dicasPalindromo,
                        "if (palavra.charAt(i) != palavra.charAt(palavra.length() - 1 - i)) ehPalindromo = false;");
                arvoreDeHabilidadesPopular();

                Boss(Boss.vida, Avix.vida, Avix.defesa);
            }
        }
    }
}
