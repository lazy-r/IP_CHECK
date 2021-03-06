package top.lazyr.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Region {
    private String ip;
    private int port;
    private String country;
    private String province;
    private String city;
    private String serverVendor;
}
