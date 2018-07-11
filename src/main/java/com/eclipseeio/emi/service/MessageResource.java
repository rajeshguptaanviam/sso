package com.eclipseeio.emi.service;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

public class MessageResource {
    public static String MESSAGE_UPDATE;
    public static String MESSAGE_DELETE;
    public static String MESSAGE_CREATE;
    public static String MESSAGE_ADMIN_DELETE;
    public static String MESSAGE_EMAIL_NOT_EXIST;
    public static String ALREADY_SUBSCRIBED;
    public static String MESSAGE_FORGOT_PASSWORD_EMAIL_SENT;
    public static String MESSAGE_TOKEN_EXPIRED;
    public MessageResource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("messages/msg");
        messageSource.setDefaultEncoding("UTF-8");
        //refresh cache after every 500 mill-secs
        messageSource.setCacheMillis(500);

        MESSAGE_UPDATE = messageSource.getMessage("msg_update", null, Locale.US);
        MESSAGE_DELETE = messageSource.getMessage("msg_delete", null, Locale.US);
        MESSAGE_CREATE = messageSource.getMessage("msg_create", null, Locale.US);
        ALREADY_SUBSCRIBED = messageSource.getMessage("news_already_subscribed", null, Locale.US);
        MESSAGE_ADMIN_DELETE = messageSource.getMessage("msg_admin_delete", null, Locale.US);
        MESSAGE_EMAIL_NOT_EXIST = messageSource.getMessage("msg_email_not_exist", null, Locale.US);
        MESSAGE_FORGOT_PASSWORD_EMAIL_SENT =  messageSource.getMessage("msg_forget_password_email_sent", null, Locale.US);
        MESSAGE_TOKEN_EXPIRED =  messageSource.getMessage("msg_token_expired", null, Locale.US);
    }

}
