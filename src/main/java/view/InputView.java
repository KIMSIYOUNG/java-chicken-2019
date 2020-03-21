package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner sc = new Scanner(System.in);

	public static String inputFunction() {
		System.out.println("##사용하고자 하는 기능을 선택하세요.");
		return sc.nextLine();
	}

	public static String inputTableId() {
		System.out.println("##테이블을 선택하세요.");
		return sc.nextLine();
	}

	public static String inputMenuId() {
		System.out.println("##등록할 메뉴를 선택하세요!");
		return sc.nextLine();
	}

	public static int inputMenuCount() {
		System.out.println("##메뉴의 수량을 입력하세요");
		return Integer.parseInt(sc.nextLine());
	}

	public static int inputPaymentType() {
		System.out.println("##신용카드는 1번, 현금은 2번, 카카오 페이나 네이버 페이, 페이코를 이용하시면 3번을 입력해주세요.");
		return Integer.parseInt(sc.nextLine());
	}
}
