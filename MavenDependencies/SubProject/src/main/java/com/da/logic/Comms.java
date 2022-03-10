package com.da.logic;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class Comms {

    public Client createClient() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustManager = new X509TrustManager[] { new X509TrustManager() {

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkClientTrusted(X509Certificate[] certs, String authType) {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] certs, String authType) {

            }
        }};

        SSLContext sslContext = null;
        sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustManager, null);

        var feature = OAuth2ClientSupport.feature("BIER");
        return ClientBuilder.newBuilder().sslContext(sslContext).register(feature).build();
    }
}
