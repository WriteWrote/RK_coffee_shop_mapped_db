package RK_coffe_shop_mapped_db.service;

import RK_coffe_shop_mapped_db.db.repository.filerepository.IFileRepository;
import RK_coffe_shop_mapped_db.dto.file.FileInfoDto;
import RK_coffe_shop_mapped_db.dto.file.FileWithContentDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class FileService {
    private IFileRepository fileRepository;

    public FileInfoDto writeFileInMemory(FileWithContentDto fileWithContentDto) {
        // there goes work with factorybean?

        return fileRepository.save(fileWithContentDto);
    }
}
