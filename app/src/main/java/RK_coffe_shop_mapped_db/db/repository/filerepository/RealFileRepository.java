package RK_coffe_shop_mapped_db.db.repository.filerepository;

import RK_coffe_shop_mapped_db.dto.file.FileInfoDto;
import RK_coffe_shop_mapped_db.dto.file.FileWithContentDto;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

@Slf4j
public class RealFileRepository implements IFileRepository {
    private final Path saveDir;

    public RealFileRepository(String saveDir) {
        this(Path.of(saveDir));
    }

    public RealFileRepository(Path saveDir) {
        if (Files.isDirectory(saveDir)) {
            this.saveDir = saveDir;
        } else {
            log.warn("Custom root path is invalid, assigning default root path.");
            this.saveDir = Path.of("D:\\Projects\\trash");
        }
    }

    @Override
    public FileInfoDto save(FileWithContentDto fileWithContentDto) {
        /**
         * saving file:
         * 1. generate UUID
         * 2. generate path: rootpath + filepath + {fileid as name}
         * 3. save recording to table: uuid, path, extension
         * 4. save file to disk
         */

//        try (InputStream file = fileWithContentDto.getInputStream()) {
//            Path dirPath = rootPath.resolve(uuid.toString());
//            if (!Files.exists(dirPath)) {
//                Files.createDirectory(dirPath);
//            }
//            Path filePath = dirPath.resolve(uuid.toString());
//            Path metaData = dirPath.resolve(METADATA_TXT);
//            Files.copy(file, filePath);
//            Files.writeString(metaData, request.contentType(), StandardOpenOption.CREATE);
//            return new FileResponse(dirPath, dirPath.getFileName().toString(), LocalDateTime.now(), request.contentType(), file);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        return null;
    }
}
