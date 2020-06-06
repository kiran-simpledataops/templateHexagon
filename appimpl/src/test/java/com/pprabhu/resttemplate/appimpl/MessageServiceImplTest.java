package com.pprabhu.resttemplate.appimpl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class MessageServiceImplTest {

    @InjectMocks
    private MessageServiceImpl messageService;

    @BeforeEach
    public void setup() {

        System.out.println("Running for each");
        String message = messageService.getMessage();
        assertThat(message, is("Bonjour"));
    }

    @Test
    public void testGetMessage() {

        System.out.println("Running the test");

    }

}
