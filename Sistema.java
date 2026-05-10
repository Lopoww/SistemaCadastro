package TesteFinal;

import java.util.Scanner;

public class Sistema {
//Dados
    // usuario
    static String nome;
    static String cpf;
    static String email;
    static String cargo;
    static String login;
    static String senha;

    // projeto
    static String nomeProjeto;
    static String tipoProjeto;
    static String dificuldade;
    static String dataInicio;
    static String dataTermino;
    static String status;

    // equipe
    static String nomeEquipe;
    static String descricaoEquipe;

    // membros
    static String[] nomesMembros = new String[6];
    static String[] cpfMembros   = new String[6];
    static String[] emailMembros = new String[6];
    static String[] cargoMembros = new String[6];
    static String[] loginMembros = new String[6];
    static String[] senhaMembros = new String[6];

    static Scanner sc = new Scanner(System.in);

    // meses
    static String calcularTermino(String inicio, int meses) {
        String[] partes = inicio.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);

        mes = mes + meses;

        if (mes > 12) {
            mes = mes - 12;
            ano = ano + 1;
        }

        String diaStr = "";
        String mesStr = "";

        if (dia < 10) {
            diaStr = "0" + dia;
        } else {
            diaStr = "" + dia;
        }

        if (mes < 10) {
            mesStr = "0" + mes;
        } else {
            mesStr = "" + mes;
        }

