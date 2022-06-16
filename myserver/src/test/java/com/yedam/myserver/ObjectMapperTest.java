package com.yedam.myserver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.myserver.todo.vo.TodoVO;

public class ObjectMapperTest {

	@Test
	public void test2() throws MalformedURLException, IOException {
		ObjectMapper om = new ObjectMapper();
		String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220614";
		JsonNode result = om.readTree(new URL(url));
		//readTree는 json문자열을 JsonNode로 변환
		//Json으로 나타난 정보에서 [ ] 표시로 시작되는 건 배열이기 때문에 Arraynode
		//{ } 표시로 시작하는 건 Json 값이기 때문에 JsonNode
		//JsonNode는 값을 불러올 수는 있지만 넣을 수는 없으므로 값을 넣기 위해서는 ObjectNode를 사용한다. 
		//ObjectNode는 값을 불러오고 넣을 수도 있다.
		//즉, JsonNode 는 값을 읽을 수만 있고 ObjectNode는 값을 읽고 쓸 수 있다.

		String nm = result.get("boxOfficeResult")
						  .get("dailyBoxOfficeList")
						  .get(0)
						  .get("movieNm")
						  .asText();
		System.out.println(nm);
	}
	
	//@Test
	public void test1() throws JsonProcessingException {
		TodoVO vo = new TodoVO();
		vo.setContents("test");
		vo.setNo("1");
		
		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(vo); // @ResponseBody : 자바객체 => 스트링(json)
		System.out.println(result);
		
		TodoVO vo2 = om.readValue(result, TodoVO.class); // @RequestBody : 스트링(json) => 자바객체
		System.out.println(vo2.getContents());
	}
}
