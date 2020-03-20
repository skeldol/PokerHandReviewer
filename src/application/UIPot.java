package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UIPot {
	private final StringProperty pot = new SimpleStringProperty("?");
	
	public StringProperty  rankProperty() { return pot;}
	
	public String getPot() {
		return pot.get();
	}
	public void setPot(String pot) {
		this.pot.set(pot);
	}
}
