package lt.codeacademy.springdataexample.controllers;

import lt.codeacademy.springdataexample.dto.HoldExamDto;
import lt.codeacademy.springdataexample.services.UserExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-exam")
public class UserExamController {

    @Autowired
    UserExamService userExamService;

    @PostMapping
    public ResponseEntity<HoldExamDto> holdExam(@RequestBody HoldExamDto holdExamDto) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(userExamService.holdExam(holdExamDto));
    }



}
