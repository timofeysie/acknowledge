package example

// (@DelegatesTo(Email) cl)
// @DelegatesTo(strategy=Closure.DELEGATE_ONLY, value=Email) cl) 

email
{
	from 'dsl-guru@mycompany.com'
	to 'john.doe@waitaminute.com'
    subject 'The pope has resigned!'
    body
    {
   		//?? p 'Really, the pope has resigned!'
	}
}