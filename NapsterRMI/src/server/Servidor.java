package server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Hashtable;

//import NapsterRMI.model.ServicoHora;
//import NapsterRMI.model.ServicoHoraImpl;
import NapsterRMI.model.ServicoNapster;
import NapsterRMI.model.ServicoNapsterImpl;

public class Servidor {

	public static void main(String[] args) throws Exception {
		//socker do servidor para comunicação TCP
		ServerSocket serverSocket = new ServerSocket(9000);
		//serverSocket.bind(new InetSocketAddress("127.0.0.1", 0));
		
		
		//RMI
		ServicoNapster sn = new ServicoNapsterImpl();
		LocateRegistry.createRegistry(1099);
		Registry reg = LocateRegistry.getRegistry();
		reg.bind("rmi://127.0.0.1/Napster", sn);
		
		System.out.println("Servidor no ar");
		


		while(true) {
			Socket no = serverSocket.accept();
			System.out.println("Conectou no server socket!");
		}
		
		
	}
}
