package ali.com.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "customer2")
@Getter
@Setter
public class Customer2 {


    @Id
    @GeneratedValue
    private Integer customerId;


    private String customerName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Project> projects;
}
