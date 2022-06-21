package com.yedam.myserver;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptTest {

	@Test
	public void test() {
		// Create an encoder with strength 16
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4); 
		//해킹을 방지하기 위해 시간을 지연시킴 숫자가 클수록 암호화하는데 시간 지연 1~32까지이고 보통 16
		String result = encoder.encode("1111");
		System.out.println(result);
		assertTrue(encoder.matches("1234", result));
		//암호화했기에 단순 스트링 이퀄로 비교할 수 없고 matches함수를 사용하여야한다.
		//db저장시에도 암호화된 결과값 사용
		//argument로 특정 조건 및 boolean 값을 넘기고 assertTrue인 경우 false일때, assertFalse인경우 true일때, junit 에러를 발생시키며 message를 메시지로 리턴
	}
}
