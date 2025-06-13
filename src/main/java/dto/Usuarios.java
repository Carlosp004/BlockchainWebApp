/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wilbert
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByCodiUsua", query = "SELECT u FROM Usuarios u WHERE u.codiUsua = :codiUsua"),
    @NamedQuery(name = "Usuarios.findByNdniUsua", query = "SELECT u FROM Usuarios u WHERE u.ndniUsua = :ndniUsua"),
    @NamedQuery(name = "Usuarios.findByAppaUsua", query = "SELECT u FROM Usuarios u WHERE u.appaUsua = :appaUsua"),
    @NamedQuery(name = "Usuarios.findByApmaUsua", query = "SELECT u FROM Usuarios u WHERE u.apmaUsua = :apmaUsua"),
    @NamedQuery(name = "Usuarios.findByNombUsua", query = "SELECT u FROM Usuarios u WHERE u.nombUsua = :nombUsua"),
    @NamedQuery(name = "Usuarios.findByFechNaciUsua", query = "SELECT u FROM Usuarios u WHERE u.fechNaciUsua = :fechNaciUsua"),
    @NamedQuery(name = "Usuarios.findByLogiUsua", query = "SELECT u FROM Usuarios u WHERE u.logiUsua = :logiUsua"),
    @NamedQuery(name = "Usuarios.validar", query = "SELECT u FROM Usuarios u WHERE u.logiUsua = :logiUsua and u.passUsua = :passUsua"),
    @NamedQuery(name = "Usuarios.findByPassUsua", query = "SELECT u FROM Usuarios u WHERE u.passUsua = :passUsua")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codiUsua")
    private Integer codiUsua;
    @Size(max = 50)
    @Column(name = "ndniUsua")
    private String ndniUsua;
    @Size(max = 50)
    @Column(name = "appaUsua")
    private String appaUsua;
    @Size(max = 50)
    @Column(name = "apmaUsua")
    private String apmaUsua;
    @Size(max = 50)
    @Column(name = "nombUsua")
    private String nombUsua;
    @Column(name = "fechNaciUsua")
    @Temporal(TemporalType.DATE)
    private Date fechNaciUsua;
    @Size(max = 100)
    @Column(name = "logiUsua")
    private String logiUsua;
    @Size(max = 500)
    @Column(name = "passUsua")
    private String passUsua;

    public Usuarios() {
    }

    public Usuarios(Integer codiUsua, String logiUsua, String passUsua) {
        this.codiUsua = codiUsua;
        this.logiUsua = logiUsua;
        this.passUsua = passUsua;
    }
    
    

    public Usuarios(Integer codiUsua) {
        this.codiUsua = codiUsua;
    }

    public Integer getCodiUsua() {
        return codiUsua;
    }

    public void setCodiUsua(Integer codiUsua) {
        this.codiUsua = codiUsua;
    }

    public String getNdniUsua() {
        return ndniUsua;
    }

    public void setNdniUsua(String ndniUsua) {
        this.ndniUsua = ndniUsua;
    }

    public String getAppaUsua() {
        return appaUsua;
    }

    public void setAppaUsua(String appaUsua) {
        this.appaUsua = appaUsua;
    }

    public String getApmaUsua() {
        return apmaUsua;
    }

    public void setApmaUsua(String apmaUsua) {
        this.apmaUsua = apmaUsua;
    }

    public String getNombUsua() {
        return nombUsua;
    }

    public void setNombUsua(String nombUsua) {
        this.nombUsua = nombUsua;
    }

    public Date getFechNaciUsua() {
        return fechNaciUsua;
    }

    public void setFechNaciUsua(Date fechNaciUsua) {
        this.fechNaciUsua = fechNaciUsua;
    }

    public String getLogiUsua() {
        return logiUsua;
    }

    public void setLogiUsua(String logiUsua) {
        this.logiUsua = logiUsua;
    }

    public String getPassUsua() {
        return passUsua;
    }

    public void setPassUsua(String passUsua) {
        this.passUsua = passUsua;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiUsua != null ? codiUsua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.codiUsua == null && other.codiUsua != null) || (this.codiUsua != null && !this.codiUsua.equals(other.codiUsua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Usuarios[ codiUsua=" + codiUsua + " ]";
    }
    
}
