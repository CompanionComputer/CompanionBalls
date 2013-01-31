package companionBalls.robotContainerParts.networking;

import java.net.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.io.*;

public class WebsocketServer extends Thread
{
	private ServerSocket serverSocket;
	private Socket server;
	private DataOutputStream out = null;

	public WebsocketServer(int port) throws IOException
	{
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(0);
	}

	public void run()
	{

		System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");


		try {
			this.server = serverSocket.accept();
			this.out = new DataOutputStream(server.getOutputStream());
		} catch (IOException e) {e.printStackTrace();}
		System.out.println("Just got connected by " + server.getRemoteSocketAddress());

	}
	
	/**
	 * returns false if:<br>
	 * * outputstream is undefined, this occurs when no client is connected<br>
	 * * an exception occurs
	 * @param degree
	 * @param speed
	 * @return boolean
	 * @throws IOException
	 */
	public boolean sendcommands(int degree, double speed) throws IOException{
		if (out==null)
			return false;
		try {
			out.writeInt(degree);
			out.writeDouble(speed);
		} catch (Exception e) {return false;}
		return true;
	}

}
