package model;
// Generated 30 ��� 2017 8:37:39 �� by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.Objects;

/**
 * Dema generated by hbm2java
 */
public class Dema  implements java.io.Serializable {


     private Integer demaId;
     private Dromologio dromologio;
     private Date demaDateApostoli;
     private String demaLastnameApostolea;
     private String demaFirstnameApostolea;
     private String demaLastnameParalipti;
     private String demaFirstnameParalipti;
     private int demaTemaxia;
     private String demaBaros;
     private String demaPrice;

    public Dema() {
    }

    public Dema(Dromologio dromologio, Date demaDateApostoli, String demaLastnameApostolea, String demaFirstnameApostolea, String demaLastnameParalipti, String demaFirstnameParalipti, int demaTemaxia, String demaBaros, String demaPrice) {
       this.dromologio = dromologio;
       this.demaDateApostoli = demaDateApostoli;
       this.demaLastnameApostolea = demaLastnameApostolea;
       this.demaFirstnameApostolea = demaFirstnameApostolea;
       this.demaLastnameParalipti = demaLastnameParalipti;
       this.demaFirstnameParalipti = demaFirstnameParalipti;
       this.demaTemaxia = demaTemaxia;
       this.demaBaros = demaBaros;
       this.demaPrice = demaPrice;
    }
   
    public Integer getDemaId() {
        return this.demaId;
    }
    
    public void setDemaId(Integer demaId) {
        this.demaId = demaId;
    }
    public Dromologio getDromologio() {
        return this.dromologio;
    }
    
    public void setDromologio(Dromologio dromologio) {
        this.dromologio = dromologio;
    }
    public Date getDemaDateApostoli() {
        return this.demaDateApostoli;
    }
    
    public void setDemaDateApostoli(Date demaDateApostoli) {
        this.demaDateApostoli = demaDateApostoli;
    }
    public String getDemaLastnameApostolea() {
        return this.demaLastnameApostolea;
    }
    
    public void setDemaLastnameApostolea(String demaLastnameApostolea) {
        this.demaLastnameApostolea = demaLastnameApostolea;
    }
    public String getDemaFirstnameApostolea() {
        return this.demaFirstnameApostolea;
    }
    
    public void setDemaFirstnameApostolea(String demaFirstnameApostolea) {
        this.demaFirstnameApostolea = demaFirstnameApostolea;
    }
    public String getDemaLastnameParalipti() {
        return this.demaLastnameParalipti;
    }
    
    public void setDemaLastnameParalipti(String demaLastnameParalipti) {
        this.demaLastnameParalipti = demaLastnameParalipti;
    }
    public String getDemaFirstnameParalipti() {
        return this.demaFirstnameParalipti;
    }
    
    public void setDemaFirstnameParalipti(String demaFirstnameParalipti) {
        this.demaFirstnameParalipti = demaFirstnameParalipti;
    }
    public int getDemaTemaxia() {
        return this.demaTemaxia;
    }
    
    public void setDemaTemaxia(int demaTemaxia) {
        this.demaTemaxia = demaTemaxia;
    }
    public String getDemaBaros() {
        return this.demaBaros;
    }
    
    public void setDemaBaros(String demaBaros) {
        this.demaBaros = demaBaros;
    }
    public String getDemaPrice() {
        return this.demaPrice;
    }
    
    public void setDemaPrice(String demaPrice) {
        this.demaPrice = demaPrice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.demaId);
        hash = 17 * hash + Objects.hashCode(this.dromologio);
        hash = 17 * hash + Objects.hashCode(this.demaDateApostoli);
        hash = 17 * hash + Objects.hashCode(this.demaLastnameApostolea);
        hash = 17 * hash + Objects.hashCode(this.demaFirstnameApostolea);
        hash = 17 * hash + Objects.hashCode(this.demaLastnameParalipti);
        hash = 17 * hash + Objects.hashCode(this.demaFirstnameParalipti);
        hash = 17 * hash + this.demaTemaxia;
        hash = 17 * hash + Objects.hashCode(this.demaBaros);
        hash = 17 * hash + Objects.hashCode(this.demaPrice);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dema other = (Dema) obj;
        if (this.demaTemaxia != other.demaTemaxia) {
            return false;
        }
        if (!Objects.equals(this.demaLastnameApostolea, other.demaLastnameApostolea)) {
            return false;
        }
        if (!Objects.equals(this.demaFirstnameApostolea, other.demaFirstnameApostolea)) {
            return false;
        }
        if (!Objects.equals(this.demaLastnameParalipti, other.demaLastnameParalipti)) {
            return false;
        }
        if (!Objects.equals(this.demaFirstnameParalipti, other.demaFirstnameParalipti)) {
            return false;
        }
        if (!Objects.equals(this.demaBaros, other.demaBaros)) {
            return false;
        }
        if (!Objects.equals(this.demaPrice, other.demaPrice)) {
            return false;
        }
        if (!Objects.equals(this.demaId, other.demaId)) {
            return false;
        }
        if (!Objects.equals(this.dromologio, other.dromologio)) {
            return false;
        }
        if (!Objects.equals(this.demaDateApostoli, other.demaDateApostoli)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dema{" + "demaId=" + demaId + ", dromologio=" + dromologio + ", demaDateApostoli=" + demaDateApostoli + ", demaLastnameApostolea=" + demaLastnameApostolea + ", demaFirstnameApostolea=" + demaFirstnameApostolea + ", demaLastnameParalipti=" + demaLastnameParalipti + ", demaFirstnameParalipti=" + demaFirstnameParalipti + ", demaTemaxia=" + demaTemaxia + ", demaBaros=" + demaBaros + ", demaPrice=" + demaPrice + '}';
    }




}

