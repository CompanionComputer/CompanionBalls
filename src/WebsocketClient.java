import java.net.*;
import java.io.*;

public class WebsocketClient
{

	public WebsocketClient(int port , String serverName){
		try
		{
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);
			System.out.println("Just connected to " + client.getRemoteSocketAddress());

			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);

			while(true){
				if (in.available()>0){
					System.out.println("Simon says my degree should be " + in.readInt());
					System.out.println("Simon says my speed should be " + in.readDouble());
				}
			}
			//client.close();
		}catch(IOException e){e.printStackTrace();}
	}
}