import java.util.*;

public class devoured {
    static int personagemEdificuldade = 0;
    // 1 = Fácil
    // 2 = Médio
    // 3 = Difícil

    // NECESSÁRIO CRIAÇÃO DE STATUS PARA OS PERSONAGENS.

    public class Kirk {

        String nome = "Kirk";
        static float defesa = 0; // defesa 1 = baixa
        static int vida = 120;
    }

    public class Judy {

        String nome = "Judy";
        static float defesa = 0.25f; // defesa 2 = média
        static int vida = 100;
    }

    public class Avix {

        String nome = "Avix";
        static float defesa = 0.50f; // defesa 3 = alta
        static int vida = 80;
    }

    public class Boss01 {
        static int vida = 100;
    }

    static String nome = "";
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    static int pontos = 0;

    static String[] habilidades = new String[3];
    static boolean[] habilidadesUsadas = new boolean[3];
    static int vida = 100;

    public static String registroPlayer() {
        System.out.println("Bem-vindo(a) ao Devoured, digite seu nome: ");
        input.nextLine();
        nome = input.nextLine();
        return nome;
    }

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

    public static void exibirNarrativa(String texto) {
        System.out.println();
        System.out.println(">>> " + texto);
        System.out.println();
    }

    // public static int desafio01Facil(Scanner input) {

    // System.out.println("DESAFIO 1:Porta Condiciona");
    // System.out.println(
    // "Você encontra um terminal com o aviso: \n “Digite o comando que libera a
    // porta se a variável senha for igual a \"DEV\".”");
    // System.out.println("Dica: use equals para comparar Strings!");
    // System.out.println("Complete a linha de código abaixo corretamente:");
    // System.out.println("if (__________) {\n" + //
    // " System.out.println(\"Acesso liberado!\");\n" + //
    // "}\n" + //
    // "");

    // input.nextLine();
    // String resposta = input.nextLine().trim();

    // if (resposta.equals("senha.equals(\"DEV\")")) {
    // System.out.println("Parábens você acertou e abriu a porta!");
    // pontos++;
    // System.out.println("Agora você tem pontos: " + pontos);
    // } else {
    // System.out.println("Resposta errada a porta permanece trancada.");
    // System.out.println("1 - Tentar novamente (Você tem x tentativas)");
    // System.out.println("2 - Pedir uma dica (Você tem X dicas)");
    // }

    // return pontos;
    // }
    // adicionar respostas em um array

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

    public static String[] arvoreDeHabilidadesPopular() {
        int habilidade = 0;
        System.out.println("Bem-vindo a loja de habilidades");
        System.out
                .println("Luz de decisão - 1 ponto (descrição da habilidade) - Digite 1 para escolher essa habilidade");
        System.out.println("Qual habilidade você deseja? ");
        habilidade = input.nextInt();
        if (pontos == 1 && habilidade == 1) {
            System.out.println("Parábens você acaba de adquirir uma nova habilidade chamada Luz de decisão");
            habilidades[0] = "Luz de decisão";
            habilidades[1] = "teste diminuir vida do boss";
        }

        return habilidades;
    }

