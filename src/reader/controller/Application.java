package reader.controller;


import java.awt.EventQueue;

import reader.view.MainScreen;
import reader.model.*;
import reader.helpers.*;

public class Application {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					RSSReader rss = new RSSReader("http://railscasts.com/subscriptions/wwHfMvyEKX87eX6k6tYBVA/episodes.rss");
					Feed demo = rss.readFeed();
					
					
					
					MainScreen window = new MainScreen();
					window.getWindow().setVisible(true);
					window.getList().setModel(new ArticlesTableModel(demo.getMessages()) );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
