package com.demo;

public class Demo {

	public static void main(String[] args) {
		String name = "md Islam";

		int vowels = 0;
		int cons = 0;
		name = name.toLowerCase();
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);

			if (Character.isLetter(ch)) {

				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
				{
					vowels++;

				} else {
					cons++;
				}
			}

		}

		System.out.println(vowels);

		System.out.println(cons);

	}
}