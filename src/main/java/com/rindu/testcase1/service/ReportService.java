package com.rindu.testcase1.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Async
    public void generateReport(String reportId) {
        // Simulasi generate laporan
        try {
            Thread.sleep(10000); // 10 detik
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // Laporan selesai digenerate
        System.out.println("Laporan dengan ID " + reportId + " berhasil digenerate.");
    }
}
