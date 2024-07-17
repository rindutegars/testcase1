package com.rindu.testcase1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.ok("Proses generasi laporan dengan ID " + reportId + " telah dimulai.");
    }

    @GetMapping("/check-status/{reportId}")
    public ResponseEntity<String> checkReportStatus(@PathVariable String reportId) {
        // Logika untuk memeriksa status generasi laporan
        return ResponseEntity.ok("Laporan dengan ID " + reportId + " sedang digenerate...");
    }
}
