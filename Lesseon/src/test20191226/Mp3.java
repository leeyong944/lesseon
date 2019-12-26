package test20191226;

public interface Mp3 {
	
	default void setMusic(boolean music) {
		if(music) {
			System.out.println("음악을 재생합니다.");
		}else {
			System.out.println("음악을 정지합니다.");
		}
		
	}

}
