package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// コントローラークラスなどと同様に、サービスクラスには@Serviceアノテーションをつける
@Service
// 検索結果をEmployeeクラスに入れて返すクラス
public class HelloService {
	// HelloRepositoryクラスを使うために@Autowiredアノテーションをつける
	@Autowired
	private HelloRepository helloRepository;

	// 1件検索実行
	public Employee findOne(int id) {
		Map<String, Object> map = helloRepository.findOne(id);
		// Mapから値を取得
		int employeeId = (Integer) map.get("employee_id");
		String employeeName = (String) map.get("employee_name");
		int age = (Integer) map.get("age");
		// Employeeクラスに値をセット
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setAge(age);
		return employee;
	}
}
