package teacher.lesson_2_multithreading.lessoncode.bankaccount.synch;

public class SynchronizedBankAccountThreadApp {

	public static void main(String[] args) {
		SynchronizedBankAccount bankAccount = new SynchronizedBankAccount(0);

		Thread thread1 = new Thread(new AddMoneyThread(bankAccount));
		Thread thread2 = new Thread(new RemoveMoneyThread(bankAccount));

		long before = System.currentTimeMillis();

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {

		}

		long after = System.currentTimeMillis();

		System.out.println("Bank Account money = " + bankAccount.getMoney());
		System.out.println("Time = " + (after - before));

	}
}
