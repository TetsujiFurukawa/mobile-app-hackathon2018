package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.common.CmdUtility;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MultiChainService {

	public static Boolean MULTICHAIN_ENNABLE = true;

	public static String MULTICHAIN_OWNER_HASH = "1U4jXsT2fZXnUQJvmjPtL6kWxqAhUP3xfDJXKN";

//	public static String ASSET_KEY_GOLD = "1U4jXsT2fZXnUQJvmjPtL6kWxqAhUP3xfDJXKN";
//	public static String ASSET_KEY_SILVER = "1U4jXsT2fZXnUQJvmjPtL6kWxqAhUP3xfDJXKN";
//	public static String ASSET_KEY_BRONZE = "1U4jXsT2fZXnUQJvmjPtL6kWxqAhUP3xfDJXKN";

	public static String HOME = "C:\\papa\\01.equinix\\11.hakkason\\2018\\multichain\\multichain-windows-1.0.4/";

	public void getMoney(String targetAddress, String assetName, Integer sendAmount)
			throws IOException, InterruptedException {
		sendAsset(HOME,MULTICHAIN_OWNER_HASH, targetAddress, assetName, sendAmount);
	}

	private void sendAsset(String home, String srcAddress, String targetAddress, String assetName, Integer sendAmount)
			throws IOException, InterruptedException {
		CmdUtility.sendAssetFrom(home,srcAddress, targetAddress, assetName, sendAmount);
	}
}
