package com.wishconsole.flymagic.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebController {

	@Autowired
	private DataSource dataSource;

	@RequestMapping(value = "/welcome")
	public String testJSP() {

		System.out.println(dataSource.toString());
		try {
			Connection con = dataSource.getConnection();
			System.out.println(con.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "welcome";
	}
}
