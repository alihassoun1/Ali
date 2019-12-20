package ali.com.dao;

import ali.com.model.Customer;
import ali.com.model.Project;
import ali.com.repository.CustomerRepository;
import ali.com.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;
    CustomerRepository customerRepository;


    public Project addProject(Project project) {

        projectRepository.save(project);
        return project;
    }

    public Project getProject(Integer projectId)
    {
        //Optional<Customer> customer=customerRepository.findById(customerId);
        //return customer.get();
        return projectRepository.findById(projectId).get();

    }


    public Iterable<Project> getAll() { return projectRepository.findAll(); }

    public Iterable<Project> getAllSorted() { return projectRepository.findAll(Sort.by("projectName")); }

    public Project updateProject(Integer projectId,Integer customerId,Project newProject){

        Project oldProject =projectRepository.findById(projectId).get();
        Customer customer = customerRepository.findById(customerId).get();
        oldProject.setProjectName(newProject.getProjectName());
        oldProject.setProjectRole(newProject.getProjectRole());
        oldProject.setProjectTeamSize(newProject.getProjectTeamSize());
        oldProject.setCustomer(customer);
        projectRepository.save(oldProject);
        return newProject;
    }

    public void deleteProject(Integer projectId)
    {

        projectRepository.deleteById(projectId);
    }


}
