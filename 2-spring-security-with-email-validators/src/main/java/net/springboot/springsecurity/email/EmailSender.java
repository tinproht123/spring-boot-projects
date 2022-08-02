package net.springboot.springsecurity.email;

public interface EmailSender {
    void send(String to, String email);
}
