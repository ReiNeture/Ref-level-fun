package fubuki.ref.character;

public class ExpTable {
	
	public static int MAX_LEVEL = 30;
	
	private static int required[] = {0,
		100, 200, 300, 400, 500, 600, 700, 800, 900, 1000,
		1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000,
		2100, 2200, 2300, 2400, 2500, 2600, 2700, 2800, 2900, 3000
	};

	
	public static int getRequiredExp(int level) {
		if( level <= 0 )
			throw new IllegalStateException("LEVEL CAT'N LESS ONE");
		if( level > MAX_LEVEL )
			throw new IllegalStateException("LEVEL CAT'N GREAT MAX_LEVEL");
		
		return required[level];
	}
}
