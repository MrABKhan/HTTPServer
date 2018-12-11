import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


//One Class implementation
public class SimpleHttpServer {

    public static void main(String[] args){

        if(args.length > 0) {
            //Read the Port Number from the command-line argument.
            int port = Integer.parseInt(args[0]);


            try {
                //Create the Socket required for listening at a specific port.
                final ServerSocket serverSocket = new ServerSocket(port);

                //Friendly message to the user as usual.
                System.out.printf("Server initiated at Port #%d", port);

                while(true){
                    //Continue Listening

                    //Listen and Accept a Connection, .accept() is a blocking method.
                    final Socket socket = serverSocket.accept();


                    //Read Contents of the HTTP Request
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    String output = bufferedReader.readLine();

                    //Print Contents till end of line
                    while (!output.isEmpty()) {
                        System.out.println(output);
                        System.out.println("IP Address:"+socket.getInetAddress());

                        //Continue Reading
                        output = bufferedReader.readLine();

                    }


                }


            } catch (IOException e) {
                //Exception Handling required in case of IO exceptions in the ServerSocket.
                e.printStackTrace();
            }

        }
        else {
            System.out.println("Please add port number in command line argument");
        }

    }

}
