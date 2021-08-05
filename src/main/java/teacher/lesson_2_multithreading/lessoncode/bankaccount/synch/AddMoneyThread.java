package teacher.lesson_2_multithreading.lessoncode.bankaccount.synch;

public class AddMoneyThread implements Runnable {

	private SynchronizedBankAccount bankAccount;

	public AddMoneyThread(SynchronizedBankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000000; i++) {
			bankAccount.add(1);
		}
	}
}
