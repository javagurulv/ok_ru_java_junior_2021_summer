package teacher.lesson_2_multithreading.lessoncode.bankaccount.synch;

public class SynchronizedBankAccount {

	private int money;

	public SynchronizedBankAccount(int money) {
		this.money = money;
	}

	public synchronized void add(int moneyToAdd) {
		this.money = this.money + moneyToAdd;
	}

	public synchronized void remove(int moneyToRemove) {
		this.money = this.money - moneyToRemove;
	}

	public int getMoney() {
		return money;
	}

}
