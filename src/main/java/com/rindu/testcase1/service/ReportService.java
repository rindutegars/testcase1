package com.rindu.testcase1.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class ReportService {

    private final ConcurrentHashMap<String, String> reportStatus = new ConcurrentHashMap<>();

    @Async
    public void generateReport(String reportId) {
        // Simulasi proses generasi laporan
        try {
            reportStatus.put(reportId, "Sedang digenerate"); // kalau berhasil ke case 1
            Thread.sleep(10000); // Simulasi proses generasi laporan selama 10 detik
            reportStatus.put(reportId, "Berhasil digenerate");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            reportStatus.put(reportId, "Gagal digenerate");
        }
    }

    public String getReportStatus(String reportId) {
        return reportStatus.getOrDefault(reportId, "Tidak ditemukan");
    }
}
