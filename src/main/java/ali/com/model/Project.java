package ali.com.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "project")
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue
    private Integer projectId;

    private String projectName;

    private String projectRole;



    @Column(name="projectTeamSize")
    private Integer projectTeamSize;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}
