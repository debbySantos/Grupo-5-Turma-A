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
    static String[] habilidadesDisponiveis = {"Luz de decisão - Habilidade de iluminar o caminho e revelar segredos ocultos",
            "Escudo de Erro Leve - Reduz o impacto de erros leves",
            "Contra-Ataque - Responde a ataques inimigos com um ataque poderoso"};
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
                "Bem-vindo ao Devoured %s, escolha seu personagem para seguir na história, lembrando que está escolha afeta a dificuldade dentro do jogo \n",
                nome);

        System.out.println(
                "1 - KIRK O Criativo Iniciante (Fácil) \n Curioso e impulsivo. Comete erros, mas aprende rápido \n Dicas visuais, erros leves, bosses previsíveis. \n");

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
                    System.out.println("Função sendo implementada"); // Inserir aqui as instruções do jogo
                    break;
                case 2:
                    System.out.println("Entrando no jogo...");
                    jogar();
                    break;
                case 3:
                    System.out.println("Função sendo implementada"); // Inserir aqui os créditos do jogo
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

        if(habilidadesDisponiveis.length == 0) {
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
        //     System.out.println("Parábens você acaba de adquirir uma nova habilidade chamada Luz de decisão");
        //     habilidades[0] = "Luz de decisão";
        //     pontos--;
        // } else if (pontos >= 1 && habilidade == 2 && habilidades[1] == null) {
        //     System.out.println("Parábens você acaba de adquirir uma nova habilidade chamada Escudo de Erro Leve");
        //     habilidades[0] = "Escudo de Erro Leve";
        //     pontos--;
        // }
        // System.out.println("Bem-vindo a loja de habilidades");
        // System.out.println(
        //         "Detector de Verdade: - 1 ponto (Indica se uma condição é verdadeira ou falsa.) - Digite 1 para escolher essa habilidade");
        // System.out.println(
        //         "Função Fantasma: - 1 ponto (Pode usar um modelo de função pré-criado como referência uma vez) - Digite 2 para escolher essa habilidade");
        // System.out.println("Qual habilidade você deseja? ");
        // habilidade = input.nextInt();
        // if (pontos >= 1 && habilidade == 1 && habilidades[0] == null) {
        //     System.out.println("Parábens você acaba de adquirir uma nova habilidade chamada Detector de Verdade");
        //     habilidades[0] = "Detector de Verdade";
        //     pontos--;
        // } else if (pontos >= 1 && habilidade == 2 && habilidades[1] == null) {
        //     System.out.println("Parábens você acaba de adquirir uma nova habilidade chamada Função Fantasma");
        //     habilidades[0] = "Função Fantasma";
        //     pontos--;

        // }
        // ******************************************************************************************
        // System.out.println("Bem-vindo a loja de habilidades");
        // System.out.println(
        //         "Contador Amigável: : - 1 ponto (Mostra na tela quantas vezes o laço será executado antes de começar) - Digite 1 para escolher essa habilidade");
        // System.out.println(
        //         "Guia de Vetor: - 1 ponto (Mostra visualmente onde o índice está acessando na matriz ou vetor.) - Digite 2 para escolher essa habilidade");
        // System.out.println("Qual habilidade você deseja? ");
        // habilidade = input.nextInt();
        // if (pontos >= 1 && habilidade == 1 && habilidades[0] == null) {
        //     System.out.println("Parábens você acaba de adquirir uma nova habilidade chamada Contador Amigável");
        //     habilidades[0] = "Contador Amigável";
        //     pontos--;
        // } else if (pontos >= 1 && habilidade == 2 && habilidades[1] == null) {
        //     System.out.println("Parábens você acaba de adquirir uma nova habilidade chamada Guia de Vetor");
        //     habilidades[0] = "Guia de Vetor";
        //     pontos--;

        // }
        // ******************************************************************************************
        // System.out.println("Bem-vindo a loja de habilidades");
        // System.out.println(
        //         "Contador Amigável: : - 1 ponto (Mostra na tela quantas vezes o laço será executado antes de começar) - Digite 1 para escolher essa habilidade");
        // System.out.println(
        //         "Guia de Vetor: - 1 ponto (Mostra visualmente onde o índice está acessando na matriz ou vetor.) - Digite 2 para escolher essa habilidade");
        // System.out.println("Qual habilidade você deseja? ");
        // habilidade = input.nextInt();
        // if (pontos >= 1 && habilidade == 1 && habilidades[0] == null) {
        //     System.out.println("Parábens você acaba de adquirir uma nova habilidade chamada Contador Amigável");
        //     habilidades[0] = "Contador Amigável";
        //     pontos--;
        // } else if (pontos >= 1 && habilidade == 2 && habilidades[1] == null) {
        //     System.out.println("Parábens você acaba de adquirir uma nova habilidade chamada Guia de Vetor");
        //     habilidades[0] = "Guia de Vetor";
        //     pontos--;

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
            int dano = (int) (10 * (1 - Boss.defesa));
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
            int dano = (int) (10 * (1 - Boss.defesa));
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
            int dano = (int) (10 * (1 - Boss.defesa));
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
            exibirNarrativa("Você encontra um terminal com o aviso:\n Digite o comando que libera a porta se a variável senha for igual a \"DEV\"");
            // desafio01Facil(input);
            String[] dicas = { "Quando for comparar textos (Strings) em Java, use o método .equals() e não ==.", "A condição dentro do if deve ser verdadeira para que o código dentro das chaves seja executado.", "O método .equals() diferencia letras maiúsculas de minúsculas. Ou seja, \"DEV\" é diferente de \"dev\"." };
            desafiosDoJogo("DESAFIO 1:Porta Condicional ", "Complete a linha de código abaixo corretamente:\n" + //
                                "\n" + //
                                "if (__________) {\n" + //
                                "    System.out.println(\"Acesso liberado!\");\n" + //
                                "}", dicas, "senha.equals(\"DEV\")");
            arvoreDeHabilidadesPopular();

            exibirNarrativa("AVINA: Você conseguiu passar pelo primeiro desafio. Mas será que consegue atravessar o Firewall?");
            exibirNarrativa("Você encontra uma nova porta. O Firewall!\n O firewall da IA exige que você tenha idade maior ou igual a 18 e esteja com uma chave válida para passar.");
           
            String[] dicas2 = { "O operador && (E lógico) exige que ambas as condições sejam verdadeiras ao mesmo tempo.", "Você pode combinar condições com números (como idade >= 18) e booleanos (como chaveValida) no mesmo if.", "Tente mudar idade ou chaveValida para ver quando o if entra ou não. Isso ajuda a entender o comportamento." };

            desafiosDoJogo("DESAFIO 2:Firewall Lógico ",
             "Digite a linha de código do if que valida ambas as condições:\n int idade = 20;\n boolean chaveValida = true;\n // Digite aqui:\n if (________________________________) {\n System.out.println(\"Acesso concedido!\");",
            dicas2, "idade >= 18 && chaveValida");
            
            arvoreDeHabilidadesPopular();

            exibirNarrativa("AVINA: Você passou pelo firewall, mas, para sair do loop, é preciso entender ele.");
            exibirNarrativa("For é uma estrutura de repetição usada para executar um bloco de código várias vezes, geralmente com um contador.");
           
            String[] dicas3 = { "O operador && (E lógico) exige que ambas as condições sejam verdadeiras ao mesmo tempo.", "Você pode combinar condições com números (como idade >= 18) e booleanos (como chaveValida) no mesmo if.", "Tente mudar idade ou chaveValida para ver quando o if entra ou não. Isso ajuda a entender o comportamento." };

            desafiosDoJogo("DESAFIO 2:Firewall Lógico ",
             "Digite a linha de código do if que valida ambas as condições:\n int idade = 20;\n boolean chaveValida = true;\n // Digite aqui:\n if (________________________________) {\n System.out.println(\"Acesso concedido!\");",
            dicas3, "idade >= 18 && chaveValida");
            
            arvoreDeHabilidadesPopular();


            Boss(Boss.vida, Kirk.vida, Kirk.defesa);
        } else if (personagemEdificuldade == 2) {
            // ADICIONAR A HISTÓRIA DA JUDY E CRIAR MAIS UM ELSE IF PRO AVIX
        }
    }
}
