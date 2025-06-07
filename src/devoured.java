
import java.util.*;

public class devoured {
    static int personagemEdificuldade = 0;

    /**
     * Classe representando o personagem Kirk (nível fácil).
     */
    public class Kirk {
        static float defesa = 0;
        static int vida = 120;
    }

    /**
     * Classe representando a personagem Judy (nível médio).
     */
    public class Judy {
        static float defesa = 0.25f;
        static int vida = 100;
    }

    /**
     * Classe representando o personagem Avix (nível difícil).
     */
    public class Avix {
        static float defesa = 0.50f;
        static int vida = 80;
    }

    /**
     * Classe representando o Boss final do jogo.
     */
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
        "Ataque Aprimorado - Aumenta o dano causado ao boss",
        "Defesa Reforçada - Reduz o dano recebido do boss",
        "Vida Extra - Ganha uma quantidade adicional de vida",
        "Dano Crítico - Chance de causar dano dobrado",
        "Regeneração - Recupera vida a cada rodada",
        "Escudo Temporário - Anula o próximo ataque do boss"
    };



    /**
     * Realiza o registro inicial do jogador, solicitando o nome e retornando o nome informado.
     */
    public static String registroPlayer() {
        System.out.println("Bem-vindo(a) ao Devoured, digite seu nome: ");
        if (input.hasNextLine()) input.nextLine();
        nome = input.nextLine();
        return nome;
    }


    /**
     * Permite ao jogador escolher o personagem e define a dificuldade do jogo. Retorna o código do personagem/dificuldade escolhido.
     */
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


    /**
     * Imprime um resumo da escolha do personagem e informa a dificuldade selecionada.
     */
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


    /**
     * Exibe o menu principal do jogo e gerencia as opções do usuário.
     */
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


    /**
     * Exibe um texto de narrativa formatado com separadores visuais. Recebe o texto da narrativa a ser exibido.
     */
    public static void exibirNarrativa(String texto) {
        System.out.println("\n=================================================");
        System.out.println();
        System.out.println(">>> " + texto);
        System.out.println();
        System.out.println("=================================================\n");
    }


    /**
     * Gerencia desafios menores do jogo, permitindo tentativas, dicas e pontuação. Recebe o título, enunciado, dicas e resposta correta. Retorna a pontuação atualizada após o desafio.
     */
    public static int desafiosDoJogo(String titulo, String enunciado, String[] dicasDaFase, String respostaCorreta) {
        System.out.println("\n====================");
        System.out.println("DESAFIO " + titulo);
        System.out.println();
        System.out.println(enunciado);
        System.out.println("====================\n");

        if (input.hasNextLine()) input.nextLine();
        System.out.print("\nSua resposta: ");
        String resposta = input.nextLine().trim();

        List<String> dicas = new ArrayList<>(Arrays.asList(dicasDaFase));

        while (!resposta.equals(respostaCorreta)) {
            System.out.println("\nResposta errada!");
            System.out.println("1 - Tentar novamente");
            System.out.println("2 - Utilizar uma dica");
            System.out.println("3 - Sair do jogo");
            int escolha = input.nextInt();
            if (escolha == 1) {
                System.out.print("\nDigite novamente sua resposta: ");
                if (input.hasNextLine()) input.nextLine();
                resposta = input.nextLine().trim();
            } else if (escolha == 2) {
                if (!dicas.isEmpty()) {
                    // Escolhe dica aleatória e remove da lista
                    int indice = random.nextInt(dicas.size());

                    String dicaSorteada = dicas.remove(indice);
                    System.out.println("\nDICA: " + dicaSorteada + "\n");
                } else {
                    System.out.println("\nVocê já usou todas as suas dicas!\n");
                }
            } else if (escolha == 3) {
                System.exit(0);
                break;
            }
        }

        System.out.println("\nParabéns, você conseguiu passar por esse desafio!");
        System.out.println("Agora um novo foi desbloqueado. Boa sorte!\n");
        pontos++;
        System.out.println("Você ganhou pontos por completar o desafio.\n Agora você possui: " + pontos);
        return pontos;

    }


    /**
     * Permite ao jogador adquirir habilidades gastando pontos. Retorna o array de habilidades adquiridas.
     */
    public static String[] arvoreDeHabilidadesPopular() {
        System.out.println("\n====================");
        System.out.println("Bem-vindo à loja de habilidades!");
        if (habilidadesDisponiveis.length == 0) {
            System.out.println("Nenhuma habilidade disponível no momento.");
            return habilidades;
        }
        boolean comprou = false;
        while (pontos > 0 && !comprou) {
            System.out.println();
            System.out.println("Você tem " + pontos + " ponto(s) para gastar.");
            System.out.println("Habilidades disponíveis:");
            for (int i = 0; i < habilidadesDisponiveis.length; i++) {
                boolean jaTem = false;
                for (String h : habilidades) {
                    if (h != null && h.equals(habilidadesDisponiveis[i].split(" - ")[0])) {
                        jaTem = true;
                        break;
                    }
                }
                if (!jaTem) {
                    System.out.println((i + 1) + " - " + habilidadesDisponiveis[i]);
                }
            }
            System.out.print("\nDigite o número da habilidade que deseja adquirir (ou 0 para sair): ");
            int escolha = input.nextInt();
            if (escolha == 0) break;
            if (escolha < 1 || escolha > habilidadesDisponiveis.length) {
                System.out.println("\nEscolha inválida.\n");
                continue;
            }
            String nomeHabilidade = habilidadesDisponiveis[escolha - 1].split(" - ")[0];
            boolean jaTem = false;
            for (String h : habilidades) {
                if (h != null && h.equals(nomeHabilidade)) {
                    jaTem = true;
                    break;
                }
            }
            if (jaTem) {
                System.out.println("\nVocê já possui essa habilidade.\n");
                continue;
            }
            for (int i = 0; i < habilidades.length; i++) {
                if (habilidades[i] == null) {
                    habilidades[i] = nomeHabilidade;
                    pontos--;
                    System.out.println("\nParabéns, você adquiriu: " + nomeHabilidade + "\n");
                    comprou = true;
                    break;
                }
            }
        }
        return habilidades;
    }


    /**
     * Permite ao jogador utilizar habilidades adquiridas antes da batalha final. Recebe um array contendo a vida atual do boss.
     */
    public static void usarHabilidades(int[] vidaBoss) {
        for (int i = 0; i < habilidades.length; i++) {
            if (habilidades[i] != null && !habilidadesUsadas[i]) {
                System.out.printf("\nDeseja utilizar %s? Digite 1 para sim e 0 para não: ", habilidades[i]);
                int escolha = input.nextInt();

                if (escolha == 1) {
                    switch (habilidades[i]) {
                        case "teste diminuir vida do boss":
                            int reducao = vidaBoss[0] * 5 / 100;
                            vidaBoss[0] -= reducao;
                            System.out.printf("\nGraças à sua habilidade, a vida do boss foi reduzida em %d para %d.\n", reducao, vidaBoss[0]);
                            break;
                        case "Luz de decisão":
                            System.out.println("\nDICA: (habilidade de dica ativada)\n"); // implementar array com dicas aleatorias referentes
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


    /**
     * Gerencia a batalha final contra o boss, aplicando habilidades e lógica de combate. Recebe a vida inicial do boss, vida inicial do personagem e defesa do personagem.
     */
    public static void Boss(int vidaBoss, int vidaPersonagem, float defesaPersonagem) {
        exibirNarrativa("Ola Kirk, bem-vindo à batalha final!");
        System.out.println("\n====================\n");

        // Flags e bônus das habilidades
        int bonusAtaque = 0;
        float bonusDefesaPersonagem = 0f;
        int vidaExtra = 0;
        boolean danoCritico = false;
        boolean regeneracao = false;
        boolean escudoTemporario = false;
        boolean escudoAtivo = false;

        // Checa habilidades adquiridas
        for (int i = 0; i < habilidades.length; i++) {
            if (habilidades[i] != null) {
                switch (habilidades[i]) {
                    case "Ataque Aprimorado":
                        bonusAtaque += 10;
                        break;
                    case "Defesa Reforçada":
                        bonusDefesaPersonagem += 0.2f;
                        break;
                    case "Vida Extra":
                        vidaExtra += 30;
                        break;
                    case "Dano Crítico":
                        danoCritico = true;
                        break;
                    case "Regeneração":
                        regeneracao = true;
                        break;
                    case "Escudo Temporário":
                        escudoTemporario = true;
                        break;
                }
            }
        }
        vidaPersonagem += vidaExtra;

        String[][] perguntas = {
            { "Qual estrutura de repetição é mais apropriada quando se sabe exatamente o número de vezes que o laço deve ser executado?", "A - while", "B - do while", "C - for", "D - if-else", "C", "alternativa" },
            { "Qual das opções abaixo representa um laço que sempre executa pelo menos uma vez, independentemente da condição?", "A - while", "B - for", "C - do while", "D - Nenhum dos anteriores", "C", "alternativa" },
            { "Qual palavra-chave é usada para sair imediatamente de um laço em Java?", "A - continue", "B - break", "C - exit", "D - stop", "B", "alternativa" },
            { "Qual destas estruturas é usada para tomar decisões em Java?", "A - for", "B - if", "C - while", "D - switch", "B", "alternativa" },
            { "O que o operador '==' compara em Java?", "A - Referência de objetos", "B - Conteúdo de strings", "C - Valores primitivos", "D - Tamanho de arrays", "C", "alternativa" },
            { "Qual destas opções representa um array de inteiros em Java?", "A - int[] numeros", "B - int numeros[]", "C - int numeros", "D - array int[]", "A", "alternativa" },
            { "Como se chama o bloco que captura exceções em Java?", "A - try", "B - catch", "C - throw", "D - finally", "B", "alternativa" },
            { "Qual destas opções declara corretamente uma variável booleana?", "A - boolean ativo = true;", "B - bool ativo = 1;", "C - boolean ativo = 'true';", "D - int ativo = true;", "A", "alternativa" },
            { "Qual método converte uma string para minúsculas em Java?", "A - toLower()", "B - lowerCase()", "C - toLowerCase()", "D - minuscule()", "C", "alternativa" },
            { "Qual destas opções é usada para ler dados do teclado em Java?", "A - Scanner", "B - InputStream", "C - System.in", "D - Reader", "A", "alternativa" },
            { "Qual destas opções representa um laço infinito?", "A - for(;;)", "B - while(true)", "C - do{}while(true)", "D - Todas as anteriores", "D", "alternativa" }
        };

        String[] dicasPerguntas = {
            "Dica: Use quando o número de repetições é conhecido.",
            "Dica: Pense em laços que garantem pelo menos uma execução.",
            "Dica: Palavra-chave que interrompe o laço.",
            "Dica: Estrutura condicional clássica.",
            "Dica: Só funciona para tipos primitivos.",
            "Dica: Arrays em Java usam colchetes.",
            "Dica: O bloco que trata erros vem logo após o try.",
            "Dica: O tipo booleano só aceita true ou false.",
            "Dica: Procure pelo método correto da classe String.",
            "Dica: Classe muito usada para entrada de dados.",
            "Dica: Todas as formas criam laços sem condição de parada explícita."
        };
        // int tentativas = 0; // Não utilizado
        // Embaralha as perguntas para garantir aleatoriedade
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < perguntas.length; i++) indices.add(i);
        Collections.shuffle(indices);


        int maxPerguntas = Math.min(6, perguntas.length);
        float defesaBossEfetiva = Boss.defesa;
        float defesaPersonagemEfetiva = defesaPersonagem + bonusDefesaPersonagem;
        int vidaBossMax = vidaBoss;
        int vidaPersonagemMax = vidaPersonagem;
        int danoBoss = (int) Math.ceil((float)vidaPersonagemMax / maxPerguntas);
        int danoPlayer = (int) Math.ceil((float)vidaBossMax / maxPerguntas) + bonusAtaque + 20;

        int i = 0;
        boolean batalhaFinalizada = false;
        while (i < maxPerguntas && !batalhaFinalizada) {
            int idx = indices.get(i);
            String[] pergunta = perguntas[idx];
            String tipo = pergunta[6];

            // Exibe a dica correspondente
            System.out.println();
            System.out.println("DICA: " + dicasPerguntas[idx]);
            System.out.println();

            int[] resultado = { vidaBoss, vidaPersonagem };

            // --- Dano crítico ---
            int danoPlayerRodada = danoPlayer;
            if (danoCritico && Math.random() < 0.25) { // 25% de chance
                System.out.println();
                System.out.println("DANO CRÍTICO! Você causou dano dobrado ao boss!");
                System.out.println();
                danoPlayerRodada *= 2;
            }

            // --- Pergunta ---
            if (tipo.equals("alternativa")) {
                resultado = devoured.perguntasAlternativasHabilidade(vidaBoss, vidaPersonagem, defesaBossEfetiva, defesaPersonagemEfetiva, pergunta[0],
                        new String[] { pergunta[1], pergunta[2], pergunta[3], pergunta[4] }, pergunta[5], danoBoss, danoPlayerRodada, bonusAtaque);
            } else if (tipo.equals("completar")) {
                resultado = perguntasCompletarCodigo(vidaBoss, vidaPersonagem, defesaBossEfetiva, pergunta[0],
                        pergunta[1],
                        pergunta[5]);
            } else if (tipo.equals("escrever")) {
                resultado = perguntasEscreverCodigo(vidaBoss, vidaPersonagem, defesaBossEfetiva, pergunta[0],
                        pergunta[5]);
            }

            vidaBoss = resultado[0];
            vidaPersonagem = resultado[1];

            // --- Escudo Temporário ---
            if (escudoTemporario && !escudoAtivo) {
                System.out.println();
                System.out.println("ESCUDO TEMPORÁRIO ativado! O próximo ataque do boss será anulado.");
                System.out.println();
                escudoAtivo = true;
                escudoTemporario = false;
            }

            // --- Regeneração ---
            if (regeneracao && vidaPersonagem > 0 && vidaPersonagem < vidaPersonagemMax) {
                int cura = 10;
                vidaPersonagem = Math.min(vidaPersonagem + cura, vidaPersonagemMax);
                System.out.println();
                System.out.println("Regeneração: você recuperou 10 de vida!");
                System.out.println();
            }

            // --- Dano do boss (após resposta errada) ---
            if (vidaBoss > 0 && vidaPersonagem > 0 && resultado[1] < vidaPersonagem) {
                if (escudoAtivo) {
                    System.out.println();
                    System.out.println("O ataque do boss foi ANULADO pelo escudo!");
                    System.out.println();
                    escudoAtivo = false;
                } else {
                    int danoRecebido = (int) Math.ceil(danoBoss * (1 - defesaPersonagemEfetiva));
                    vidaPersonagem -= danoRecebido;
                    System.out.println();
                    System.out.printf("O boss te atacou! Você perdeu %d de vida.\n", danoRecebido);
                    System.out.println();
                }
            }

            if (vidaBoss <= 0) {
                System.out.println();
                System.out.println("============================");
                System.out.println("VOCÊ VENCEU!");
                System.out.println("Você conseguiu vencer o boss, agora está livre para programar no mundo real.");
                System.out.println("Mas, lembre-se, você pode ser devorado novamente!\n");
                System.out.println("============================");
                System.exit(0);
            }
            if (vidaPersonagem <= 0) {
                System.out.println();
                System.out.println("============================");
                System.out.println("VOCÊ PERDEU!");
                System.out.println("O boss te derrotou. Tente novamente para escapar desse loop!");
                System.out.println("============================");
                System.exit(0);
            }
            i++;
        }
    }


    /**
     * Realiza perguntas de múltipla escolha durante a batalha, considerando habilidades. Recebe vida e defesa do boss e personagem, enunciado, opções, resposta correta, dano do boss, dano do personagem e bônus de ataque. Retorna array com vida atualizada do boss e do personagem.
     */
    public static int[] perguntasAlternativasHabilidade(int vidaBoss, int vidaPersonagem, float defesaBoss, float defesaPersonagem, String enunciado,
            String[] opcoes, String respostaCorreta, int danoBoss, int danoPlayer, int bonusAtaque) {
        System.out.println();
        System.out.println(enunciado);
        for (String opcao : opcoes) {
            System.out.println(opcao);
        }
        System.out.println();
        if (input.hasNextLine()) input.nextLine();
        System.out.print("Sua resposta: ");
        String resposta = input.nextLine();

        if (resposta.equals(respostaCorreta)) {
            int dano = (int) Math.ceil((danoBoss + bonusAtaque) * (1 - defesaBoss) + 15);
            vidaBoss -= dano;
            System.out.println();
            System.out.printf("Acertou! Você causou %d de dano ao boss!\n", dano);
            System.out.println();
        } else {
            int dano = (int) Math.ceil(danoPlayer * (1 - defesaPersonagem)) + 10;
            vidaPersonagem -= dano;
            System.out.println();
            System.out.printf("RESPOSTA INCORRETA! O boss te atacou e você perdeu %d de vida!\n", dano);
            System.out.println();
        }
        return new int[] { vidaBoss, vidaPersonagem };
    }


    /**
     * Realiza perguntas do tipo completar código durante a batalha. Recebe vida do boss, vida do personagem, defesa, enunciado, problema e resposta correta. Retorna array com vida atualizada do boss e do personagem.
     */
    public static int[] perguntasCompletarCodigo(int vidaBoss, int vidaPersonagem, float defesa, String enunciado,
            String problema, String respostaCorreta) {

        System.out.println(enunciado);
        System.out.println(problema);
        System.out.println();
        if (input.hasNextLine()) input.nextLine();
        String resposta = input.nextLine();
        if (resposta.equals(respostaCorreta)) {
            int dano = (int) Math.ceil(17 * (1 - devoured.Boss.defesa));
            vidaBoss -= dano;
            System.out.printf("STATUS: vida personagem: %d vida boss %d \n", vidaPersonagem, vidaBoss);
        } else {
            int dano = (int) (10 * (1 - devoured.Kirk.defesa));
            vidaPersonagem -= dano;
            System.out.printf("RESPOSTA INCORRETA VOCE PERDEU VIDA E AGORA TEM %d D VIDA \n", vidaPersonagem);
        }

        return new int[] { vidaBoss, vidaPersonagem };
    }


    /**
     * Realiza perguntas do tipo escrever código durante a batalha. Recebe vida do boss, vida do personagem, defesa, enunciado e resposta correta. Retorna array com vida atualizada do boss e do personagem.
     */
    public static int[] perguntasEscreverCodigo(int vidaBoss, int vidaPersonagem, float defesa, String enunciado,
            String respostaCorreta) {

        System.out.println();
        System.out.println(enunciado);
        System.out.println();
        if (input.hasNextLine()) input.nextLine();
        System.out.print("Sua resposta: ");
        String resposta = input.nextLine();
        if (resposta.equals(respostaCorreta)) {
            int dano = (int) Math.ceil(17 * (1 - Boss.defesa));
            vidaBoss -= dano;
            System.out.println();
            System.out.printf("STATUS: vida personagem: %d | vida boss: %d\n", vidaPersonagem, vidaBoss);
            System.out.println();
        } else {
            int dano = (int) (10 * (1 - Kirk.defesa));
            vidaPersonagem -= dano;
            System.out.println();
            System.out.printf("RESPOSTA INCORRETA! Você perdeu vida e agora tem %d de vida.\n", vidaPersonagem);
            System.out.println();
        }

        return new int[] { vidaBoss, vidaPersonagem };
    }

    /**
     * Função principal do jogo, gerencia a narrativa, desafios e fluxo geral.
     */
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
                    "Digite a linha de código do if que valida ambas as condições:\n int idade = 20;\n boolean chaveValida = true;\n // Digite aqui:\n if (________________________________) \n System.out.println(\"Acesso concedido!\");",
                    dicas2, "idade >= 18 && chaveValida");

                    arvoreDeHabilidadesPopular();
        
                    exibirNarrativa("AVINA: Você passou pelo firewall, mas, para sair do loop, é preciso entender ele.");
                    exibirNarrativa(
                            "For é uma estrutura de repetição usada para executar um bloco de código várias vezes, geralmente com um contador.");
        

        
                    // ...duplicata removida...

                    // NOVOS DESAFIOS
                    exibirNarrativa("AVINA: Você escapou do firewall, mas agora está preso em um ciclo misterioso! Só quem entende como controlar repetições conseguirá avançar. Complete o laço corretamente para seguir em frente.");


                    desafiosDoJogo("DESAFIO 3: Laço Misterioso",
                        "Complete o for para imprimir os números de 1 a 5:\n// Digite aqui:\nfor (________________) {\n    System.out.println(i);\n}",
                        new String[]{"Dica: O laço deve começar em 1.", "Dica: O laço deve terminar em 5."}, "int i = 1; i <= 5; i++");

                    // Após cada desafio, ganha ponto e pode comprar habilidade
                    pontos++;
                    arvoreDeHabilidadesPopular();

                    // Transição para a batalha final
                    exibirNarrativa("AVINA: Você avançou pelos desafios, mas agora enfrentará o Boss! Use suas habilidades com sabedoria antes do combate.");

                    // Permite o uso das habilidades adquiridas antes da batalha
                    int[] vidaBoss = { Boss.vida };
                    usarHabilidades(vidaBoss);

                    // Inicia a batalha final com o boss
                    Boss(vidaBoss[0], Kirk.vida, Kirk.defesa);
            } else if(personagemEdificuldade == 2){
                System.out.println("Teste personagem 2");
            }
        


            }
}
