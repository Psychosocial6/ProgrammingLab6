package Server.commands;

import Server.managers.CollectionManager;

/**
 * Класс команды помощи
 * @author Андрей
 * */
public class CommandHelp extends Command{

    /**
     * Конструктор
     * @param collectionManager - класс управляющий коллекцией
     * */
    public CommandHelp(CollectionManager collectionManager) {
        super(collectionManager, 0);
    }

    /**
     * Метод реализующий исполнение команды
     * @param args - массив аргументов команды
     * */
    @Override
    public String execute(Object[] args) {
        String msg = "";
        for (Object command: args) {
            msg += ((Command) command).getInfo() + "\n";
        }
        return msg;
    }

    /**
     * Метод возвращающий информацию о команде
     * @return String info
     * */
    @Override
    public String getInfo() {
        return "help: вывести справку по доступным командам";
    }
}
