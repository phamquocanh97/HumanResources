import java.util.Scanner;
//create class Employee which inherits parent class Staff
public class Employee extends Staff implements ICalculator{
    //creat Attribute for class Employee
    public int overtimeHours;
    //crear constructor for class Employee
    public Employee(int code, String name, int age, double salaryFactor, String startDayWork, String workingParts, int dayOff , int overtimeHours){
        super(code,name,age,salaryFactor,startDayWork,workingParts,dayOff);
        this.overtimeHours = overtimeHours;
    }

    public Employee() {
        super();

    }
    //get,set methods
    public int getOvertimeHours(){
        return overtimeHours;
    }
    public void setOvertimeHours(int overtimeHours)
    {
        this.overtimeHours = overtimeHours;
    }
    //input , output
    @Override
    public void input(Scanner scan){
        super.input(scan);
        System.out.println("Nhập số giờ làm thêm: ");
        this.overtimeHours = scan.nextInt();
    }
    @Override
    public void displayInformation()
    {

        System.out.println("Mã: " + getId() +"\t Tên: " + getName() + "\t Tuổi: " + getAge() + "\t Hệ số lương: "
                + getSalaryFactor() + "\t Ngày bắt đầu làm: " + getStartDayWork() +
                "\t bộ phận làm việc: " + getWorkingParts() + "\t số ngày nghỉ phép: " + getDayOff() + "\t Số giờ làm thêm: " + this.overtimeHours);
    }
    //business method
    //salary calculation of management staff
    @Override
    public double calculateSalary(){
        return super.getSalaryFactor() * 3000000 + overtimeHours * 200000;
    };


}
