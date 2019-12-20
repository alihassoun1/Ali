package ali.com.controller;


import ali.com.dao.ProjectService;
import ali.com.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/potservice/project")
public class ProjectController  {
    HttpHeaders httpHeaders = new HttpHeaders();
    @Autowired
    ProjectService projectService;



    @PostMapping()
    public ResponseEntity<Project> addProject(@RequestBody Project project) {

        //return (ResponseEntity<Project>) super.add(project);
        projectService.addProject(project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping(path = "/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable("projectId") Integer projectId) {

        //return (ResponseEntity<Project>) super.get(projectId);
        Project project=projectService.getProject(projectId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Project>> getAllProjects() {

        //return (ResponseEntity<List<Project>>) super.getAll();
        List<Project> projects=(List<Project>) projectService.getAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping(path = "/getAllSorted")
    public @ResponseBody
    List<Project> getAllProjectsSorted() {

        return(List<Project>) projectService.getAllSorted();
    }

    @PutMapping(path = "/{projectId}/{customerId}")
    public ResponseEntity<Project> updateProject(@PathVariable("projectId") Integer projectId,@PathVariable("customerId") Integer customerId, @RequestBody Project project) {
       // return (ResponseEntity<Project>) super.update(project, projectId);
        projectService.updateProject(projectId,customerId,project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{projectId}")
    public ResponseEntity<Project> deleteProject(@PathVariable("projectId") Integer projectId) {
       // return (ResponseEntity<Project>) super.delete(projectId);
        Project project=projectService.getProject(projectId);
        projectService.deleteProject(projectId);
        return new ResponseEntity<>(project, HttpStatus.OK);

    }
}
