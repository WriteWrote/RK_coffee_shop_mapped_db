package RK_coffe_shop_mapped_db.controller;

import RK_coffe_shop_mapped_db.dto.file.FileInfoDto;
import RK_coffe_shop_mapped_db.dto.file.FileWithContentDto;
import RK_coffe_shop_mapped_db.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<FileInfoDto> upload(@RequestParam("file") MultipartFile file, @RequestParam("extension") String extension) {
        try {
            return new ResponseEntity<>(
                    fileService.writeFileInMemory(new FileWithContentDto(
                            file.getInputStream(),
                            extension
                    )),
                    HttpStatus.CREATED
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<FileWithContentDto> download(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(
                fileService.getFileContentById(id),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}/info")
    public ResponseEntity<FileInfoDto> getFileInfo(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(
                fileService.getFileInfoById(id),
                HttpStatus.OK
        );
    }

    /**
     * upload
     * download
     * delete
     * getByName
     * filter
     */
}
