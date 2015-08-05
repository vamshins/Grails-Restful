// Place your Spring DSL code here
import grails.rest.render.xml.XmlRenderer
import grails.rest.render.json.JsonRenderer
import restservice.City
import restservice.Customer

beans = {
    cityXmlRenderer(XmlRenderer, City) {
        excludes = ['class', 'dateCreated']
    }
    cityJSONRenderer(JsonRenderer, City) {
        excludes = ['class', 'dateCreated']
    }
    customerXmlRenderer(XmlRenderer, Customer) {
        excludes = ['class']
    }
    customerJSONRenderer(JsonRenderer, Customer) {
        excludes = ['class']
    }
}
