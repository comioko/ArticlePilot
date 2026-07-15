package github.comioko.articlepilot.AI;

import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

/**
 * @author comioko
 * @version 1.0
 * @className TestAlibailian
 * @since 1.0
 */
@SpringBootTest
public class TestBaiLian {

    @Resource
    private DashScopeChatModel chatModel;

    @Test
    public void testBaiLian() {
        String response = chatModel.call("来介绍一下你自己");
        System.out.println(response);

        //流式调用
        Flux<ChatResponse> streamResponse = chatModel.stream(
                new Prompt("用一句话介绍一下Spring ai")
        );

        streamResponse.subscribe(chunk ->
                System.out.print(chunk.getResult().getOutput().getText())
        );
    }
}
