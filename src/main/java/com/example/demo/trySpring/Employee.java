package com.example.demo.trySpring;

import lombok.Data;

// 検索結果を入れるクラス
// @Dataアノテーションをつけるとgetterやsetterなどを自動で作成してくれる
// これは、Springではなくて、Lombokの機能
@Data
public class Employee {
	private int employeeId; // 従業員ID
	private String employeeName; // 従業員名
	private int age; // 年齢
}

// リポジトリークラスやサービスクラスなどの間で渡すクラスのことを、
// Springではドメインクラスと呼ぶ。
// Employeeクラスもドメインクラスである
