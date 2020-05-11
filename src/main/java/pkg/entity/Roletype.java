package pkg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity mapping the Roletype table
 *
 */
@Entity
public class Roletype {
    
    @Id
    @Column(name = "POSITION_ID")
    private Integer id;
    private String payType;

    public String getPayType() {
        return payType;
    }

    @Override
    public String toString() {
        return "Roletype [id=" + id + ", payType=" + payType + "]";
    }
}