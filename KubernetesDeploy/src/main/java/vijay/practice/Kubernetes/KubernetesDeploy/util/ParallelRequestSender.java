package vijay.practice.Kubernetes.KubernetesDeploy.util;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class ParallelRequestSender {

    public static void main(String args[]) {
        int reqCount = 2000; int loopCount=2000;


        try {


            List<CompletableFuture<Void>> completableFutureList = new ArrayList<>();

            for (int i = 0;i < reqCount;i++) {
                String urlString = "http://localhost:8080/hello?loopcount="+loopCount+"&reqno="+i;
                URL url = new URL(urlString);
                int finalI = i;
                CompletableFuture<Void> future = CompletableFuture.runAsync( ( ) -> {
                    HttpURLConnection connection = null;
                    try {
                        connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        int responseCode = connection.getResponseCode();
                        log.info("Response Code: {} req No {}" , responseCode, finalI);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                completableFutureList.add(future);
            }

            log.info("Loop completed");


            CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0])).join();

            log.info("Execution completed");

            // Get the response code


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
