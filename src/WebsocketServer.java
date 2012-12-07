
import java.net.*;
import java.io.*;

public class WebsocketServer extends Thread
{
   private ServerSocket serverSocket;
   
   public WebsocketServer(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(10000);
   }

   public void run()
   {
      while(true)
      {
         try
         {
            System.out.println("Waiting for client on port " +
            serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            System.out.println("Just connected to "
                  + server.getRemoteSocketAddress());
            int i=0;
            DataOutputStream out =
                    new DataOutputStream(server.getOutputStream());
           while(true){
        	  
                  out.writeInt(i);
           i++;
            
           }
           //server.close();
           /*
           DataInputStream in =
                  new DataInputStream(server.getInputStream());
            
            System.out.println(in.readUTF());
            DataInputStream in2 =
                    new DataInputStream(server.getInputStream());
              System.out.println(in2.readUTF());
            DataOutputStream out =
                 new DataOutputStream(server.getOutputStream());
            out.writeUTF("Thank you for connecting to "
              + server.getLocalSocketAddress() + "\nGoodbye!");
              
            server.close();*/
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
            break;
         }catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
   public static void main(String [] args)
   {
      int port = 8080;
      try
      {
         Thread t = new WebsocketServer(port);
         t.start();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}