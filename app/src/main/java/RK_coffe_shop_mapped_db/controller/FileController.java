package RK_coffe_shop_mapped_db.controller;

import RK_coffe_shop_mapped_db.dto.file.FileInfoDto;
import RK_coffe_shop_mapped_db.dto.file.FileWithContentDto;
import RK_coffe_shop_mapped_db.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

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

    /**
     * upload
     * download
     * delete
     * getByName
     * filter
     */
}
