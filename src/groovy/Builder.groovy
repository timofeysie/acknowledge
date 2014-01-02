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
println "How Builders Work Example"

// create a builder, (note: this is not in one of the packages that are automatically imported

def builder2 = new groovy.xml.MarkupBuilder()  // construct a builder step(1)

// create a simple xml markup

builder2.stocks {                              // step (2)
    stock(symbol: 'JAVA')                     // step (3-1)
    stock(symbol: 'MSFT')                     // step (3-2)
    stock(symbol: 'IBM' )
}

println ""
def test_builder = new groovy.xml.MarkupBuilder()  // construct a builder step(1)
test_builder.word {                              // step (2)
    text(string: '»ç°ú')                     // step (3-1)
    definition(string: 'apple')                     // step (3-2)
}
println ""

println ""
println "builder does not know the method stocks, so "
println "the builder will 'missing method exception'."
println "(unifinished tutrial)"
println ""
println "The @DelegatesTo annotation"
import example.Email
def email(Closure cl) 
{
    def email = new Email()
    def code = cl.rehydrate(email, this, this)
    code.resolveStrategy = DELEGATE_ONLY
    code()
}
println "Documentation is important"
println " IDEs can help the developper by suggesting, once they are in "
println "the closure body, methods that exist on the class."
println ""
println "Type checking builders"
println "The goal of this annotation is to solve both the documentation issue, "
println "that will let your IDE know about the expected methods in the "
println "closure body, and it will also solve the type checking issue, "
println "by giving hints to the compiler about what are the potential "
println "receivers of method calls in the closure body."
println ""
def email(@DelegatesTo(strategy=Closure.DELEGATE_ONLY, value=Email) cl) { ... }
println ""
println "DelegatesTo modes"
println "Simple delegation"
def build(@DelegatesTo(BuilderItem) cl) { ... }
println "Delegation strategy"
def build(@DelegatesTo(strategy=Closure.DELEGATE_FIRST, value=BuilderItem) { ... }
println "Delegate to parameter"
def exec(Object target, Closure code) {
   def clone = code.rehydrate(target, this, this)
   clone()
}
println "This is a widely used pattern which is also supported by "
println "@DelegatesTo using a companion annotation:"
def exec(@DelegatesTo.Target target, @DelegatesTo code) { ... }"
println "annotating another parameter with @DelegatesTo.Target."
println "In this mode, the @DelegatesTo annotation also supports the "
println "strategy parameter that we've described upper."
println ""
println "Multiple closures"
//def guardWith(Closure guard, Closure code, Closure fallback) { ... }
//  annotating each closure with @DelegatesTo:
//def guardWith(@DelegatesTo(Foo) Closure guard, @DelegatesTo(Bar) Closure code, @DelegatesTo(Baz) Closure fallback) { ... }
println "if you have multiple closures and multiple arguments, "
println "you can use several targets:
def guardWith(@DelegatesTo.Target('guarded') guarded,??
              @DelegatesTo.Target('codeObject') codeObject,??
              @DelegatesTo.Target('fallbackObject') fallbackObject,  
              @DelegatesTo(target='guarded') Closure guard,
              @DelegatesTo(target='codeObject') Closure code,
              @DelegatesTo(target='fallbackObject') Closure fallback) { ... }"
println ""
println ""
println ""
println ""