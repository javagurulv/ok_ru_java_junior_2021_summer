package ru.mail.java.junior.library.console_ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProgramMenu {

	private Map<Integer, UIAction> menuNumberToUIActionMap;

	@Autowired
	public ProgramMenu(List<UIAction> uiActions) {
		menuNumberToUIActionMap = new HashMap<>();
		menuNumberToUIActionMap.put(1, findUIAction(uiActions, AddBookUIAction.class));
		menuNumberToUIActionMap.put(2, findUIAction(uiActions, UpdateBookUIAction.class));
		menuNumberToUIActionMap.put(3, findUIAction(uiActions, RemoveBookUIAction.class));
		menuNumberToUIActionMap.put(4, findUIAction(uiActions, GetAllBooksUIAction.class));
		menuNumberToUIActionMap.put(5, findUIAction(uiActions, SearchBooksUIAction.class));
		menuNumberToUIActionMap.put(6, findUIAction(uiActions, RegisterReaderUIAction.class));
		menuNumberToUIActionMap.put(7, findUIAction(uiActions, ExitUIAction.class));
	}

	private UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
		return uiActions.stream()
				.filter(uiAction -> uiAction.getClass().equals(uiActionClass))
				.findFirst()
				.get();
	}

	public void print() {
		System.out.println();
		System.out.println("Program menu:");
		System.out.println("1. Add book to list");
		System.out.println("2. Update book");
		System.out.println("3. Delete book");
		System.out.println("4. Show all books");
		System.out.println("5. Search books");
		System.out.println("6. Register reader");
		System.out.println("7. Exit");
		System.out.println();
	}

	public int getMenuNumberFromUser() {
		System.out.println("Enter menu item number to execute:");
		Scanner scanner = new Scanner(System.in);
		return Integer.parseInt(scanner.nextLine());
	}

	public void executeSelectedMenuItem(int selectedMenu) {
		menuNumberToUIActionMap.get(selectedMenu).execute();
	}

}
