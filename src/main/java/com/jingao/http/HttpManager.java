package com.jingao.http;

import java.net.URI;

import javax.net.ssl.SSLContext;

import org.glassfish.grizzly.ssl.SSLEngineConfigurator;
import org.glassfish.jersey.SslConfigurator;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.jingao.Config.ConfigDataPool;
import com.jingao.base.Operator;

/**
 * 
 * @ClassName: HttpManager
 * @Description: TODO(http访问控制)
 * @author Administrator
 * @date 2017年8月18日
 *
 */
public class HttpManager implements Operator {

	/**
	 * 
	 */
	public void init() throws Exception {
		Integer authType = 1;

		SslConfigurator sslConfig = SslConfigurator.newInstance();
		if (authType == 1) {
			sslConfig.keyStoreFile(ConfigDataPool.config("SSLConfig").get("serverCer"))
					.keyStorePassword(ConfigDataPool.config("SSLConfig").get("serverCerPwd"))
					.keyPassword(ConfigDataPool.config("SSLConfig").get("serverKeyPwd"));
		} else if (authType == 2) {
			sslConfig.keyStoreFile(ConfigDataPool.config("SSLConfig").get("serverCer"))
					.keyStorePassword(ConfigDataPool.config("SSLConfig").get("serverCerPwd"))
					.keyPassword(ConfigDataPool.config("SSLConfig").get("serverKeyPwd"))
					.trustStoreFile(ConfigDataPool.config("SSLConfig").get("serverTrustCer"))
					.trustStorePassword(ConfigDataPool.config("SSLConfig").get("serverTrustCerPwd"));
		}
		sslConfig.securityProtocol(ConfigDataPool.config("SSLConfig").get("protocol"));
		SSLContext sslContext = sslConfig.createSSLContext();

		SSLEngineConfigurator sslEngineConfig = new SSLEngineConfigurator(sslContext);

		// 默认客户端模式
		sslEngineConfig.setClientMode(false);
		if (authType == 1)
			sslEngineConfig.setWantClientAuth(true);
		else if (authType == 2)
			sslEngineConfig.setNeedClientAuth(true);

		final ResourceConfig rc = new ResourceConfig().packages(ConfigDataPool.config("config").get("resourcePackage"));
		rc.register(MultiPartFeature.class);
		GrizzlyHttpServerFactory.createHttpServer(URI.create("https://"
				+ ConfigDataPool.config("config").get("HttpsURL") + ":" + ConfigDataPool.config.get("HttpsPort") + "/"),
				rc, true, sslEngineConfig);
		GrizzlyHttpServerFactory.createHttpServer(URI.create("http://" + ConfigDataPool.config("config").get("HttpURL")
				+ ":" + ConfigDataPool.config("config").get("HttpPort") + "/"), rc, false, sslEngineConfig);

	}

}
