import java.io.IOException;
import java.net.ServerSocket;

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


            } catch (IOException e) {
                //Exception Handling required incase of IO exceptions in the ServerSocket.
                e.printStackTrace();
            }

        }
        else {
            System.out.println("Add ");
        }


    }

}
