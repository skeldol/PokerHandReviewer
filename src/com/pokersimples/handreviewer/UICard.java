package com.pokersimples.handreviewer;

import com.pokersimples.bo.Card;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UICard {
	private final StringProperty rank = new SimpleStringProperty("?");
	private final StringProperty suit = new SimpleStringProperty("?");
	private final StringProperty card = new SimpleStringProperty("?");
	private final StringProperty colour = new SimpleStringProperty("?");
	private final StringProperty visible = new SimpleStringProperty("true");
	
	public StringProperty  rankProperty() { return rank;}
	public StringProperty  suitProperty() { return suit;}
	public StringProperty  cardProperty() { return card;}
	public StringProperty  colourProperty() { return colour;}
	public StringProperty  visibleProperty() { return visible;}
	
	public UICard() {}
	
	public UICard(Card pCard) {
		if(pCard != null) {
			setCard(pCard.toString());
			switch(pCard.suit) {
				case Clubs:
					colour.set("-fx-background-color:green");
					break;
				case Hearts:
					colour.set("-fx-background-color:red");
					break;
				case Diamonds:
					colour.set("-fx-background-color:aqua");
					break;
				case Spades:
					colour.set("-fx-background-color:lightgray");
					break;
				default:
					colour.set("-fx-background-color:white");	
			}
		} else {
			setCard("??");
			colour.set("-fx-background-color:white");	
		}
	}

	
	public String getRank() {
		return rank.get();
	}
	public void setRank(String rank) {
		this.rank.set(rank);
	}

	public String getSuit() {
		return suit.get();
	}
	public void setSuit(String suit) {
		this.suit.set(suit);

	}
	
	public String getCard() {
		return card.get();
	}
	public void setCard(String card) {
		this.card.set(card);
	}
	
	public String getColour() {
		return colour.get();
	}

	public String getVisible() {
		return visible.get();
	}
	
	public void setVisible(String pVisible) {
		this.visible.set(pVisible);
	}
}
