package RK_coffe_shop_mapped_db.dto.file;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class FileInfoDto {
    private UUID id;
    private String path;
    private String createdAt;
}
