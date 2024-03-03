package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {
	@Autowired
	private SqlSession sqlSession;
	
	//전체 가져오기
	public List<PersonVo> personSelect(){
		
		List<PersonVo> personList = sqlSession.selectList("phonebook.select");//namespace.id가 이름이 된다.
		System.out.println(personList);
		return personList;
	}
	
	//등록2
	public int personInsert(PersonVo personVo) {

		int count = sqlSession.insert("phonebook.insert", personVo); //(mapper.xml에서 실행,넣는 파라미터값)- 파라미터자리에는 하나만 올 수 있기때문에 하나 이상이면 묶어서 여기에 넣을 수 있다.
		System.out.println(count);
		return 0;
	}
	//등록1
	public int personInsert2(Map<String, String> pMap) {//pMap=personMap 이름이 항상 같지않아도됨!내가 이름 설정하는거임
		System.out.println("phonebookDao.personInsert(1)");
		System.out.println(pMap);
		int count = sqlSession.insert("phonebook.insert2", pMap); //sqlsession안에 있는 메소드를 쓰는거라 insert2를 우리가 만들순 없다!
		System.out.println(count);
		return count;
	}
	
	//수정폼 (데이터 하나 가져오기)
	public PersonVo personSelectOne(int no) {
		System.out.println("phonebookDao.personSelectOne()");
		PersonVo personVo= sqlSession.selectOne("phonebook.selectOne", no);
		
		return personVo;
	}
	//수정폼2 (데이터 하나 가져오기)
	public Map<String, Object> personSelectOne2(int no) {
		System.out.println("phonebookDao.personSelectOne2()");
		System.out.println(no);//Dao에서는 중간에 확인이 안되니 꼭 찍어보기
		Map<String, Object> pMap= sqlSession.selectOne("phonebook.selectOne2", no);//받는 값에 int도 있고 String 도 있어서 2번째 자리는 Object라고 받는다. xml안에서 맵으로 만들어서 임의로 키값을 만든거라 우리는 모름. Object로 받을수밖에 없다.
		
		System.out.println(pMap.get("name"));
		System.out.println(pMap.get("hp"));
		System.out.println(pMap.get("company"));
		
		return pMap;
	}
	//수정
	public int personUpdate(PersonVo personVo) {
		System.out.println("phonebookDao.personUpdate()");
		
		int count = sqlSession.update("phonebook.update", personVo);
		System.out.println(count);
		return count;
	}
	//삭제
	public int personDelete(int no) {
		System.out.println("phonebookDao.personDelete");
		
		int count = sqlSession.delete("phonebook.delete", no);
		return count;
	}

}