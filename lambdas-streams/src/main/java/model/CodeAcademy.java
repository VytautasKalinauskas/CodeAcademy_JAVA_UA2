package model;

public class CodeAcademy implements CodeAcademyI {
    @Override
    public void study(Integer time) {
        System.out.println("we will study for " + time + " minutes");
    }

    @Override
    public void haveBreak(Integer time) {
        System.out.println("we will have break for " + time + " minutes");
    }
}
