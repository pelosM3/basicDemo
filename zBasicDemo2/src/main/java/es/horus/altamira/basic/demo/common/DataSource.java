package es.horus.altamira.basic.demo.common;

public class DataSource {
	private static String data;
	
	public static void init()  {
		data = UtilsUI.hoyFormateado();
	}
	
	public static String getData() {
		return data;
	}
}
