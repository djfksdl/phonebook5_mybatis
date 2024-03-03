package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;
@Controller
public class PhonebookController {
	//필드
	//메모리에 올려줘문법 :@Autowired
	@Autowired
	private PhonebookService phonebookService;
	
	//생성자-디폴트 생성자 쓸거임
	
	//메소드-gs
	
	//메소드-일반
	
	//등록폼
	//localhost:8080/phonebook5(여기까진 공통주소)/phone/writeform - 이런 주소가 왔을때 밑에 있는 메소드가 작동했으면 좋겠다.
	@RequestMapping(value="/phone/writeform" ,method={RequestMethod.GET , RequestMethod.POST } )//get으로 실행시켜줘야한다. 하나만 쓰면 method= RequestMethod.GET으로 쓴다.지금은 연습하느라 두개 다 하는걸로 써놓음/ 이거 쓰는 이유는 매핑에 등록시키려고 쓰는거임!
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");
		return "writeForm";//'뷰' 를 추가해줘서 앞뒤에 붙은 건 빼줘야 주소가 제대로 찾아감
	}
	//등록2- 갯수 많으면 실수할 수 있으니 파라미터 묶어서'까지 줘-> PersonVo에 담는것까지는 알려줘야함. 꺼내서 묶어서 나한테 줘. 자료형(PserconVo)에 담고 이름을 알려줘야 꺼내 쓸 수 있으니 personVo로 이름을 주면 디스패쳐가 new해줌.
	@RequestMapping(value="/phone/write" ,method={RequestMethod.GET , RequestMethod.POST } )
	//localhost:8080/phonebook5/phone/write?name=황일영&hp=010&company=02
	public String write(@ModelAttribute PersonVo personVo)  {//이때도 setter로 담는다.
		System.out.println("PhonebookController.write2()");
		
		//vo묶어진것 확인
		System.out.println(personVo.toString());
		
		//서비스를 메모리에 올리고 서비스의 메소드 사용해야함!(3단계)
		phonebookService.exeWrite2(personVo);
		
		//리스트로 리다이렉트
		return "redirect:/phone/list";
	}
	//등록1- 안묶고 넘길때 Map사용!
	@RequestMapping(value="/phone/write2" ,method={RequestMethod.GET , RequestMethod.POST } )
	//localhost:8080/phonebook5/phone/write?name=황일영&hp=010&company=02
	public String write2(@RequestParam(value="name") String name,
						 @RequestParam(value="hp") String hp,
						 @RequestParam(value="company") String company)  {//이때도 setter로 담는다.
		System.out.println("PhonebookController.write1()");
		
		System.out.println(name);
		//서비스로
		phonebookService.exeWrite(name, hp, company);
		
		//리스트로 리다이렉트
		return "redirect:/phone/list";
	}
	//리스트
		@RequestMapping(value="/phone/list" ,method={RequestMethod.GET , RequestMethod.POST } )
		//localhost:8080/phonebook5/phone/write?name=황일영&hp=010&company=02
		private String list(Model model) {//Model에서 넣은주소를 request.attribute에 담아야할때만 써준다. model은 데이터고, view는 화면이다.
			System.out.println("PhonebookController.list()");
			
			//서비스를 메모리에 올리고 서비스의 메소드 사용해야함!(3단계)
			List<PersonVo> personList = phonebookService.exeList();
			
			
			model.addAttribute("pList", personList);//별명, 진짜 주소
			

			return "list";
		}
		//삭제
		@RequestMapping(value="/phone/delete", method= {RequestMethod.GET, RequestMethod.POST})
		private String delete(@RequestParam("no") int no) { // value안쓰고 가져와도됨 설명듣기 11:09
			System.out.println("PhonebookController.delete()");
			
			//서비스
			phonebookService.exeDelete(no);
			
			return "redirect:/phone/list";
		}
		//수정
		@RequestMapping(value="/phone/modify", method= {RequestMethod.GET, RequestMethod.POST})
		private String modify(@ModelAttribute PersonVo personVo) {
			System.out.println("PhonebookController.modify()");
			
//			System.out.println(personVo);
			//서비스
			phonebookService.exeModify(personVo);
			
			return "redirect:/phone/list";
			
		}
		//수정폼
		@RequestMapping(value="/phone/modifyform", method= {RequestMethod.GET, RequestMethod.POST}) //=이 주소에 오면 일할 수 있게 주소좀 등록해주렴.
		private String modifyForm(@RequestParam(value="no") int no , Model model) {//파라미터 가져오기- 하나씩 꺼내오거나 두개이상은 묶어줘 의 2가지 방법이 있다. 지금은 int no 1개만 받아옴.
			System.out.println("PhonebookController.modifyForm()");
			System.out.println(no);
			
			//서비스 연결
			PersonVo personVo = phonebookService.exeModifyForm(no);
			

			
			model.addAttribute("personVo" ,personVo); //이름,주소 로 담아준다.
			return "modifyForm";
			
		}
		//수정폼2
		@RequestMapping(value="/phone/modifyform2", method= {RequestMethod.GET, RequestMethod.POST}) //=이 주소에 오면 일할 수 있게 주소좀 등록해주렴.
		private String modifyForm2(@RequestParam(value="no") int no , Model model) {//파라미터 가져오기- 하나씩 꺼내오거나 두개이상은 묶어줘 의 2가지 방법이 있다. 지금은 int no 1개만 받아옴.
			System.out.println("PhonebookController.modifyForm2()");
			System.out.println(no);
			
//			//서비스 연결
			Map<String , Object> pMap = phonebookService.exeModifyForm2(no);

			System.out.println(pMap);
			model.addAttribute("pMap" ,pMap); //이름,주소 로 담아준다.
			
			return "modifyForm2";
			
		}
		
}//컨트롤러 끝
