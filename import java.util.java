import java.util.Scanner;
public class SistemaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] alunos = new String[100];
        double[] medias = new double[100];
        String[] situacoes = new String[100];

        int quantidade = 0;
        int opcao = -1;
+
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Cadastrar notas do aluno");
            System.out.println("2 - Listar alunos e resultados");
            System.out.println("0 - Encerrar");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("\nOpção inválida! Digite apenas números inteiros.");
                scanner.nextLine(); 
                continue;
            }
            
            switch (opcao) {
                case 1:
                    if (quantidade < 100) {
                        System.out.println("\n--- CADASTRO DE NOTAS ---");

                        System.out.print("Digite o nome do aluno: ");
                        alunos[quantidade] = scanner.nextLine();

                        System.out.print("Digite a nota 1: ");
                        double nota1 = scanner.nextDouble();

                        System.out.print("Digite a nota 2: ");
                        double nota2 = scanner.nextDouble();

                        System.out.print("Digite a nota 3: ");
                        double nota3 = scanner.nextDouble();
                        scanner.nextLine(); 

                        double media = (nota1 + nota2 + nota3) / 3.0;
                        medias[quantidade] = media;

                        String situacao;
                        if (media >= 60.0) {
                            situacao = "Aprovado";
                        } else if (media >= 30.0) {
                            situacao = "Recuperação";
                        } else {
                            situacao = "Reprovado";
                        }
                        situacoes[quantidade] = situacao;

                        System.out.println("\nResultado final:");
                        System.out.printf("Média obtida: %.2f%n", media);
                        System.out.println("Situação: " + situacao);

                        quantidade++;
                    } else {
                        System.out.println("\nLimite máximo de 100 alunos atingido!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE CADASTROS ---");

                    if (quantidade == 0) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        for (int i = 0; i < quantidade; i++) {
                            System.out.println("\nAluno " + (i + 1) + ": " + alunos[i]);
                            System.out.printf("Média obtida: %.2f%n", medias[i]);
                            System.out.println("Situação: " + situacoes[i]);
                        }
                    }
                    break;

                case 0:
                    System.out.println("\nPrograma encerrado com sucesso!");
                    break;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 0); 

        scanner.close();
    }
}