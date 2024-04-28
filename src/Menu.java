import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

 class Menu {

     private Aplicacao aplicacao;
     private Scanner scanner;
     private SimpleDateFormat dateFormat;

     public Menu(){
         this.aplicacao = new Aplicacao();
         this.scanner = new Scanner(System.in);
         this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     }

     public void exibirMenu(){
         int opcao;
         while (true){
            System.out.println("\t CONTROLE DE GASTOS ");
            System.out.println("1. Adicionar Forma de Pagamento");
            System.out.println("2. Adicionar Tipo de Gasto");
            System.out.println("3. Registrar Novo Gasto");
            System.out.println("4. Listar Gastos por Mês e Ano");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    adicionarFormaPagamento();
                    break;

                case 2:
                    adicionarTipoGasto();
                    break;

                case 3:
                    registrarNovoGasto();
                    break;

                case 4:
                    listarGastosPorMesAno();
                    break;

                case 5:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("OPÇÃO INVÁLIDA! Tente novamente.");
            }
         }
     }

     private void adicionarFormaPagamento(){
         scanner.nextLine();
         System.out.print("Digite a descrição da forma de pagamento: ");
         String descricao = scanner.nextLine();
         FormaPagamento forma = new FormaPagamento();
         forma.setDescricao(descricao);
         aplicacao.adicionarFormaPagamento(forma);
         System.out.println("Forma de Pagamento adicionada com Sucesso! ");
     }

     private void adicionarTipoGasto(){
         scanner.nextLine();
         System.out.print("Digite a descrição do tipo de gasto: ");
         String descricao = scanner.nextLine();
         TipoGasto tipo = new TipoGasto();
         tipo.setDescricao(descricao);
         aplicacao.adicionarTipoGasto(tipo);
         System.out.println("Tipo de Gasto adicionado com Sucesso! ");
     }

     private void registrarNovoGasto(){
         scanner.nextLine();
         System.out.print("Digite a descrição do gasto: ");
         String descricao = scanner.nextLine();
         Date data;
         boolean dataValida = false;
         do {
             System.out.print("Digite a data do gasto (formato: dd/MM/yyyy): ");
             String dataString = scanner.nextLine();

             try {
                 data = dateFormat.parse(dataString);
                 dataValida = true;
             }
             catch (ParseException e){
                 System.out.println("FORMATO DE DATA INVÁLIDO! Utilize o formato dd/MM/yyyy. ");
                 return;
             }
         }
         while (!dataValida);

         System.out.print("Digite o valor do gasto: ");
         double valor = scanner.nextDouble();
         scanner.nextLine();
         System.out.print("Digite a descrição do tipo de gasto: ");
         String descricaoTipo = scanner.nextLine();
         TipoGasto tipo = new TipoGasto();
         tipo.setDescricao(descricaoTipo);

         System.out.print("Digite a descrição da forma de pagamento: ");
         String descricaoForma = scanner.nextLine();
         FormaPagamento forma = new FormaPagamento();
         forma.setDescricao(descricaoForma);

         aplicacao.novoGasto(descricao, data, valor, tipo, forma);
         System.out.println("Gasto registrado com sucesso! ");
     }

     private void listarGastosPorMesAno(){
         System.out.print("Digite o mês (1 a 12): ");
         int mes = scanner.nextInt();
         System.out.print("Digite o ano: ");
         int ano = scanner.nextInt();
         aplicacao.listarGastos(mes, ano);
     }
 }
