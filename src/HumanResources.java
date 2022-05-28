import java.util.*;

public class HumanResources {
    ////initialize list of staff including manager and employee
    ArrayList<Staff> listStaff = new ArrayList<>();
    //create a list of Department
    ArrayList<Department> listDepartment = new ArrayList<Department>();
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        //call doMenu() method;
        doMenu(scan);
    }
    //the doMenu() method for the user to select the function
    public static void doMenu(Scanner scan)
    {
        //create function selection menu
        boolean flag = true;
        //create objListStaff object
        HumanResources objListStaff = new HumanResources();
        //get the information of the staff that has been initialized
        objListStaff.dataStaff();
        //get the information of the department that has been initialized
        objListStaff.dataDepartment();
        do {
            System.out.println("==============Mời Chọn=============");
            System.out.println("1. Hiện thị danh sách các nhân viên trong công ty");
            System.out.println("2. Hiện thị các bộ phận trong công ty");
            System.out.println("3. Hiện thị các nhân viên theo từng bộ phận");
            System.out.println("4. Thêm nhân viên mới vào công ty.");
            System.out.println("5. Tìm kiếm thông tin theo tên hoặc mã nhân viên");
            System.out.println("6. Hiện thị bảng lương của nhân viên toàn công ty");
            System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
            System.out.println("8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần");
            System.out.println("0. Thoát");
            int chon = scan.nextInt();
            switch(chon) {
                case 1:
                    //call the outputStaff method to display the list of staff
                    objListStaff.outputStaff();
                    break;
                case 2:
                    //call the displayDepartment method to display the list of department
                    objListStaff.displayDepartment();
                    break;
                case 3:
                    //call display Staff By Department method to display staff by department
                    objListStaff.displayStaffByDepartment();
                    break;
                case 4:
                    //call the inputStaff() method for the user to enter information for the staff
                    objListStaff.inputStaff(scan);
                    break;
                case 5:
                    //call findStaffById method to find staff by code or name
                   objListStaff.findStaffById(scan);
                    break;
                case 6:
                    //call calculateSalary() method to calculate staff salary
                   objListStaff.calculateSalary();
                    break;

                case 7:
                    //call displayPayrollascending() method to sort employee salary ascending
                    objListStaff.displayPayrollascending();
                    break;
                case 8:
                    //call displayPayrollDescending() method to sort employee salary descending
                    objListStaff.displayPayrollDescending();
                    break;
                case 0:
                    flag = false;
                    break;
            }

        }while (flag);
    }
    //dataStaff() method create staff information
    public void dataStaff()
    {
        //add employee to the list
        Staff Employee1 = new Employee(1,"Đức" , 26 , 2.5 , "18/8/2021" , "Project", 4 , 9);
        listStaff.add(Employee1);
        Staff Employee2 = new Employee(2,"Lan",24,2.3,"17/8/2020" , "Business" , 4  ,8 );
        listStaff.add(Employee2);
        Staff Employee3 = new Employee(3,"Dũng" , 27, 2.8 , "20/12/2019" , "Technical" , 4 ,10);
        listStaff.add(Employee3);
        //add manager to the list
        Staff manager1 = new Manager(4,"Ngọc" ,28,3.0 ,"30/4/2016", "Business" , 4 ,"Business Leader");
        listStaff.add(manager1);
        Staff manager2 = new Manager(5,"Hoàng" ,28,3.2 ,"1/5/2017", "Project" , 4 ,"Project Leader");
        listStaff.add(manager2);
        Staff manager3 = new Manager(6,"Hiếu" ,28,3.1 ,"1/6/2018", "Technical" , 4 ,"Technical Leader");
        listStaff.add(manager3);
    }
    //dataDepartment() method dacreat department infomation
    public void dataDepartment() {
        //add Department to the list
        Department d1 = new Department("D1", "Business", 0);
        listDepartment.add(d1);
        Department d2 = new Department("D2", "Project", 0);
        listDepartment.add(d2);
        Department d3 = new Department("D3", "Technical", 0);
        listDepartment.add(d3);
    }
    //inputStaff() medthod help users enter staff information
    public void inputStaff(Scanner scan)
    {
        boolean flag1 = true;
        do {
            System.out.println("1. Nhập nhân viên thường");
            System.out.println("2. Nhập Quản Lý");
            System.out.println("3. Thoát");
            int chon = scan.nextInt();
            Staff staff;
            switch (chon) {
                //apply polymorphism to add employees
                case 1:
                    staff = new Employee();
                    staff.input(scan);
                    listStaff.add(staff);
                    break;
                //apply polymorphism to add Manager
                case 2:
                    staff = new Manager();
                    staff.input(scan);
                    listStaff.add(staff);
                    break;
                case 3:
                    flag1 = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập 1,2,3");
                    break;
            }
        } while(flag1);
    }
    //outputStaff() method to display staff information
    public void outputStaff()
    {
        for(Staff staff : listStaff)
        {
            staff.displayInformation();
        }
    }
    //displayDepartment() method to display department infomation
    public void displayDepartment()
    {
        for(Department department : listDepartment) {
            //create a count variable to store employees
            int count = 0;
            for (Staff staff : listStaff) {
                if(department.getNameDepartment().equals(staff.getWorkingParts()))
                {
                    //If employees are in the same department, the count will increase
                    count++;
                }
                ////set property for NumberOfEmPloyee
                department.setNumberOfEmployees(count);
            }
            //shows all Department
            System.out.println(department.toString());
        }

    }
    //displayStaffByDepartment() method to display staff by department
    public void displayStaffByDepartment()
    {
        for(Department department : listDepartment) {
            //create a count variable to store employees
            int count = 0;
            for (Staff staff : listStaff) {
                if(department.getNameDepartment().equals(staff.getWorkingParts()))
                {
                    //If employees are in the same department, the count will increase
                    count++;
                }
                ////set property for NumberOfEmPloyee
                department.setNumberOfEmployees(count);
            }
        }
        for(Department department : listDepartment ) {
            System.out.println(department.toString());
            for (Staff staff : listStaff) {
                //If the department name is the same as the employee's department name, then display the employee by that department
                if(department.getNameDepartment().equals(staff.getWorkingParts()))
                {
                    staff.displayInformation();
                }
            }
        }
    }
    //findStaffById() method helps user to search staff by code or name
    public void findStaffById(Scanner scan)
    {
        boolean flag2 = true;
        do {
            System.out.println("1. Tìm kiếm theo mã");
            System.out.println("2. Tìm kiếm theo tên");
            System.out.println("3. Thoát");
            int chon2 = scan.nextInt();
            switch (chon2) {
                // Search for employees by code
                case 1:
                    System.out.println("Nhập mã cần tìm");
                    int id = scan.nextInt();
                    //No staff found
                    Staff staff = null;
                    for (Staff staff1 : listStaff)
                    {
                        if(staff1.getId() == id)
                        {
                            //if the employee is found, st = E will be assigned;
                            staff = staff1;
                            staff.displayInformation();
                            break;
                        }

                    }
                    //if st = null then employee does not exist
                    if(staff == null)
                    {
                        System.out.println("Nhân viên không tồn tại.");
                    }
                    break;
                // Search for employees by name
                case 2:
                    System.out.println("Nhập tên cần tìm");
                    scan.nextLine();
                    String name = scan.nextLine();
                    Staff staff2 = null;
                    for (Staff staff3 : listStaff)
                    {
                        if(staff3.getName().toLowerCase().equals(name.toLowerCase()))
                        {
                            staff2 = staff3;
                            staff3.displayInformation();
                            break;
                        }
                    }
                    if(staff2 == null)
                    {
                        System.out.println("Nhân viên không tồn tại.");
                    }
                    break;
                case 3:
                    flag2 = false;
                    break;
            }
        } while(flag2);
    }
    //calculateSalary() method to calculate employee salary
    public void calculateSalary()
    {
        for(Staff staff : listStaff)
        {
            double caculateSalary = 0;
            staff.displayInformation();
            if(staff instanceof Employee)
            {
                caculateSalary =  ((Employee) staff).calculateSalary();
            }
            if(staff instanceof Manager)
            {
                caculateSalary = ((Manager) staff).calculateSalary();
            }
            System.out.println("Lương: " + Math.round(caculateSalary));
        }
    }
    //displayPayrollascending method to sort employee salary ascending
    public void displayPayrollascending()
    {
        //create a list to store all employee's salary
        ArrayList<Double> listSalary  = new ArrayList<Double>();
        for(Staff staff : listStaff)
        {
            double caculateSalary = 0;
            if(staff instanceof Employee)
            {
                caculateSalary =  ((Employee) staff).calculateSalary();

            }
            if(staff instanceof Manager)
            {
                caculateSalary =  ((Manager) staff).calculateSalary() ;

            }
            //add staff salary to the list
            listSalary.add(caculateSalary);
        }
        //sort(Comparator.naturalOrder()) method to sort the salary list ascending
        listSalary.sort(Comparator.naturalOrder());
        for(int i = 0 ; i < listSalary.size() ; i++)
        {
            for(Staff staff : listStaff)
            {
                double caculateSalary = 0;
                if(staff instanceof Employee)
                {
                    caculateSalary =  ((Employee) staff).calculateSalary();

                }
                if(staff instanceof Manager)
                {
                    caculateSalary =  ((Manager) staff).calculateSalary() ;

                }
                //If the salary in listSalary is equal to the staff's salary, the employee will be displayed according to the increasing salary
                if(listSalary.get(i) == caculateSalary)
                {
                    staff.displayInformation();
                    System.out.println("Lương: " + Math.round(listSalary.get(i)));
                }

            }
        }

        }
        // //sort(Comparator.naturalOrder()) method to sort the salary list decrease
        public void displayPayrollDescending()
        {
            ArrayList<Double> listSalary  = new ArrayList<Double>();
            for(Staff staff : listStaff)
            {
                double caculateSalary = 0;
                if(staff instanceof Employee)
                {
                    caculateSalary =  ((Employee) staff).calculateSalary();

                }
                if(staff instanceof Manager)
                {
                    caculateSalary =  ((Manager) staff).calculateSalary() ;

                }
                listSalary.add(caculateSalary);
            }

            listSalary.sort(Comparator.reverseOrder());
            for(int i = 0 ; i < listSalary.size() ; i++)
            {
                for(Staff staff : listStaff)
                {
                    double caculateSalary = 0;
                    if(staff instanceof Employee)
                    {
                        caculateSalary =  ((Employee) staff).calculateSalary();

                    }
                    if(staff instanceof Manager)
                    {
                        caculateSalary =  ((Manager) staff).calculateSalary() ;

                    }
                    if(listSalary.get(i) == caculateSalary)
                    {
                        staff.displayInformation();
                        System.out.println("Lương: " + Math.round(listSalary.get(i)));
                    }

                }
            }
        }
    }


