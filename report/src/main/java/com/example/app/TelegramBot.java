package com.example.app;

import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends AbilityBot {

    public TelegramBot() {
        super("6204788370:AAF6e1a-BcCoLJtGCdsVHyEQHkcUyyJI_rU", "locomotive_notification_bot");
    }

    @Override
    public long creatorId() {
        return 1L;
    }

    public void sendTextMessage(String chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}