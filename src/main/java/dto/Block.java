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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Piero
 */
@Entity
@Table(name = "block")
@NamedQueries({
    @NamedQuery(name = "Block.findAll", query = "SELECT b FROM Block b"),
    @NamedQuery(name = "Block.findById", query = "SELECT b FROM Block b WHERE b.id = :id"),
    @NamedQuery(name = "Block.findByHash", query = "SELECT b FROM Block b WHERE b.hash = :hash"),
    @NamedQuery(name = "Block.findByPreviousHash", query = "SELECT b FROM Block b WHERE b.previousHash = :previousHash"),
    @NamedQuery(name = "Block.findByNonce", query = "SELECT b FROM Block b WHERE b.nonce = :nonce"),
    @NamedQuery(name = "Block.findByTimestamp", query = "SELECT b FROM Block b WHERE b.timestamp = :timestamp")})
public class Block implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "data")
    private String data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "hash")
    private String hash;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "previous_hash")
    private String previousHash;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nonce")
    private int nonce;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public Block() {
    }

    public Block(Integer id) {
        this.id = id;
    }

    public Block(Integer id, String data, String hash, String previousHash, int nonce, Date timestamp) {
        this.id = id;
        this.data = data;
        this.hash = hash;
        this.previousHash = previousHash;
        this.nonce = nonce;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Block)) {
            return false;
        }
        Block other = (Block) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Block[ id=" + id + " ]";
    }
    
}
