println "Builders are based on the builder pattern from the "
println "GOF design pattern book. "
println "It provides a way to build your own DSL"
println "(Domain Specific Language)"

def builder = NodeBuilder.newInstance()
def xmlns = new groovy.xml.NamespaceBuilder(builder)

def xsd = xmlns.namespace('http://www.w3.org/2001/XMLSchema', 'xsd')

def root = xsd.schema(xmlns:['foo':'http://someOtherNamespace']) {
  annotation {
      documentation("Purchase order schema for Example.com.")
      //documentation(xmlns=[xml.lang:'en']) ["Purchase order schema for Example.com."]
  }
  element(name:'purchaseOrder', type:'PurchaseOrderType')
  element(name:'comment', type:'xsd:string')
  complexType(name:'PurchaseOrderType') {
    sequence {
      element(name:'shipTo', type:'USAddress')
      element(name:'billTo', type:'USAddress')
      element(minOccurs:'0', ref:'comment')
      element(name:'items', type:'Items')
    }
    attribute(name:'orderDate', type:'xsd:date')
  }
  complexType(name:'USAddress') {
    sequence {
      element(name:'name', type:'xsd:string')
      element(name:'street', type:'xsd:string')
      element(name:'city', type:'xsd:string')
      element(name:'state', type:'xsd:string')
      element(name:'zip', type:'xsd:decimal')
    }
    attribute(fixed:'US', name:'country', type:'xsd:NMTOKEN')
  }
  complexType(name:'Items') {
    sequence {
      element(maxOccurs:'unbounded', minOccurs:'0', name:'item') {
        complexType {
          sequence {
            element(name:'productName', type:'xsd:string')
            element(name:'quantity') {
              simpleType {
                restriction(base:'xsd:positiveInteger') {
                  maxExclusive(value:'100')
                }
              }
            }
            element(name:'USPrice', type:'xsd:decimal')
            element(minOccurs:'0', ref:'comment')
            element(minOccurs:'0', name:'shipDate', type:'xsd:date')
          }
          attribute(name:'partNum', type:'SKU', use:'required')
        }
      }
    }
  }
  /* Stock Keeping Unit, a code for identifying products */
  simpleType(name:'SKU') {
    restriction(base:'xsd:string') {
      pattern(value:'\\d{3}-[A-Z]{2}')
    }
  }
}

builder = new groovy.xml.MarkupBuilder()
	
	builder.'web-app' {
    	'display-name' 'Builder Application'
	}
println ""
println "There's a converter org.codehaus.groovy.tools.xml.DomToGroovy "
println "from XML to groovy markup so you can try out this new "
println "markup language on any XML documents you have already."
println ""

//import example.MyConfig
//def result = new YourBuilder().invokeMethod('rootNode', MyConfig.nodes )

println "http://www.nofluffjuststuff.com/blog/andrew_glover/2007/07/builders_are_groovy_s_bag"

println ""
println "How Builders Work example"

// create a builder, (note: this is not in one of the packages that are automatically imported

def builder2 = new groovy.xml.MarkupBuilder()  // construct a builder step(1)

// create a simple xml markup

builder2.stocks {                              // step (2)
    stock(symbol: 'JAVA')                     // step (3-1)
    stock(symbol: 'MSFT')                     // step (3-2)
    stock(symbol: 'IBM' )
}

/*
==== result output =====>
<stocks>
  <stock symbol='JAVA' />
  <stock symbol='MSFT' />
  <stock symbol='IBM' />
</stocks>
*/