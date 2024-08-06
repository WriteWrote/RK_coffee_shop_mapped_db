package RK_coffe_shop_mapped_db.db.repository.filerepository;

import RK_coffe_shop_mapped_db.dto.file.FileInfoDto;
import RK_coffe_shop_mapped_db.dto.file.FileWithContentDto;

import java.util.UUID;

public interface IFileRepository {
    FileInfoDto save(FileWithContentDto fileWithContentDto);

//    FileWithContentDto getById();
//
//    void delete(UUID id);
}
