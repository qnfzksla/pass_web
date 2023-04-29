package com.qnfzksla.pass.controller.admin;

import com.qnfzksla.pass.service.packaze.PackageService;
import com.qnfzksla.pass.service.pass.BulkPassService;
import com.qnfzksla.pass.service.statistics.StatisticsService;
import com.qnfzksla.pass.service.user.UserGroupMappingService;
import com.qnfzksla.pass.util.LocalDateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/admin")
public class AdminViewController {

    @Autowired
    private BulkPassService bulkPassService;
    @Autowired
    private PackageService packageService;
    @Autowired
    private UserGroupMappingService userGroupMappingService;
    @Autowired
    private StatisticsService statisticsService;

    @GetMapping
    public ModelAndView home(ModelAndView modelAndView, @RequestParam("to") String toString) {
        LocalDateTime to = LocalDateTimeUtils.parseDate(toString);

        modelAndView.addObject("chartData", statisticsService.makeChartData(to));
        modelAndView.setViewName("admin/index");
        return modelAndView;
    }

    @GetMapping("/bulk-pass")
    public ModelAndView registerBulkPass(ModelAndView modelAndView) {
        modelAndView.addObject("bulkPasses", bulkPassService.getAllBulkPasses());
        modelAndView.addObject("packages", packageService.getAllPackages());
        modelAndView.addObject("userGroupIds", userGroupMappingService.getAllUserGroupIds());
        modelAndView.addObject("request", new BulkPassRequest());
        modelAndView.setViewName("admin/bulk-pass");

        return modelAndView;
    }

    @PostMapping("/bulk-pass")
    public String addBulkPass(@ModelAttribute("request") BulkPassRequest request, Model model) {
        bulkPassService.addBulkPass(request);
        return "redirect:/admin/bulk-pass";
    }
}
