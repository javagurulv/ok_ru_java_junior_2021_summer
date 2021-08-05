package teacher.lesson_2_multithreading.lessoncode.bankaccount.atomicwithoutsynch;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccountAtomic {

	private AtomicInteger money;
	//private AtomicInteger operationCount;

	public BankAccountAtomic(int money) {
		this.money = new AtomicInteger(money);
		//this.operationCount = new AtomicInteger(0);
	}

	public void add(int moneyToAdd) {
		this.money.addAndGet(moneyToAdd);
		//this.operationCount.incrementAndGet();
	}

	public void remove(int moneyToRemove) {
		if (getMoney() > 0) {
			this.money.addAndGet(-1 * moneyToRemove);
			//this.operationCount.decrementAndGet();
		}
	}

	public int getMoney() {
		return money.get();
	}

/*
	public int getOperationCount() {
		return operationCount.get();
	}
*/
}
