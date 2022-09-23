package zayson.java.lab.webclient.dto;

import lombok.Data;

@Data
public class OttDto {
    private Long ottId;
    private String ottImage;
    private String ottName;

    public OttDto() {}


    public OttDto(Long ottId, String ottImage, String ottName) {
        this.ottId = ottId;
        this.ottImage = ottImage;
        this.ottName = ottName;
    }
}
