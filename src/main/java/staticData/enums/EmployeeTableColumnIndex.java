package staticData.enums;

public enum EmployeeTableColumnIndex {

    NAME("2","Name"),
    POSITION("3","Position"),
    OFFICE("4","Office"),
    AGE("5"," Age"),
    SALARY("6","Salary");


    String index;
    String name;

    EmployeeTableColumnIndex(String index, String name){
        this.index= index;
        this.name= name;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

}
