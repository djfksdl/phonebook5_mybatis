package com.javaex.dao;

import java.sql.SQLException;
import java.util.List;

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
	
	//등록
	public int personInsert(PersonVo personVo) {

		int count = sqlSession.insert("phonebook.insert", personVo); //(mapper.xml에서 실행,넣는 파라미터값)- 파라미터자리에는 하나만 올 수 있기때문에 하나 이상이면 묶어서 여기에 넣을 수 있다.
		System.out.println(count);
		return 0;
	}
	
	//수정폼 (데이터 하나 가져오기)
	public PersonVo personSelectOne(int no) {
		System.out.println("phonebookDao.personSelectOne()");
		PersonVo personVo= sqlSession.selectOne("phonebook.selectOne", no);
		
		return personVo;
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