package vijay.practice.Kubernetes.KubernetesDeploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class KubernetesDeployApplication {

	public static void main(String[] args) {
		SpringApplication.run(KubernetesDeployApplication.class, args);
		List<Integer> nums = new ArrayList<>();

		nums.stream().filter( n -> true).sorted(Comparator.reverseOrder()).toList();
	}






}
