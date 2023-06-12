package lt.codeacademy.restapiexample.utils;

import lt.codeacademy.restapiexample.exceptions.InvalidPersonalCodeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Arrays;

public class PersonalCodeUtil {
    public static LocalDate convertPersonalCodeToBirthDate(String personalCode) {
        if (personalCode.isEmpty()) {
            throw new InvalidPersonalCodeException("is empty");
        }

        if (personalCode.length() != 11) {
            throw new InvalidPersonalCodeException("length should be exactly 11 characters long");
        }

        int century = Integer.parseInt(String.valueOf(personalCode.charAt(0)));

        if (!Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}).contains(century)) {
            throw new InvalidPersonalCodeException("century should be one of [1,2,3,4,5,6]");
        }

        int year = convertCenturyToYear(century) + Integer.parseInt(personalCode.substring(1, 3));
        int month = Integer.parseInt(personalCode.substring(3, 5));
        int day = Integer.parseInt(personalCode.substring(5, 7));
        return LocalDate.of(year, month, day);
    }

    private static Integer convertCenturyToYear(Integer century) {
        switch (century) {
            case 1:
            case 2:
                return 1800;
            case 3:
            case 4:
                return 1900;
            case 5:
            case 6:
                return 2000;
            default:
                throw new InvalidPersonalCodeException("century should be one of [1,2,3,4,5,6]");
        }
    }
}
