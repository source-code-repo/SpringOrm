package pkg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity mapping the PEOPLE table
 *
 */
@Entity
public class People {
    
    @Id
    private Integer employeeId;

    private String fullName;
    private String positionTitle;
    private String educationLevel;
    
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Dept department;
    
    @ManyToOne
    @JoinColumn(name = "POSITION_ID")
    private Roletype position;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public Dept getDepartment() {
        return department;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public Roletype getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "People [employeeId=" + employeeId + ", fullName=" + fullName + ", positionTitle=" + positionTitle
                + ", educationLevel=" + educationLevel + ", department=" + department
                + ", position=" + position + "]";
    }
}