package com.cisco.la.common;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

import com.cisco.la.Application;

public class MyX509TrustManager implements X509TrustManager {

	@Override
	public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
		Application.logger.debug("MyX509TrustManager");
		Application.logger.debug("" + xcs.length);
		Application.logger.debug(xcs[0].getSigAlgName());
		Application.logger.debug(string);
	}

	@Override
	public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
		Application.logger.debug("MyX509TrustManager");
		Application.logger.debug("" + xcs.length);
		Application.logger.debug(xcs[0].getSigAlgName());
		Application.logger.debug(string);
	}

	@Override
    public X509Certificate[] getAcceptedIssuers() {
		Application.logger.debug("MyX509TrustManager");
		Application.logger.debug("" + (new X509Certificate[0]).length);
		return new X509Certificate[0];
    }
}