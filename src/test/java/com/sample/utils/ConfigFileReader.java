package com.sample.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath =  "Config//Configurations.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getFrontUrl_qa3_6_auto() {
		String url = properties.getProperty("frontURL");
		if (url != null)
			return url;
		else
			throw new RuntimeException("front url not specified in the Configuration.properties file.");
	}

	public String getAdminUrl_qa3_6_auto() {
		String url = properties.getProperty("adminURL");
		if (url != null)
			return url;
		else
			throw new RuntimeException("admin url not specified in the Configuration.properties file.");
	}

	public String getdev3_4Url() {
		String url = properties.getProperty("dev3_4front");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}


	public String getqa3_5adminUrl() {
		String url = properties.getProperty("qa3_5admin");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getFrontApiUrl() {
		String url = properties.getProperty("frontapiURL");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getdev_auctionUrl() {
		String url = properties.getProperty("devauction");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getdevUrl() {
		String url = properties.getProperty("devfront");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String settlement_Url() {
		String url = properties.getProperty("my-settlements");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getqa_dev_autofrontendUrl() {
		String url = properties.getProperty("qa_dev_autofrontend");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getqa_dev_autoadminUrl() {
		String url = properties.getProperty("qa_dev_autoadmin");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getdev_main() {
		String url = properties.getProperty("dev_main");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getqa_MainAutoAdmin() {
		String url = properties.getProperty("qaMainAutoAdmin");

		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getqa_MainAutoFront() {
		String url = properties.getProperty("qaMainAutoFront");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getdev3_6_Admin() {
		String url = properties.getProperty("dev3-6-Admin");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getdev3_6_Front() {
		String url = properties.getProperty("dev3-6-Front");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getqa_main() {
		String url = properties.getProperty("qa_main");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String qa_dev_rc_admin() {
		String url = properties.getProperty("qa_dev_rc_admin");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String qa_dev_rc_front() {
		String url = properties.getProperty("qa_dev_rc_front");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getAdminURL() {

		String url = properties.getProperty("Admin_URL");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");

	}

	public String getFrontURL() {

		String url = properties.getProperty("Front_URL");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");

	}
	
	public String getAlt1Admin() {

		String url = properties.getProperty("alt1Admin");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");

	}
	
	public String getAlt2Admin() {

		String url = properties.getProperty("alt2Admin");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");

	}
	
	public String getAlt2Front() {

		String url = properties.getProperty("alt2Font");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");

	}
	/**
	 * frontURL=https://bid:path@qa3-6-auto.auctionserver.net/
	 * adminURL=https://bid:path@qa3-6-auto.auctionserver.net/admin
	 * dev3_4front=https://bid:path@dev3-4.auctionserver.net/
	 * devfront=https://bid:path@dev.auctionserver.net/ qa3_5admin
	 * =https://bid:path@qa3-5-auto.auctionserver.net/admin
	 * devauction:https://bid:path@dev.auctionserver.net/admin
	 * frontapiURL=https://qa3-6-auto.auctionserver.net/api/soap12
	 * my-settlements=https://bid:path@qa-main-auto.auctionserver.net/my-settlements
	 * qa_dev_autofrontend=https://bid:path@qa-dev-auto.auctionserver.net/
	 * qa_dev_autoadmin=https://bid:path@qa-dev-auto.auctionserver.net/admin
	 * dev_main = https://bid:path@dev-main.auctionserver.net/admin qaMainAutoAdmin
	 * = https://bid:path@qa-main-auto.auctionserver.net/admin qaMainAutoFront =
	 * https://bid:path@qa-main-auto.auctionserver.net/ dev3-6-Admin =
	 * https://bid:path@dev3-6.auctionserver.net/admin dev3-6-Front =
	 * https://bid:path@dev3-6.auctionserver.net/ qa_main =
	 * https://bid:path@qa-main.auctionserver.net/admin qa_main_Front =
	 * https://bid:path@qa-main.auctionserver.net/ qa_dev_rc_admin =
	 * https://bid:path@qa-dev-rc-auto.auctionserver.net/admin qa_dev_rc_front =
	 * https://bid:path@qa-dev-rc-auto.auctionserver.net/ browser = chrome Admin_URL
	 * * = https://bid:path@qa-dev-rc-auto.auctionserver.net/admin Front_URL =
	 * https://bid:path@qa-dev-rc-auto.auctionserver.net/
	 **/
}