        return diaStr + "/" + mesStr + "/" + ano;
    }

    // login
    static String gerarLogin(String nomeCompleto) {
        String primeiro = "";
        for (int i = 0; i < nomeCompleto.length(); i++) {
            if (nomeCompleto.charAt(i) == ' ') {
                break;
            }
            primeiro = primeiro + nomeCompleto.charAt(i);
        }
        return primeiro + "@Endgame.com";
    }

    // senha
    static String gerarSenha(String nomeCompleto, String cpfDigitado) {
        String primeiro = "";
        for (int i = 0; i < nomeCompleto.length(); i++) {
            if (nomeCompleto.charAt(i) == ' ') {
                break;
            }
            primeiro = primeiro + nomeCompleto.charAt(i);
        }

        String cpfLimpo = "";
        for (int i = 0; i < cpfDigitado.length(); i++) {
            char c = cpfDigitado.charAt(i);
            if (c != '.' && c != '-') {
                cpfLimpo = cpfLimpo + c;
            }
        }

        return primeiro + cpfLimpo;
    }

    public static void main(String[] args) {

        // CADASTRO 
               
        System.out.println("     CADASTRO DE PROJETO     ");
        
        System.out.print("Nome do projeto: ");
        nomeProjeto = sc.nextLine();

        System.out.println("Tipo do projeto:");
        System.out.println("1 - Jogo");
        System.out.println("2 - SaaS");
        System.out.println("3 - Bet");
        System.out.println("4 - Aplicativo de Treino");
        System.out.print("Escolha: ");
        int tipoOp = Integer.parseInt(sc.nextLine());

        if (tipoOp == 1) {
            tipoProjeto = "Jogo";
        } else if (tipoOp == 2) {
            tipoProjeto = "SaaS";
        } else if (tipoOp == 3) {
            tipoProjeto = "Bet";
        } else {
            tipoProjeto = "Aplicativo de Treino";
        }

        System.out.println("Dificuldade:");
        System.out.println("1 - Facil   (termina em 1 mes)");
        System.out.println("2 - Medio   (termina em 3 meses)");
        System.out.println("3 - Dificil (termina em 5 meses)");
        System.out.print("Escolha: ");
        int difOp = Integer.parseInt(sc.nextLine());

        int prazoMeses = 0;
        if (difOp == 1) {
            dificuldade = "Facil";
            prazoMeses  = 1;
        } else if (difOp == 2) {
            dificuldade = "Medio";
            prazoMeses  = 3;
        } else {
            dificuldade = "Dificil";
            prazoMeses  = 5;
        }

        System.out.print("Data de inicio (dd/MM/yyyy): ");
        dataInicio  = sc.nextLine();
        dataTermino = calcularTermino(dataInicio, prazoMeses);

        System.out.println("Status:");
        System.out.println("1 - Planejado");
        System.out.println("2 - Em andamento");
        System.out.println("3 - Concluido");
        System.out.println("4 - Cancelado");
        System.out.print("Escolha: ");
        int statusOp = Integer.parseInt(sc.nextLine());

        if (statusOp == 1) {
            status = "Planejado";
        } else if (statusOp == 2) {
            status = "Em andamento";
        } else if (statusOp == 3) {
            status = "Concluido";
        } else {
            status = "Cancelado";
        }

        // CADASTRO DA EQUIPE
       
        System.out.println("     CADASTRO DA EQUIPE      ");
        
        nomeEquipe = "Projeto " + tipoProjeto;

        System.out.print("Descricao da equipe: ");
        descricaoEquipe = sc.nextLine();

        // Limite Cargo
        int qtdAdm         = 0;
        int qtdGerente     = 0;
        int qtdColaborador = 0;

        int membro = 0;
        while (membro < 6) {
            System.out.println("\n--- Membro " + (membro + 1) + " de 6 ---");

            System.out.print("Nome: ");
            nomesMembros[membro] = sc.nextLine();

            System.out.print("CPF: ");
            cpfMembros[membro] = sc.nextLine();

            System.out.print("E-mail (@gmail.com): ");
            emailMembros[membro] = sc.nextLine();

            System.out.println("Cargo:");
            System.out.println("1 - Adm        (maximo 1)");
            System.out.println("2 - Gerente    (maximo 1)");
            System.out.println("3 - Colaborador (maximo 4)");
            System.out.print("Escolha: ");
            int cargoOp = Integer.parseInt(sc.nextLine());

            // E se
            boolean cargoValido = false;

            if (cargoOp == 1 && qtdAdm < 1) {
                cargoMembros[membro] = "Adm";
                qtdAdm++;
                cargoValido = true;
            } else if (cargoOp == 2 && qtdGerente < 1) {
                cargoMembros[membro] = "Gerente";
                qtdGerente++;
                cargoValido = true;
            } else if (cargoOp == 3 && qtdColaborador < 4) {
                cargoMembros[membro] = "Colaborador";
                qtdColaborador++;
                cargoValido = true;
            } else {
                System.out.println("Cargo cheio! Escolha outro.");
            }

            if (cargoValido) {
                loginMembros[membro] = gerarLogin(nomesMembros[membro]);
                senhaMembros[membro] = gerarSenha(nomesMembros[membro], cpfMembros[membro]);
                System.out.println("Login gerado: " + loginMembros[membro]);
                System.out.println("Senha gerada: " + senhaMembros[membro]);
                membro++;
            }
        }

        //Final
        System.out.println("\n==============================");
        System.out.println("       STATUS DO PROJETO      ");
        System.out.println("==============================");
        System.out.println("Nome       : " + nomeProjeto);
        System.out.println("Tipo       : " + tipoProjeto);
        System.out.println("Dificuldade: " + dificuldade + " (" + prazoMeses + " mes/meses)");
        System.out.println("Inicio     : " + dataInicio);
        System.out.println("Termino    : " + dataTermino);
        System.out.println("Status     : " + status);

        System.out.println("\n--- Equipe: " + nomeEquipe + " ---");
        System.out.println("Descricao  : " + descricaoEquipe);
        System.out.println("Membros    :");

        for (int i = 0; i < 6; i++) {
            System.out.println("  [" + cargoMembros[i] + "] " + nomesMembros[i]
                + " | " + cpfMembros[i]
                + " | " + emailMembros[i]
                + " | Login: " + loginMembros[i]
                + " | Senha: " + senhaMembros[i]);
        }

        System.out.println("==============================");

        sc.close();
    }
}