package sample;

public class EmployeeInfo {

    private String fName;
    private String lName;
    private String code;

    public EmployeeInfo(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        if(!checkName(fName,lName)) {
            System.out.println("Please enter a first and last name");
            return;
        }
        createEmployeeCode(fName,lName);
    }

    private void createEmployeeCode(String fName, String lName) {
        code = (fName.substring(0,1) + "" + lName).toLowerCase();
    }

    private boolean checkName(String fName, String lName) {
        return !fName.equals("") && !lName.equals("");
    }

    public String getfName() {
       return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getCode() {
        return code;
    }

    private void setfName(String name) {
        this.fName = name;
    }

    private void setlName(String name) {
        this.lName = name;
    }

    //private String inputName() {}



}
