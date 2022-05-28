import java.util.Scanner;
//create a manger class that inherits staff
public class Manager extends Staff implements ICalculator{
    //create attribute for class manager
    private String title;
    ////create constructor
    public Manager(int code , String name , int age, double salaryFactor ,String startDayWork , String workingParts, int dayOff,String title){
        super(code,name,age,salaryFactor,startDayWork,workingParts,dayOff);
        this.title = title;
    }
    public Manager(){
        super();
    }
    //get,set methods
    public String getTitle(){
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    //input , output
    @Override
    public void input(Scanner scan){
        //super keyword inherits staff input
        super.input(scan);
        System.out.println("Nhập chức danh(1.Business Leader , 2.Project Leader , 3.Technical Leader): ");
        int chon = scan.nextInt();
        if(chon == 1)
        {
            title = "Business Leader";
        }
        else if (chon == 2)
        {
            title = "Project Leader";
        }
        else
        {
            title = "Technical Leader";
        }

        if(chon > 3) {
            do {
                System.out.println("Nhập lại chức danh(1.Business Leader , 2.Project Leader , 3.Technical Leader): ");
                chon = scan.nextInt();
                if(chon == 1)
                {
                    title = "Business Leader";
                }
                else if (chon == 2)
                {
                    title = "Project Leader";
                }
                else
                {
                    title = "Technical Leader";
                }
            } while (chon > 3);
        }
    }
    //Display information of management staff
    @Override
    public void displayInformation()
    {


        System.out.println("Mã: " + getId() +"\t Tên: " + getName() + "\t Tuổi: " + getAge() + "\t Hệ số lương: "
                + getSalaryFactor() + "\t Ngày bắt đầu làm: " + getStartDayWork() +
                "\t bộ phận làm việc: " + getWorkingParts() + "\t số ngày nghỉ phép: " + getDayOff() + "\t Chức danh: " + title);
    }
    //business methods
    //salary calculation of management staff
    @Override
    public double calculateSalary(){
        if (title == "Business Leader")
        {
            return getSalaryFactor() * 5000000 + 8000000;
        }
        else if ( title == "Project Leader")
        {
            return getSalaryFactor() * 5000000 + 5000000;
        }
        else
        {
            return getSalaryFactor() * 5000000 + 6000000;
        }
    }


}
