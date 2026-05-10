package com.example.zhansayauniversity.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/zhansaya/files")
public class ZhansayaFileController {

    /**
     * Эндпоинт для загрузки файла (UPLOAD)
     * В учебных целях мы просто подтверждаем получение файла.
     */
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload.");
        }

        String fileName = file.getOriginalFilename();
        long size = file.getSize();

        return ResponseEntity.ok("File '" + fileName + "' (" + size + " bytes) uploaded successfully by Zhansaya!");
    }

    /**
     * Эндпоинт для скачивания файла (DOWNLOAD)
     * Мы генерируем текстовый файл "на лету" и отдаем его пользователю.
     */
    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile() {
        String content = "This is a report from Zhansaya University Management System.";
        byte[] data = content.getBytes();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"zhansaya_report.txt\"")
                .contentType(MediaType.TEXT_PLAIN)
                .contentLength(data.length)
                .body(data);
    }
}