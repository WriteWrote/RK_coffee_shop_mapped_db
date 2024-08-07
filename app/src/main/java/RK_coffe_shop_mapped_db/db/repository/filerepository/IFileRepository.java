package RK_coffe_shop_mapped_db.db.repository.filerepository;

import RK_coffe_shop_mapped_db.db.entity.FileMetadataEntity;
import RK_coffe_shop_mapped_db.dto.file.FileInfoDto;
import RK_coffe_shop_mapped_db.dto.file.FileWithContentDto;

import java.util.UUID;

public interface IFileRepository {
    FileInfoDto save(FileWithContentDto fileWithContentDto);

    FileWithContentDto getContentById(UUID id);

    FileMetadataEntity getInfoById(UUID id);
//
//    void delete(UUID id);
}
