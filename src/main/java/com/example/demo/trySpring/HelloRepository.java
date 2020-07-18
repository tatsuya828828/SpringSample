package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
// コントローラークラスと同じようにRepositoryクラスにもアノテーションをつける
// こうすることでDIに登録される
@Repository
public class HelloRepository {
	@Autowired
	// JdbcTemplateとはSpringが用意しているJDBC接続用のクラス
	// JdbcTemplateを使う場合は、@Autowiredアノテーションをつける
	// @Autowiredをつけることで、インスタンスを生成してると思えば良い
	private JdbcTemplate jdbcTemplate;

	public Map<String, Object> findOne(int id){
		// SELECT文
		String query = "SELECT"+"employee_id,"+"employee_name,"+"age"+"FROM employee"+"WHERE employee_id = ?";
		// 検索実行
		Map<String, Object> employee = jdbcTemplate.queryForMap(query, id);
		return employee;
	}
}