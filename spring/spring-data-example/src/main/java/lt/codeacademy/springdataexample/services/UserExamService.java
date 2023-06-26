package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.repositories.UserExamRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserExamService {

    private UserExamRepository userExamRepository;

}
