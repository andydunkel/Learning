package com.dasoftware.integratedserver.comms;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class Comms {

    private Client createClient() throws NoSuchAlgorithmException, KeyManagementException {
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

        var client = ClientBuilder.newBuilder().sslContext(sslContext).build();
        return client;
    }
    public CatFact getCatFacts() throws NoSuchAlgorithmException, KeyManagementException {
        var url = "https://catfact.ninja/fact";

        var client = createClient();
        var resp = client.target(url).request().get();
        resp.bufferEntity();
        var result = resp.readEntity(CatFact.class);
        return result;
    }
}
