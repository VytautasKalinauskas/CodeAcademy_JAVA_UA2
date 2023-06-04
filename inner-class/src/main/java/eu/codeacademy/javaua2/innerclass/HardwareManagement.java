package eu.codeacademy.javaua2.innerclass;


public class HardwareManagement {

    public void init() {
        var cpu = new CPU(300.99);
        var proc = cpu.new Processor(5.0, "AMD");
        var ram = new CPU.RAM(50, "rX");

        System.out.println(cpu);
        System.out.println(proc);
        System.out.println(ram);
        System.out.println(cpu.printInfo());
    }

}
