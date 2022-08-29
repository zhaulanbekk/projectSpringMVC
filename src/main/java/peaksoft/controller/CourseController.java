package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Course;
import peaksoft.service.CompanyService;
import peaksoft.service.CourseService;

@Controller
@RequestMapping("/courses/{id}")
public class CourseController {
    private final CourseService courseService;
    private final CompanyService companyService;

    @Autowired
    public CourseController(CourseService courseService, CompanyService companyService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }

    @GetMapping
    public String allCourses(@PathVariable("id") Long id, Model model) {
        model.addAttribute("courses", courseService.getAllCourses(id));
        model.addAttribute("companyId", companyService.getCompanyById(id));
        return "course/allCourses";
    }


    @GetMapping("/add")
    public String addCourses(Model model, @PathVariable Long id) {
        // model.addAttribute("companyId", id);
//        model.addAttribute("companyId",companyService.getCompanyById(id));
        model.addAttribute("course", new Course());
        return "course/newCourse";
    }

    @PostMapping("/saveCourse")
    public String saveCourses(@ModelAttribute("course") Course course, @PathVariable("id") Long id) {
        Course course1 = courseService.courseService(course);
        course1.setCompany(companyService.getCompanyById(id));
        courseService.addCourse(id, course1);
        return "redirect:/courses/ "+id;
    }

    @GetMapping("/updateCourse")
    public String updateCourse(Model model,  @PathVariable Long id) {
       model.addAttribute("course",courseService.getCourseById(id)) ;
        return "/course/updateCourse";
    }
    @PostMapping("/editCourse")
    public String saveUpdateCourse(@PathVariable("id") Long id, @ModelAttribute Course course) {
        courseService.updateCourse(id, course);
        return "redirect:/courses/{id}";
    }
    @PostMapping("/delete")
    public String deleteCourse(@PathVariable Long id,Course course){
        courseService.deleteCourse(id,course );
        courseService.getCourseById(id);

        return "redirect:/course/allCourses";
    }

//    @GetMapping("/getCourse/{courseId}")
//    public String getCourseById(@PathVariable("courseId")Long id,Model model) {
//        model.addAttribute("course",courseService.getCourseById(id));
//        return "course/allCourses";
//    }
//
//
}












