package github.antonybresolin.livechat.controller;

import github.antonybresolin.livechat.domain.ChatInput;
import github.antonybresolin.livechat.domain.ChatOutPut;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LiveChatController {

    @MessageMapping("/new-message")
    @SendTo("/topics/livechat")
    public ChatOutPut newChatMessage(ChatInput chatInput) {
        return new ChatOutPut(HtmlUtils.htmlEscape(chatInput.user() + ": "+ chatInput.message()));
    }
}
