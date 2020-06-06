package com.pprabhu.resttemplate.appimpl;

import com.pprabhu.resttemplate.api.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private static String MESSAGE = "Bonjour";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
