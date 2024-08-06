package RK_coffe_shop_mapped_db.db.repository.filerepository;

import RK_coffe_shop_mapped_db.db.entity.FileMetadataEntity;
import RK_coffe_shop_mapped_db.db.repository.CommonCrudRepository;
import RK_coffe_shop_mapped_db.db.repository.rowmapper.FileMetadataRowMapper;
import RK_coffe_shop_mapped_db.dto.file.FileInfoDto;
import RK_coffe_shop_mapped_db.dto.file.FileWithContentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
public class RealFileRepository extends CommonCrudRepository<FileMetadataEntity, UUID> implements IFileRepository {
    private final Path rootSaveDir;

    public RealFileRepository(Path rootSaveDir) {
        super("file_metadata", new JdbcTemplate(), new FileMetadataRowMapper());
        if (Files.isDirectory(rootSaveDir)) {
            this.rootSaveDir = rootSaveDir;
        } else {
            log.warn("Custom root path is invalid, assigning default root path.");
            this.rootSaveDir = Path.of("D:\\Projects\\trash");
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

        try (InputStream file = fileWithContentDto.getInputStream()) {
            UUID generatedId = UUID.randomUUID();
            Path generatedPath = this.rootSaveDir.resolve(fileWithContentDto.getPath())
                    .resolve(generatedId.toString())
                    .resolve(".")
                    .resolve(fileWithContentDto.getExtension());
            save(new FileMetadataEntity(
                    generatedId,
                    generatedPath.toString(),
                    fileWithContentDto.getExtension()
            ));
            Files.copy(file, generatedPath);
            return new FileInfoDto(generatedId, generatedPath.toString(), LocalDateTime.now().toString());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
