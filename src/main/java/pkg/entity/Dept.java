package pkg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity mapping the DEPT table
 */
@Entity
public class Dept {
    
    @Id
    private Integer departmentId;
    private String departmentDescription;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    @Override
    public String toString() {
        return "Dept [departmentId=" + departmentId + ", departmentDescription=" + departmentDescription + "]";
    }
}