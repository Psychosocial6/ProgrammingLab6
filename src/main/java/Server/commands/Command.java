package Server.commands;

import Server.interfaces.CommandInterface;
import Server.managers.CollectionManager;

/**
 * Базовый класс для всех команд
 * @author Андрей
 * */
public abstract class Command implements CommandInterface {

    protected static CollectionManager collectionManager;
    public boolean requiresVehicleObject;
    protected int simpleArgumentsRequired;

    /**
     * Конструктор
     * @param collectionManager - класс, управялющий коллекцией
     * @param simpleArgumentsRequired - количество необходимых простых аргументов
     *
     * */
    public Command(CollectionManager collectionManager, int simpleArgumentsRequired) {
        Command.collectionManager = collectionManager;
        requiresVehicleObject = false;
        this.simpleArgumentsRequired = simpleArgumentsRequired;
    }

    /**
     * Метод возвращающий количество простых аргументов
     * @return simpleArgumentsRequired
     * */
    public int getSimpleArgumentsRequired() {
        return simpleArgumentsRequired;
    }

    /**
     * Метод возвращающий класс, управляющий коллекцией
     * @return collectionManager
     * */
    public static CollectionManager getCollectionManager() {
        return collectionManager;
    }
}
