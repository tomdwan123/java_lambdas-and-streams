package com.phucdevs.streams.exam;

import java.util.Optional;

public class Q2_1826 {

    public static void main(String[] args) {

        /*
           5. Code a method public static Optional<String> getGrade(int marks) (QID 2.1826)
                a. in the method getGrade:
                    i. declare an empty optional, typed for String called grade
                    ii. insert the following code:
                        if (marks > 50) {grade = Optional.of(“PASS”);} else {grade.of(“FAIL”);}
                b. in main():
                    i. declare an Optional, typed for String named grade1 which is initialised to the return
                    value of calling getGrade(50)
                    ii. declare an Optional, typed for String named grade2 which is initialised to the return
                    value of calling getGrade(55)
                    iii. using orElse() on grade1, output the value of grade1 or “UNKNOWN”
                    iv. if(grade2.isPresent()) is true: use ifPresent(Consumer) to output the contents of
                    grade2; if false, use orElse() to output the contents of grade2 or “Empty”
                    v. Notes:
                        1. Optional’s are immutable.
                        2. Optional.of(null); // NullPointerException
                        3. Optional.ofNullable(null); // Optional.empty returned
         */

        Optional<String> grade1 = getGrade(50);
        System.out.println("grade1 = " + grade1.get()); // FAIL

        Optional<String> grade2 = getGrade(55);
        System.out.println("grade2 = " + grade2.get()); // PASS

        System.out.println("grade1OrElse = " + grade1.orElse("UNKNOWN")); // UNKNOWN

        if (grade2.isPresent()) {
            grade2.ifPresent(x -> System.out.println(x));
        } else {
            grade2.orElse("Empty");
        }
    }

    public static Optional<String> getGrade(int marks) {

        Optional<String> grade = Optional.empty();
        if (marks > 50) {
            grade = Optional.of("PASS");
        } else {
            grade = Optional.of("FAIL");
        }

        return grade;
    }
}
