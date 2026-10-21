package prakash.model;

public class Student {
    private Long id;
    private String name;
    private String email;
    private  int age;
   public Student(){}
    public Student(String name,String email,int age){
        this.name=name;
        this.age=age;
        this.email=email;

    }

     public Long getId() {
         return id;
     }

     public String getName() {
         return name;
     }

     public String getEmail() {
         return email;
     }

     public int getAge() {
         return age;
     }

     public int age() {
         return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public String email() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long id() {
        return id;
    }

    public Student setId(Long id) {
        this.id = id;
        return this;
    }

    public String name() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
