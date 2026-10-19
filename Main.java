import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

    Scanner ler = new Scanner(System.in);
    ler.useLocale(Locale.forLanguageTag("pt-BR"));

    ArrayList<ProdEstoque> produtos = new ArrayList<>();
    int opcao = 0;

    while (opcao != 6) {

    System.out.println("\n===== CONTROLE DE ESTOQUE =====");
    System.out.println("1 - Cadastrar produto");
    System.out.println("2 - Consultar produto");
    System.out.println("3 - Entrada de produto");
    System.out.println("4 - Saída de produto");
    System.out.println("5 - Mostrar quantidade em estoque");
    System.out.println("6 - Sair");
    System.out.println("===============================");
    System.out.print("Escolha uma opção: ");

    try {
    opcao = ler.nextInt();
    ler.nextLine();

    } catch (InputMismatchException e) {

    System.out.println("Digite apenas um número!");
    ler.nextLine();
    opcao = 0;
    continue;
    }

        if (opcao == 1) {

        System.out.print("Digite o código do produto: ");
        int cod;

        try {
        cod = ler.nextInt();
        ler.nextLine();

        } catch (InputMismatchException e) {

        System.out.println("O código deve ser um número inteiro.");
        ler.nextLine();
        continue;
        }

        boolean codigoExiste = false;

        for (ProdEstoque produto : produtos) {

        if (produto.getCodigo() == cod) {
        codigoExiste = true;
        break;
        }
        }

        if (codigoExiste) {

        System.out.println("Já existe um produto com esse código!");

        } else {

        System.out.print("Digite o nome do produto: ");
        String nome = ler.nextLine();

        System.out.print("Digite o preço do produto: ");
        double preco;

        try {
        preco = ler.nextDouble();

        } catch (InputMismatchException e) {

        System.out.println("O preço deve ser um número.");
        ler.nextLine();
        continue;
        }

        if (preco < 0) {

        System.out.println("O preço não pode ser negativo.");

        } else {

        System.out.print("Digite a quantidade em estoque: ");
        int quantidade;

        try {
        quantidade = ler.nextInt();

        } catch (InputMismatchException e) {

        System.out.println("A quantidade deve ser um número inteiro.");
        ler.nextLine();
        continue;
        }

        if (quantidade < 0) {

        System.out.println("A quantidade não pode ser negativa.");

        } else {

        ProdEstoque produto = new ProdEstoque(cod, nome, preco, quantidade);
        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso!");
        }
        }
        }
        }

        else if (opcao == 2) {

        boolean encontrado = false;
        String nomeBusca = "";

        while (!encontrado && !nomeBusca.equals("0")) {

        System.out.print("Digite o nome do produto (ou 0 para voltar): ");
        nomeBusca = ler.nextLine();

        if (nomeBusca.equals("0")) {
        break;
        }

        for (ProdEstoque produto : produtos) {

        if (produto.getNome().equalsIgnoreCase(nomeBusca)) {

        System.out.println("\nProduto encontrado!");
        System.out.println("Código: " + produto.getCodigo());
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Preço: R$ " + produto.getPreco());
        System.out.println("Quantidade: " + produto.getQuantidade());

        encontrado = true;
        break;
        }
        }

        if (!encontrado) {
        System.out.println("Produto não encontrado! Tente novamente.");
        }
        }
        }

        else if (opcao == 3) {

        System.out.print("Digite o nome do produto: ");
        String nomeBusca = ler.nextLine();
        boolean encontrado = false;

        for (ProdEstoque produto : produtos) {

        if (produto.getNome().equalsIgnoreCase(nomeBusca)) {

        System.out.print("Quantas unidades chegaram? ");
        int entrada;

        try {
        entrada = ler.nextInt();

        } catch (InputMismatchException e) {

        System.out.println("Digite uma quantidade em números.");
        ler.nextLine();
        encontrado = true;
        break;
        }

        if (entrada > 0) {

        int novaQuantidade = produto.getQuantidade() + entrada;
        produto.setQuantidade(novaQuantidade);

        System.out.println("Entrada registrada!");
        System.out.println("Nova quantidade: " + produto.getQuantidade());

        } else {

        System.out.println("A quantidade deve ser maior que zero.");
        }

        encontrado = true;
        break;
        }
        }

        if (!encontrado) {
        System.out.println("Produto não encontrado!");
        }
        }

        else if (opcao == 4) {

        System.out.print("Digite o nome do produto: ");
        String nomeBusca = ler.nextLine();
        boolean encontrado = false;

        for (ProdEstoque produto : produtos) {

        if (produto.getNome().equalsIgnoreCase(nomeBusca)) {

        System.out.print("Quantas unidades deseja retirar? ");
        int saida;

        try {
        saida = ler.nextInt();

        } catch (InputMismatchException e) {

        System.out.println("Digite uma quantidade em números.");
        ler.nextLine();
        encontrado = true;
        break;
        }

        if (saida > 0 && saida <= produto.getQuantidade()) {

        int novaQuantidade = produto.getQuantidade() - saida;
        produto.setQuantidade(novaQuantidade);

        System.out.println("Saída registrada!");
        System.out.println("Quantidade restante: " + produto.getQuantidade());

        } else if (saida <= 0) {

        System.out.println("A quantidade deve ser maior que zero.");

        } else {

        System.out.println("Estoque insuficiente!");
        System.out.println("Quantidade disponível: " + produto.getQuantidade());
        }

        encontrado = true;
        break;
        }
        }

        if (!encontrado) {
        System.out.println("Produto não encontrado!");
        }
        }

        else if (opcao == 5) {

        if (produtos.isEmpty()) {

        System.out.println("Nenhum produto cadastrado.");

        } else {

        System.out.println("\n===== PRODUTOS EM ESTOQUE =====");

        for (ProdEstoque produto : produtos) {

        System.out.println("Código: " + produto.getCodigo());
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Quantidade: " + produto.getQuantidade());
        }
        }
        }

        else if (opcao == 6) {

        System.out.println("Encerrando o sistema...");

        } else {

        System.out.println("Opção inválida!");
        }
    }

    ler.close();
    }
}