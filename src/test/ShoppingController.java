package test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ShoppingController implements Initializable {

	@FXML
	private ListView<ItemsObjects> itemslistView;

	@FXML
	private ListView<ItemsObjects> cart;

	@FXML
	private TextField itemPrice;

	@FXML
	private Button purchase;

	@FXML
	private TextField total;

	@FXML
	private TextField totalVat;

	@FXML
	void shoppDone(ActionEvent event) {
		cart.getItems().add(itemslistView.getSelectionModel().getSelectedItem());

		ObservableList<ItemsObjects> res = cart.getItems();
		double result_price = 0;
		for (ItemsObjects tabPane : res) {
			result_price += tabPane.getValue();
		}
		total.setText("" + result_price);
		double vat;

		double vatAmount;

		vatAmount = (result_price * 5.0) / 105;

		totalVat.setText(String.valueOf(result_price + vatAmount));

	}

	@FXML
	void showPrice(MouseEvent event) {
		ItemsObjects x = itemslistView.getSelectionModel().getSelectedItem();
		itemPrice.setText(String.valueOf(x.getValue()));

		System.out.println("clicked on " + x);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// itemslistView.setItems( names);

		ItemsObjects DozenApples = new ItemsObjects("Dozen Apples", 13);
		ItemsObjects Basket = new ItemsObjects("Basket O' Plums", 16.9);
		ItemsObjects LargeEggs = new ItemsObjects("Large Eggs", 23.1);
		ItemsObjects Milk = new ItemsObjects("2L Milk", 7.8);
		ItemsObjects CheeseCurds = new ItemsObjects("Cheese Curds", 14.5);
		ItemsObjects packCoke = new ItemsObjects("24 pack Coke", 24);
		ItemsObjects packSprite = new ItemsObjects("12 pack Sprite", 12);
		ItemsObjects CannedOlives = new ItemsObjects("Canned Olives", 17.6);
		ItemsObjects BurgerBread = new ItemsObjects("Burger Bread", 6.5);
		ItemsObjects MandM = new ItemsObjects("M&M (180 grams)", 13.6);

		itemslistView.getItems().addAll(DozenApples, Basket, LargeEggs, Milk, CheeseCurds, packCoke, packSprite,
				CannedOlives, BurgerBread, MandM);
		// names.add("First task");
		// names.add("Second task");

		// ItemsObjects Apple = new ItemsObjects("Apple",5);
		// ItemsObjects Pumpkin = new ItemsObjects("Pumpkin",7);

		// itemslistView.getItems().addAll(Apple,Pumpkin);

	}

}
