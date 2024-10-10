import groovy.swing.SwingBuilder
import groovy.beans.Bindable

class MyModel 
{
   @Bindable int count = 0
}

def model = new MyModel()
builder = new SwingBuilder().edt 
{
  frame(
  		title: "Java Frame", 
  		size: [100, 100], 
  		locationRelativeTo: null, 
  		show: true) 
  {
    gridLayout(cols: 1, rows: 2)
    label(
    	text: bind(
    		source: model, 
    		sourceProperty: "count", 
    		converter: { v ->  v? "Clicked $v times": ''}))
    button(
    	"Click me!", 
    	actionPerformed: 
    	{ 
    		model.count++ 
    		builder.edt{frame(title:"Groovy Frame")}
    	})
  }

}