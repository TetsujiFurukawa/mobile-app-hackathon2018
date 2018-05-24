package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.common.CmdUtility;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MultiChainService {

	@Value("${command.altichain.enable}")
	private Boolean commandMultichainEnable;

	public void sendAssetFrom(String srcAddress, String targetAddress, String assetName, Integer sendAmount)
			throws IOException, InterruptedException {
		if (commandMultichainEnable) {
			CmdUtility.sendAssetFrom(srcAddress, targetAddress, assetName, sendAmount);
		}
	}
}
