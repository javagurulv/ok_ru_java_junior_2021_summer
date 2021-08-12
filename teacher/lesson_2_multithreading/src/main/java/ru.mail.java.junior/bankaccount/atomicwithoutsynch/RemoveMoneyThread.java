package teacher.lesson_2_multithreading.lessoncode.bankaccount.atomicwithoutsynch;

public class RemoveMoneyThread implements Runnable {

	private BankAccountAtomic bankAccount;

	public RemoveMoneyThread(BankAccountAtomic bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100000000; i++) {
			bankAccount.remove(1);
		}
	}
}
