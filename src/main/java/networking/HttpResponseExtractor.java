package networking;

import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;

@UtilityClass
class HttpResponseExtractor {
    static String getFullResponse(HttpURLConnection con) throws IOException {

        return getHttpStatus(con) +
                getHttpHeaders(con) +
                getResponseContent(con);
    }

    static String getHttpStatus(HttpURLConnection con) throws IOException {

        return con.getResponseCode() +
                " " +
                con.getResponseMessage() +
                "\n";
    }

    static String getHttpHeaders(HttpURLConnection con) {
        StringBuilder fullResponseBuilder = new StringBuilder();

        con.getHeaderFields().entrySet().stream()
                .filter(entry -> entry.getKey() != null)
                .forEach(entry -> {
                    fullResponseBuilder.append(entry.getKey()).append(": ");
                    List headerValues = entry.getValue();
                    Iterator it = headerValues.iterator();
                    if (it.hasNext()) {
                        fullResponseBuilder.append(it.next());
                        while (it.hasNext()) {
                            fullResponseBuilder.append(", ").append(it.next());
                        }
                    }
                    fullResponseBuilder.append("\n");
                });

        return fullResponseBuilder.toString();
    }

    static String getResponseContent(HttpURLConnection con) throws IOException {
        int status = con.getResponseCode();

        Reader streamReader;

        if (status > 299) {
            streamReader = new InputStreamReader(con.getErrorStream());
        } else {
            streamReader = new InputStreamReader(con.getInputStream());
        }

        BufferedReader in = new BufferedReader(streamReader);
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        return content.toString();
    }
}
