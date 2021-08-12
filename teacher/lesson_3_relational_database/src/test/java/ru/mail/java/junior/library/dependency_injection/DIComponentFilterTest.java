package ru.mail.java.junior.library.dependency_injection;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.springframework.stereotype.Component;

@Component
public class DIComponentFilterTest {

	@Test
	public void test() throws IOException, ClassNotFoundException {
		ClassFinder classFinder = new ClassFinder();
		DIComponentFilter filter = new DIComponentFilter();
		List<Class> classes = classFinder.findClassesInsidePackage("ru.mail.java.junior.library");
		List<Class> diComponents = filter.filter(classes);
		diComponents.forEach(aClass -> {
			System.out.println(aClass.getName());
		});
	}

}