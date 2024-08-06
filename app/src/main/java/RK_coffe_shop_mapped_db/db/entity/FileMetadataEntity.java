package RK_coffe_shop_mapped_db.db.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "file_metadata", schema = "rk_coffee_shop")
public class FileMetadataEntity {
    @Id
    @Column("id")
    private UUID id;

    @Column("filepath")
    private String filepath;

    @Column("file_extension")
    private String fileExtension;
}
