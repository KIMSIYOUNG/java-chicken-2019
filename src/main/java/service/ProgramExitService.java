package service;

public class ProgramExitService implements PosService {
	private static final int NORMAL_EXIT = 0;

	@Override
	public void run() {
		System.exit(NORMAL_EXIT);
	}
}
