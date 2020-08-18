package ssafy0724;

public class StudentMgr {
	/**
	 * Singleton Pattern
	 */
	private static StudentMgr mgr = new StudentMgr();

	private StudentMgr() {
		
	}
	
	public static StudentMgr getInstance() {
		return mgr;
	}

}
