package com.moretolearn.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.moretolearn.repository")
public class DynamoDBConfig {

	@Value("${dynamodb.endpoint}")
	String endpoint;
	@Value("${dynamodb.accesskey}")
	String accesskey;
	@Value("${dynamodb.secretkey}")
	String secretkey;
	@Value("${dynamodb.region}")
	String region;
	
	@Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(endpoint,region))
				.withCredentials(
						new AWSStaticCredentialsProvider(new BasicAWSCredentials(accesskey,secretkey)))
                .build();
    }
}

