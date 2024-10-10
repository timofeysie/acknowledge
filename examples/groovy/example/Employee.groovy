package example

class Employee 
{
    def salary
	//highPaid(emps) 
	def threshold = 150
	public Employee doMethod()
	{
		return emps.findAll{ e -> e.salary > threshold }
	}
}