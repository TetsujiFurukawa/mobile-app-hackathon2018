package jp.co.yahoo.tetsufuru1968.hackathon.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jp.co.yahoo.tetsufuru1968.hackathon.domain.Currency;
import jp.co.yahoo.tetsufuru1968.hackathon.domain.MFamily;
import jp.co.yahoo.tetsufuru1968.hackathon.domain.User;
import jp.co.yahoo.tetsufuru1968.hackathon.domain.Wallet;
import jp.co.yahoo.tetsufuru1968.hackathon.domain.Work;
import jp.co.yahoo.tetsufuru1968.hackathon.domain.WorkItem;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.CurrencyRepository;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.MFamilyRepository;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.UserRepository;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.WalletRepository;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.WorkItemRepository;
import jp.co.yahoo.tetsufuru1968.hackathon.repository.WorkRepository;
import lombok.AllArgsConstructor;
import twitter4j.TwitterException;

@Service
@AllArgsConstructor
public class WorkService {

	WorkRepository workRepository;
	WorkItemRepository workItemRepository;
	CurrencyRepository currencyRepository;

	UserRepository userRepository;
	MFamilyRepository mFamilyRepository;

	WalletRepository walletRepository;

	MultiChainService multiChainService;

	TwitterService twitterService;

	// 登録する
	public Work create(Work work) {
		Date payDate = new Date();
		work.setPay_date(payDate);
		return workRepository.save(work);

	}

	// 更新する
	public Work update(Work work) throws IOException, InterruptedException, TwitterException {
		Optional<Work> beforeUpdateWork = workRepository.findById(work.getWork_id());

		if (beforeUpdateWork.orElse(null) != null) {
			int approval = beforeUpdateWork.get().getApproval();
			if (work.getApproval() == 1 && work.getApproval() != approval) {

				// マルチチェインからお金をもらう
				getMoneyFromMultiChain(work);

			}
		}

		return workRepository.save(work);
	}

	/**
	 * マルチチェインからお金をもらう
	 * @param work
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws TwitterException
	 */
	private void getMoneyFromMultiChain(Work work) throws IOException, InterruptedException, TwitterException {
		// 承認フラグが初めて立った場合にお金をもらう

		// ユーザを取得する
		Optional<User> user = userRepository.findById(work.getUser_id());
		if (user.orElse(null) != null) {
			String targetHash = user.get().getHash_value();
			String assetHash = "";
			Integer sendAmount = 0;
			String userName = user.get().getName();

			String familyName = "";
			String workItemName = "";
			String currencyName = "";

			// 数量
			int number = 0;

			// 世帯を取得する
			Optional<MFamily> fam = mFamilyRepository.findById(user.get().getFamily_id());
			if (fam.orElse(null) != null) {
				familyName = fam.get().getName();
			}

			// 労働のアイテムを取得する
			Optional<WorkItem> workItem = workItemRepository.findById(work.getWork_item_id());
			if (workItem.orElse(null) != null) {
				sendAmount = workItem.get().getNumber();
				workItemName = workItem.get().getName();
				number = workItem.get().getNumber();
			}

			// 通貨を取得する
			Currency currency = currencyRepository.findBycurrencyId(workItem.get().getCurrency_id());
			if (currency != null) {
				assetHash = currency.getHash_value();
				currencyName = currency.getName();
			}

			// 所持金を更新する
			List<Wallet> wallets = walletRepository.findByCurrency(user.get().getUser_id(), currency.getCurrency_id());

			if (!wallets.isEmpty()) {
				int amount = wallets.get(0).getNumber();
				amount += number;
				wallets.get(0).setNumber(amount);
			}
			walletRepository.save(wallets.get(0));

			multiChainService.getMoney(targetHash, assetHash, sendAmount);

			StringBuffer sb = createTweetMessage(sendAmount, familyName, userName, workItemName, currencyName);

			tweetGotMoney(sb.toString(), workItem.get().getCurrency_id());

		}
	}

	private StringBuffer createTweetMessage(Integer sendAmount, String familyName, String userName, String workItemName,
			String currencyName) {
		// ツイートする
		StringBuffer sb = new StringBuffer();
		sb.append(familyName);
		sb.append("の");
		sb.append(userName);
		sb.append("はきょう");
		sb.append("「");
		sb.append(workItemName);
		sb.append("」をしました！\n");
		sb.append("そして");
		sb.append(sendAmount);
		sb.append(currencyName);
		sb.append("をもらいました(^^)/");
		return sb;
	}

	private void tweetGotMoney(String tweet, String currency_id) throws TwitterException {
		// ツイートする
		twitterService.tweetGotMoney(tweet, currency_id);

	}
}
