package jp.co.yahoo.tetsufuru1968.hackathon.common;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;

public class CmdUtility {
    @Value("${command.altichain.enable}")
    private Boolean commandMultichainEnable;


    public static void commandMultiChainDo(String cmd) throws IOException, InterruptedException {
    	        Runtime runtime = Runtime.getRuntime();
    	        Process p = runtime.exec("ping 192.168.0.1");
    	        p.waitFor();
    }

}
