package model;
// Generated 30 ��� 2017 8:37:39 �� by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.Objects;

/**
 * Ticket generated by hbm2java
 */
public class Ticket  implements java.io.Serializable {


     private Integer ticketId;
     private Dromologio dromologio;
     private String ticketType;
     private String ticketTypeEkptosi;
     private Date ticketDateEkdosi;
     private String ticketCategoryEkdosis;
     private String ticketPrice;

    public Ticket() {
    }

    public Ticket(Dromologio dromologio, String ticketType, String ticketTypeEkptosi, Date ticketDateEkdosi, String ticketCategoryEkdosis, String ticketPrice) {
       this.dromologio = dromologio;
       this.ticketType = ticketType;
       this.ticketTypeEkptosi = ticketTypeEkptosi;
       this.ticketDateEkdosi = ticketDateEkdosi;
       this.ticketCategoryEkdosis = ticketCategoryEkdosis;
       this.ticketPrice = ticketPrice;
    }
   
    public Integer getTicketId() {
        return this.ticketId;
    }
    
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }
    public Dromologio getDromologio() {
        return this.dromologio;
    }
    
    public void setDromologio(Dromologio dromologio) {
        this.dromologio = dromologio;
    }
    public String getTicketType() {
        return this.ticketType;
    }
    
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    public String getTicketTypeEkptosi() {
        return this.ticketTypeEkptosi;
    }
    
    public void setTicketTypeEkptosi(String ticketTypeEkptosi) {
        this.ticketTypeEkptosi = ticketTypeEkptosi;
    }
    public Date getTicketDateEkdosi() {
        return this.ticketDateEkdosi;
    }
    
    public void setTicketDateEkdosi(Date ticketDateEkdosi) {
        this.ticketDateEkdosi = ticketDateEkdosi;
    }
    public String getTicketCategoryEkdosis() {
        return this.ticketCategoryEkdosis;
    }
    
    public void setTicketCategoryEkdosis(String ticketCategoryEkdosis) {
        this.ticketCategoryEkdosis = ticketCategoryEkdosis;
    }
    public String getTicketPrice() {
        return this.ticketPrice;
    }
    
    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    
    @Override
    public String toString() {
        return "Ticket{" + "ticketId=" + ticketId + ", dromologio=" + dromologio + ", ticketType=" + ticketType + ", ticketTypeEkptosi=" + ticketTypeEkptosi + ", ticketDateEkdosi=" + ticketDateEkdosi + ", ticketCategoryEkdosis=" + ticketCategoryEkdosis + ", ticketPrice=" + ticketPrice + '}';
    }




}


