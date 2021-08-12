package teacher.lesson_2_multithreading.lessoncode.bankaccount.synch;

public class RemoveMoneyThread implements Runnable {

	private SynchronizedBankAccount bankAccount;

	public RemoveMoneyThread(SynchronizedBankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000000; i++) {
			bankAccount.remove(1);
		}
	}
}
