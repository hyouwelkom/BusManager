package fr.unice.iut.info.coo;

import java.util.Date;

/**
 * Created by Virgile on 22/09/2017.
 * TU VOLES TU PAIES
 */
public class Message {

    private String content;
    private Date createdAt;

    public Message (String c) {
        this.content = c;
        this.createdAt = new Date();
    }

    public String toString() {
        return "Contenu : "+this.content+"\n Created at :"+this.createdAt;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }





}
