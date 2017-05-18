package com.jts.weixin.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jts.weixin.utils.WeixinUtil;
import com.jts.weixin.web.modle.AccessToken;

/**
 * 定时获取微信access_token的线程
 * 在WechatMpDemoApplication中注解@EnableScheduling，在程序启动时就开启定时任务。 每7200秒执行一次
 */
@Component
public class AccessTokenThread {
	private static Logger log = LoggerFactory
			.getLogger(AccessTokenThread.class);

	// 第三方用户唯一凭证
	public static String appid = "wx97a9b12cdf8a7ab4";

	// 第三方用户唯一凭证密钥
	public static String appsecret = "67718990a97ba583ab8e4162c5e19fa8";
	// 第三方用户唯一凭证
	public static AccessToken accessToken = null;

	@Scheduled(fixedDelay = 2 * 3600 * 1000)
	// 7200秒执行一次
	public void gettoken() {
		accessToken = WeixinUtil.getAccessToken(appid, appsecret);
		if (null != accessToken) {
			log.info("获取成功，accessToken:" + accessToken.getToken());
		} else {
			log.error("获取token失败");
		}
	}
}
