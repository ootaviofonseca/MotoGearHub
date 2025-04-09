package com.example.MotoGearHub.service;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import java.util.List;

public class OpenAIQuery {
    public static String getBrandInfo(String brand) {
        OpenAiService service = new OpenAiService(System.getenv("OPENAI_APIKEY"));

        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(List.of(
                        new ChatMessage("system", "You are an assistant at a motorcycle gear store (only clothing and equipment) who helps the customer learn more about a brand."),
                        new ChatMessage("user", "You receive the brand name and must provide a brief summary about the brand and its reputation: " + brand)
                ))
                .maxTokens(100)
                .temperature(0.7)
                .build();

        var response = service.createChatCompletion(request);
        return response.getChoices().get(0).getMessage().getContent();
    }
}