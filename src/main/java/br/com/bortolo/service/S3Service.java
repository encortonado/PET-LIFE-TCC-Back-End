package br.com.bortolo.service;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class S3Service {

	final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AmazonS3 s3Client;

	@Value("${s3.bucket}")
	String bucketName;

	public void uploadFile(String localFilePath) {

		try {

			LOG.info("Iniciando upload");
			File file = new File(localFilePath);
			s3Client.putObject(new PutObjectRequest(bucketName, "teste", file));
			LOG.info("Upload finalizado");

		} catch (AmazonServiceException e) {
			LOG.info("AmazonServiceException: " + e.getErrorMessage());
			LOG.info("Status Code: " + e.getErrorCode());
		} catch (AmazonClientException e) {
			LOG.info("AmazonClientException: " + e.getMessage());
		}

	}

}
