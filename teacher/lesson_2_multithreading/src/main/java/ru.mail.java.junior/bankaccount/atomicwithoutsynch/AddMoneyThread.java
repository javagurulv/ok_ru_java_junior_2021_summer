package teacher.lesson_2_multithreading.lessoncode.bankaccount.atomicwithoutsynch;

public class AddMoneyThread implements Runnable {

	private BankAccountAtomic bankAccount;

	public AddMoneyThread(BankAccountAtomic bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100000000; i++) {
			bankAccount.add(1);
		}
	}
}
