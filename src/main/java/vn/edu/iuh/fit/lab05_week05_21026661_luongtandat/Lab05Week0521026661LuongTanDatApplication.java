package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Address;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Candidate;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.AddressServices;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.CandidateServices;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.impl.AddressServicesImpl;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.impl.CandidateServiceImpl;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class Lab05Week0521026661LuongTanDatApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab05Week0521026661LuongTanDatApplication.class, args);
    }

//    @Autowired
//    private CandidateServices candidateServices = new CandidateServiceImpl();
//    @Autowired
//    private AddressServices addressServices = new AddressServicesImpl();

//    @Bean
//    CommandLineRunner initData() {
//        return args -> {
//            Random rnd = new Random();
//            for (int i = 0; i < 1000; i++) {
//                Address add = new Address(rnd.nextLong(1, 1000) + "", "Quang Trung", "HCM",
//                        rnd.nextInt(70000, 80000) + "", CountryCode.VN);
//                addressServices.saveAddress(add);
//                Candidate can = new Candidate("Name #" + i,
//                        LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)),
//                        add,
//                        rnd.nextLong(1111111111L, 9999999999L) + "",
//                        "email_" + i + "@gmail.com");
//                candidateServices.saveCandidate(can);
//                System.out.println("Added: " + can);
//            }
//        };
//    }
}