    // criar função futura que vai atribuir status aos personagens

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
                                                                    // ao tipo de boss que essa habilidade pertence
                            break;
                        default:
                            break;
                    }

                    habilidadesUsadas[i] = true;
                }
            }
        }
    }

    public static void BossKirk(int vidaBoss, int vidaPersonagem, float defesaPersonagem) {

        exibirNarrativa("Ola Kirk bem vindo a primeira batalha");

        while (vidaBoss > 0 && vidaPersonagem > 0) {
            int escolha = random.nextInt(6) + 1;
            if (escolha == 1) {
                int[] resultado = perguntasAlternativas(vidaBoss, vidaPersonagem, defesaPersonagem, "TESTE ENUNCIADO 1",
                        new String[] { "teste 1 op", "teste2", "teste4", "teste5" }, "r");
                vidaBoss = resultado[0];
                vidaPersonagem = resultado[1];
            } else if (escolha == 2) {
                int[] resultado = perguntasAlternativas(vidaBoss, vidaPersonagem, defesaPersonagem, "TESTE ENUNCIADO 2",
                        new String[] { "teste 1 op", "teste2", "teste4", "teste5" }, "r");
                        vidaBoss = resultado[0];
                        vidaPersonagem = resultado[1];
                
            } else if (escolha == 3) {
                int[] resultado =  perguntasCompletarCodigo(vidaBoss, vidaPersonagem, defesaPersonagem, "teste 3", "teste 3", "r");
                vidaBoss = resultado[0];
                vidaPersonagem = resultado[1];
            } else if (escolha == 4) {
                int[] resultado =  perguntasCompletarCodigo(vidaBoss, vidaPersonagem, defesaPersonagem, "teste 3", "teste 3", "r");
                vidaBoss = resultado[0];
                vidaPersonagem = resultado[1];
            } else if (escolha == 5) {
                int[] resultado = perguntasEscreverCodigo(vidaBoss, vidaPersonagem, defesaPersonagem, "teste4", "r");
                vidaBoss = resultado[0];
                vidaPersonagem = resultado[1];
            } else {
                int[] resultado = perguntasEscreverCodigo(vidaBoss, vidaPersonagem, defesaPersonagem, "teste4", "r");
                vidaBoss = resultado[0];
                vidaPersonagem = resultado[1];
            }
            if (Boss01.vida < 0) {
                System.out.println("Voce venceu");
            }
        }
        if (Kirk.vida < 0) {
            System.out.println("voce perdeu");
        }

    }

    public static int[] perguntasAlternativas(int vidaBoss, int vidaPersonagem, float defesa, String enunciado,
            String[] opcoes, String respostaCorreta) {
        System.out.println(enunciado);
        System.out.println(opcoes[0]);
        System.out.println(opcoes[1]);
        System.out.println(opcoes[2]);
        System.out.println(opcoes[3]);
        input.nextLine();
        String resposta = input.nextLine();

        if (resposta.equals(respostaCorreta)) {
            vidaBoss -= 15; // mudar status do boss
            System.out.printf("STATUS: vida personagem: %d vida boss %d \n", vidaPersonagem, vidaBoss); // melhorar
                                                                                                        // texto
        } else {
            vidaPersonagem -= 10;
            System.out.printf("RESPOSTA INCORRETA VOCE PERDEU VIDA E AGORA TEM %d D VIDA \n", vidaPersonagem);
        }

        return new int[] { vidaBoss, vidaPersonagem };

    }

    public static int[] perguntasCompletarCodigo(int vidaBoss, int vidaPersonagem, float defesa, String enunciado,
            String problema, String respostaCorreta) {

        System.out.println(enunciado);
        System.out.println(problema);
        input.nextLine();
        String resposta = input.nextLine();
        if (resposta.equals(respostaCorreta)) {
            vidaBoss -= 15; // mudar status do boss
            System.out.printf("STATUS: vida personagem: %d vida boss %d \n", vidaPersonagem, vidaBoss); // melhorar
                                                                                                        // texto
        } else {
            vidaPersonagem -= 10;
            System.out.printf("RESPOSTA INCORRETA VOCE PERDEU VIDA E AGORA TEM %d D VIDA \n", vidaPersonagem);
        }

        return new int[] { vidaBoss, vidaPersonagem };
    }

    public static int[] perguntasEscreverCodigo(int vidaBoss, int vidaPersonagem, float defesa, String enunciado,
            String respostaCorreta) {

        System.out.println(enunciado);
        input.nextLine();
        String resposta = input.nextLine();
        if (resposta.equals(respostaCorreta)) {
            vidaBoss -= 15; // mudar status do boss
            System.out.printf("STATUS: vida personagem: %d vida boss %d \n", vidaPersonagem, vidaBoss); // melhorar
                                                                                                        // texto
        } else {
            vidaPersonagem -= 10;
            System.out.printf("RESPOSTA INCORRETA VOCE PERDEU VIDA E AGORA TEM %d D VIDA \n", vidaPersonagem);
        }

        return new int[] { vidaBoss, vidaPersonagem };
    }

    // public static void batalhaTesteBoss(int vidaPersonagem, int defesaPersonagem,
    // String nomePersonagem) {

    // boolean venceu = false;

    // exibirNarrativa("Bem vindo a batalha com o boss BLABLABLA"); // adicionar
    // dialogos reais aqui

    // while (vidaJogador[0] > 0 && !venceu) {
    // usarHabilidades(vidaBoss);

    // System.out.println("Qual estrutura de controle permite repetir o código até
    // algo"); // adicionar problema
    // // real
    // System.out.println("A");
    // System.out.println("B");
    // System.out.println("C");

    // System.out.println("Digite a resposta correta: ");
    // input.nextLine();
    // String resposta = input.nextLine().trim().toUpperCase();

    // if (resposta.equals("C")) {
    // System.out.println("Parabens resposta correta");

    // vidaBoss[0] -= 15;
    // System.out.printf("STATUS: vida personagem: %d vida boss %d \n",
    // vidaJogador[0], vidaBoss[0]);

    // } else {
    // vidaJogador[0]--;
    // System.out.printf("RESPOSTA INCORRETA VOCE PERDEU VIDA E AGORA TEM %d de vida
    // \n", vidaJogador[0]);
    // }

    // if (vidaBoss[0] <= 0) {
    // venceu = true;
    // System.out.println("Você derrotou o BOSS");
    // }

    // }

    // if (!venceu) {
    // System.out.println("Você foi derrotado");
    // }
    // }

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
            BossKirk(Boss01.vida, Kirk.vida, Kirk.defesa);
        } else if (personagemEdificuldade == 2) {

        }
    }
}
