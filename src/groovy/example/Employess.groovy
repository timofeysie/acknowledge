package example

class Employee 
{
    def salary
}
def highPaid(emps) 
{
	def threshold = 150
	return emps.findAll{ e -> e.salary > threshold }
}