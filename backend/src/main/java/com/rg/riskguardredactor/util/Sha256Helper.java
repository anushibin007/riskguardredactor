package com.rg.riskguardredactor.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class Sha256Helper {

	public String toSha256(String input) {
		return DigestUtils.sha256Hex(input);
	}
}
