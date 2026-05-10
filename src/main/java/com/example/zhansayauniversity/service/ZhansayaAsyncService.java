package com.example.zhansayauniversity.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class ZhansayaAsyncService {

    /**
     * Процесс 1: Имитация отправки приветственного письма.
     * Аннотация @Async заставляет метод выполняться в отдельном потоке.
     */
    @Async
    public void sendWelcomeEmail(String studentName) {
        try {
            // Имитируем долгую отправку (3 секунды)
            Thread.sleep(3000);
            System.out.println("Async Process 1: Welcome email sent to " + studentName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Async email process was interrupted");
        }
    }

    /**
     * Процесс 2: Имитация асинхронного логирования действий.
     */
    @Async
    public void logActionAsync(String action) {
        System.out.println("Async Process 2: Action '" + action + "' recorded at " + System.currentTimeMillis());
    }

    /**
     * Процесс 3: Пример использования CompletableFuture (требование из задания).
     * Это позволяет вернуть результат из асинхронного метода.
     */
    @Async
    public CompletableFuture<String> generateHeavyReport(String reportName) {
        try {
            Thread.sleep(2000); // Имитация генерации отчета
            String result = "Report '" + reportName + "' is ready!";
            return CompletableFuture.completedFuture(result);
        } catch (InterruptedException e) {
            return CompletableFuture.failedFuture(e);
        }
    }
}