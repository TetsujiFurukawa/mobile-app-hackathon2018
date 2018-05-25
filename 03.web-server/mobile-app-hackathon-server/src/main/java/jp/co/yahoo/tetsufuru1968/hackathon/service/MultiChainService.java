package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.common.CmdUtility;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MultiChainService {

	public static  Boolean MULTICHAIN_ENNABLE = true;

	public static String MULTICHAIN_OWNER_HASH="1U4jXsT2fZXnUQJvmjPtL6kWxqAhUP3xfDJXKN";

	public static String ASSET_KEY_GOLD="1U4jXsT2fZXnUQJvmjPtL6kWxqAhUP3xfDJXKN";
	public static String ASSET_KEY_SILVER="1U4jXsT2fZXnUQJvmjPtL6kWxqAhUP3xfDJXKN";
	public static String ASSET_KEY_BRONZE="1U4jXsT2fZXnUQJvmjPtL6kWxqAhUP3xfDJXKN";

	public void getMoney(String targetAddress, String assetName, Integer sendAmount)
			throws IOException, InterruptedException {
		sendAsset(MULTICHAIN_OWNER_HASH, targetAddress, assetName, sendAmount);
	}


	private void sendAsset(String srcAddress, String targetAddress, String assetName, Integer sendAmount)
			throws IOException, InterruptedException {
			CmdUtility.sendAssetFrom(srcAddress, targetAddress, assetName, sendAmount);
	}
}
