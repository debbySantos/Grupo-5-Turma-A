import java.util.*;

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

        System.out.println("Acertou eba");
        pontos++;
        System.out.println("Pontos: " + pontos);
        return pontos;

    }


    //HABILIDADES DO JOGO
    public static String[] arvoreDeHabilidadesPopular() {
        int habilidade = 0;
        System.out.println("Bem-vindo a loja de habilidades");
        System.out.println("Luz de decisão - 1 ponto (descrição da habilidade) - Digite 1 para escolher essa habilidade");
        System.out.println("Qual habilidade você deseja? ");
        habilidade = input.nextInt();
        if (pontos == 1 && habilidade == 1) {
            System.out.println("Parábens você acaba de adquirir uma nova habilidade chamada Luz de decisão");
            habilidades[0] = "Luz de decisão";
            habilidades[1] = "teste diminuir vida do boss"; // REMOVER ESSA LINHA, É APENAS UM TESTE
        }

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
                                                                    // ao tipo de boss que essa habilidade pertence ou remover essa habilidade, ela é apenas um exemplo
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
    // O PERSONAGEM DEVE GANHAR OU PERDER EM ATÉ 6 TENTATIVAS, ESCOLHER UM BOM VALOR DE DANO PARA QUE ELE CONSIGA NÃO FICAR PRESO NA BATALHA PRA SEMPRE
    // COLOCAR VALORES QUE TORNEM POSSÍVEL AINDA SIM GANHAR OU PERDER EM 6 TENTATIVAS NOS SETS DE DEFESA E VIDA DAS HABILIDADES
    public static void Boss(int vidaBoss, int vidaPersonagem, float defesaPersonagem) {

        exibirNarrativa("Ola Kirk bem vindo a primeira batalha");

        String[][] perguntas = { { "Pergunta teste 1", "opcao 1", "opcao 2", "opcao 3", "opcao 4", "C", "alternativa" },
                { "Pergunta teste 2", "escreva", "", "", "", "1", "escrever" },
                { "Complete: int[] numeros = new ____[5];", "", "", "", "", "int", "completar" } }; // INSERIR AQUI AS QUESTÕES, A ÚLTIMA POSIÇÃO É O QUE ELA É E A PENÚLTIMA É A RESPOSTA CORRETA 
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
            int dano = (int) (15 * (1 - Boss.defesa)); // CONTA PARA CALCULAR DANO COM BASE NA DEFESA, LEMBRANDO QUE O VALOR DA DEFESA PODE SER MODIFICADO COM HABILIDADES
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

            // desafio01Facil(input);
            String[] dicas = { "aa", "opooo", "odsp" };
            desafiosDoJogo("rato1", "lolo", dicas, "r");
            arvoreDeHabilidadesPopular();
            Boss(Boss.vida, Kirk.vida, Kirk.defesa);
        } else if (personagemEdificuldade == 2) {
            // ADICIONAR A HISTÓRIA DA JUDY E CRIAR MAIS UM ELSE IF PRO AVIX
        }
    }
}
