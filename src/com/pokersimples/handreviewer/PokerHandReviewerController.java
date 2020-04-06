package com.pokersimples.handreviewer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.pokersimples.bo.Action;
import com.pokersimples.bo.BigBlind;
import com.pokersimples.bo.DealerAction;
import com.pokersimples.bo.Flop;
import com.pokersimples.bo.Hand;
import com.pokersimples.bo.Player;
import com.pokersimples.bo.PlayerAction;
import com.pokersimples.bo.River;
import com.pokersimples.bo.Turn;
import com.pokersimples.parser.handhistory.pokerstars.PokerStarsParser;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PokerHandReviewerController implements Initializable {
	private Hand hand = null;

	
	private int actionSeq = 0;

	private UIPot pot = new UIPot();
	
	private UIPlayer  player1;
	private UIPlayer  player2;
	private UIPlayer  player3;
	private UIPlayer  player4;
	private UIPlayer  player5;
	private UIPlayer  player6;

	private UIBoard	board = new UIBoard();
	
	public final UIPot getPot() { return pot; }
	public final UIBoard getBoard() { return board; }
	
	public final UIPlayer getPlayer1() { return player1; }
	public final UIPlayer getPlayer2() { return player2; }
	public final UIPlayer getPlayer3() { return player3; }
	public final UIPlayer getPlayer4() { return player4; }
	public final UIPlayer getPlayer5() { return player5; }
	public final UIPlayer getPlayer6() { return player6; }


    
    
    public PokerHandReviewerController() {
		System.out.println(System.getProperty("user.dir"));
		File file = new File("C:\\Users\\Leon\\eclipse-workspace\\Poker\\PokerHandParser\\src\\SinglePokerHand.txt"); 
	  
		List<Hand> games = new ArrayList<Hand>();
		

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file)); 
			
			PokerStarsParser parser = new PokerStarsParser();
			String st; 
			
			while ((st = br.readLine()) != null) 
				hand = parser.parse(st); 
				
				if(hand != null) {
					games.add(hand);
				}
			
		
		} catch(Exception e1) {
			e1.printStackTrace();
		} finally {
			try { br.close();}
			catch(Exception e1) {e1.printStackTrace();}
		}

		player1 = new UIPlayer(hand.getPlayer(1));
		player2 = new UIPlayer(hand.getPlayer(2));
		player3 = new UIPlayer(hand.getPlayer(3));
		player4 = new UIPlayer(hand.getPlayer(4));
		player5 = new UIPlayer(hand.getPlayer(5));
		player6 = new UIPlayer(hand.getPlayer(6));
		
		//Run through the actions til the BigBlind is posted.
		Action action = null;
		while(!(action instanceof BigBlind) ) {
			action = hand.getAction(actionSeq++);
			if(action instanceof PlayerAction) {
				PlayerAction playerAction = (PlayerAction) action;
				pot.setPotOdds(playerAction.getPotOdds().toString());
				UIPlayer uiPlayer = getPlayerForAction(playerAction);
				uiPlayer.update(playerAction);
			} 
			
			pot.setTotal(action.getPot().toString());			
		}
		
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

	
	
	public void next(ActionEvent event) {
		Action action = hand.getAction(actionSeq++);
		if(action instanceof PlayerAction) {
			PlayerAction playerAction = (PlayerAction) action;
			pot.setPotOdds(playerAction.getPotOdds().toString());
			UIPlayer uiPlayer = getPlayerForAction(playerAction);
			uiPlayer.update(playerAction);
		} else if(action instanceof DealerAction) {
			DealerAction dealerAction = (DealerAction) action;
			board.update(dealerAction);
		}
		
		pot.setTotal(action.getPot().toString());
		System.out.println(actionSeq);
	}
	
	public void previous(ActionEvent event) {
		Action action = hand.getAction(--actionSeq);
		if(action instanceof PlayerAction) {
			PlayerAction playerAction = (PlayerAction) action;
			pot.setPotOdds(playerAction.getPotOdds().toString());
			UIPlayer uiPlayer = getPlayerForAction(playerAction);
			uiPlayer.undo();
		} else if(action instanceof DealerAction) {
			DealerAction dealerAction = (DealerAction) action;
			board.undo(dealerAction);
		}
		
		pot.setTotal(action.getPot().toString());
		System.out.println(actionSeq);

	}
	
	private UIPlayer getPlayerForAction(PlayerAction playerAction) {
		UIPlayer playerUI = null;
		if(playerAction.getPlayer().getSeatNumber() == getPlayer1().getSeatNumber()) {
			playerUI = getPlayer1();
			
		} else if(playerAction.getPlayer().getSeatNumber() == getPlayer2().getSeatNumber()) {
			playerUI = getPlayer2();
			
		} else if(playerAction.getPlayer().getSeatNumber() == getPlayer3().getSeatNumber()) {
			playerUI = getPlayer3();
			
		} else if(playerAction.getPlayer().getSeatNumber() == getPlayer4().getSeatNumber()) {
			playerUI = getPlayer4();
			
		} else if(playerAction.getPlayer().getSeatNumber() == getPlayer5().getSeatNumber()) {
			playerUI = getPlayer5();
			
		} else if(playerAction.getPlayer().getSeatNumber() == getPlayer6().getSeatNumber()) {
			playerUI = getPlayer6();
		}
		
		return playerUI;
	}


}
