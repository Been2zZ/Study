package ssafy0820;

public class EmpDto {
    private int id;
    private String name;
    private String mailid;
    private String start_date;
    private int manager_id;
    private String title;
    private int dept_id;
    private double salary;
    private double commission_pct;

    public EmpDto(int id, String name, String mailId) {
        this.id = id;
        this.name = name;
        this.mailid = mailId;
    }

    public EmpDto(int id, String name, String mailid, String start_date, int manager_id, String title, int dept_id, double salary, double commission_pct) {
        this.id = id;
        this.name = name;
        this.mailid = mailid;
        this.start_date = start_date;
        this.manager_id = manager_id;
        this.title = title;
        this.dept_id = dept_id;
        this.salary = salary;
        this.commission_pct = commission_pct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailid() {
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(double commission_pct) {
        this.commission_pct = commission_pct;
    }

    @Override
    public String toString() {
        return "EMPDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mailid='" + mailid + '\'' +
                ", start_date='" + start_date + '\'' +
                ", manager_id=" + manager_id +
                ", title='" + title + '\'' +
                ", dept_id=" + dept_id +
                ", salary=" + salary +
                ", commission_pct=" + commission_pct +
                '}';
    }
}
