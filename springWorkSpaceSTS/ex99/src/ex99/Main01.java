package ex99;

public class Main01 {

	public static void main(String[] args) {
		// 메서드를 사용하는 방법
		TestCls tc = new TestCls();
		tc.mo();
		
		/////////////////////////////////////////////////
		TestInter ti = new TestCls();  // 다형성
						// mo, m2
		
		ti.mo();
//		ti.m2();
//////////////////////////////////////////////////////////
		kkk(new TestCls());
//////////////////////////////////////////////////////////
		
		// 익명구현객체
		TestInter ti2 = new TestInter() {	// 익명구현객체 => 즉석에서 만들어 사용
			
			@Override
			public void mo() {
				System.out.println("익명구현객체의 메서드");
			}
			
		};
		
		ti2.mo();
	/////////////////////////////////////////////////////	
		
		kkk(new TestInter() {

			@Override
			public void mo() {
				
				
			}
			
		});
		
		
	}

	private static void kkk(TestInter ti) {
		ti.mo();
		
	}

}
