package org.test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Test {

	static class DirFilter implements FilenameFilter {

		private Pattern pattern;

		public DirFilter(String regex) {
			pattern = Pattern.compile(regex);

		}

		public boolean accept(File dir, String name) {

			return pattern.matcher(name).matches();
		}
	}

	public static void main(String[] args) {
		File file = new File(".");
		String[] list;
		if (args.length == 0) {
			list = file.list();

		} else {
			list = file.list(new DirFilter(args[0]));
			Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
			for (String s : list) {
				System.out.print(s);
			}

		}

	}

}
