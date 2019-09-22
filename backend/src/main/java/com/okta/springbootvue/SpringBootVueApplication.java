package com.okta.springbootvue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import com.okta.springbootvue.entity.*;
import com.okta.springbootvue.repository.*;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootVueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVueApplication.class, args);
	}
	@Bean
	ApplicationRunner init(HospitalRepository hospitalRepository,CurebyRepository curebyRepository,CustomerRepository customerRepository,InsuranceRepository insuranceRepository,PaychecksRepository paychecksRepository,TreatmethodRepository treatmethodRepository){
		return args ->{
			hospitalRepository.save(new Hospital("Korat Hospital"));
			curebyRepository.save(new Cureby("ศัลยกรรม"));
			curebyRepository.save(new Cureby("ใช้ยา"));
			customerRepository.save(new Customer("Cherprang","Female","BKK","BangKapi","BangKapi","Cherprang@bnk48.com","0912345678",23));
			insuranceRepository.save(new Insurance("ประกันสุขภาพ"));
			insuranceRepository.save(new Insurance("ประกันอุบัติเหตุ"));
			paychecksRepository.save(new Paychecks("ผู้เอาประกันภัย"));
			paychecksRepository.save(new Paychecks("ผู้เสียหาย"));
			paychecksRepository.save(new Paychecks("ตัวแทน"));
			paychecksRepository.save(new Paychecks("ตามที่อยู่ข้างต้น"));
			paychecksRepository.save(new Paychecks("บัญชี"));
			treatmethodRepository.save(new Treatmethod("เอ๊กซ์เรย์"));
			treatmethodRepository.save(new Treatmethod("ตรวจหัวใจ"));
			treatmethodRepository.save(new Treatmethod("ตรวจเลือด"));
			treatmethodRepository.save(new Treatmethod("ทำแผล"));
			
			hospitalRepository.findAll().forEach(System.out::println);
			curebyRepository.findAll().forEach(System.out::println);
 			customerRepository.findAll().forEach(System.out::println);
			insuranceRepository.findAll().forEach(System.out::println);
			paychecksRepository.findAll().forEach(System.out::println);
			treatmethodRepository.findAll().forEach(System.out::println); 

		};
	}
}
