package com.movie.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.movie.mapper.TimeMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TimeMapperTest {
	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		System.out.println("timeMapper.getTime()="+timeMapper.getTime());
	}
	
	@Test
	public void testGetTime1() {
		System.out.println("timeMapper.getTime1()="+timeMapper.getTime1());
	}
}
