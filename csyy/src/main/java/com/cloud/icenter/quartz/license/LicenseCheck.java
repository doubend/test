package com.cloud.icenter.quartz.license;

import java.util.Date;

import org.springframework.core.io.ClassPathResource;

import com.isoftstone.license.v1.client.LicenseVerify;
import com.isoftstone.license.v1.client.bean.PublicParam;

public class LicenseCheck {
	public LicenseCheck() {
	}

	public void  execute() {
		Date d = new Date();
		System.out.println(d.toString());
		try {
			PublicParam publicParam = new PublicParam("isoftstone456", LicenseVerify.class, "/public.store",
					"isoftstone_public", "isoftstone_csyy_sub");
			if (new ClassPathResource("simple.license").exists()) {
				LicenseVerify verify = new LicenseVerify(publicParam,
						new ClassPathResource("simple.license").getFile().getPath());
				if (!verify.verify()) {
					System.out.println("非法的授权文件");
					System.exit(0);
				}
			} else {
				System.out.println("授权文件不存在");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("公钥文件或授权文件不存在");
			System.exit(0);
		}

	}
}
