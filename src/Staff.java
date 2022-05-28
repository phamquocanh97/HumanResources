import java.util.Scanner;
//create the abstract class Staff
public abstract class Staff  {
    //create attribute of the staff . object
    private int id;
    private String name;
    private int age;
    private double salaryFactor;
    private String startDayWork;
    private String workingParts;
    private int dayOff;
    //create constructor
    public Staff(int id , String name , int age, double salaryFactor ,String startDayWork , String workingParts, int dayOff)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salaryFactor = salaryFactor;
        this.startDayWork = startDayWork;
        this.workingParts = workingParts;
        this.dayOff = dayOff;
    }

    public Staff() {
        super();
    }


    //get,set methods
    public int getId()
    {
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public double getSalaryFactor(){
        return salaryFactor;
    }
    public void setSalaryFactor(double salaryFactor)
    {
        this.salaryFactor = salaryFactor;
    }
    public String getWorkingParts(){
        return workingParts;
    }
    public void setWorkingParts(String workingParts)
    {
        this.workingParts = workingParts;
    }
    public int getDayOff(){
        return dayOff;
    }
    public void setDayOff(int dayOff){
        this.dayOff = dayOff;
    }
    public String getStartDayWork(){
        return startDayWork;
    }
    public void setStartDayWork(String startDayWork)
    {
        this.startDayWork = startDayWork;
    }
    // input , output
    ////user enters information
    public void input(Scanner scan){
        System.out.println("Nhập mã nhân viên: ");
        this.id = scan.nextInt();
        scan.nextLine();
        System.out.println("Nhập tên nhân viên: ");
        this.name = scan.nextLine();
        System.out.println("Nhập tuổi nhân viên: ");
        this.age = scan.nextInt();
        System.out.println("Nhập hệ số lương: ");
        this.salaryFactor = scan.nextDouble();
        scan.nextLine();
        System.out.println("Nhập ngày bắt đầu làm: ");
        this.startDayWork = scan.nextLine();
        System.out.println("Nhập bộ phận làm việc(1.Business ,2.Project ,3.Technical): ");
        int chon = scan.nextInt();
        if (chon == 1)
        {
            this.workingParts = "Business";
        }
        else if(chon == 2)
        {
            this.workingParts = "Project";
        }
        else
        {
            this.workingParts = "Technical";
        }
        if (chon > 3){
        do {
            System.out.println("Nhập lại bộ phận làm việc(1.Business ,2.Project ,3.Technical): ");
             chon = scan.nextInt();
            if (chon == 1)
            {
                this.workingParts = "Business";
            }
            else if(chon == 2)
            {
                this.workingParts = "Project";
            }
            else
            {
                this.workingParts = "Technical";
            }

        }while(chon > 3);
        }

        System.out.println("Nhập số ngày nghỉ phép: ");
        this.dayOff = scan.nextInt();

    }
    //business method
    //function displayInformation() is an abstract function
    public abstract void displayInformation();

}
