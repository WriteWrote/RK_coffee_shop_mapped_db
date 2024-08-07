package RK_coffe_shop_mapped_db.dto.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class FileInfoDto {
    private UUID id;
    private String path;
//    private String createdAt; //todo alter table to store this data
}
