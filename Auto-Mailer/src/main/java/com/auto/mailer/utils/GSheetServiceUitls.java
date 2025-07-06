package com.auto.mailer.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auto.mailer.constants.Constants;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;

@Component
public class GSheetServiceUitls {

	private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

	private static final Logger logger = LogManager.getLogger(GSheetServiceUitls.class);

	@Value("${auto.mailer.gsheets.oauth.cred}")
	private String credPath;

//	sheets scope all(crud)
	private static final List<String> SCOPES = List.of(SheetsScopes.SPREADSHEETS);

	Credential credential;

	public Sheets getSheetService() throws IOException, GeneralSecurityException {
		File file = new File(credPath);

		NetHttpTransport newTrustedTransport = GoogleNetHttpTransport.newTrustedTransport();
		try (InputStream in = new FileInputStream(file)) {

			GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

			GoogleAuthorizationCodeFlow authorizationCodeFlow = new GoogleAuthorizationCodeFlow.Builder(
					newTrustedTransport, JSON_FACTORY, clientSecrets, SCOPES)
					.setDataStoreFactory(new FileDataStoreFactory(new java.io.File("gsheets_tokens")))
					.setAccessType("offline").build();

			LocalServerReceiver localServerReceiver = new LocalServerReceiver.Builder().setPort(8888).build();

			credential = new AuthorizationCodeInstalledApp(authorizationCodeFlow, localServerReceiver)
					.authorize("user");

		} catch (Exception e) {
			logger.error("Exception Occured");
		}
		return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, credential)
				.setApplicationName(Constants.APPLICATION_NAME).build();

	}

}
