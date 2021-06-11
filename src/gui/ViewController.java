package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entities.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {

    private String[] tipoUnidade = { "SÓLIDO", "LÍQUIDO" };
    private String[] unidadesVolume = { "L", "mL" };
    private String[] unidadesPeso = { "Kg", "g" };

    private List<Product> lista = new ArrayList<>();

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPreco;

    @FXML
    private TextField txtQuantidadeComprada;

    @FXML
    private TextField txtQuantidadeUsada;

    @FXML
    private Button btAdiciona;

    @FXML
    private Button btLimpa;

    @FXML
    private Button btListar;

    @FXML
    private ChoiceBox<String> cbTipo;

    @FXML
    private ChoiceBox<String> cbTipoComprado;

    @FXML
    private ChoiceBox<String> cbTipoUsado;

    @FXML
    private TextArea txtLista;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cbTipo.setValue("SÓLIDO");
        cbTipo.getItems().addAll(tipoUnidade);
        cbTipo.setOnAction(this::getTipo);

        cbTipoComprado.getItems().addAll(unidadesPeso);
        cbTipoUsado.getItems().addAll(unidadesPeso);
        cbTipoUsado.setValue("Kg");
        cbTipoComprado.setValue("Kg");
    }

    public void getTipo(ActionEvent event) {
        if (cbTipo.getValue() == "SÓLIDO") {
            cbTipoComprado.getItems().clear();
            cbTipoUsado.getItems().clear();
            cbTipoComprado.getItems().addAll(unidadesPeso);
            cbTipoUsado.getItems().addAll(unidadesPeso);
            cbTipoUsado.setValue("Kg");
            cbTipoComprado.setValue("Kg");
        } else {
            cbTipoComprado.getItems().clear();
            cbTipoUsado.getItems().clear();
            cbTipoComprado.getItems().addAll(unidadesVolume);
            cbTipoUsado.getItems().addAll(unidadesVolume);
            cbTipoUsado.setValue("L");
            cbTipoComprado.setValue("L");
        }

    }

    @FXML
    public void btAdicionaClick() {
        try {
            String nome = txtNome.getText();
            String tipoUnidade = cbTipo.getValue();
            String tipoComprado = cbTipoComprado.getValue();
            Double quantidadeComprada = Double.parseDouble(txtQuantidadeComprada.getText());
            Double valorComprado = Double.parseDouble(txtPreco.getText());
            String tipoUsado = cbTipoUsado.getValue();
            Double quantidadeUsada = Double.parseDouble(txtQuantidadeUsada.getText());

            Product item = new Product(nome, tipoUnidade, tipoComprado, quantidadeComprada, valorComprado, tipoUsado,
                    quantidadeUsada);
            lista.add(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void btLimpaClick() {
        txtNome.clear();
        txtPreco.clear();
        txtQuantidadeComprada.clear();
        txtQuantidadeUsada.clear();
    }

    @FXML
    public void btListarClick() {
        Double total = 0.0;

        for (Product p : lista) {
            total += p.geraCusto();
            txtLista.appendText(p.toString());
            txtLista.appendText("------------------------------------\n");
        }
        txtLista.appendText("Foram gastos no total R$" + String.format("%.2f", total));

    }
}
