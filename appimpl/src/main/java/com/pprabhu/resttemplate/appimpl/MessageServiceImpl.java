package com.pprabhu.resttemplate.appimpl;

import com.pprabhu.resttemplate.api.Message;
import com.pprabhu.resttemplate.api.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);

    private static String MESSAGE = "Bonjour";

    @Override
    public Message getMessage() {
        LOGGER.debug("#getMessage invoked, returning message {}", MESSAGE);
        Message message = new Message(MESSAGE);
        return message;
    }
}
