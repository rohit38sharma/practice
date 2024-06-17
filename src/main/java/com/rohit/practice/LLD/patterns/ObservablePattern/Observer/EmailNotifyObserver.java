package com.rohit.practice.LLD.patterns.ObservablePattern.Observer;

public class EmailNotifyObserver implements NotifyObserver{
    private String email;

    public EmailNotifyObserver(String email){
        this.email = email;
    }
    @Override
    public void update() {
        sendEmail();
    }

    private void sendEmail(){
        System.out.println("Stock is available.");
    }
}
