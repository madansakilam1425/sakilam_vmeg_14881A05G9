import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	int i,j;
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
        this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		if(students == null){
			throw new IllegalArgumentException("Null");
		}
         return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		
         this.students = students;
	}

	@Override
	public Student getStudent(int index) {
		if(index<0||index>=students.length)
		{
			throw new IllegalArgumentException("Null");
		}
          return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		if(students == null){
			throw new IllegalArgumentException("Null");
		}
		if(index<0||index>=students.length)
		{
			throw new IllegalArgumentException("Null");
		}
           this.getStudents()[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		if(students == null){
			throw new IllegalArgumentException("Null");
		}
         ArrayList<Student> al=new ArrayList<Student>();
		al.add(student);
		for(i=0;i<students.length;i++)
		{
			al.add(students[i]);
		}
		students=al.toArray(new Student[al.size()]);
	}

	@Override
	public void addLast(Student student) {
		if(students == null){
			throw new IllegalArgumentException("Null");
		}
		// Add your implementation here
		List<Student> al=new ArrayList<Student>();
		for(Student s:this.students){al.add(s);}
		al.add(student);
		students=al.toArray(new Student[al.size()]);
	}

	@Override
	public void add(Student student, int index) {
		if(students == null){
			throw new IllegalArgumentException("Null");
		}
		if(index<0||index>=students.length)
		{
			throw new IllegalArgumentException("Null");
		}
		List<Student> al=new ArrayList<Student>();
		for(int i=0;i<index;i++){al.add(getStudent(i));}
		al.add(student);
		for(int i=index;i<this.students.length;i++)
		{al.add(getStudent(i));}
		this.students=al.toArray(new Student[al.size()]);
		
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0||index>=students.length)
		{
			throw new IllegalArgumentException("Null");
		}
		List<Student> al=new ArrayList<Student>();
		for(i=0;i<index;i++)
		{
			al.add(getStudent(i));
		}
		for(i=index+1;i<this.students.length;i++){al.add(getStudent(i));}
		this.students=al.toArray(new Student[al.size()]);
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		
		if(student==null){throw new IllegalArgumentException("student not exist");}
		 Student[] temp = new Student[this.students.length-1]; 
		 int c = 0;
		 for(int i = 0; i < this.students.length; i++)
			 if(this.students[i] != student) temp[c++] = this.students[i];
		 this.students = temp;
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index<0||index>=students.length)
		{
			throw new IllegalArgumentException("Null");
		}
		 		List<Student> al=new ArrayList<Student>();
		for(i=0;i<index;i++)
		{
			al.add(getStudent(i));
		}
		students=al.toArray(new Student[al.size()]);
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException("Null");
		}
		      int ind = getStudentIndex(student);
		   ArrayList<Student> temp = new ArrayList<>();
		   for(int i = 0; i < ind; i++)
			   temp.add(this.students[i]);
		   this.students = temp.toArray(new Student[temp.size()]);
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index<0||index>=students.length)
		{
			throw new IllegalArgumentException("Null");
		}
		  Student[] temp = new Student[this.students.length-index]; 
		 int c = 0;
		 for(int i = index; i < this.students.length; i++)
			 temp[i-index] = this.students[i];
		 this.students = temp;
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException("Null");
		}
		    int ind = getStudentIndex(student);
		   ArrayList<Student> temp = new ArrayList<>();
		   for(int i = ind; i < this.students.length; i++)
			   temp.add(this.students[i]);
		   this.students = temp.toArray(new Student[temp.size()]);
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		Student temp;
		List<Student> al=new ArrayList<Student>();
		for(i=0;i<this.students.length;i++)
		{
			for(j=0;j<this.students.length;j++)
			{
				if(this.students[j].getId()>this.students[j+1].getId()){
					temp=this.students[j];
					this.students[j]=this.students[j+1];
					this.students[j+1]=temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		if(date == null){
			throw new IllegalArgumentException("Null");
		}
		 ArrayList<Student> temp = new ArrayList<>();
		   for(Student s : this.students)
		   {
		       if(s.getBirthDate().compareTo(date) == 0)
				   temp.add(s);
		   }
		   return  temp.toArray(new Student[temp.size()]);
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		if(firstDate == null || lastDate == null){
			throw new IllegalArgumentException("Null");
		}
		  ArrayList<Student> temp = new ArrayList<>();
		   for(Student s : this.students)
		   {
		       if(s.getBirthDate().after(firstDate) && s.getBirthDate().before(lastDate))
				   temp.add(s);
		   }
		   return  temp.toArray(new Student[temp.size()]); 
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		if(date == null){
			throw new IllegalArgumentException("Null");
		}
		ArrayList<Student> temp = new ArrayList<>();
		   Calendar cal = getCalendar(date);
		   cal.add(Calendar.DATE, days);
           date = cal.getTime();
		   for(Student s : this.students)
		   {
		       if(s.getBirthDate().before(date))
				   temp.add(s);
		   }
		   return  temp.toArray(new Student[temp.size()]);
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		if(indexOfStudent == 0){
			throw new IllegalArgumentException("Null");
		}
		Date now = new Date();
           return this.students[indexOfStudent].getBirthDate().getYear() - now.getYear();
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		  ArrayList<Student> temp = new ArrayList<>();
		  for(int i = 0; i < this.students.length; i++)
		  {
		      if(getCurrentAgeByDate(i) == age)
				  temp.add(this.students[i]);
		  }
          return  temp.toArray(new Student[temp.size()]);
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		 double maxavg = 0;
		  for(Student s : this.students)
			  if(s.getAvgMark() > maxavg) maxavg = s.getAvgMark();
		  ArrayList<Student> temp = new ArrayList<>();
		  for(Student s : this.students)
			  if(s.getAvgMark() == maxavg)  temp.add(s);
		  return  temp.toArray(new Student[temp.size()]);
	}

	@Override
	public Student getNextStudent(Student student) {
		if(students == null){
			throw new IllegalArgumentException("Null");
		}
		   this.bubbleSort();
		   int i;
		   for(i = 0; i < this.students.length; i++)
			   if(this.students[i].equals(student)) break;
		   return this.students[i+1];
	}
	private int getStudentIndex(Student student) {
         for(int i = 0; i < this.students.length; i++)
			 if(this.students[i].equals(student)) return i;
		 return -1;
    }

	private int getDiffYears(Date first, Date last) {
            return first.getYear() - last.getYear();
	}

	private Calendar getCalendar(Date date) {
          Calendar aDay = Calendar.getInstance();
          aDay.setTime(date);
		  return aDay;
	}
}
