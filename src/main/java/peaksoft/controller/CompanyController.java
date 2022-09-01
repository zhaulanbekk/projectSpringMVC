package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Company;
import peaksoft.service.CompanyService;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public String allCompany(Model model) {
        model.addAttribute("companies", companyService.getAllCompany());
        return "/company/allCompany";
    }

    @GetMapping("/new")
    public String newCompany(Model model) {
        model.addAttribute("company", new Company());
        return "company/newCompany";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.addCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("/update/{id}")
    public String updateCompany(Model model, @PathVariable("id") Long id) {
        model.addAttribute("company", companyService.getCompanyById(id));
        return "company/updateCompany";
    }

    @PostMapping("{id}/updateCompany")
    public String saveUpdateCompany(@ModelAttribute("company") Company company,
                                    @PathVariable("id") Long id) {
        companyService.updateCompany(id, company);
        return "redirect:/companies";
    }

    @PostMapping("/delete/{id}")
    public String deleteCompany(@PathVariable("id") Long id) {
        companyService.deleteCompany(id);
        return "redirect:/companies";
    }

}
