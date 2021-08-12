package teacher.lesson_2_multithreading.lessoncode.bankaccount.atomic;

public class AddMoneyThread implements Runnable {

	private BankAccountAtomic bankAccount;

	public AddMoneyThread(BankAccountAtomic bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000000; i++) {
			bankAccount.add(1);
		}
	}
}
