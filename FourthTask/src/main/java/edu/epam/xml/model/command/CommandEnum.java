package edu.epam.xml.model.command;

import edu.epam.xml.model.command.impl.ParsingCommand;

public enum CommandEnum {
    PARSE(new ParsingCommand());

    CommandEnum(Command currentCommand){
        command = currentCommand;
    }

    Command command;
    public Command getCommand(){
        return command;
    }

}
