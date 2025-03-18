package Server;

import Server.managers.CollectionManager;
import Server.managers.ServerConsoleManager;
import Server.threads.ConsoleThread;
import extra.utils.FileReader;
import extra.utils.Invoker;
import extra.utils.XMLDeserializer;

import java.io.File;
import java.io.FileNotFoundException;

public class Server {
    public static void main(String[] args) {
        File inputFile = new File("src/main/java/Server/files/input.xml");
        CollectionManager collectionManager = new CollectionManager();
        try {
            collectionManager = XMLDeserializer.deserializeFromXML(FileReader.readFile(inputFile));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Invoker invoker = new Invoker(collectionManager);
        UDPServer udpServer = new UDPServer(2222, 65507, invoker);
        ServerConsoleManager consoleManager = new ServerConsoleManager(invoker);
        ConsoleThread consoleThread = new ConsoleThread(consoleManager);
        consoleThread.start();
        udpServer.startServer();
    }
}
