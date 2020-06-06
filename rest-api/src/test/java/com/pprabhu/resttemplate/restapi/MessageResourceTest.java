package com.pprabhu.resttemplate.restapi;

import com.pprabhu.resttemplate.api.MessageService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@AutoConfigureMockMvc
@ContextConfiguration(classes = {MessageService.class})
@WebMvcTest
public class MessageResourceTest {

    @Mock
    private MessageService messageService;

    @InjectMocks
    private MessageResource messageResource;

    @Test
    public void testGetMessage() {
        String testMessage = "Hello message";
        Mockito.when(messageService.getMessage()).thenReturn(testMessage);
        String message = messageResource.getMessage();
        assertThat(message, is(testMessage));
    }
}
