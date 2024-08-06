package RK_coffe_shop_mapped_db.dto.file;

import jdk.jfr.ContentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.InputStream;
import java.nio.file.Path;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class FileWithContentDto {
    private InputStream inputStream;
    private String extension;
    private Path path;
}
