package RK_coffe_shop_mapped_db.db.repository.filerepository;

import RK_coffe_shop_mapped_db.db.entity.FileMetadataEntity;
import RK_coffe_shop_mapped_db.db.repository.CommonCrudRepository;
import RK_coffe_shop_mapped_db.db.repository.rowmapper.FileMetadataRowMapper;
import RK_coffe_shop_mapped_db.dto.file.FileInfoDto;
import RK_coffe_shop_mapped_db.dto.file.FileWithContentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileSystemUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Repository
public class RealFileRepository extends CommonCrudRepository<FileMetadataEntity, UUID> implements IFileRepository {
    @Value("${root-dir}")
    private String rootSaveDir;

    @Autowired
    public RealFileRepository(JdbcTemplate jdbcTemplate, FileMetadataRowMapper fileMetadataRowMapper) {
        super("file_metadata", jdbcTemplate, fileMetadataRowMapper);
    }

    @Override
    public FileInfoDto saveContentById(FileWithContentDto fileWithContentDto) {
        try (InputStream file = fileWithContentDto.getInputStream()) {
            UUID generatedId = UUID.randomUUID();
            Path generatedPath = Paths.get(
                    this.rootSaveDir
            );

            if (!Files.isDirectory(generatedPath)) {
                Files.createDirectory(generatedPath);
            }

            generatedPath = generatedPath.resolve(generatedId + fileWithContentDto.getExtension());
            Files.write(generatedPath, file.readAllBytes(), StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);

            save(new FileMetadataEntity(
                    generatedId,
                    generatedPath.toString(),
                    fileWithContentDto.getExtension()
            ));

            return new FileInfoDto(generatedId, generatedPath.toString()
//                    , LocalDateTime.now().toString()
            );
        } catch (Exception e) {
            throw new RuntimeException();       //todo change to cannotsavefile custom exeption
        }
    }

    @Override
    public FileWithContentDto getContentById(UUID id) {
        var fileMetadata = getInfoById(id);
        var path = Path.of(fileMetadata.getFilepath());

        if (!Files.isReadable(path)) {
            throw new RuntimeException();   //todo change to notfoundfile custom ex
        }

        try {
            var content = Files.readAllBytes(path);
            return new FileWithContentDto(
                    new ByteArrayInputStream(content),
                    fileMetadata.getFileExtension()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FileMetadataEntity getInfoById(UUID id) {
        return findById(id).orElseThrow();
    }

    @Override
    public void deleteContentById(UUID id) {
        var fileMetadata = getInfoById(id);
        var path = Path.of(fileMetadata.getFilepath());

        if (!Files.isReadable(path)) {
            throw new RuntimeException();   //todo change to notfoundfile custom ex
        }

        try {
//            FileSystemUtils.deleteRecursively(path);
            Files.delete(path);
            delete(fileMetadata.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
