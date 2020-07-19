package com.example.demo.trySpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HomeController {
	@Autowired
	private HelloService helloService;

	@GetMapping("/hello")
	public String getHello() {
		// hello.htmlに画面遷移
		return "hello";
	}


	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1")String str, Model model) {
		// 画面から受け取った文字列をModelに登録
		model.addAttribute("sample", str);
		// helloResponse.htmlに画面遷移
		return "helloResponse";
	}

	// /hello/dbを処理するメソッド
	@PostMapping("hello/db")
	// @RequestParamアノテーションでtext2という名前のパラメータを受け取る
	// あとはその値をHelloServiceクラスのfindOneメソッドに渡せば、検索結果としてEmployeeのインスタンスが返ってくる
	// Employeeクラスの値をmodel.addAtributeで登録しておけば画面で受け取ることができる

	public String postDbRequest(@RequestParam("text2")String str, Model model) {
		// Stringからintに変換
		int id = Integer.parseInt(str);
		// 1件検索
		Employee employee = helloService.findOne(id);
		// 検索結果をModelに登録
		model.addAttribute("id", employee.getEmployeeId());
		model.addAttribute("name", employee.getEmployeeName());
		model.addAttribute("age", employee.getAge());

		// helloResponseDBに画面遷移
		return "helloResponseDB";
	}
}
