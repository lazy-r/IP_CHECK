package top.lazyr.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class IPUtilsTest {

    @Test
    public void ip2Provence() {
        System.out.println(IPUtils.ip2Region("121.42.13.243",0));
    }
}
