package ar.com.pablocaamano.blogapi.model;

import javax.persistence.*;

@Entity
@Table(name = "Authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAuthor;

    private String names;

    private String facebook;

    private String twitter;

    private String instagram;

    private String mail;

    private String telegram;

    private String biography;

    private Integer idRole;

    public String toString(){
        return "{'idAuthor': '" + idAuthor + "'," +
                "'names': '" + names + "'," +
                "'facebook': '" + facebook + "'," +
                "'twitter': '" + twitter + "'," +
                "'instagram': '" + instagram + "'," +
                "'mail': '" + mail + "'," +
                "'telegram': '" + telegram + "'," +
                "'biography': '" + biography + "'," +
                "'idRole': '" + idRole + "'}";
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }
}
