package ru.mail.java.junior.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ru.mail.java.junior.library.config.SpringCoreConfiguration;
import ru.mail.java.junior.library.console_ui.ProgramMenu;

@SpringBootApplication
public class ConsoleBookListApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringCoreConfiguration.class);

		ProgramMenu programMenu = context.getBean(ProgramMenu.class);
		while (true) {
			programMenu.print();
			int menuNumber = programMenu.getMenuNumberFromUser();
			programMenu.executeSelectedMenuItem(menuNumber);
		}
	}

}
