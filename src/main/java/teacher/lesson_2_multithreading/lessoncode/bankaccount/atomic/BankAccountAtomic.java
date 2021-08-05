package teacher.lesson_2_multithreading.lessoncode.bankaccount.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccountAtomic {

	private AtomicInteger money;

	public BankAccountAtomic(int money) {
		this.money = new AtomicInteger(money);
	}

	public void add(int moneyToAdd) {
		this.money.addAndGet(moneyToAdd);
	}

	public void remove(int moneyToRemove) {
		this.money.addAndGet(-1 * moneyToRemove);
	}

	public int getMoney() {
		return money.get();
	}

}
