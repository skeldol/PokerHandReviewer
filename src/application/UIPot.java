package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UIPot {
	private final StringProperty total = new SimpleStringProperty("?");
	private final StringProperty potOdds = new SimpleStringProperty("?");
	
	public StringProperty  totalProperty() { return total;}
	public StringProperty  potOddsProperty() { return potOdds;}
	
	public String getTotal() {
		return total.get();
	}
	public void setTotal(String pot) {
		System.out.println("Pot is " + pot);
		this.total.set(pot);
	}
	
	public String getPotOdds() {
		return potOdds.get();
	}
	public void setPotOdds(String potOdds) {
		System.out.println("Pot odds " + potOdds);
		this.potOdds.set(potOdds);
	}
}
