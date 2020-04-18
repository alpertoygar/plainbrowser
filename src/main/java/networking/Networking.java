package networking;

import logging.LoggerFactory;
import lombok.experimental.UtilityClass;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Logger;

@UtilityClass
public class Networking {

    private static final Logger LOGGER = LoggerFactory.getLogger(Networking.class);

    public String doGetRequest(String urlString) throws IOException {
        LOGGER.info("Fetching " + urlString);
        final URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        setHttpUrlConnectionSettings(con);

        int status = con.getResponseCode();

        if (locationIsMoved(status)) {
            con = handleMovedLocation(con);
        }

        String response = HttpResponseExtractor.getResponseContent(con);
        con.disconnect();
        return response;
    }

    private void setHttpUrlConnectionSettings(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setInstanceFollowRedirects(false);
    }

    private HttpURLConnection handleMovedLocation(HttpURLConnection httpURLConnection) throws IOException {
        String location = httpURLConnection.getHeaderField("Location");
        return getNewConnectionFromNewLocation(location);
    }

    private boolean locationIsMoved(int status){
        return status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM;
    }

    private HttpURLConnection getNewConnectionFromNewLocation(String location) throws IOException {
        URL newUrl = new URL(location);
        return (HttpURLConnection) newUrl.openConnection();
    }
}
