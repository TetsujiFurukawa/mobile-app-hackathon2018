package jp.co.yahoo.tetsufuru1968.hackathon.common;

import java.io.IOException;

import jp.co.yahoo.tetsufuru1968.hackathon.service.MultiChainService;

public class CmdUtility {
	private static final String SEND_ASSET_FROM = "multichain-cli chain1 sendassetfrom @SOURCE_ADDRE @TARGET_ADDRE @ASSET_NAME @SEND_AMOUNT";

	private static void commandMultiChainDo(String cmd) throws IOException, InterruptedException {

		Runtime runtime = Runtime.getRuntime();
		String[] Command = { "cmd", "/c", cmd};
		Process  p =runtime.exec(cmd);
//		int ret = p.waitFor();
		System.out.print(p.toString());
	}

	public static void sendAssetFrom(String home,String srcAddress, String targetAddress, String assetName, Integer sendAmount)
			throws IOException, InterruptedException {
		String cmd = home + SEND_ASSET_FROM.replaceAll(
				"@SOURCE_ADDRE", srcAddress)
				.replace("@TARGET_ADDRE", targetAddress)
				.replace("@ASSET_NAME", assetName)
				.replace("@SEND_AMOUNT", sendAmount.toString());

		System.out.println("cmd:" + cmd);
		if (MultiChainService.MULTICHAIN_ENNABLE) {
			commandMultiChainDo(cmd);
		}
	}

}
