package com.rindu.testcase1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rindu.testcase1.service.ReportService;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateReport(@RequestParam String reportId) {
        reportService.generateReport(reportId);
        return ResponseEntity.ok("Generate laporan dengan ID " + reportId + " sedang di proses");
    }

    @GetMapping("/check-status/{reportId}")
    public ResponseEntity<String> checkReportStatus(@PathVariable String reportId) {
        String status = reportService.getReportStatus(reportId);
        return ResponseEntity.ok("Status laporan dengan ID " + reportId + ": " + status);
    }
}
