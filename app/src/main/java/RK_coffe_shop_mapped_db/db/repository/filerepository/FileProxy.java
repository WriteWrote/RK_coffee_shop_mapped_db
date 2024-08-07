package RK_coffe_shop_mapped_db.db.repository.filerepository;

import RK_coffe_shop_mapped_db.db.entity.FileMetadataEntity;
import RK_coffe_shop_mapped_db.dto.file.FileInfoDto;
import RK_coffe_shop_mapped_db.dto.file.FileWithContentDto;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Primary
@Repository
@AllArgsConstructor
public class FileProxy implements IFileRepository {
    private RealFileRepository realFileRepository;

    @Override
    public FileInfoDto save(FileWithContentDto fileWithContentDto) {
        System.out.println("Proxy was there");

        return realFileRepository.save(fileWithContentDto);
    }

    @Override
    public FileWithContentDto getContentById(UUID id) {
        System.out.println("Proxy was there");

        return realFileRepository.getContentById(id);
    }

    public FileMetadataEntity getInfoById(UUID id) {
        System.out.println("Proxy was there");

        return realFileRepository.getInfoById(id);
    }
}
