/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpi_get_email_status;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Federico
 */
public class RPI_Get_Email_Status {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new RPI_Get_Email_Status().start();
    }
    
    public void start() throws IOException, ClassNotFoundException{
    
        Socket socket = new Socket("localhost",30007);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        
        oos.writeObject("get status");
        boolean status = (boolean) ois.readObject();
        System.out.println(status);
        oos.close();
        ois.close();
        socket.close();
        
    }
    
}
