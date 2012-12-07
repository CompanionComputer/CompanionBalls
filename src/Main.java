
import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.Iterator;


import se.nicklasgavelin.sphero.Robot;


public class Main {
	
	
	public static void main(String[] args) {
		//Example_Site_API example = new Example_Site_API();
		// new Thread( new Example_Site_API() ).start();
		//	DirectionalKeysPanel DKP = null;// = new DirectionalKeysPanel();if( ct != null )
		//ct.stopThread();
		// Create a new thread
		//		ConnectThread ct = new ConnectThread();
		//		ct.start();
		//		while(ct.getRobotArray().size()==0){}
		
		
		GurrUI gurrui = new GurrUI(new ConnectThread());
		gurrui.fixGUI();
		
		
		
		
		//backgroundvariables, do not touch
		//server sends commands - clients recieves and does them
		int server = 0;
		int client = 1;
		WebsocketClient	wc;
		Thread ws;
		
		
		
		//CONFIGS
		int ApplicationType = server;
		int port = 8080;
		String socketname = "sötsocket" ;
		
		
		

		if (ApplicationType==server)
			try 
			{
				ws = new WebsocketServer(port);
				ws.start();
			} catch (IOException e) {e.printStackTrace();}

		else if (ApplicationType==client)
			wc = new WebsocketClient(port, socketname);
		
		else 
			System.out.println("Warning: Single Player only");
		//SpheroGUI commander = new SpheroGUI();
		

	}

}

