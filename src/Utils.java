import db.entity.Entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Utils {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void printInstruction() {
		System.out.println("Starting application...");
		System.out.println("0 - close\n1 - create entity\n2 - delete entity\n3 - print entity by id\n4 - print all entities");
	}
	
	public static void play() {
		while (!Objects.equals(scanner.next(), "0")) {
			switch (scanner.nextLine()) {
				case "1":
					Utils.createEntity();
					break;
				case "2":
					break;
				case "3":
					break;
				case "4":
					break;
				default:
					System.out.println("Stopping application...\nEnd");
			}
		}
	}
	
	public static Object createEntity() {
		System.out.println("Create entity (insert name with packaging):");
		String className = scanner.nextLine();
		System.out.println("Insert parameters. For stop insert .");
		List<String> parameters = new ArrayList<>();
		while (!Objects.equals(scanner.nextLine(), ".")) {
			parameters.add(scanner.nextLine());
		}
		try {
			Class<?> clazz = Class.forName(className);
			Constructor<?> constructor = clazz.getConstructor(String.class);
			Object o = constructor.newInstance(parameters);
			return o;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
}
