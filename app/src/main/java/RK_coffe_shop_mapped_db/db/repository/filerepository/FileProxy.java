package RK_coffe_shop_mapped_db.db.repository.filerepository;

import RK_coffe_shop_mapped_db.dto.file.FileInfoDto;
import RK_coffe_shop_mapped_db.dto.file.FileWithContentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileProxy implements IFileRepository {
    private RealFileRepository realFileRepository;

    @Override
    public FileInfoDto save(FileWithContentDto fileWithContentDto) {
        //do smth


        return realFileRepository.save(fileWithContentDto);
    }
}
