package RK_coffe_shop_mapped_db.db.repository.filerepository;

import RK_coffe_shop_mapped_db.dto.file.FileInfoDto;
import RK_coffe_shop_mapped_db.dto.file.FileWithContentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FileProxy implements IFileRepository {
    private RealFileRepository realFileRepository;

//    public FileProxy() {
//        this.realFileRepository = RealFileRepository.getInstanse();
//    }

    @Override
    public FileInfoDto save(FileWithContentDto fileWithContentDto) {
        System.out.println("Proxy was there");


        return realFileRepository.save(fileWithContentDto);
    }
}
