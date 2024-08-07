package RK_coffe_shop_mapped_db.service;

import RK_coffe_shop_mapped_db.db.repository.filerepository.IFileRepository;
import RK_coffe_shop_mapped_db.dto.file.FileInfoDto;
import RK_coffe_shop_mapped_db.dto.file.FileWithContentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FileService {
    private IFileRepository fileRepository;

    public FileInfoDto writeFileInMemory(FileWithContentDto fileWithContentDto) {
        return fileRepository.saveContentById(fileWithContentDto);
    }

    public FileInfoDto getFileInfoById(UUID id) {
        var storedInfo = fileRepository.getInfoById(id);
        return new FileInfoDto(
                storedInfo.getId(),
                storedInfo.getFilepath()
        );
    }

    public FileWithContentDto getFileContentById(UUID id) {
        return fileRepository.getContentById(id);
    }

    public void deleteFileById(UUID id) {
        fileRepository.deleteContentById(id);
    }
}
