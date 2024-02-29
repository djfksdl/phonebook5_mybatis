package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {
	
	//리스트
	public List<PersonVo> exeList() {
		System.out.println("PhonebookService.exeList");
		
		List<PersonVo> personList = phonebookDao.personSelect();
		
		return personList;
	}
	//등록2
	public int exeWrite2(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite2()");
		
		//비지니스 로직이 있어야하는데, 여기선 없긴함. 
		int count= phonebookDao.personInsert(personVo);
		
		return count ;
	}
	
	//등록1
	public int exeWrite(String name, String hp, String company) {
		System.out.println("PhonebookService.exeWrite1()");
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		//PersonVo를 제작해서 묶는다-> 근데 딱 1번만 쓸거같다는 상황설정 묶어야하는 이유: Dao에서 파라미터 받을때 1자리밖에 안되서 묶어줘야한다. 
		Map<String, String> personMap = new HashMap<String, String>();
		personMap.put("name",name);//"name"이라는 별명으로 name값을 넣는다.
		personMap.put("hp",hp);
		personMap.put("company",company);
		
		//Dao에 보내기
		int count = phonebookDao.personInsert2(personMap);
		
		return count ;
	}
	//수정폼
	public PersonVo exeModifyForm(int no) {
		System.out.println("PhonebookService.exeModifyForm()");
		
		//비지니스 로직이 있어야하는데, 여기선 없긴함. 
		PersonVo personVo= phonebookDao.personSelectOne(no);
		
		return personVo ;
	}
	//수정폼2
	public Map<String , Object> exeModifyForm2(int no) {
		System.out.println("PhonebookService.exeModifyForm2()");
		
		//비지니스 로직이 있어야하는데, 여기선 없긴함. 
		Map<String , Object> pMap= phonebookDao.personSelectOne2(no);//여기 pMap이름은 아무거나 써도 됨
//		
		return pMap ;
	}

	// 수정
	public int exeModify(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite");

		// 비지니스 로직이 있어야하는데, 여기선 없긴함.
		int count = phonebookDao.personUpdate(personVo);

		return count;
	}
	
	// 삭제
	public int exeDelete(int no) {
		System.out.println("PhonebookService.exeDelete");
		
		int count = phonebookDao.personDelete(no);
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//필드
	@Autowired
	private PhonebookDao phonebookDao;
	//생성자- 디폴트
	//메소드-gs
	//메소드-일반
	
	//등록2,1
//	public int exeWrite(PersonVo personVo) {
//		System.out.println("PhonebookService.exeWrite");
//		
//		//비지니스 로직이 있어야하는데, 여기선 없긴함. 
//		//PhonebookDao phonebookDao = new PhonebookDao();- 자동연결해놔서 막기
//		int count= phonebookDao.personInsert(personVo);
//		
//		return count ;
//	}
	
	//리스트
//	public List<PersonVo> exeList() {
//		System.out.println("PhonebookService.exeList");
//		
////		PhonebookDao phonebookDao = new PhonebookDao(); - 자동연결해놔서 막으면 됨
//		List<PersonVo> personList = phonebookDao.personSelect();
//		
//		return personList;
//	}
//	
//	//삭제
//	public int exeDelete(int no) {
//		System.out.println("PhonebookService.exeDelete");
//		
//		//PhonebookDao phonebookDao = new PhonebookDao();- 자동연결해놔서 막기
//		int count = phonebookDao.personDelete(no);
//		
//		return count;//받는 이유?: 나중에 jsp2개 만들어서 지워지면 출력하는것과, 안지워졌을때 출력하는게 다를 수 있어서 쓰임! 
//		
//	}
//	
//	//수정폼
//	public PersonVo exeModifyForm(int no) {
//		System.out.println("PhonebookService.exeModifyForm");
//		
//		//PhonebookDao phonebookDao = new PhonebookDao();- 자동연결해놔서 막기
//		PersonVo personVo = phonebookDao.personSelectOne(no);
//		
//		return personVo;
//		
//	}
//	//수정
//	public int exeModify(PersonVo personVo) {
//		System.out.println("PhonebookService.exeModify");
//		
//		//PhonebookDao phonebookDao = new PhonebookDao();- 자동연결해놔서 막기
//		int count = phonebookDao.personUpdate(personVo);
//		
//		return count;
//		
//	}
	
}
