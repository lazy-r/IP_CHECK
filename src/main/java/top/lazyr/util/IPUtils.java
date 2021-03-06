package top.lazyr.util;

import org.lionsoul.ip2region.*;
import top.lazyr.model.pojo.Region;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class IPUtils {
    public static DbConfig config;

    //获取ip库的位置（放在resources下）（直接通过测试类获取文件Ip2RegionTest为测试类）
    public static String dbfile;

    public static DbSearcher searcher;


    static {

        //获取ip库的位置（放在src下）（直接通过测试类获取文件Ip2RegionTest为测试类）
//        dbfile = "./src/main/resources/ip2region.db";
        dbfile = "./ip2region.db";


        try {

            config = new DbConfig();
            searcher = new DbSearcher(config, dbfile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (DbMakerConfigException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Region ip2Region(String ip, int port){
        if (!Util.isIpAddress(ip)){
            return Region.builder().ip(ip).port(port).build();
        }

        DataBlock block = null;
        //采用Btree搜索
        try {
            block = searcher.btreeSearch(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(block != null){
                String[] data = block.getRegion().split("\\|");
                return Region.builder()
                        .ip(ip)
                        .port(port)
                        .country(data[0])
                        .province(data[2])
                        .city(data[3])
                        .serverVendor(data[4]).build();
            }else {
                return Region.builder().ip(ip).port(port).build();
            }
        }
    }
}
