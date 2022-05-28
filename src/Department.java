//create Department class containing department information
public class Department {
    //creat attribute for class Department
    private String idDepartment;
    private String nameDepartment;
    private int numberOfEmployees;
    //creat constructor for class Department
    public Department(String idDepartment , String nameDepartment , int numberOfEmployees)
    {
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
        this.numberOfEmployees = numberOfEmployees;

    }
    //get,set methods
    public int getIdDepartment(){
        return getIdDepartment();
    }
    public void setIdDepartment(String idDepartment)
    {
        this.idDepartment = idDepartment;
    }
    public String getNameDepartment(){
        return nameDepartment;

    }
    public void setNameDepartment(String nameDepartment)
    {
        this.nameDepartment = nameDepartment;
    }
    public int getNumberOfEmployees(){
        return numberOfEmployees;
    }
    public void setNumberOfEmployees(int numberOfEmployees)
    {
        this.numberOfEmployees = numberOfEmployees;
    }
    //toString() method displays information about Department
    public String toString(){

        return "mã bộ phận: " + this.idDepartment + "\t tên bộ phận: " + this.nameDepartment + "\t số lượng nhân viên hiện tại: " + this.numberOfEmployees;
    }
}
