package by.tc.task.controller.command;

import by.tc.task.controller.command.help.*;
import by.tc.task.controller.constant.CommandParam;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Y50-70 on 19.11.2017.
 */
public class CommandDirector {
    private Map<String,Command> map = new HashMap<>();
    public CommandDirector(){
        map.put(CommandParam.CHANGE_LOCALE, new ChangeLocale());
        map.put(CommandParam.SIGN_IN, new SignIn());
        map.put(CommandParam.AFTER_REGISTRATION, new AfterRegistrationPage());
        map.put(CommandParam.CHANGE_PAGE, new ChangePage());
        map.put(CommandParam.SIGN_UP, new SignUp());
        map.put(CommandParam.SEND_CODE, new EmailCode());
        map.put(CommandParam.CHECK_CODE, new CheckCode());
        map.put(CommandParam.CHANGE_PASSWORD_BY_EMAIL, new ChangePasswordByEmail());
        map.put(CommandParam.SEARCH_BY_CATEGORY, new SearchByCategory());
    }
    public Command getCommand(String commandType){
        return  map.get(commandType);
    }
}
