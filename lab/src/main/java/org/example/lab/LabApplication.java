package org.example.lab;

import org.example.lab.entity.association.Association;
import org.example.lab.entity.association.Division;
import org.example.lab.entity.association.Member;
import org.example.lab.repository.AssociationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LabApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabApplication.class, args);
    }
    @Bean
    CommandLineRunner run(AssociationRepository repo) {
        return args -> {

            int memberCount = 0;

            List<Division> divisions = new ArrayList<>();

            for (int i = 1; i <= 7; i++) {

                List<Member> members = new ArrayList<>();

                Division division = new Division();
                division.setName("Division " + i);

                for (int j = 0; j < 3; j++) {
                    Member member = new Member();
                    member.setName("Member " + (++memberCount));

                    member.setDivision(division);
                    members.add(member);
                }

                division.setMembers(members);
                divisions.add(division);
            }

            Association association = new Association();
            association.setName("My Association");

            for (Division d : divisions) {
                d.setAssociation(association);
            }

            association.setDivisions(divisions);

            repo.save(association);
        };
    }
}
