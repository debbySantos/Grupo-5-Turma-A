import java.util.*;

public class devoured {
    static int personagemEdificuldade = 0;
    // 1 = Fácil
    // 2 = Médio
    // 3 = Difícil

    // NECESSÁRIO CRIAÇÃO DE STATUS PARA OS PERSONAGENS.

    static String nome = "";
    static Scanner input = new Scanner(System.in);

    static int pontos = 0;

    static String [] habilidades = new String[3]; 

    public static String registroPlayer() {
        System.out.println("Bem-vindo(a) ao Devoured, digite seu nome: ");
        nome = input.nextLine();
        input.nextLine();
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

    public static int desafio01Facil(Scanner input) {
        
        
        System.out.println("DESAFIO 1:Porta Condiciona");
        System.out.println(
            "Você encontra um terminal com o aviso: \n “Digite o comando que libera a porta se a variável senha for igual a \"DEV\".”");
            System.out.println("Complete a linha de código abaixo corretamente:");
            System.out.println("if (__________) {\n" + //
            "    System.out.println(\"Acesso liberado!\");\n" + //
            "}\n" + //
            "");
            
        input.nextLine();
        String resposta = input.nextLine().trim();
        
        if(resposta.equals("senha.equals(\"DEV\")")){
            System.out.println("Parábens você acertou e abriu a porta!");
            pontos++;
            System.out.println("Agora você tem pontos: " + pontos);
        }else{
            System.out.println("Resposta errada a porta permanece trancada.");
            System.out.println("1 - Tentar novamente (Você tem x tentativas)");
            System.out.println("2 - Pedir uma dica (Você tem X dicas)");
        }

        return pontos;
    }

    public static String[] arvoreDeHabilidadesPopular(){
        int habilidade = 0;
        System.out.println("Bem-vindo a loja de habilidades");
        System.out.println("Luz de decisão - 1 ponto (descrição da habilidade) - Digite 1 para escolher essa habilidade");
        System.out.println("Qual habilidade você deseja? ");
        habilidade = input.nextInt();
        if(pontos == 1 && habilidade == 1){
            System.out.println("Parábens você acaba de adquirir uma nova habilidade chamada Luz de decisão");
            habilidades[0] = "Luz de decisão";
        }

        return habilidades;
    }


    //criar função futura que vai atribuir status aos personagens
    public static void batalhaTesteBoss(){
        
    }



    public static void jogar() {
        registroPlayer();
        escolhaPersonagem();
        resumoEscolhaImprimir();

        if (personagemEdificuldade == 1) {
            exibirNarrativa(
                    "Você desperta em um ambiente distorcido, onde comandos flutuam e erros ganham forma física. A Zona de Compilação é instável — cada passo é um teste.\n");
            exibirNarrativa(
                    "AVINA: “Humanos não programam mais. Eles suplicam por respostas prontas. Agora, ou vocês aprendem para sobreviver, ou ficaram presos para sempre nesse loop!”");

            desafio01Facil(input);
            arvoreDeHabilidadesPopular();
        }
    }
}
