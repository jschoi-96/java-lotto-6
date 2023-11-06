package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.LottoService;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private Amount amount;

    public void run() {
        getLottoMoney();
        printLottoList();
        winningLotto();
        bonusLotto();
    }

    private void getLottoMoney() {
        OutputView.printPurchaseAmount();
        int purchaseAmount = InputView.readPurchaseAmount();
        amount = new Amount(purchaseAmount);
    }

    private void printLottoList() {
        int count = amount.getCount();
        OutputView.printPurchaseCount(count);
        LottoService lottoService = new LottoService(new ArrayList<>());
        for(int i = 0; i  < count; i++){
            OutputView.printBoughtLottoNumbers(lottoService.createLottoList());
        }
    }

    private void winningLotto() {
        OutputView.printWinningNumbers();
        List<Integer> winningNumbers = InputView.readWinningNumbers();
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
    }

    private void bonusLotto() {
        OutputView.printBonusNumber();
        InputView.readBonusNumber();
    }
}
