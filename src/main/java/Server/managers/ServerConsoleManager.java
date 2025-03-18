package Server.managers;

import extra.exceptions.ExecutionException;
import extra.utils.Invoker;

import java.io.File;
import java.util.Scanner;

public class ServerConsoleManager {
    private Invoker invoker;

    public ServerConsoleManager(Invoker invoker) {
        this.invoker = invoker;
    }

    public void readConsole() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String[] input;

            if (scanner.hasNext()) {

                input = scanner.nextLine().split("\s+");
                String commandToken = input[0];

                switch (commandToken) {
                    case "exit":
                        Object[] args = {"src/main/java/Server/files/savedCollection.xml"};
                        try {
                            invoker.executeCommandUsingToken("save", args);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        System.exit(0);
                        break;

                }
            }
        }
    }
}
