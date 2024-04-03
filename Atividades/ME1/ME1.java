package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InterfaceMe extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        TabPane tabPane = new TabPane();
        Tab tabContas = new Tab("Contas");
        Tab tabSeguroVida = new Tab("Seguro de Vida");
        Tab tabRelatorio = new Tab("Relatório");

        // Desabilitando o fechamento das abas
        tabContas.setClosable(false);
        tabSeguroVida.setClosable(false);
        tabRelatorio.setClosable(false);

        VBox contasContent = new VBox();
        contasContent.setSpacing(10);
        contasContent.setPadding(new Insets(10));

        TableView<String> tabelaContas = new TableView<>();
        TableColumn<String, String> colunaTitular = new TableColumn<>("Titular");
        TableColumn<String, String> colunaNumero = new TableColumn<>("Número");
        TableColumn<String, String> colunaAgencia = new TableColumn<>("Agência");
        TableColumn<String, String> colunaSaldo = new TableColumn<>("Saldo");
        TableColumn<String, String> colunaTipo = new TableColumn<>("Tipo");

        tabelaContas.getColumns().addAll(colunaTitular, colunaNumero, colunaAgencia, colunaSaldo, colunaTipo);
        tabelaContas.setPlaceholder(new Label("Não há conteúdo na tabela"));

        // Centralizando as colunas da tabela
        tabelaContas.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        contasContent.getChildren().add(tabelaContas);

        Button btnNovaConta = new Button("Nova Conta");
        Button btnSalvarDados = new Button("Salvar Dados");
        HBox botoes = new HBox(10, btnNovaConta, btnSalvarDados);
        botoes.setAlignment(Pos.CENTER);

        botoes.setPadding(new Insets(10));

        contasContent.getChildren().add(botoes);

        tabContas.setContent(contasContent);

        // Conteúdo da aba Seguro de Vida
        VBox seguroVidaContent = new VBox();
        seguroVidaContent.setPadding(new Insets(10));

        TableView<SeguroVida> tabelaSeguroVida = new TableView<>();
        TableColumn<SeguroVida, String> colunaTitularSeguro = new TableColumn<>("Titular");
        TableColumn<SeguroVida, String> colunaNumeroAplice = new TableColumn<>("Nº da Apólice");
        TableColumn<SeguroVida, Double> colunaValor = new TableColumn<>("Valor");

        tabelaSeguroVida.getColumns().addAll(colunaTitularSeguro, colunaNumeroAplice, colunaValor);
        tabelaSeguroVida.setPlaceholder(new Label("Não há conteúdo na tabela"));

        // Centralizando as colunas da tabela
        tabelaSeguroVida.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        seguroVidaContent.getChildren().add(tabelaSeguroVida);

        Button btnNovoSeguroVida = new Button("Novo Seguro de Vida");
        HBox novoSeguroBox = new HBox(btnNovoSeguroVida);
        novoSeguroBox.setPadding(new Insets(10));
        seguroVidaContent.getChildren().add(novoSeguroBox);
        novoSeguroBox.setAlignment(Pos.CENTER);

        tabSeguroVida.setContent(seguroVidaContent);

        // Conteúdo da aba Relatório
        VBox relatorioContent = new VBox();
        relatorioContent.setPadding(new Insets(10));

        TableView<Relatorio> tabelaRelatorio = new TableView<>();
        TableColumn<Relatorio, String> colunaProduto = new TableColumn<>("Produto");
        TableColumn<Relatorio, String> colunaTitularRel = new TableColumn<>("Titular");
        TableColumn<Relatorio, Double> colunaValorImposto = new TableColumn<>("Valor do Imposto");

        tabelaRelatorio.getColumns().addAll(colunaProduto, colunaTitularRel, colunaValorImposto);
        tabelaRelatorio.setPlaceholder(new Label("Não há conteúdo na tabela"));

        // Centralizando as colunas da tabela
        tabelaRelatorio.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        relatorioContent.getChildren().add(tabelaRelatorio);

        Button btnCalcularImpostos = new Button("Calcular Impostos");
        HBox calcularImpostosBox = new HBox(btnCalcularImpostos);
        calcularImpostosBox.setPadding(new Insets(10));
        relatorioContent.getChildren().add(calcularImpostosBox);

        calcularImpostosBox.setAlignment(Pos.CENTER);

        tabRelatorio.setContent(relatorioContent);

        tabPane.getTabs().addAll(tabContas, tabSeguroVida, tabRelatorio);

        root.setCenter(tabPane);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Tela de Contas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class SeguroVida {
        private String titular;
        private String numeroAplice;
        private double valor;

        public SeguroVida(String titular, String numeroAplice, double valor) {
            this.titular = titular;
            this.numeroAplice = numeroAplice;
            this.valor = valor;
        }

        public String getTitular() {
            return titular;
        }

        public void setTitular(String titular) {
            this.titular = titular;
        }

        public String getNumeroAplice() {
            return numeroAplice;
        }

        public void setNumeroAplice(String numeroAplice) {
            this.numeroAplice = numeroAplice;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }
    }

    public static class Relatorio {
        private String produto;
        private String titular;
        private double valorImposto;

        public Relatorio(String produto, String titular, double valorImposto) {
            this.produto = produto;
            this.titular = titular;
            this.valorImposto = valorImposto;
        }

        public String getProduto() {
            return produto;
        }

        public void setProduto(String produto) {
            this.produto = produto;
        }

        public String getTitular() {
            return titular;
        }

        public void setTitular(String titular) {
            this.titular = titular;
        }

        public double getValorImposto() {
            return valorImposto;
        }

        public void setValorImposto(double valorImposto) {
            this.valorImposto = valorImposto;
        }
    }
}